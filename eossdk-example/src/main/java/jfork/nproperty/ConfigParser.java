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

import jfork.typecaster.TypeCaster;
import jfork.typecaster.exception.IllegalTypeException;

import java.io.*;
import java.lang.reflect.*;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Configuration parser parses given configuration file(s) and fills given object fields.
 *
 * It can be used like this:<br /><br />
 * <pre>
 * {@literal @}Cfg
 * class ConfigMain
 * {
 *     public static int SOME_CONFIGURATION_OPTION = 0;
 *
 *     public ConfigMain()
 *     {
 *         ConfigParser.parse(this, "main.ini");
 *     }
 * }</pre>
 *
 * @author Nikita Sankov
 */
public class ConfigParser
{
	private final static Pattern parametersPattern = Pattern.compile("\\$\\{([^}]*)\\}");

	/**
	 * Parses property set with using of NProperty annotations and string path to property source.
	 *
	 * @param object NProperty annotated object, that represents Java property storage.
	 * @param path Path to properties file.
	 * @throws InvocationTargetException Failed invoke some annotated method.
	 * @throws NoSuchMethodException Appears on adding splitter properties to lists.
	 * @throws InstantiationException When failed to create instance of an custom object. Such exception can appered when property field is of custom type.
	 * @throws IllegalAccessException If NProperty tries access inaccessible entities in annotated object.
	 * @throws IOException If configuration file does not exists or due to system IO errors.
	 */
	public static Properties parse(Object object, String path) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IOException
	{
		return parse(object, new File(path));
	}

	/**
	 * Parses XML property set with using of nProperty annotations and string path to property XML source.
	 * Author - PointerRage.
	 *
	 * @param object NProperty annotated object, that represents Java property storage.
	 * @param path Path to properties file.
	 * @throws InvocationTargetException Failed invoke some annotated method.
	 * @throws NoSuchMethodException Appears on adding splitter properties to lists.
	 * @throws InstantiationException When failed to create instance of an custom object. Such exception can appered when property field is of custom type.
	 * @throws IllegalAccessException If NProperty tries access inaccessible entities in annotated object.
	 * @throws IOException If configuration file does not exists or due to system IO errors.
	 */
	public static Properties parseXml(Object object, String path) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IOException
	{
		return parseXml(object, new File(path));
	}

	/**
	 * Parses property set with using of NProperty annotations and File object referenced to property source.
	 *
	 * @param object NProperty annotated object, that represents Java property storage.
	 * @param file File to read properties from.
	 * @throws InvocationTargetException Failed invoke some annotated method.
	 * @throws NoSuchMethodException Appears on adding splitter properties to lists.
	 * @throws InstantiationException When failed to create instance of an custom object. Such exception can appered when property field is of custom type.
	 * @throws IllegalAccessException If NProperty tries access inaccessible entities in annotated object.
	 * @throws IOException If configuration file does not exists or due to system IO errors.
	 */
	public static Properties parse(Object object, File file) throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException
	{
		Properties props;

		try (FileInputStream stream = new FileInputStream(file))
		{
			props = parse(object, stream, file.getPath());
		}

		return props;
	}

	/**
	 * Parses XML property set with using of nProperty annotations and XML File object referenced to property source.
	 * Author - PointerRage.
	 *
	 * @param object nProperty annotated object, that represents Java property storage.
	 * @param file File to read properties from.
	 * @throws InvocationTargetException Failed invoke some annotated method.
	 * @throws NoSuchMethodException Appears on adding splitter properties to lists.
	 * @throws InstantiationException When failed to create instance of an custom object. Such exception can appered when property field is of custom type.
	 * @throws IllegalAccessException If NProperty tries access inaccessible entities in annotated object.
	 * @throws IOException If configuration file does not exists or due to system IO errors.
	 */
	public static Properties parseXml(Object object, File file) throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException
	{
		Properties props;

		try (FileInputStream stream = new FileInputStream(file))
		{
			props = parseXml(object, stream, file.getPath());
		}

		return props;
	}

	/**
	 * Parses property set with using of NProperty annotations and using abstract input io stream (it can be a file, network or any other thing Java can provide within io streams).
	 *
	 * @param object NProperty annotated object, that represents Java property storage.
	 * @param stream IO stream from properties will be read.
	 * @param streamName Name of stream (this will be used instead of file name, because of using IO stream we cannot retrieve file name).
	 * @throws InvocationTargetException Failed invoke some annotated method.
	 * @throws NoSuchMethodException Appears on adding splitter properties to lists.
	 * @throws InstantiationException When failed to create instance of an custom object. Such exception can appered when property field is of custom type.
	 * @throws IllegalAccessException If NProperty tries access inaccessible entities in annotated object.
	 * @throws IOException If configuration file does not exists or due to system IO errors.
	 */
	public static Properties parse(Object object, InputStream stream, String streamName) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IOException
	{
		Properties props = new Properties();
		props.load(stream);

		return parse0(object, props, streamName);
	}

	/**
	 * Parses XML property set with using of nProperty annotations and using abstract input XML io stream (it can be a file, network or any other thing Java can provide within io streams).
	 * Author - PointerRage.
	 *
	 * @param object nProperty annotated object, that represents Java property storage.
	 * @param stream IO stream from properties will be read.
	 * @param streamName Name of stream (this will be used instead of file name, because of using IO stream we cannot retrieve file name).
	 * @throws InvocationTargetException Failed invoke some annotated method.
	 * @throws NoSuchMethodException Appears on adding splitter properties to lists.
	 * @throws InstantiationException When failed to create instance of an custom object. Such exception can appered when property field is of custom type.
	 * @throws IllegalAccessException If NProperty tries access inaccessible entities in annotated object.
	 * @throws IOException If configuration file does not exists or due to system IO errors.
	 */
	public static Properties parseXml(Object object, InputStream stream, String streamName) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IOException
	{
		Properties props = new Properties();
		props.loadFromXML(stream);

		return parse0(object, props, streamName);
	}

	/**
	 * Parses property set with using of NProperty annotations and using abstract input io stream reader (it can be a file, network or any other thing Java can provide within io streams).
	 *
	 * @param object NProperty annotated object, that represents Java property storage.
	 * @param reader IO stream reader.
	 * @param streamName Name of stream (this will be used instead of file name, because of using IO stream we cannot retrieve file name).
	 * @throws InvocationTargetException Failed invoke some annotated method.
	 * @throws NoSuchMethodException Appears on adding splitter properties to lists.
	 * @throws InstantiationException When failed to create instance of an custom object. Such exception can appered when property field is of custom type.
	 * @throws IllegalAccessException If NProperty tries access inaccessible entities in annotated object.
	 * @throws IOException If configuration file does not exists or due to system IO errors.
	 */
	public static Properties parse(Object object, Reader reader, String streamName) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IOException
	{
		Properties props = new Properties();
		props.load(reader);

		return parse0(object, props, streamName);
	}

	/**
	 * Parses property set with using of NProperty annotations.
	 *
	 * @param object NProperty annotated object, that represents Java property storage.
	 * @param path Path to configuration file.
	 * @throws IOException If configuration file does not exists or due to system IO errors.
	 * @throws IllegalAccessException If NProperty tries access inaccessible entities in annotated object.
	 * @throws InstantiationException When failed to create instance of an custom object. Such exception can appered when property field is of custom type.
	 * @throws NoSuchMethodException Appears on adding splitter properties to lists.
	 * @throws InvocationTargetException Failed invoke some annotated method.
	 */
	@SuppressWarnings("unchecked")
	private static Properties parse0(Object object, Properties props, String path) throws IOException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException
	{
		boolean callEvents = object instanceof IPropertyListener;

		if (callEvents)
			((IPropertyListener)object).onStart(path);

		boolean isClass = (object instanceof Class);
		boolean classAnnotationPresent;
		String prefix = null;
		boolean classAllowParameters = false;
		if (isClass)
		{
			classAnnotationPresent = ((Class)object).isAnnotationPresent(Cfg.class);

			if (classAnnotationPresent)
			{
				prefix = ((Cfg)((Class)object).getAnnotation(Cfg.class)).prefix();
				classAllowParameters = ((Cfg)((Class)object).getAnnotation(Cfg.class)).parametrize();
			}
		}
		else
		{
			classAnnotationPresent = object.getClass().isAnnotationPresent(Cfg.class);

			if (classAnnotationPresent)
			{
				prefix = object.getClass().getAnnotation(Cfg.class).prefix();
				classAllowParameters = object.getClass().getAnnotation(Cfg.class).parametrize();
			}
		}

		Field[] fields = (object instanceof Class) ? ((Class) object).getDeclaredFields() : object.getClass().getDeclaredFields();
		for (Field field : fields)
		{
			// Find property name
			String name;
			boolean allowParameters = classAllowParameters;
			if (isClass && !Modifier.isStatic(field.getModifiers()))
				continue;

			if (field.isAnnotationPresent(Cfg.class))
			{
				if (field.getAnnotation(Cfg.class).ignore() || field.isAnnotationPresent(CfgIgnore.class))
					continue;

				name = field.getAnnotation(Cfg.class).value();

				if (!allowParameters)
					allowParameters = field.getAnnotation(Cfg.class).parametrize();

				// If name is empty, we should try to take field name as property name
				if (name.isEmpty())
					name = field.getName();
			}
			else if (classAnnotationPresent)
				name = field.getName();
			else
				continue;

			// Adding prefix if needed
			if (prefix != null && !prefix.isEmpty())
				name = prefix.concat(name);

			boolean oldAccess = field.isAccessible();
			field.setAccessible(true);
			if (props.containsKey(name))
			{
				String propValue = props.getProperty(name);

				if (allowParameters)
				{
					boolean replacePlaceholders = false;
					while (true)
					{
						// Check for parameters in property value
						Matcher parametersMatcher = parametersPattern.matcher(propValue);
						boolean exit = true;
						while (parametersMatcher.find())
						{
							String parameterPropertyName = parametersMatcher.group(1);

							if (!parameterPropertyName.isEmpty())
							{
								exit = false;

								String parameterPropertyValue = props.containsKey(parameterPropertyName) ? props.getProperty(parameterPropertyName) : "";
								propValue = propValue.replace(parametersMatcher.group(), parameterPropertyValue);
							}
							else if (!replacePlaceholders)
							{
								replacePlaceholders = true;
							}
						}

						if (exit)
							break;
					}

					if (replacePlaceholders)
					{
						propValue = propValue.replace("${}", "$");
					}
				}

				// Native arrays
				if (field.getType().isArray())
				{
					Class baseType = field.getType().getComponentType();
					if (propValue != null)
					{
						String[] values = propValue.split(field.isAnnotationPresent(Cfg.class) ? field.getAnnotation(Cfg.class).splitter() : ";");

						Object array = Array.newInstance(baseType, values.length);
						field.set(object, array);

						int index = 0;
						for (String value : values)
						{
							try
							{
								Array.set(array, index, TypeCaster.cast(baseType, value));
							}
							catch (IllegalTypeException | NumberFormatException e)
							{
								if (callEvents)
									((IPropertyListener)object).onInvalidPropertyCast(name, value);
							}
							++index;
						}

						field.set(object, array);
					}
				}
				// Lists
				else if (field.getType().isAssignableFrom(List.class))
				{
					if (field.get(object) == null)
						throw new NullPointerException("Cannot use null-object for parsing List splitter.");

					Class genericType = (Class)((ParameterizedType)field.getGenericType()).getActualTypeArguments()[0];
					if (propValue != null)
					{
						String[] values = propValue.split(field.isAnnotationPresent(Cfg.class) ? field.getAnnotation(Cfg.class).splitter() : ";");

						for (String value : values)
						{
							try
							{
								((List<Object>)field.get(object)).add(TypeCaster.cast(genericType, value));
							}
							catch (IllegalTypeException | NumberFormatException e)
							{
								if (callEvents)
									((IPropertyListener)object).onInvalidPropertyCast(name, value);
							}
						}
					}
				}
				// Primary & standard types
				else
				{
					if (propValue != null)
					{
						// If it is known type - just cast it, else - create new instance of class is possible
						if (TypeCaster.isCastable(field))
						{
							try
							{
								TypeCaster.cast(object, field, propValue);
							}
							catch (IllegalTypeException | NumberFormatException e)
							{
								if (callEvents)
									((IPropertyListener)object).onInvalidPropertyCast(name, propValue);
							}
						}
						// Custom classes
						else
						{
							Constructor construct = field.getType().getDeclaredConstructor(String.class);
							boolean oldConstructAccess = construct.isAccessible();
							construct.setAccessible(true);
							field.set(object, construct.newInstance(propValue));
							construct.setAccessible(oldConstructAccess);
						}
					}
				}
			}
			else
			{
				if (object instanceof IPropertyListener)
				{
					((IPropertyListener)object).onPropertyMiss(name);
				}
			}
			field.setAccessible(oldAccess);
		}

		// Methods
		Method[] methods = (object instanceof Class) ? ((Class) object).getDeclaredMethods() : object.getClass().getDeclaredMethods();
		for (Method method : methods)
		{
			// Accumulate annotation info
			if (method.isAnnotationPresent(Cfg.class))
			{
				String propName = method.getAnnotation(Cfg.class).value();

				if (propName.isEmpty())
					propName = method.getName();

				if (!props.containsKey(propName))
				{
					if (object instanceof IPropertyListener)
					{
						((IPropertyListener)object).onPropertyMiss(propName);
					}
					continue;
				}

				if (method.getParameterTypes().length == 1)
				{
					String propValue = props.getProperty(propName);
					boolean oldAccess = method.isAccessible();
					method.setAccessible(true);

					if (propValue != null)
					{
						try
						{
							method.invoke(object, TypeCaster.cast(method.getParameterTypes()[0], propValue));
						}
						catch (IllegalTypeException | NumberFormatException | InvocationTargetException e)
						{
							if (callEvents)
								((IPropertyListener)object).onInvalidPropertyCast(propName, propValue);
						}
					}
					else
						method.invoke(object, method.getParameterTypes()[0] == String.class ? propValue : (TypeCaster.cast(method.getParameterTypes()[0], propValue)));

					method.setAccessible(oldAccess);
				}
			}
		}

		if (callEvents)
			((IPropertyListener)object).onDone(path);

		return props;
	}

	/**
	 * Stores configuration fields to file with given path.
	 *
	 * @param object Object to get fields from.
	 * @param path Path to file write to.
	 * @throws IOException If any I/O error occurs.
	 * @throws IllegalAccessException When failed to access objects' data.
	 */
	public static void store(Object object, String path) throws IOException, IllegalAccessException
	{
		store(object, new File(path));
	}

	/**
	 * Stores configuration fields in XML format to file with given path.
	 * Author - PointerRage.
	 *
	 * @param object Object to get fields from.
	 * @param path Path to file write to.
	 * @throws IOException If any I/O error occurs.
	 * @throws IllegalAccessException When failed to access objects' data.
	 */
	public static void storeXml(Object object, String path) throws IOException, IllegalAccessException
	{
		storeXml(object, new File(path));
	}

	/**
	 * Stores configuration fields to given file.
	 *
	 * @param object Object to get fields from.
	 * @param file File descriptor to write to.
	 * @throws IOException If any I/O error occurs.
	 * @throws IllegalAccessException When failed to access objects' data.
	 */
	public static void store(Object object, File file) throws IOException, IllegalAccessException
	{
		try (OutputStream stream = new FileOutputStream(file))
		{
			store(object, stream);
		}
	}

	/**
	 * Stores configuration fields in XML format to given file.
	 * Author - PointerRage.
	 *
	 * @param object Object to get fields from.
	 * @param file File descriptor to write to.
	 * @throws IOException If any I/O error occurs.
	 * @throws IllegalAccessException When failed to access objects' data.
	 */
	public static void storeXml(Object object, File file) throws IOException, IllegalAccessException
	{
		try (OutputStream stream = new FileOutputStream(file))
		{
			storeXml(object, stream);
		}
	}

	/**
	 * Stores configuration fields to stream.
	 *
	 * @param object Object to get fields from.
	 * @param stream Output stream to write to.
	 * @throws IOException If any I/O error occurs.
	 * @throws IllegalAccessException When failed to access objects' data.
	 */
	public static void store(Object object, OutputStream stream) throws IOException, IllegalAccessException
	{
		ConfigStoreFormatterIni formatter = new ConfigStoreFormatterIni();
		store0(object, formatter);
		stream.write(formatter.generate().getBytes());
	}

	/**
	 * Stores configuration fields to stream in XML format.
	 * Author - PointerRage.
	 *
	 * @param object Object to get fields from.
	 * @param stream Output stream to write to.
	 * @throws IOException If any I/O error occurs.
	 * @throws IllegalAccessException When failed to access objects' data.
	 */
	public static void storeXml(Object object, OutputStream stream) throws IOException, IllegalAccessException
	{
		ConfigStoreFormatterXml formatter = new ConfigStoreFormatterXml();
		store0(object, formatter);
		stream.write(formatter.generate().getBytes());
	}

	/**
	 * Stores configuration fields to stream.
	 *
	 * @param object Object to get fields from.
	 * @param writer Writer interface to write to.
	 * @throws IOException If any I/O error occurs.
	 * @throws IllegalAccessException When failed to access objects' data.
	 */
	public static void store(Object object, Writer writer) throws IOException, IllegalAccessException
	{
		ConfigStoreFormatterIni formatter = new ConfigStoreFormatterIni();
		store0(object, formatter);
		writer.write(formatter.generate());
	}

	/**
	 * Stores configuration fields to stream in XML format.
	 *
	 * @param object Object to get fields from.
	 * @param writer Writer interface to write to.
	 * @throws IOException If any I/O error occurs.
	 * @throws IllegalAccessException When failed to access objects' data.
	 */
	public static void storeXml(Object object, Writer writer) throws IOException, IllegalAccessException
	{
		ConfigStoreFormatterXml formatter = new ConfigStoreFormatterXml();
		store0(object, formatter);
		writer.write(formatter.generate());
	}

	/**
	 * Stores configuration fields to stream.
	 *
	 * @param object Object to get fields from.
	 * @throws IOException If any I/O error occurs.
	 * @throws IllegalAccessException When failed to access objects' data.
	 */
	private static void store0(Object object, IConfigStoreFormatter formatter) throws IOException, IllegalAccessException
	{
		boolean isClass = (object instanceof Class);
		boolean classAnnotationPresent;
		String prefix = null;
		if (isClass)
		{
			classAnnotationPresent = ((Class)object).isAnnotationPresent(Cfg.class);

			if (classAnnotationPresent)
			{
				prefix = ((Cfg)((Class)object).getAnnotation(Cfg.class)).prefix();
			}
		}
		else
		{
			classAnnotationPresent = object.getClass().isAnnotationPresent(Cfg.class);

			if (classAnnotationPresent)
			{
				prefix = object.getClass().getAnnotation(Cfg.class).prefix();
			}
		}

		Field[] fields = (object instanceof Class) ? ((Class) object).getDeclaredFields() : object.getClass().getDeclaredFields();
		for (Field field : fields)
		{
			// Find property name
			String name, value;
			String splitter = ";";
			if (isClass && !Modifier.isStatic(field.getModifiers()))
				continue;

			if (field.isAnnotationPresent(Cfg.class))
			{
				if (field.getAnnotation(Cfg.class).ignore() || field.isAnnotationPresent(CfgIgnore.class))
					continue;

				name = field.getAnnotation(Cfg.class).value();
				splitter = field.getAnnotation(Cfg.class).splitter();

				// If name is empty, we should try to take field name as property name
				if (name.isEmpty())
					name = field.getName();
			}
			else if (classAnnotationPresent)
				name = field.getName();
			else
				continue;

			// Adding prefix if needed
			if (prefix != null && !prefix.isEmpty())
				name = prefix.concat(name);

			boolean oldAccess = field.isAccessible();
			field.setAccessible(true);

			Object fieldValue = field.get(object);

			if (fieldValue != null && field.getType().isArray())
			{
				StringBuilder builder = new StringBuilder();
				for (int i = 0, j = Array.getLength(fieldValue); i < j; ++i)
				{
					builder.append(Array.get(fieldValue, i));
					if (i < j - 1)
						builder.append(splitter);
				}
				value = builder.toString();
			}
			else if (fieldValue != null && field.getType().isAssignableFrom(List.class))
			{
				StringBuilder builder = new StringBuilder();
				boolean isFirst = true;
				for (Object val : (List<?>)fieldValue)
				{
					if (isFirst)
						isFirst = false;
					else
						builder.append(splitter);

					builder.append(val);
				}
				value = builder.toString();
			}
			else
			{
				value = String.valueOf(fieldValue);
			}

			formatter.addPair(name, value);
			field.setAccessible(oldAccess);
		}
	}
}
