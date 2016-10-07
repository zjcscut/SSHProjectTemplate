/*
 * Copyright (c) zjc@scut 2016~
 * Free of All
 * Help Yourselves!
 * Any bugs were found please contact me at 739805340scut@gmail.com
 */

package cn.util.asser;


import java.util.Collection;
import java.util.Map;

/**
 * @author zhangjinci
 * @version 2016/9/21 9:40
 * @function 服务层异常断言，不满足断言会抛出IllegalArgumentException
 */
public abstract class Assert {

    public Assert() {
        super();
    }

    private static final String DEFAULT_IS_TRUE_ASSERT_MESSAGE = "This valitaed expression is false";
    private static final String DEFAULT_IS_NULL_ASSERT_MESSAGE = "This valitaed value is null";
    private static final String DEFAULT_NOT_EMPTY_ARRAY_EX_MESSAGE = "The validated array is empty";
    private static final String DEFAULT_NOT_EMPTY_COLLECTION_EX_MESSAGE = "The validated collection is empty";
    private static final String DEFAULT_NOT_EMPTY_MAP_EX_MESSAGE = "The validated map is empty";
    private static final String DEFAULT_NOT_EMPTY_STRING_EX_MESSAGE = "The validated String is empty";
    private static final String DEFAULT_NOT_BLANK_STRING_EX_MESSAGE = "The validated String is blank";

    public static void isTrue(final boolean expression, final String message, final Double value) {
        if (!expression) {
            throw new IllegalArgumentException(String.format(message, value));
        }
    }

    public static void isTrue(final boolean expression, final String message, final Long value) {
        if (!expression) {
            throw new IllegalArgumentException(String.format(message, value));
        }
    }

    public static void isTrue(final boolean expression, final String message, final Object... values) {
        if (!expression) {
            throw new IllegalArgumentException(String.format(message, values));
        }
    }

    public static void isTrue(final boolean expression) {
        if (!expression) {
            throw new IllegalArgumentException(DEFAULT_IS_TRUE_ASSERT_MESSAGE);
        }
    }

    public static <T> T notNull(final T object, final String message, final Object... values) {
        if (object == null) {
            throw new IllegalArgumentException(String.format(message, values));
        }
        return object;
    }

    public static <T> T notNull(final T object) {
        if (object == null) {
            throw new IllegalArgumentException(DEFAULT_IS_NULL_ASSERT_MESSAGE);
        }
        return object;
    }

    //notEmpty
    //array
    public static <T> T[] notEmpty(final T[] array, final String message, Object... values) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException(String.format(message, values));
        }
        return array;
    }

    public static <T> T[] notEmpty(final T[] array) {
        return notEmpty(array, DEFAULT_NOT_EMPTY_ARRAY_EX_MESSAGE);
    }

    //notEmpty
    //Collection
    public static <T extends Collection<?>> T notEmpty(final T collection, final String message, Object... values) {
        if (collection == null || collection.isEmpty()) {
            throw new IllegalArgumentException(String.format(message, values));
        }
        return collection;
    }


    public static <T extends Collection<?>> T notEmpty(final T collection) {
        return notEmpty(collection, DEFAULT_NOT_EMPTY_COLLECTION_EX_MESSAGE);
    }

    //notEmpty
    //Map
    public static <T extends Map<?, ?>> T notEmpty(final T map, final String message, Object... values) {
        if (map == null || map.isEmpty()) {
            throw new IllegalArgumentException(String.format(message, values));
        }
        return map;
    }

    public static <T extends Map<?, ?>> T notEmpty(final T map) {
        return notEmpty(map, DEFAULT_NOT_EMPTY_MAP_EX_MESSAGE);
    }

    //notEmpty
    //CharSequence
    public static <T extends CharSequence> T notEmpty(final T string, final String message, Object... values) {
        if (string == null || string.length() == 0) {
            throw new IllegalArgumentException(String.format(message, values));
        }
        return string;
    }

    public static <T extends CharSequence> T notEmpty(final T string) {
        return notEmpty(string, DEFAULT_NOT_EMPTY_STRING_EX_MESSAGE);
    }


    private static boolean isBlank(final CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    //notBlank
    //CharSequence
    public static <T extends CharSequence> T notBlank(final T string, final String message, Object... values) {
        if (string == null || isBlank(string)) {
            throw new IllegalArgumentException(String.format(message, values));
        }
        return string;
    }

    public static <T extends CharSequence> T notBlank(final T string) {
        return notBlank(string, DEFAULT_NOT_BLANK_STRING_EX_MESSAGE);
    }


}
