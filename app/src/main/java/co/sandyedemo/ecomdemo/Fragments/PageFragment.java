package co.sandyedemo.ecomdemo.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import co.sandyedemo.ecomdemo.MVP.Product;
import co.sandyedemo.ecomdemo.Activities.MainActivity;
import co.sandyedemo.ecomdemo.R;
import co.sandyedemo.ecomdemo.Activities.SplashScreen;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PageFragment extends Fragment {
    public static PageFragment newInstance(int position) {
        Bundle args = new Bundle();
        args.putInt("position", position);
        PageFragment fragment = new PageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final int position = getArguments().getInt("position");
        int layout = R.layout.fragment_page_one;
        View root = inflater.inflate(layout, container, false);
        root.setTag(position);
        ImageView image_one = (ImageView) root.findViewById(R.id.image_one);
        image_one.setScaleType(ImageView.ScaleType.FIT_XY);
        try {
            Picasso.with(getActivity())
                    .load(SplashScreen.sliderListResponsesData.get(position).getImage())
                    .placeholder(R.drawable.defaultimage)
                    .into(image_one);
        }catch (Exception e)
        {

        }
        Log.d("positionOfSlider", position + "");
        image_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!Home.swipeRefreshLayout.isRefreshing()) {
                    Log.d("clickedPosition", position + "");
                    List<Product> list = new ArrayList<>();
                    list.add(SplashScreen.sliderListResponsesData.get(position).getProductsdetails());
                    ProductDetail.productList.clear();
                    ProductDetail.productList.addAll(list);
                    ProductDetail productDetail = new ProductDetail();
                    Bundle bundle = new Bundle();
                    bundle.putInt("position", 0);
                    productDetail.setArguments(bundle);
                    ((MainActivity) getActivity()).loadFragment(productDetail, true);
                }
            }
        });
        return root;
    }

}
