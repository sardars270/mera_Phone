package com.example.meraphone.Adapters;

import android.content.Context;
import android.content.Intent;
import android.media.Rating;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.meraphone.Model;
import com.example.meraphone.R;
import com.example.meraphone.ShowDetailsActivity;
import com.example.meraphone.model.Product;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.ViewHolder> {
   // private ArrayList<String> mImageNames=new ArrayList<>();
   // private ArrayList<String> mImages=new ArrayList<>();
  //  private ArrayList<String> mcost=new ArrayList<>();
  //  private Context context;
   private ArrayList<Product> modelArrayList;
    public DetailsAdapter(ArrayList<Product> modelArrayList) {
        this.modelArrayList = modelArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_accessories, parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final Product objectModel =modelArrayList.get(position);

       // holder.img.setImageBitmap(objectModel.getItemImage());
       // holder.rating.setRating(Float.parseFloat(objectModel.getItemRating()));
       // holder.cost.setText(objectModel.getItemPrice());
        holder.itemname.setText(objectModel.getItemName());
       // holder.faltu.setText(String.valueOf(objectModel.getItemModelNo()));
        holder.layoutclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  Toast.makeText(view.getContext(),"click on item: "+objectModel,Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        if(modelArrayList!=null){
            return modelArrayList.size();
        }
        else
        {return 0;}
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView itemname,count,cost,faltu;
        Button decrease,add;
        RatingBar rating;
        ImageView img ;
        LinearLayout layoutclick;
        int counter=0;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);
            itemname=itemView.findViewById(R.id.itemname);
           rating=itemView.findViewById(R.id.rating);
            cost=itemView.findViewById(R.id.cost);
            faltu = itemView.findViewById(R.id.faltu);
            layoutclick=itemView.findViewById(R.id.layoutclick);
      img.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent i=new Intent(v.getContext(), ShowDetailsActivity.class);
              v.getContext().startActivity(i);
          }
      });
        }

    }
}
