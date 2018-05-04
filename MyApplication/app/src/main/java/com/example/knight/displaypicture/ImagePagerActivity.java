package com.example.knight.displaypicture;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by yg_DC on 2018/5/4.
 */

public class ImagePagerActivity extends FragmentActivity {
    private static final String STATE_POSITION = "STATE_POSITION";
    public static final String EXTRA_IMAGE_INDEX = "image_index";
    public static final String EXTRA_IMAGE_URLS = "image_urls";


    private HackyViewPager mPager;
    private int pagerPosition;
    private TextView indicator;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_detail_pager);

        pagerPosition=getIntent().getIntExtra(EXTRA_IMAGE_INDEX,0);
        ArrayList<String> urls=getIntent().getStringArrayListExtra(EXTRA_IMAGE_URLS);
        mPager=(HackyViewPager)findViewById(R.id.pager);
        ImagePagerAdapter mAdapter=new ImagePagerAdapter(getSupportFragmentManager(),urls);

        mPager.setAdapter(mAdapter);

        indicator=findViewById(R.id.indicator);
        CharSequence text=getString(R.string.viewpager_indicator,1,mPager.getAdapter().getCount());
        indicator.setText(text);

        mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                CharSequence text=getString(R.string.viewpager_indicator,position+1,mPager.getAdapter().getCount());
                indicator.setText(text);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        if(savedInstanceState!=null){
            pagerPosition=savedInstanceState.getInt(STATE_POSITION);
        }
        mPager.setCurrentItem(pagerPosition);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {

        outState.putInt(STATE_POSITION,mPager.getCurrentItem());
    }

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        return super.onCreateView(name, context, attrs);
    }

    private class ImagePagerAdapter extends FragmentStatePagerAdapter{

        public ArrayList<String> fileList;

        public ImagePagerAdapter(FragmentManager fm,ArrayList<String> fileList) {
            super(fm);
            this.fileList=fileList;
        }

        @Override
        public Fragment getItem(int position) {
            String url=fileList.get(position);

            return ImageDetailFragment.newInstance(url);
        }

        @Override
        public int getCount() {
            return  fileList==null?0:fileList.size();
        }
    }
}
