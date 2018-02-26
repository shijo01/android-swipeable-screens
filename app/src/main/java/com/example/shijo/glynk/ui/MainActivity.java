package com.example.shijo.glynk.ui;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.shijo.glynk.R;
import com.example.shijo.glynk.adapters.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {
    public static final String SPORTS = "Sports";
    public static final String TECHNOLOGIES = "Technologies";
    public static final String DESIGN = "Design";
    public static final String POLITICS = "Politics";
    public static final String MOVIES = "Movies";
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ViewPagerAdapter mViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = findViewById(R.id.viewpager);
        mTabLayout = findViewById(R.id.tabs);

        setupViewPager();

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (mViewPager != null) {
                    mViewPager.setCurrentItem(tab.getPosition());
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                if (mViewPager != null) {
                    mViewPager.setCurrentItem(tab.getPosition());
                }
            }
        });
    }

    private void setupViewPager() {
        mViewPagerAdapter = new ViewPagerAdapter(getFragmentManager());
        ContentFragment sports = ContentFragment.newInstance(SPORTS);
        ContentFragment technologies = ContentFragment.newInstance(TECHNOLOGIES);
        ContentFragment design = ContentFragment.newInstance(DESIGN);
        ContentFragment politics = ContentFragment.newInstance(POLITICS);
        ContentFragment movies = ContentFragment.newInstance(MOVIES);

        mViewPagerAdapter.addFragment(sports, SPORTS);
        mViewPagerAdapter.addFragment(technologies, TECHNOLOGIES);
        mViewPagerAdapter.addFragment(design, DESIGN);
        mViewPagerAdapter.addFragment(politics, POLITICS);
        mViewPagerAdapter.addFragment(movies, MOVIES);

        mViewPager.setAdapter(mViewPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

}
