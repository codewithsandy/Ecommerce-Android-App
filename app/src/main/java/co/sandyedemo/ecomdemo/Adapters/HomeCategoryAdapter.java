package co.sandyedemo.ecomdemo.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import co.sandyedemo.ecomdemo.MVP.CategoryListResponse;
import co.sandyedemo.ecomdemo.R;
import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * Created by Android
 */
public class HomeCategoryAdapter extends RecyclerView.Adapter<CategoriesViewHolder> {
    Context context;
    List<CategoryListResponse> categoryListResponses;
    int size;

    public HomeCategoryAdapter(Context context, List<CategoryListResponse> categoryListResponses,int size) {
        this.context = context;
        this.categoryListResponses = categoryListResponses;
        this.size=size;
    }

    @Override
    public CategoriesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.homw_category_list_items, null);
        CategoriesViewHolder categoriesViewHolder = new CategoriesViewHolder(context, view);
        return categoriesViewHolder;
    }

    @Override
    public void onBindViewHolder(CategoriesViewHolder holder, int position) {
        if (position == 3) {
            holder.catName.setText("More");
            holder.image.setImageResource(R.drawable.new_more_icon);
        } else {
            holder.catName.setText(categoryListResponses.get(position).getCategory_name());
            String temp = categoryListResponses.get(position).getCategory_image().replaceAll(" ", "%20");
            Picasso.with(context)
                    .load(temp)
                    .placeholder(R.drawable.defaultimage)
                    .resize(Integer.parseInt(context.getResources().getString(R.string.cartImageWidth)),Integer.parseInt(context.getResources().getString(R.string.cartImageWidth)))
                    .into(holder.image);
        }
    }

    @Override
    public int getItemCount() {
        return size;
    }
}
