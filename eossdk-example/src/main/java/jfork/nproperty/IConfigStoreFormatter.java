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

import java.io.IOException;

/**
 * Interface for store configuration files in different formats.
 */
public interface IConfigStoreFormatter
{
	/**
	 * Adds property entry.
	 *
	 * @param key Entry key.
	 * @param value Entry value.
	 */
	public void addPair(String key, String value);

	/**
	 * Generates configuration file text based on type of this store formatter.
	 *
	 * @return Generated configuration file.
	 * @throws IOException Used to re-throw unusual exceptions during format.
	 */
	public String generate() throws IOException;
}
