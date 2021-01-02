package com.example.recyclerviewfinal_hw;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> wordList = new ArrayList<>();
    private RecyclerView recyclerView;
    private WordListAdapter adapter;
    FloatingActionButton addButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        adapter = new WordListAdapter(this, wordList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        addButton = findViewById(R.id.floatingActionButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wordListSize = wordList.size();
                wordList.add("+ Word " + wordListSize);
                recyclerView.getAdapter().notifyItemInserted(wordListSize);
                recyclerView.smoothScrollToPosition(wordListSize);
            }
        });

        for (int i = 0; i < 20; i++) {
            wordList.add("Word " + i);
        }
    }
}