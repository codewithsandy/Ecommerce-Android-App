package co.sandyedemo.ecomdemo.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import co.sandyedemo.ecomdemo.Fragments.PageFragment;
import co.sandyedemo.ecomdemo.MVP.SliderListResponse;

import java.util.List;

public class MyPagerAdapter extends FragmentStatePagerAdapter {
    public static int LOOPS_COUNT = 1000;
    private List<SliderListResponse> sliderListResponsesData;


    public MyPagerAdapter(FragmentManager manager, List<SliderListResponse> sliderListResponsesData) {
        super(manager);
        this.sliderListResponsesData = sliderListResponsesData;
    }


    @Override
    public Fragment getItem(int position) {
        if (sliderListResponsesData != null && sliderListResponsesData.size() > 0) {
            position = position % sliderListResponsesData.size(); // use modulo for infinite cycling
            return PageFragment.newInstance(position);
        } else {
            return PageFragment.newInstance(0);
        }
    }


    @Override
    public int getCount() {
        if (sliderListResponsesData != null && sliderListResponsesData.size() > 0) {
            return sliderListResponsesData.size() * LOOPS_COUNT; // simulate infinite by big number of products
        } else {
            return 1;
        }
    }
} 