package co.sandyedemo.ecomdemo.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import co.sandyedemo.ecomdemo.Adapters.SearchProductListAdapter;
import co.sandyedemo.ecomdemo.MVP.Product;
import co.sandyedemo.ecomdemo.Activities.MainActivity;
import co.sandyedemo.ecomdemo.R;
import co.sandyedemo.ecomdemo.Activities.SplashScreen;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchProducts extends Fragment {

    @BindView(R.id.searchProductsRecyclerView)
    RecyclerView searchProductsRecyclerView;
    @BindView(R.id.searchEditText)
    EditText searchEditText;
    List<Product> productList;

    @BindView(R.id.defaultMessage)
    TextView defaultMessage;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.activity_search_products, container, false);
        ButterKnife.bind(this, view);
        defaultMessage.setText("Search Any Product");
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                Log.d("text", editable.toString());
                searchProducts(editable.toString());
            }
        });
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        ((MainActivity) getActivity()).lockUnlockDrawer(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        MainActivity.title.setText("Search");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    private void searchProducts(String s) {
        productList = new ArrayList<>();
        if (s.length() > 0) {
            for (int i = 0; i < SplashScreen.allProductsData.size(); i++)
                if (SplashScreen.allProductsData.get(i).getProductName().toLowerCase().contains(s.toLowerCase().trim())) {
                    productList.add(SplashScreen.allProductsData.get(i));
                }
            if (productList.size() < 1) {
                defaultMessage.setText("Record Not Found");
                defaultMessage.setVisibility(View.VISIBLE);
            } else {
                defaultMessage.setVisibility(View.GONE);
            }
            Log.d("size", productList.size() + "" + SplashScreen.allProductsData.size());
        } else {
            productList = new ArrayList<>();
            defaultMessage.setText("Search Any Product");
            defaultMessage.setVisibility(View.VISIBLE);
        }
        setProductsData();


    }

    private void setProductsData() {
        SearchProductListAdapter productListAdapter;
        GridLayoutManager gridLayoutManager;
        gridLayoutManager = new GridLayoutManager(getActivity(), 1);
        searchProductsRecyclerView.setLayoutManager(gridLayoutManager);
        productListAdapter = new SearchProductListAdapter(getActivity(), productList);
        searchProductsRecyclerView.setAdapter(productListAdapter);

    }
}
