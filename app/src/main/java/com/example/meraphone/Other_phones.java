package com.example.meraphone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.meraphone.Adapters.DetailsAdapter;
import com.example.meraphone.database.Db_frall;

public class Other_phones extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Db_frall databaseHandler;
    private DetailsAdapter rvAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_phones);
        recyclerView=findViewById(R.id.recycle_others);
        //recyclerView=view.findViewById(R.id.recycle_iphone);
        databaseHandler = new Db_frall(getApplicationContext());
        //  rating=view.findViewById(R.id.rating);
        String s =((global_vars)this.getApplication()).getAct_naam_others().toString();
       /*
        rvAdapter =new DetailsAdapter(databaseHandler.getAllImagesData( s,"Active") );
        if(rvAdapter.getItemCount()==0){
            Toast.makeText(getApplicationContext(), "No data found please contact to admin", Toast.LENGTH_SHORT).show();
            return ;
        }
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(rvAdapter);

        */
    }
}