package co.sandyedemo.ecomdemo.Adapters;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import co.sandyedemo.ecomdemo.R;


/**
 * Created by Android
 */
public class DotsAdapter extends RecyclerView.Adapter<DotViewHolder> {

    Context context;
    int size, selectedPos;

    public DotsAdapter(Context context, int size, int selectedPos) {
        this.context = context;
        this.size = size;
        this.selectedPos = selectedPos;
    }

    @Override
    public DotViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.dots_list_items, null);
        DotViewHolder DotViewHolder = new DotViewHolder(context, view);
        return DotViewHolder;
    }

    @Override
    public void onBindViewHolder(DotViewHolder holder, int position) {
        if (position == selectedPos) {
            holder.dotImageView.setColorFilter(ContextCompat.getColor(context, R.color.colorPrimary));
        } else {
            holder.dotImageView.setColorFilter(ContextCompat.getColor(context, R.color.gray));
        }

    }

    @Override
    public int getItemCount() {
        return size;
    }
}
