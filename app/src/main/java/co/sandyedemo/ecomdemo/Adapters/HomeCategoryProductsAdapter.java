package co.sandyedemo.ecomdemo.Adapters;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import co.sandyedemo.ecomdemo.MVP.CategoryListResponse;
import co.sandyedemo.ecomdemo.R;
import co.sandyedemo.ecomdemo.Activities.SplashScreen;

import java.util.List;


/**
 * Created by Android
 */
public class HomeCategoryProductsAdapter extends RecyclerView.Adapter<CategoriesProductsViewHolder> {
    Context context;
    List<CategoryListResponse> categoryListResponses;

    public HomeCategoryProductsAdapter(Context context, List<CategoryListResponse> categoryListResponses) {
        this.context = context;
        this.categoryListResponses = categoryListResponses;
    }

    @Override
    public CategoriesProductsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.homw_category_products_list_items, null);
        CategoriesProductsViewHolder categoriesProductsViewHolder = new CategoriesProductsViewHolder(context, view);
        return categoriesProductsViewHolder;
    }

    @Override
    public void onBindViewHolder(CategoriesProductsViewHolder holder, int position) {
        if (SplashScreen.categoryListResponseData.get(position).getProducts().size() > 0) {
            holder.homeCategoryProductLayout.setVisibility(View.VISIBLE);
            holder.homeCategoryRelativeLayout.setVisibility(View.VISIBLE);
            holder.catName.setText(categoryListResponses.get(position).getCategory_name());
            setCategoryProductsData(holder.productsRecyclerView, position);
        }else
        {
            holder.homeCategoryProductLayout.setVisibility(View.GONE);
            holder.homeCategoryRelativeLayout.setVisibility(View.GONE);
        }


    }

    private void setCategoryProductsData(RecyclerView productsRecyclerView, int position) {
        HomeProductsAdapter homeProductsAdapter;
        GridLayoutManager gridLayoutManager;
        if (position % 2 == 0) {
            gridLayoutManager = new GridLayoutManager(context, 2);
        } else
            gridLayoutManager = new GridLayoutManager(context, 1);

        productsRecyclerView.setLayoutManager(gridLayoutManager);
        if (SplashScreen.categoryListResponseData.get(position).getProducts().size() > 4)
            homeProductsAdapter = new HomeProductsAdapter(context, SplashScreen.categoryListResponseData.get(position).getProducts(), 4, position);
        else
            homeProductsAdapter = new HomeProductsAdapter(context, SplashScreen.categoryListResponseData.get(position).getProducts(), SplashScreen.categoryListResponseData.get(position).getProducts().size(), position);


        productsRecyclerView.setAdapter(homeProductsAdapter);

    }

    @Override
    public int getItemCount() {
        return categoryListResponses.size();
    }
}
