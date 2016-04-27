package com.androidapp.yanx.lan_gtd.gank.ui;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.androidapp.yanx.lan_gtd.R;
import com.androidapp.yanx.lan_gtd.gank.presenters.CategoryActPresenter;
import com.androidapp.yanx.lan_gtd.gank.ui.iview.IViewBase;

import butterknife.Bind;

/**
 * com.androidapp.yanx.lan_gtd.gank.ui
 * Created by yanx on 4/26/16 5:11 PM.
 * Description ${TODO}
 */
public class GankCategoryActivity extends ToolBarBaseActivity<CategoryActPresenter> implements IViewBase {


    @Bind(R.id.tab_layout)
    TabLayout tabLayout;

    @Bind(R.id.view_pager)
    ViewPager viewPager;

    @Bind(R.id.fab)
    FloatingActionButton fab;
    //    Android | iOS | 休息视频 | 福利 | 拓展资源 | 前端 | 瞎推荐 | App


    @Override
    public int getLayoutId() {
        return R.layout.activity_gank_category;
    }

    @Override
    public void initPresenter() {
        presenter = new CategoryActPresenter(this, this);
        presenter.init();
    }

    @Override
    public void initView() {
        viewPager.setAdapter(new MyPageAdapter(getSupportFragmentManager()));
        viewPager.setOffscreenPageLimit(5);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.blue));
        tabLayout.setTabTextColors(getResources().getColor(R.color.blue), getResources().getColor(R.color.white));
    }

    class MyPageAdapter extends FragmentStatePagerAdapter {

        final String[] tabs = new String[]{"Android", "iOS", "休息视频", "福利", "拓展资源", "前端", "瞎推荐", "App"};

        public MyPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return tabs.length;
        }

        @Override
        public Fragment getItem(int position) {
            return GanhuoFragment.newInstance(tabs[position]);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabs[position];
        }
    }
}
