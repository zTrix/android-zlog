# Zlog is a simple enhanced log tool for Android

# Usage
just copy Zlog.java into your project, and set the package and TAG properly, it will serve for you.

# Example

    Zlog.i(1);
    Zlog.v("string");
    Zlog.i(new int[]{1,2,3});
    Zlog.d(1, null, "log String test", new int[]{100, 101, 102}, new String[]{"a", "b", "c"});
    Zlog.e(new Exception());
    Zlog.w(new Object());

# Log Output

    :)#adb logcat TAG:V *:S
    --------- beginning of /dev/log/system
    --------- beginning of /dev/log/main
    I/TAG     (25064): [TestZlog.java:17, onCreate]: 1
    V/TAG     (25064): [TestZlog.java:18, onCreate]: string
    I/TAG     (25064): [TestZlog.java:19, onCreate]: [1, 2, 3]
    D/TAG     (25064): [TestZlog.java:20, onCreate]: 1, null, log String test, [100, 101, 102], [a, b, c]
    E/TAG     (25064): [TestZlog.java:21, onCreate]: 
    E/TAG     (25064): ----java.lang.Exception
    E/TAG     (25064): --------com.ztrix.TestZlog.onCreate(TestZlog.java:21)
    E/TAG     (25064): --------android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1047)
    E/TAG     (25064): --------android.app.ActivityThread.performLaunchActivity(ActivityThread.java:1628)
    E/TAG     (25064): --------android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:1680)
    E/TAG     (25064): --------android.app.ActivityThread.access$1500(ActivityThread.java:117)
    E/TAG     (25064): --------android.app.ActivityThread$H.handleMessage(ActivityThread.java:931)
    E/TAG     (25064): --------android.os.Handler.dispatchMessage(Handler.java:99)
    E/TAG     (25064): --------android.os.Looper.loop(Looper.java:130)
    E/TAG     (25064): --------android.app.ActivityThread.main(ActivityThread.java:3703)
    E/TAG     (25064): --------java.lang.reflect.Method.invokeNative(Native Method)
    E/TAG     (25064): --------java.lang.reflect.Method.invoke(Method.java:507)
    E/TAG     (25064): --------com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:841)
    E/TAG     (25064): --------com.android.internal.os.ZygoteInit.main(ZygoteInit.java:599)
    E/TAG     (25064): --------dalvik.system.NativeStart.main(Native Method)
    W/TAG     (25064): [TestZlog.java:22, onCreate]: java.lang.Object@4051a410

