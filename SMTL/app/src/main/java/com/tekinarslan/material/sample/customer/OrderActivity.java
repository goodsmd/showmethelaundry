package com.tekinarslan.material.sample.customer;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.tekinarslan.material.sample.R;
import com.tekinarslan.material.sample.SlidingTabLayout;

//주문

public class OrderActivity extends ActionBarActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle drawerToggle;

    private ListView mDrawerList;
    ViewPager pager;
    private String[] titles = new String[]{"정장", "아우터", "Tab 3", "Tab 4"
            , "Tab 5", "Tab 6", "Tab 7", "Tab 8"};
    private Toolbar toolbar;


    SlidingTabLayout slidingTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.navdrawer);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setNavigationIcon(R.drawable.ic_ab_drawer);
        }
        pager = (ViewPager) findViewById(R.id.viewpager);
        slidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tabs);
        pager.setAdapter(new ViewPagerAdapter3(getSupportFragmentManager(), titles));
        slidingTabLayout.setViewPager(pager);
        slidingTabLayout.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return Color.WHITE;
            }
        });

        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        Toast.makeText(getApplicationContext(),"0번",Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(getApplicationContext(),"1번",Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(getApplicationContext(),"2번",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        drawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.app_name, R.string.app_name);
        mDrawerLayout.setDrawerListener(drawerToggle);
        mDrawerLayout.closeDrawer(Gravity.START);
        String[] values = new String[]{
                "세탁물 조회", "세탁소 검색", "주문하기", "설정"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);
        mDrawerList.setAdapter(adapter);
        mDrawerList.setBackgroundColor(getResources().getColor(R.color.red));
        toolbar.setBackgroundColor(getResources().getColor(R.color.red));
        slidingTabLayout.setBackgroundColor(getResources().getColor(R.color.red));
        mDrawerLayout.closeDrawer(Gravity.START);
        mDrawerLayout.closeDrawer(Gravity.START);
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                switch (position) {
                    case 0:
                        Toast.makeText(getApplicationContext(), "세탁물 조회가 터치되었습니다", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(OrderActivity.this, ContentActivity.class);
                        OrderActivity.this.startActivity(intent);
                        mDrawerLayout.closeDrawer(Gravity.START);

                        break;
                    case 1:
                        Toast.makeText(getApplicationContext(), "세탁소 검색이 터치되었습니다", Toast.LENGTH_SHORT).show();
                        Intent intent2 = new Intent(OrderActivity.this, LaundrySearchActivity.class);
                        OrderActivity.this.startActivity(intent2);
                        mDrawerLayout.closeDrawer(Gravity.START);

                        break;
                    case 2:
                        Toast.makeText(getApplicationContext(), "주문하기가 터치되었습니다", Toast.LENGTH_SHORT).show();
                        Intent intent3 = new Intent(OrderActivity.this, OrderActivity.class);
                        OrderActivity.this.startActivity(intent3);
                        mDrawerLayout.closeDrawer(Gravity.START);

                        break;
                    case 3:
                        Toast.makeText(getApplicationContext(), "설정 터치되었습니다", Toast.LENGTH_SHORT).show();
                        Intent intent4 = new Intent(OrderActivity.this, SettingActivity.class);
                        OrderActivity.this.startActivity(intent4);
                        mDrawerLayout.closeDrawer(Gravity.START);

                        break;
                }

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(Gravity.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

}
