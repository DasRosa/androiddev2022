package vn.edu.usth.weather;

import android.annotation.SuppressLint;

import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class FragmentAdapter extends FragmentPagerAdapter {
    private String titles[] = new String[] { "Hanoi", "Paris", "Toulouse" };

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public int getCount() {
        return 3; // number of pages for a ViewPager
    }
    @Override
    public Fragment getItem(int page) {
        return WeatherAndForecastFragment.newInstance(titles[page], "");
    }
    @Override
    public CharSequence getPageTitle(int page) {
        // returns a tab title corresponding to the specified page
        return titles[page];
    }
}