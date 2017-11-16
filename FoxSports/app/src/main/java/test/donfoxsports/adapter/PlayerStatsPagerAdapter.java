package test.donfoxsports.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import test.donfoxsports.view.fragment.PlayerStatsFragment;

/**
 * Created by don.chummar on 16/11/17.
 */

public class PlayerStatsPagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<String> pageTitle;

    public PlayerStatsPagerAdapter(FragmentManager fm) {
        super(fm);
        pageTitle = new ArrayList<>();
    }

    @Override
    public Fragment getItem(int position) {
        Log.v("Miles", "getItem called");
        return PlayerStatsFragment.newInstance(position);
    }


    @Override
    public int getCount() {
        return pageTitle.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return pageTitle.get(position);
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    public void updateTitle(ArrayList<String> pageTitle) {
        this.pageTitle = new ArrayList<>();
        this.pageTitle = pageTitle;
        notifyDataSetChanged();
    }
}
