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

package jfork.typecaster;

import jfork.typecaster.exception.IllegalTypeException;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * The Type Caster is small utility that helps put string values into object fields with different types.
 *
 * @author Yorie
 */
public class TypeCaster
{
    private final static Class[] _allowedTypes = {
            Integer.class, int.class,
            Short.class, short.class,
            Float.class, float.class, // PointerRage -- support float types
            Double.class, double.class,
            Long.class, long.class,
            Boolean.class, boolean.class,
            String.class,
            Character.class, char.class,
            Byte.class, byte.class,
            AtomicInteger.class, AtomicBoolean.class, AtomicLong.class,
            BigInteger.class, BigDecimal.class
    };

    /**
     * Puts value to field.
     *
     * @param object Object, whom field value should be changed.
     * @param field Class field.
     * @param value Value to cast.
     */
    public static void cast(Object object, Field field, String value) throws IllegalAccessException, IllegalTypeException
    {
        if (!isCastable(field))
            throw new IllegalTypeException("Unsupported type [" + field.getType().getName() + "] for field [" + field.getName() + "]");

        Class type = field.getType();
        boolean oldAccess = field.isAccessible();

        field.setAccessible(true);

        if (type.isEnum())
            field.set(object, Enum.valueOf((Class<Enum>)type, value));
        else if (type == Integer.class || type == int.class)
            field.set(object, Integer.decode(value));
        else if (type == Short.class || type == short.class)
            field.set(object, Short.decode(value));
        else if (type == Float.class || type == float.class) // PointerRage -- support float types
            field.set(object, Float.parseFloat(value));
        else if (type == Double.class || type == double.class)
            field.set(object, Double.parseDouble(value));
        else if (type == Long.class || type == long.class)
            field.set(object, Long.decode(value));
        else if (type == Boolean.class || type == boolean.class)
            field.set(object, Boolean.parseBoolean(value));
        else if (type == String.class)
            field.set(object, value);
        else if (type == Character.class || type == char.class)
            field.set(object, value.charAt(0));
        else if (type == Byte.class || type == byte.class)
            field.set(object, Byte.parseByte(value));
        else if (type == AtomicInteger.class)
            field.set(object, new AtomicInteger(Integer.decode(value)));
        else if (type == AtomicBoolean.class)
            field.set(object, new AtomicBoolean(Boolean.parseBoolean(value)));
        else if (type == AtomicLong.class)
            field.set(object, new AtomicLong(Long.decode(value)));
        else if (type == BigInteger.class)
            field.set(object, new BigInteger(value));
        else if (type == BigDecimal.class)
            field.set(object, new BigDecimal(value));
        else
        {
            field.setAccessible(oldAccess);
            throw new IllegalTypeException("Unsupported type [" + type.getName() + "] for field [" + field.getName() + "]");
        }

        field.setAccessible(oldAccess);
    }

    /**
     * Changes targets' value to new given value with type casting.
     *
     * @param type Cast type.
     * @param value Value to cast.
     */
    @SuppressWarnings("unchecked")
    public static <T> T cast(Class<T> type, String value) throws IllegalAccessException, IllegalTypeException
    {
        if (!isCastable(type))
            throw new IllegalTypeException("Unsupported type [" + type.getName() + "]");

        if (type.isEnum())
            return (T)Enum.valueOf((Class<Enum>)type, value);
        else if (type == Integer.class || type == int.class)
            return (T)Integer.class.cast(Integer.decode(value));
        else if (type == Short.class || type == short.class)
            return (T)Short.class.cast(Short.decode(value));
        else if (type == Float.class || type == float.class) // PointerRage -- support float types
            return (T)Float.class.cast(Float.parseFloat(value));
        else if (type == Double.class || type == double.class)
            return (T)Double.class.cast(Double.parseDouble(value));
        else if (type == Long.class || type == long.class)
            return (T)Long.class.cast(Long.decode(value));
        else if (type == Boolean.class || type == boolean.class)
            return (T)Boolean.class.cast(Boolean.parseBoolean(value));
        else if (type == String.class)
            return (T)value;
        else if (type == Character.class || type == char.class)
            return (T)((Object)value.charAt(0));
        else if (type == Byte.class || type == byte.class)
            return (T)Byte.class.cast(Byte.decode(value));
        else if (type == AtomicInteger.class)
            return (T)new AtomicInteger(Integer.decode(value));
        else if (type == AtomicBoolean.class)
            return (T)new AtomicBoolean(Boolean.parseBoolean(value));
        else if (type == AtomicLong.class)
            return (T)new AtomicLong(Long.decode(value));
        else if (type == BigInteger.class)
            return (T)new BigInteger(value);
        else if (type == BigDecimal.class)
            return (T)new BigDecimal(value);
        else
        {
            throw new IllegalTypeException("Unsupported type [" + type.getName() + "]");
        }
    }

    /**
     * Checks whether class can be used for casting with TypeCaster.
     *
     * @param type Class or type to check.
     * @return True, if class or type can be casted, false in other case.
     */
    public static boolean isCastable(Class type)
    {
        if (type.isEnum())
            return true;

        for (Class t : _allowedTypes)
        {
            if (t == type)
                return true;
        }
        return false;
    }

    /**
     * Checks whether object can be casted by TypeCaster.
     * @param object Object to check.
     * @return True, if object can be casted, false in other case.
     */
    public static boolean isCastable(Object object)
    {
        return isCastable(object.getClass());
    }

    /**
     * Checks whether field castable by type caster or not.
     *
     * @param field Field to check is castable.
     * @return True, if field can be casted, false in other case.
     */
    public static boolean isCastable(Field field)
    {
        return isCastable(field.getType());
    }
}
