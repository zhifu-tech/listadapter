package com.zhi.widget.list.samples.util;

public class Util {
    public static int safeOfInt(String value, int def) {
        try {
            return Integer.parseInt(value);
        } catch (Throwable throwable) {
            return def;
        }
    }
}
