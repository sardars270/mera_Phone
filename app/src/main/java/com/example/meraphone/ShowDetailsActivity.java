package com.example.meraphone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.meraphone.model.CartItem;
import com.example.meraphone.model.Product;
import com.example.meraphone.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.Calendar;
import java.util.Date;

public class ShowDetailsActivity extends AppCompatActivity {
    private Button btn_cart;
    TextView name, cost, modelnumber, megapixelfront, megapixelback, HybridYes, OTGyes, tocuhscreenyes;
    String productId;
    String imgnamefrmstorage;
    ImageView img;
    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);
        btn_cart=findViewById(R.id.btn_cart);
        name = findViewById(R.id.name);
        img = findViewById(R.id.img);
        cost = findViewById(R.id.cost);
        modelnumber = findViewById(R.id.modelnumber);
        megapixelfront = findViewById(R.id.megapixelfront);
        megapixelback = findViewById(R.id.megapixelback);
        HybridYes = findViewById(R.id.HybridYes);
        OTGyes = findViewById(R.id.OTGyes);
        tocuhscreenyes = findViewById(R.id.tocuhscreenyes);



        productId =getIntent().getStringExtra("productId");
        //  name.setText(productId);
        /// getting details


        db = FirebaseFirestore.getInstance();
        DocumentReference docRef = db.collection("Product").document(productId);
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {

                        Product pro = document.toObject(Product.class);
                        name.setText(pro.getItemName());
                        // img.setItemImage(d.getString("itemImage"));
                        FirebaseStorage firebaseStorage;
                        StorageReference storageReference;

                        firebaseStorage = FirebaseStorage.getInstance();
                        storageReference = firebaseStorage.getReference();

//        StorageReference imageRef = storageReference.child("Images/my.png");
                        imgnamefrmstorage = pro.getItemImage();
                        StorageReference imageRef = storageReference.child("Images/"+pro.getItemImage());

                        imageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {

                                Glide.with(getApplicationContext())
                                        .load(uri)
                                        .into(img);

                                //Toast.makeText(getApplicationContext(),"Success.",Toast.LENGTH_SHORT).show();

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                //Toast.makeText(getApplicationContext(),"fail.",Toast.LENGTH_SHORT).show();
                            }
                        });

                        cost.setText(pro.getItemPrice());
                        modelnumber.setText(pro.getItemModelNo());
                        megapixelfront.setText(pro.getItemFrontCamera());
                        megapixelback.setText(pro.getItemBackCamera());
                        HybridYes.setText(pro.getItemHybridSimSlot());
                        OTGyes.setText(pro.getItemOtg());
                        tocuhscreenyes.setText(pro.getItemMultiTouch());

                    } else {
                        // Log.d(TAG, "No such document");
                    }
                } else {
                    // Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });






        btn_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /// perform to add item in cart

                CartItem crt = new CartItem();
                String Id;
                String productid;
                String userid;
                String bookingdt;
                String status;
                // crt.setProductid();
                Date currentTime = Calendar.getInstance().getTime();
                crt.setProductid(productId);
                crt.setItemName(name.getText().toString());
                crt.setPrice(cost.getText().toString());
                crt.setImageName(imgnamefrmstorage.toString());
                crt.setUserid( ((global_vars) getApplicationContext()).getLoginUserID());
                crt.setBookingdt(currentTime.toString());
                crt.setStatus("Received");





                db.collection("Cart").add(crt)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Toast.makeText(getApplicationContext(), "Product Added to crt", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getApplicationContext(), "Product Not Added. Try Again...", Toast.LENGTH_SHORT).show();
                            }
                        });




                Intent i =new Intent(getApplicationContext(), ShowCartActivity.class);
                startActivity(i);
            }
        });
    }

}


