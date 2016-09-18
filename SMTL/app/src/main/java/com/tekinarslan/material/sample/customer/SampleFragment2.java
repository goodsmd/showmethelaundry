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
public class SampleFragment2 extends Fragment{

    private static final String ARG_POSITION = "position2";

    private int position2;

    public static SampleFragment2 newInstance(int position2) {
        SampleFragment2 f = new SampleFragment2();
        Bundle b = new Bundle();
        b.putInt(ARG_POSITION, position2);
        f.setArguments(b);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        position2 = getArguments().getInt(ARG_POSITION);
        View rootView2 = inflater.inflate(R.layout.activity_search, container, false);

        return rootView2;
    }
}

