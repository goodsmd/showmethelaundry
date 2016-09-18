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
public class SampleFragment3 extends Fragment{

    private static final String ARG_POSITION = "position3";

    private int position3;

    public static SampleFragment3 newInstance(int position3) {
        SampleFragment3 f = new SampleFragment3();
        Bundle b = new Bundle();
        b.putInt(ARG_POSITION, position3);
        f.setArguments(b);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        position3 = getArguments().getInt(ARG_POSITION);
        View rootView3 = inflater.inflate(R.layout.activity_orderitem, container, false);

        return rootView3;
    }
}

