package co.sandyedemo.ecomdemo.Adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import co.sandyedemo.ecomdemo.MVP.Product;
import co.sandyedemo.ecomdemo.R;

import java.util.List;


/**
 * Created by Android
 */
public class HomeProductsViewHolder extends RecyclerView.ViewHolder {

    ImageView image, image1,delete;
    TextView productName, price, actualPrice, productName1, price1, actualPrice1, discountPercentage, discountPercentage1;
    CardView cardView, cardView1;

    public HomeProductsViewHolder(final Context context, View itemView, List<Product> productList) {
        super(itemView);
        image = (ImageView) itemView.findViewById(R.id.productImage);
        image1 = (ImageView) itemView.findViewById(R.id.productImage1);
        delete = (ImageView) itemView.findViewById(R.id.delete);
        productName = (TextView) itemView.findViewById(R.id.productName);
        price = (TextView) itemView.findViewById(R.id.price);
        actualPrice = (TextView) itemView.findViewById(R.id.actualPrice);
        productName1 = (TextView) itemView.findViewById(R.id.productName1);
        price1 = (TextView) itemView.findViewById(R.id.price1);
        actualPrice1 = (TextView) itemView.findViewById(R.id.actualPrice1);
        discountPercentage = (TextView) itemView.findViewById(R.id.discountPercentage);
        discountPercentage1 = (TextView) itemView.findViewById(R.id.discountPercentage1);
        cardView = (CardView) itemView.findViewById(R.id.cardView);
        cardView1 = (CardView) itemView.findViewById(R.id.cardView1);

    }
}
