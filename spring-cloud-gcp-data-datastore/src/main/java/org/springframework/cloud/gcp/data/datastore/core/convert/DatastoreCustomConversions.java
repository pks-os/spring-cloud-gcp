/*
 *  Copyright 2018 original author or authors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.springframework.cloud.gcp.data.datastore.core.convert;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.data.convert.CustomConversions;
import org.springframework.data.convert.JodaTimeConverters;

/**
 * Value object to capture custom conversion. {@link DatastoreCustomConversions} also act
 * as factory for {@link org.springframework.data.mapping.model.SimpleTypeHolder}
 *
 * @see org.springframework.data.convert.CustomConversions
 * @see org.springframework.data.mapping.model.SimpleTypeHolder
 * @see DatastoreSimpleTypes
 *
 * @author Dmitry Solomakha
 */

public class DatastoreCustomConversions extends CustomConversions {
	private static final StoreConversions STORE_CONVERSIONS;

	private static final List<Object> STORE_CONVERTERS;

	static {
		List<Object> converters = new ArrayList<>();

		// converters.addAll(JodaTimeConverters.getConvertersToRegister());

		STORE_CONVERTERS = Collections.unmodifiableList(converters);
		STORE_CONVERSIONS = StoreConversions.of(DatastoreSimpleTypes.HOLDER, STORE_CONVERTERS);
	}

	/**
	 * Creates a new {@link DatastoreCustomConversions} instance registering the given
	 * converters.
	 *
	 * @param storeConversions must not be {@literal null}.
	 * @param converters must not be {@literal null}.
	 */
	public DatastoreCustomConversions(StoreConversions storeConversions, Collection<?> converters) {
		super(storeConversions, converters);
	}

	public DatastoreCustomConversions(List<?> converters) {
		super(STORE_CONVERSIONS, converters);
	}

	public DatastoreCustomConversions() {
		this(Collections.EMPTY_LIST);
	}
}
