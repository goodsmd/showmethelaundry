package com.tekinarslan.material.sample.customer;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.tekinarslan.material.sample.customer.SampleFragment2;

public class ViewPagerAdapter2 extends FragmentPagerAdapter {

    final int PAGE_COUNT =8;
    private String[] titles;

    public ViewPagerAdapter2(FragmentManager fm, String[] titles2) {
        super(fm);
        titles=titles2;
    }

    @Override
    public Fragment getItem(int position2) {
        switch (position2) {
            // Open FragmentTab1.java
            case 0:
                return SampleFragment2.newInstance(position2);
            case 1:
                return SampleFragment2.newInstance(position2);
            case 2:
                return SampleFragment2.newInstance(position2);
            case 3:
                return SampleFragment2.newInstance(position2);
            case 4:
                return SampleFragment2.newInstance(position2);
            case 5:
                return SampleFragment2.newInstance(position2);
            case 6:
                return SampleFragment2.newInstance(position2);
            case 7:
                return SampleFragment2.newInstance(position2);

        }
        return null;
    }

    public CharSequence getPageTitle(int position2) {
        return titles[position2];
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

}