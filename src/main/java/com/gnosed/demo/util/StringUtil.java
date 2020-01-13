package com.gnosed.demo.util;

public class StringUtil {
    public StringUtil() {
    }

    public static boolean isEmpty(String str) {
        if (str == null) {
            return true;
        } else {
            return "".equals(str.trim()) ? true : str.isEmpty();
        }
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
}
