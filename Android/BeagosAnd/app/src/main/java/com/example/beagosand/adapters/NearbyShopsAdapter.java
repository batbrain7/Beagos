package com.example.beagosand.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.beagosand.R;
import com.example.beagosand.activities.ShopDetailsActivity;
import com.example.beagosand.models.Shop;

import java.util.ArrayList;

/**
 * Created by piyush0 on 29/12/16.
 */

public class NearbyShopsAdapter extends RecyclerView.Adapter<NearbyShopsAdapter.ShopViewHolder> {

    Context context;
    ArrayList<Shop> shops;

    public NearbyShopsAdapter(Context context, ArrayList<Shop> shops) {
        this.context = context;
        this.shops = shops;
    }

    @Override
    public ShopViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = li.inflate(R.layout.item_nearby_shops, parent, false);

        ShopViewHolder shopViewHolder = new ShopViewHolder(view);

        shopViewHolder.tv_shopName = (TextView) view.findViewById(R.id.item_nearby_shop_tv_name);
        shopViewHolder.iv_shop = (ImageView) view.findViewById(R.id.item_nearby_shop_iv_pic);

        return shopViewHolder;
    }

    @Override
    public void onBindViewHolder(ShopViewHolder holder, int position) {
        final Shop shop = shops.get(position);

        holder.tv_shopName.setText(shop.getName());
        //TODO: Set pic

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, ShopDetailsActivity.class);
                i.putExtra("UUID", shop.getUUID());
                i.putExtra("source", "NearbyShopsActivity");
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return shops.size();
    }

    class ShopViewHolder extends RecyclerView.ViewHolder {

        ImageView iv_shop;
        TextView tv_shopName;

        public ShopViewHolder(View itemView) {
            super(itemView);
        }
    }
}
