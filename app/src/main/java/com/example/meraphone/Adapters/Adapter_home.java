
/**
 * Adapter_home.java class is adapter for home recyclerview
 * @author Barinder
 * @date - 08/03/2020
 * @version 1.0
 */
package com.example.meraphone.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.meraphone.R;

import java.util.ArrayList;
import  com.example.meraphone.Adapters.*;
import com.example.meraphone.model.Product;

public class Adapter_home extends RecyclerView.Adapter<Adapter_home.ViewHolder> {

    private ArrayList<Product>  l = new ArrayList<>();
    private Context context;

    public Adapter_home(ArrayList<Product> o, Context context) {
        this.l = l;

        this.context = context;
    }

    /**
     *
     * @param parent
     * @param viewType
     * @return holder
     */
    @NonNull
    @Override
    public Adapter_home.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_home, parent,false);
        Adapter_home.ViewHolder holder=new Adapter_home.ViewHolder(view);
        return holder;
    }

    /**
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull Adapter_home.ViewHolder holder, int position) {
        final Product o =l.get(position);

        Glide.with(context).asBitmap().load(o.getItemImage()).into(holder.img);
        holder.imageName.setText(o.getItemName());
        holder.cost.setText(o.getItemPrice());



    }

    /**
     *
     * @return size of list
     */
    @Override
    public int getItemCount() {
        return l.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView imageName,cost;

        LinearLayout layoutclick;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);
            imageName=itemView.findViewById(R.id.itemname);
            cost=itemView.findViewById(R.id.cost);
            layoutclick=itemView.findViewById(R.id.layoutclick);

        }

    }
}

