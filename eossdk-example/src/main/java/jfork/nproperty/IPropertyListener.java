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

/**
 * Properties event listener. Target class should implement this interface to be available to listen nProperty events.
 * In other cases events will not be called.
 *
 * @author Nikita Sankov
 */
public interface IPropertyListener
{
	/**
	 * When parsing of configuration file starts.
	 *
	 * @param path Path to configuration file.
	 */
	public void onStart(String path);

	/**
	 * When some property is missing.
	 *
	 * @param name Missed property name.
	 */
	public void onPropertyMiss(String name);

	/**
	 * When done parsing configuration file.
	 *
	 * @param path File path.
	 */
	public void onDone(String path);

	/**
	 * When property value casting is invalid.
	 *
	 * @param name Property name.
	 * @param value Casted value.
	 */
	public void onInvalidPropertyCast(String name, String value);
}
