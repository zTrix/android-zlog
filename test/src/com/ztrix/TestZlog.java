package com.ztrix;

import com.test.R;

import android.app.Activity;
import android.os.Bundle;

public class TestZlog extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Zlog.i(1);
        Zlog.v("string");
        Zlog.i(new int[]{1,2,3});
        Zlog.d(1, null, "log String test", new int[]{100, 101, 102}, new String[]{"a", "b", "c"});
        Zlog.e(new Exception());
        Zlog.w(new Object());
    }
}
