package com.ztrix;

import java.lang.reflect.Array;

import android.util.Log;

public class Zlog {
    private static final String TAG = "TAG";        // modify this

    private static final String INDENTATION = "----";

    private static String getLogPosition() {
        int first = 3;
        Exception e = new Exception();
        StackTraceElement [] ses = e.getStackTrace();
        return "[" + ses[first].getFileName() + ":" + ses[first].getLineNumber() + ", " + ses[first].getMethodName() + "]";
    }

    private static String getLogString(Object ...log) {
        StringBuilder sb = new StringBuilder();
        sb.append(getLogPosition() + ": ");
        boolean nextline = false;
        if (log != null) {
            for (int i = 0; i < log.length; i++) {
                if (log[i] == null) {
                    if (nextline) {
                        sb.append(INDENTATION);
                        nextline = false;
                    } else if (i > 0) {
                        sb.append(", ");
                    }
                    sb.append("null");
                } else if (log[i] instanceof Exception) {
                    sb.append('\n');
                    nextline = true;
                    Exception e = (Exception)log[i];
                    sb.append(INDENTATION + e.toString() + "\n");
                    StackTraceElement[] stes = e.getStackTrace();
                    for (StackTraceElement ste: stes) {
                        sb.append(INDENTATION);
                        sb.append(INDENTATION);
                        sb.append(ste.toString());
                        sb.append('\n');
                    }
                } else if (log[i].getClass().isArray()) {
                    if (nextline) {
                        sb.append(INDENTATION);
                        nextline = false;
                    } else if (i > 0) {
                        sb.append(", ");
                    }
                    sb.append("[");
                    for (int j = 0; j < Array.getLength(log[i]); j++) {
                        if (j > 0) {
                            sb.append(", ");
                        }
                        sb.append(Array.get(log[i], j).toString());
                    }
                    sb.append("]");
                } else {
                    String []lines = log[i].toString().split("\n");
                    if (lines.length == 1) {
                        if (nextline) {
                            sb.append(INDENTATION);
                            nextline = false;
                        } else if (i > 0) {
                            sb.append(", ");
                        }
                        sb.append(lines[0]);
                    } else {
                        sb.append('\n');
                        nextline = true;
                        for (String line: lines) {
                            sb.append(INDENTATION);
                            sb.append(line.toString());
                            sb.append('\n');
                        }
                    }
                }
            }
        }
        return sb.toString();
    }

    public static void i(Object ...log) {
        Log.i(TAG, getLogString(log));
    }

    public static void w(Object ...log) {
        Log.w(TAG, getLogString(log));
    }

    public static void d(Object ...log) {
        Log.d(TAG, getLogString(log));
    }

    public static void v(Object ...log) {
        Log.v(TAG, getLogString(log));
    }

    public static void e(Object ...log) {
        Log.e(TAG, getLogString(log));
    }
}
