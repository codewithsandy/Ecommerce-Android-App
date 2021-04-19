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
public class CategoryListAdapter extends RecyclerView.Adapter<CategorieListViewHolder> {
    Context context;
    List<CategoryListResponse> categoryListResponses;

    public CategoryListAdapter(Context context, List<CategoryListResponse> categoryListResponses) {
        this.context = context;
        this.categoryListResponses = categoryListResponses;
    }

    @Override
    public CategorieListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.category_list_items, null);
        CategorieListViewHolder CategorieListViewHolder = new CategorieListViewHolder(context, view);
        return CategorieListViewHolder;
    }

    @Override
    public void onBindViewHolder(CategorieListViewHolder holder, int position) {

            holder.catName.setText(categoryListResponses.get(position).getCategory_name());
            String temp = categoryListResponses.get(position).getCategory_image().replaceAll(" ", "%20");
            Picasso.with(context)
                    .load(temp)
                    .placeholder(R.drawable.defaultimage)
                    .resize(Integer.parseInt(context.getResources().getString(R.string.targetProductImageHeight)),Integer.parseInt(context.getResources().getString(R.string.targetProductImageHeight)))
                    .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return categoryListResponses.size();
    }
}
