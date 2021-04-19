package co.sandyedemo.ecomdemo.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import co.sandyedemo.ecomdemo.Fragments.ProductDetail;
import co.sandyedemo.ecomdemo.R;

import java.util.ArrayList;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;


public class ColorListAdapter extends RecyclerView.Adapter<ColorListAdapter.MyViewHolder> implements View.OnClickListener {

    ArrayList<String> listData;
    Context context;
    public static int pos;


    public ColorListAdapter(Context context, ArrayList<String> listData) {
        this.context = context;
        this.listData = listData;
        pos = -1;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.size_list_items, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder

        return vh;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        // set the data in items
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.RECTANGLE);
        shape.setCornerRadii(new float[]{5, 5, 5, 5, 5, 5, 5, 5});
        if (position == pos) {
            holder.size.setTextColor(Color.WHITE);
            shape.setColor(holder.colorPrimary);
        } else {
            holder.size.setTextColor(Color.BLACK);
            shape.setColor(holder.gray);
        }
        holder.size.setText(listData.get(position).trim());
        holder.size.setBackgroundDrawable(shape);
        holder.size.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pos = position;
                if (Integer.parseInt(ProductDetail.productQuantity) < 1) {
                    ProductDetail.addToCart.setText("Out of Stock");
                } else
                    ProductDetail.addToCart.setText("Add to Cart");
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
        }

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // init the item view's
        @BindView(R.id.size)
        TextView size;
        @BindColor(R.color.gray)
        int gray;
        @BindColor(R.color.colorPrimary)
        int colorPrimary;

        public MyViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            ButterKnife.bind(this, itemView);

        }
    }
}