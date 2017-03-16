package com.training.android.abode;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.training.android.abode.Adapter.ListAdapter;
import com.training.android.abode.Apartment.CtrlLinearLayoutManager;
import com.training.android.abode.Apartment.MarginConfig;
import com.training.android.abode.Apartment.ZoomHeaderView;

import java.util.ArrayList;

/**
 * Created by Lenovo on 3/12/2017.
 */

public class ApartmentActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ViewPager mViewPager;
    private ZoomHeaderView mZoomHeader;
    private boolean isFirst = true;

    private RelativeLayout mBottomView;

    public static int bottomY;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apartment);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mZoomHeader = (ZoomHeaderView) findViewById(R.id.zoomHeader);
        mViewPager.setAdapter(new Adapter());
        mViewPager.setOffscreenPageLimit(4);
        CtrlLinearLayoutManager layoutManager = new CtrlLinearLayoutManager(this);


        layoutManager.setScrollEnabled(false);
        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerView.setAdapter(new ListAdapter());
        mRecyclerView.setAlpha(0);
        mBottomView = (RelativeLayout) findViewById(R.id.rv_bottom);
    }

    @Override public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (isFirst) {
            for (int i = 0; i < mViewPager.getChildCount(); i++) {
                View v = mViewPager.getChildAt(i).findViewById(R.id.ll_bottom);
                v.setY(mViewPager.getChildAt(i).findViewById(R.id.imageView).getHeight());
                v.setX(MarginConfig.MARGIN_LEFT_RIGHT);

                mZoomHeader.setY(mZoomHeader.getY() - 1);
                isFirst = false;
            }
        }

        bottomY = (int) mBottomView.getY();
        mBottomView.setTranslationY(mBottomView.getY() + mBottomView.getHeight());
        mZoomHeader.setBottomView(mBottomView, bottomY);
    }

    class Adapter extends PagerAdapter {
        public Adapter() {
            views = new ArrayList<>();
            views.add(View.inflate(ApartmentActivity.this, R.layout.item_img, null));
            views.get(0).findViewById(R.id.btn_buy).setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    Toast.makeText(ApartmentActivity.this, "Rent", Toast.LENGTH_SHORT).show();
                }
            });
            views.add(View.inflate(ApartmentActivity.this, R.layout.item_img, null));

            views.add(View.inflate(ApartmentActivity.this, R.layout.item_img, null));

            views.add(View.inflate(ApartmentActivity.this, R.layout.item_img, null));

            views.add(View.inflate(ApartmentActivity.this, R.layout.item_img, null));
        }

        private ArrayList<View> views;
        private int[] imgs = { R.drawable.condo1, R.drawable.condo2, R.drawable.condo4, R.drawable.condo, R.drawable.condo3 };

        @Override public int getCount() {
            return views.size();
        }

        @Override public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override public Object instantiateItem(ViewGroup container, int position) {
            views.get(position).findViewById(R.id.imageView).setBackgroundResource(imgs[position]);
            container.addView(views.get(position));

            return views.get(position);
        }

        @Override public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(views.get(position));
        }
    }

    @Override protected void onResume() {
        super.onResume();
    }

    @Override public void onBackPressed() {

        if (mZoomHeader.isExpand()) {
            mZoomHeader.restore(mZoomHeader.getY());
        } else {
            finish();
        }
    }
}


