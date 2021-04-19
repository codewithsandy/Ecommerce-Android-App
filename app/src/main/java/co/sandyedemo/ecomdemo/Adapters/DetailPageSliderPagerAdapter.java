package co.sandyedemo.ecomdemo.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import co.sandyedemo.ecomdemo.Fragments.DetailPageFragment;

import java.util.ArrayList;
import java.util.List;

public class DetailPageSliderPagerAdapter extends FragmentStatePagerAdapter {
    public static int LOOPS_COUNT = 1000;
    private List<String> imagesList;


    public DetailPageSliderPagerAdapter(FragmentManager manager, List<String> imagesList) {
        super(manager);
        this.imagesList = imagesList;
    }


    @Override
    public Fragment getItem(int position) {
        if (imagesList != null && imagesList.size() > 0) {
            position = position % imagesList.size(); // use modulo for infinite cycling
            return DetailPageFragment.newInstance(position, (ArrayList<String>) imagesList);
        } else {
            return DetailPageFragment.newInstance(0, (ArrayList<String>) imagesList);
        }
    }


    @Override
    public int getCount() {
        if (imagesList != null && imagesList.size() > 1) {
            return imagesList.size() * LOOPS_COUNT; // simulate infinite by big number of products
        } else {
            return 1;
        }
    }
} 