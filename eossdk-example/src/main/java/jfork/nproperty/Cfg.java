/*
 * JFork Project
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package jfork.nproperty;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The Cfg annotation represents ability to annotate fields and methods for lazy configuration files parsing.<br /><br />
 *
 * You can use it like this:
 * <pre>
 * class FooPropertySet
 * {
 *     {@literal @}Cfg
 *     private int FOO_PROPERTY;
 *
 *     {@literal @}Cfg
 *     private FooClass OBJECT;
 *
 *     {@literal @}Cfg
 *     public void myIntProperty(int value) { ... }
 * }</pre>
 * <br />
 * When annotate fields, library will parse property from file and manually cast its value to field type.
 * When annotate methods, library will parse property from file and send its contents to first method argument. <b>Important!</b> Method should have only one argument.
 * When annotate fields of custom types, library will parse property and create a new instance of an object. <b>Important!</b> Constructor should be marked with @Cfg property too
 * and should have only one argument.
 *
 * <h1>Splitters</h1>
 *
 * Let's assume you want to read some string with using separation token.<br />
 * For example: MY_CONCATENATED_INT_VALUES = 1;2;3;4;5<br /><br />
 *
 * Then instead of creating method handler for such property you can register field like this:<br />
 * <pre>
 * class MyConfig
 * {
 *     // There is empty int array will be default value (if config will not be found in properties file)
 *     // And property value will be splitted with using of ";" symbol as split token.
 *     // So, in MY_CONCATENATED_INT_VALUES will be array int[]{1, 2, 3, 4, 5}
 *     {@literal @}Cfg
 *     public static int[] MY_CONCATENATED_INT_VALUES = new int[];
 * }
 *</pre>
 * You can override split token and field name.
 *
 * @author Nikita Sankov
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.TYPE})
public @interface Cfg
{
	/**
	 * Custom property name. Can be used when real property name differs from class field.
	 */
	String value() default "";

	/**
	 * Splitter that can be used for splitting settings into arrays & collections.
	 */
	String splitter() default ";";

	/**
	 * Should be set up to true if you with to ignore some field of class.
	 */
	boolean ignore() default false;

	/**
	 * Prefix of property name can be used for batch loading of property sets with prefixes
	 * For example, let properties be: db.name, db.user, db.password
	 * then we can load them by annotating class by {@link Cfg} annotation:
	 * <pre>{@literal @}Cfg(prefix = "db.")
	 * class MyDatabaseConfig
	 * {
	 *     // ...
	 * }
	 * </pre>
	 */
	String prefix() default "";

	/**
	 * Allows parametrization of properties.
	 * Parametrization is pre-work of parser and it affects native string values from property file.
	 * Property parameters is sequence: ${key}, where key is property name from configuration file.
	 */
	boolean parametrize() default false;
}