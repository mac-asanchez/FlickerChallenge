package com.example.user.flickerchallenge.view.mainactivity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.user.flickerchallenge.R;
import com.example.user.flickerchallenge.model.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 8/17/17.
 */

public class MainActivityAdapter extends RecyclerView.Adapter<MainActivityAdapter.ViewHolder> {


    List<Item> items = new ArrayList<>();
    Context context;


    public MainActivityAdapter(List<Item> items) {
        this.items = items;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.tvTitle);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.flicker_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Item item = items.get(position);
        Log.d("TAG", "onBindViewHolder: " + item.getMedia().getM());
        Glide.with(context).load(item.getMedia().getM()).into(holder.imageView);
        holder.textView.setText(item.getTitle());


    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
