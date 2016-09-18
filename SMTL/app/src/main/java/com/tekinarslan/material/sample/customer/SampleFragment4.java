package com.tekinarslan.material.sample.customer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tekinarslan.material.sample.R;

/**
 * Created by 권기성 on 2016-08-25.
 */
public class SampleFragment4 extends Fragment{

    private static final String ARG_POSITION = "position3";

    private int position4;

    public static SampleFragment4 newInstance(int position4) {
        SampleFragment4 f = new SampleFragment4();
        Bundle b = new Bundle();
        b.putInt(ARG_POSITION, position4);
        f.setArguments(b);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        position4 = getArguments().getInt(ARG_POSITION);
        View rootView4 = inflater.inflate(R.layout.activity_setting, container, false);

        return rootView4;
    }
}

