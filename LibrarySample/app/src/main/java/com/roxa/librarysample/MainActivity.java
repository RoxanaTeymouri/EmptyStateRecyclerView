package com.roxa.librarysample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.roxa.emptystatehelper.EmptyStateRecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EmptyStateRecyclerView emptyStateRecyclerView = findViewById(R.id.recyclerview_main);

        emptyStateRecyclerView.setAdapter(new SimpleRVAdapter(new String[]{}));
        //When you want to use ErrorState add this:
        emptyStateRecyclerView.showError();
        //When you want to use Loading add this:
        emptyStateRecyclerView.showLoading();

    }
}






