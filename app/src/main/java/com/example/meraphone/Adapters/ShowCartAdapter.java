package com.example.meraphone.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.meraphone.Admin_Tasks_activity;
import com.example.meraphone.R;
import com.example.meraphone.ShowCartActivity;
import com.example.meraphone.ShowDetailsActivity;
import com.example.meraphone.fragmentPhone;
import com.example.meraphone.global_vars;
import com.example.meraphone.model.CartItem;
import com.example.meraphone.model.Product;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class ShowCartAdapter extends RecyclerView.Adapter<ShowCartAdapter.ViewHolder> {
    private ArrayList<CartItem> modelArrayList;
    Context context;
    FirebaseFirestore db;

    public ShowCartAdapter(ArrayList<CartItem> mImageNames,  Context context) {
        this.modelArrayList = mImageNames;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_cart, parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {


        final CartItem objectModel =modelArrayList.get(position);


        FirebaseStorage firebaseStorage;
        StorageReference storageReference;

        firebaseStorage = FirebaseStorage.getInstance();
        storageReference = firebaseStorage.getReference();


        StorageReference imageRef = storageReference.child("Images/"+objectModel.getImageName());

        imageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {

                Glide.with(context.getApplicationContext())
                        .load(uri)
                        .into(holder.img);

                //Toast.makeText(getApplicationContext(),"Success.",Toast.LENGTH_SHORT).show();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                //Toast.makeText(getApplicationContext(),"fail.",Toast.LENGTH_SHORT).show();
            }
        });



        //  holder.img.setImageBitmap(objectModel.getItemImage());
//    holder.rating.setRating(Float.parseFloat(objectModel.getItemRating()));
        holder.cost.setText(objectModel.getPrice());
        holder.dt.setText(objectModel.getBookingdt());
        holder.imageName.setText(objectModel.getItemName());

        //Toast.makeText(context, objectModel.getPrice(),Toast.LENGTH_SHORT).show();

        //  holder.faltu.setText(String.valueOf(objectModel.getId()));
        holder.layoutclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(view.getContext(),"click on item: "+objectModel.getId(),Toast.LENGTH_LONG).show();
                db=FirebaseFirestore.getInstance();
                DocumentReference docRef = db.collection("Cart").document(objectModel.getId());

// Update the timestamp field with the value from the server
                Map<String,Object> updates = new HashMap<>();
                updates.put("status", "out");


                docRef.update(updates)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Toast.makeText(context,"Data Deleted...",Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(context, ShowCartActivity.class);
                                context.startActivity(i);

                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(context,"Data Not Deleted. Try Again..,",Toast.LENGTH_SHORT).show();

                            }
                        });


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
        ImageView img;
        TextView imageName,cost, dt;
        Button cancel;

        Button layoutclick;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dt=itemView.findViewById(R.id.dt);
            img=itemView.findViewById(R.id.img);
            imageName=itemView.findViewById(R.id.itemname);
            cost=itemView.findViewById(R.id.cost);
            layoutclick=itemView.findViewById(R.id.cancel);

        }

    }
}


