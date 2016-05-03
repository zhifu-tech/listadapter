package com.zhi.widget.list.uti;

import android.util.Log;

import static android.util.Log.ERROR;
import static android.util.Log.INFO;
import static android.util.Log.VERBOSE;
import static android.util.Log.WARN;

public final class Logs {
    private static String sLogTag = "zhi";

    private static final String LOG_PREFIX = sLogTag;
    private static final int LOG_PREFIX_LENGTH = sLogTag.length();
    private static final int MAX_LOG_TAG_LENGTH = 23;

    public static String makeLogTag(String str) {
        if (str.length() > MAX_LOG_TAG_LENGTH - LOG_PREFIX_LENGTH) {
            return LOG_PREFIX + str.substring(0, MAX_LOG_TAG_LENGTH - LOG_PREFIX_LENGTH - 1);
        }

        return LOG_PREFIX + str;
    }

    /**
     * Used to enable/disable logging that we don't want included in
     * production releases.
     * This should be set to DEBUG for production releases, and VERBOSE for
     * internal builds.
     */
    private static final int MAX_ENABLED_LOG_LEVEL = VERBOSE;

    /**
     * Checks to see whether or not a log for the specified tag is loggable at the specified level.
     */
    public static boolean isLoggable(String tag, int level) {
        if (MAX_ENABLED_LOG_LEVEL > level) {
            return false;
        }
        return Log.isLoggable(tag, level) || Log.isLoggable(sLogTag, level);
    }

    /**
     * Send a {@link Log#VERBOSE} log message.
     *
     * @param tag    Used to identify the source of a log message.  It usually identifies
     *               the class or activity where the log call occurs.
     * @param format the format string (see {@link java.util.Formatter#format})
     * @param args   the list of arguments passed to the formatter. If there are
     *               more arguments than required by {@code format},
     *               additional arguments are ignored.
     */
    public static int v(String tag, String format, Object... args) {
        if (isLoggable(tag, VERBOSE)) {
            return Log.v(tag, String.format(format, args));
        }
        return 0;
    }

    /**
     * Send a {@link Log#VERBOSE} log message.
     *
     * @param tag    Used to identify the source of a log message.  It usually identifies
     *               the class or activity where the log call occurs.
     * @param tr     An exception to log
     * @param format the format string (see {@link java.util.Formatter#format})
     * @param args   the list of arguments passed to the formatter. If there are
     *               more arguments than required by {@code format},
     *               additional arguments are ignored.
     */
    public static int v(String tag, Throwable tr, String format, Object... args) {
        if (isLoggable(tag, VERBOSE)) {
            return Log.v(tag, String.format(format, args), tr);
        }
        return 0;
    }

    /**
     * Send a {@link Log#DEBUG} log message.
     *
     * @param tag    Used to identify the source of a log message.  It usually identifies
     *               the class or activity where the log call occurs.
     * @param format the format string (see {@link java.util.Formatter#format})
     * @param args   the list of arguments passed to the formatter. If there are
     *               more arguments than required by {@code format},
     *               additional arguments are ignored.
     */
    public static int d(String tag, String format, Object... args) {
        if (isLoggable(tag, Log.DEBUG)) {
            return Log.d(tag, String.format(format, args));
        }
        return 0;
    }

    /**
     * Send a {@link Log#DEBUG} log message.
     *
     * @param tag    Used to identify the source of a log message.  It usually identifies
     *               the class or activity where the log call occurs.
     * @param tr     An exception to log
     * @param format the format string (see {@link java.util.Formatter#format})
     * @param args   the list of arguments passed to the formatter. If there are
     *               more arguments than required by {@code format},
     *               additional arguments are ignored.
     */
    public static int d(String tag, Throwable tr, String format, Object... args) {
        if (isLoggable(tag, Log.DEBUG)) {
            return Log.d(tag, String.format(format, args), tr);
        }
        return 0;
    }

    /**
     * Send a {@link Log#INFO} log message.
     *
     * @param tag    Used to identify the source of a log message.  It usually identifies
     *               the class or activity where the log call occurs.
     * @param format the format string (see {@link java.util.Formatter#format})
     * @param args   the list of arguments passed to the formatter. If there are
     *               more arguments than required by {@code format},
     *               additional arguments are ignored.
     */
    public static int i(String tag, String format, Object... args) {
        if (isLoggable(tag, INFO)) {
            return Log.i(tag, String.format(format, args));
        }
        return 0;
    }

    /**
     * Send a {@link Log#INFO} log message.
     *
     * @param tag    Used to identify the source of a log message.  It usually identifies
     *               the class or activity where the log call occurs.
     * @param tr     An exception to log
     * @param format the format string (see {@link java.util.Formatter#format})
     * @param args   the list of arguments passed to the formatter. If there are
     *               more arguments than required by {@code format},
     *               additional arguments are ignored.
     */
    public static int i(String tag, Throwable tr, String format, Object... args) {
        if (isLoggable(tag, INFO)) {
            return Log.i(tag, String.format(format, args), tr);
        }
        return 0;
    }

    /**
     * Send a {@link Log#WARN} log message.
     *
     * @param tag    Used to identify the source of a log message.  It usually identifies
     *               the class or activity where the log call occurs.
     * @param format the format string (see {@link java.util.Formatter#format})
     * @param args   the list of arguments passed to the formatter. If there are
     *               more arguments than required by {@code format},
     *               additional arguments are ignored.
     */
    public static int w(String tag, String format, Object... args) {
        if (isLoggable(tag, WARN)) {
            return Log.w(tag, String.format(format, args));
        }
        return 0;
    }

    /**
     * Send a {@link Log#WARN} log message.
     *
     * @param tag    Used to identify the source of a log message.  It usually identifies
     *               the class or activity where the log call occurs.
     * @param tr     An exception to log
     * @param format the format string (see {@link java.util.Formatter#format})
     * @param args   the list of arguments passed to the formatter. If there are
     *               more arguments than required by {@code format},
     *               additional arguments are ignored.
     */
    public static int w(String tag, Throwable tr, String format, Object... args) {
        if (isLoggable(tag, WARN)) {
            return Log.w(tag, String.format(format, args), tr);
        }
        return 0;
    }

    /**
     * Send a {@link Log#ERROR} log message.
     *
     * @param tag    Used to identify the source of a log message.  It usually identifies
     *               the class or activity where the log call occurs.
     * @param format the format string (see {@link java.util.Formatter#format})
     * @param args   the list of arguments passed to the formatter. If there are
     *               more arguments than required by {@code format},
     *               additional arguments are ignored.
     */
    public static int e(String tag, String format, Object... args) {
        if (isLoggable(tag, ERROR)) {
            return Log.e(tag, String.format(format, args));
        }
        return 0;
    }

    /**
     * Send a {@link Log#ERROR} log message.
     *
     * @param tag    Used to identify the source of a log message.  It usually identifies
     *               the class or activity where the log call occurs.
     * @param tr     An exception to log
     * @param format the format string (see {@link java.util.Formatter#format})
     * @param args   the list of arguments passed to the formatter. If there are
     *               more arguments than required by {@code format},
     *               additional arguments are ignored.
     */
    public static int e(String tag, Throwable tr, String format, Object... args) {
        if (isLoggable(tag, ERROR)) {
            return Log.e(tag, String.format(format, args), tr);
        }
        return 0;
    }

    /**
     * What a Terrible Failure: Report a condition that should never happen.
     * The error will always be logged at level ASSERT with the call stack.
     * Depending on system configuration, a report may be added to the
     * {@link android.os.DropBoxManager} and/or the process may be terminated
     * immediately with an error dialog.
     *
     * @param tag    Used to identify the source of a log message.  It usually identifies
     *               the class or activity where the log call occurs.
     * @param format the format string (see {@link java.util.Formatter#format})
     * @param args   the list of arguments passed to the formatter. If there are
     *               more arguments than required by {@code format},
     *               additional arguments are ignored.
     */
    public static int wtf(String tag, String format, Object... args) {
        return Log.wtf(tag, String.format(format, args), new Error());
    }

    /**
     * What a Terrible Failure: Report a condition that should never happen.
     * The error will always be logged at level ASSERT with the call stack.
     * Depending on system configuration, a report may be added to the
     * {@link android.os.DropBoxManager} and/or the process may be terminated
     * immediately with an error dialog.
     *
     * @param tag    Used to identify the source of a log message.  It usually identifies
     *               the class or activity where the log call occurs.
     * @param tr     An exception to log
     * @param format the format string (see {@link java.util.Formatter#format})
     * @param args   the list of arguments passed to the formatter. If there are
     *               more arguments than required by {@code format},
     *               additional arguments are ignored.
     */
    public static int wtf(String tag, Throwable tr, String format, Object... args) {
        return Log.wtf(tag, String.format(format, args), tr);
    }
}
