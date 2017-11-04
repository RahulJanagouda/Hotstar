package com.rahuljanagouda.hotstar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.rahuljanagouda.hotstar.adapters.HorizontalListAdapter;
import com.rahuljanagouda.hotstar.adapters.VerticalListAdapter;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        RecyclerView verticalRecycler = findViewById(R.id.verticalRecycler);
        verticalRecycler.setAdapter(new VerticalListAdapter());

    }
}
