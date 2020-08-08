package com.example.meraphone.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.meraphone.R;
import com.example.meraphone.ShowDetailsActivity;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.ViewHolder> {
    private ArrayList<String> mImageNames=new ArrayList<>();
    private ArrayList<String> mImages=new ArrayList<>();
    private ArrayList<String> mcost=new ArrayList<>();
    private Context context;

    public DetailsAdapter(ArrayList<String> mImageNames, ArrayList<String> mImages,ArrayList<String> mcost ,Context context) {
        this.mImageNames = mImageNames;
        this.mImages = mImages;
        this.context = context;
        this.mcost = mcost;
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

        Glide.with(context).asBitmap().load(mImages.get(position)).into(holder.circleImageView);
        holder.imageName.setText(mImageNames.get(position));
        holder.cost.setText(mcost.get(position));
    }

    @Override
    public int getItemCount() {
        return mImageNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CircleImageView circleImageView;
        TextView imageName,cost;
        LinearLayout layoutclick;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            circleImageView=itemView.findViewById(R.id.img);
            imageName=itemView.findViewById(R.id.itemname);
            cost=itemView.findViewById(R.id.cost);
            layoutclick=itemView.findViewById(R.id.layoutclick);
      circleImageView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent i=new Intent(v.getContext(), ShowDetailsActivity.class);
              v.getContext().startActivity(i);
          }
      });
        }

    }
}
