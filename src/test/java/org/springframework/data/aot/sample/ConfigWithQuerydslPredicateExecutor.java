/*
 * Copyright 2022-2025 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.aot.sample;

import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.aot.sample.ConfigWithQuerydslPredicateExecutor.MyRepo;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.config.EnableRepositories;

/**
 * @author Christoph Strobl
 */
@EnableRepositories(includeFilters = { @Filter(type = FilterType.ASSIGNABLE_TYPE, value = MyRepo.class) },
		basePackageClasses = ConfigWithQuerydslPredicateExecutor.class, considerNestedRepositories = true)
public class ConfigWithQuerydslPredicateExecutor {

	public interface MyRepo extends CrudRepository<Person, String>, QuerydslPredicateExecutor<Person> {

	}

	public static class Person {

		Address address;

	}

	public static class Address {
		String street;
	}
}
