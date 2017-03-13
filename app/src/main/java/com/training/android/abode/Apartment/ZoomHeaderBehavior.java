package com.training.android.abode.Apartment;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

import com.training.android.abode.R;


public class ZoomHeaderBehavior extends CoordinatorLayout.Behavior<View> {
  public ZoomHeaderBehavior(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  private boolean isFirst = true;
  private ZoomHeaderView mDependency;


  @Override
  public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
    return dependency instanceof ZoomHeaderView;
  }

  @Override
  public boolean onDependentViewChanged(CoordinatorLayout parent, final View child,
                                        View dependency) {
    init((RecyclerView) child, dependency);


    child.setY(dependency.getY() + dependency.getHeight());

    ViewPager viewPager = ((ZoomHeaderView) dependency).getViewPager();

    for (int i = 0; i <viewPager.getChildCount(); i++) {

      changeView(child, dependency, viewPager, i);
    }

    return super.onDependentViewChanged(parent, child, dependency);
  }


  private void changeView(View child, View dependency, ViewPager viewPager, int i) {
    View view = viewPager.getChildAt(i);
    View target = view.findViewById(R.id.linearLayout);
    View img = view.findViewById(R.id.imageView);
    View bottom = view.findViewById(R.id.ll_bottom);
    View buyButton = view.findViewById(R.id.btn_buy);
    View nameTxt = view.findViewById(R.id.tv_name);
    View costText = view.findViewById(R.id.tv_cost);
    View left = null;

    if (viewPager.getCurrentItem() > 0) {
      left = viewPager.getChildAt(viewPager.getCurrentItem() - 1);
    }

    float progress = -dependency.getY() / dependency.getHeight() * 2;


    child.setAlpha(progress * 2);



    if (target.getWidth() * (1 + progress) <= dependency.getWidth()) {

      if (progress > 0) {

        bottom.offsetLeftAndRight(
            (int) (target.getWidth() / 2 - target.getWidth() * (1 + progress) / 2
                + MarginConfig.MARGIN_LEFT_RIGHT - bottom.getX()));


        buyButton.offsetLeftAndRight(
            (int) (target.getWidth() / 2 + target.getWidth() * (1 + progress) / 2
                - buyButton.getWidth()
                - MarginConfig.MARGIN_LEFT_RIGHT
                - buyButton.getX()));


        buyButton.offsetTopAndBottom((int) (bottom.getY()
            + (costText.getY() + costText.getHeight() - nameTxt.getY()) / 2
            + nameTxt.getY() - buyButton.getHeight() / 2 - buyButton.getY()));
      }
    }


      if (progress > 0 && progress < 0.8) {


        target.setScaleX(1 + progress);

        img.setScaleY(1 + progress);
      }
  }


  private void init(final RecyclerView child, View dependency) {
    if (isFirst) {
      mDependency = (ZoomHeaderView) dependency;
      isFirst = false;
      mDependency.setRecyclerView(child);
      child.addOnScrollListener(new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
          super.onScrollStateChanged(recyclerView, newState);
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {


          if (child.getChildAt(0).getY() == 0) {
            mDependency.restore(mDependency.getY());
          }
          super.onScrolled(recyclerView, dx, dy);
        }
      });
    }
  }

  @Override
  public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child,
                                     View directTargetChild, View target, int nestedScrollAxes) {

    return (nestedScrollAxes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
  }

  @Override
  public boolean onNestedFling(CoordinatorLayout coordinatorLayout, View child, View target,
                               float velocityX, float velocityY, boolean consumed) {

    if (velocityY < 0 && ((RecyclerView) target).getChildAt(0).getY() == 0) {
      mDependency.restore(mDependency.getY());
    }
    return super.onNestedFling(coordinatorLayout, child, target, velocityX, velocityY, consumed);
  }

  @Override
  public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target,
                                int dx, int dy, int[] consumed) {

    if (((RecyclerView) target).getChildAt(0).getY() == 0) {

      if (dy < 0) {
        mDependency.setY(mDependency.getY() - dy);

        if (mDependency.getY() < 500) {
          mDependency.restore(mDependency.getY());
        }
      }
    }
    super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
  }
}
