package com.tekinarslan.material.sample.customer;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.tekinarslan.material.sample.customer.SampleFragment4;

public class ViewPagerAdapter4 extends FragmentPagerAdapter {

    final int PAGE_COUNT =8;
    private String[] titles;

    public ViewPagerAdapter4(FragmentManager fm, String[] titles2) {
        super(fm);
        titles=titles2;
    }

    @Override
    public Fragment getItem(int position4) {
        switch (position4) {
            // Open FragmentTab1.java
            case 0:
                return SampleFragment4.newInstance(position4);
            case 1:
                return SampleFragment4.newInstance(position4);
            case 2:
                return SampleFragment4.newInstance(position4);
            case 3:
                return SampleFragment4.newInstance(position4);
            case 4:
                return SampleFragment4.newInstance(position4);
            case 5:
                return SampleFragment4.newInstance(position4);
            case 6:
                return SampleFragment4.newInstance(position4);
            case 7:
                return SampleFragment4.newInstance(position4);

        }
        return null;
    }

    public CharSequence getPageTitle(int position4) {
        return titles[position4];
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

}