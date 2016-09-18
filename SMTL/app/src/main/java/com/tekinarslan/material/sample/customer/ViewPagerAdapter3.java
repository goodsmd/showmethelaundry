package com.tekinarslan.material.sample.customer;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.tekinarslan.material.sample.customer.SampleFragment3;

public class ViewPagerAdapter3 extends FragmentPagerAdapter {

    final int PAGE_COUNT =8;
    private String[] titles;

    public ViewPagerAdapter3(FragmentManager fm, String[] titles2) {
        super(fm);
        titles=titles2;
    }

    @Override
    public Fragment getItem(int position3) {
        switch (position3) {
            // Open FragmentTab1.java
            case 0:
                return SampleFragment3.newInstance(position3);
            case 1:
                return SampleFragment3.newInstance(position3);
            case 2:
                return SampleFragment3.newInstance(position3);
            case 3:
                return SampleFragment3.newInstance(position3);
            case 4:
                return SampleFragment3.newInstance(position3);
            case 5:
                return SampleFragment3.newInstance(position3);
            case 6:
                return SampleFragment3.newInstance(position3);
            case 7:
                return SampleFragment3.newInstance(position3);

        }
        return null;
    }

    public CharSequence getPageTitle(int position3) {
        return titles[position3];
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

}