package com.ashikurrahman.chinesetraditionaldress;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class DetailPageActivity extends AppCompatActivity {

    private ImageView itemImage;
    private TextView topBar;
    private TextView itemDescription;
    private Button backButton;
    private RatingBar ratingBar;

    private ItemModel item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        itemImage = findViewById(R.id.itemImage);
        topBar = findViewById(R.id.topBar);
        itemDescription = findViewById(R.id.itemDescription);
        backButton = findViewById(R.id.backButton);
        ratingBar = findViewById(R.id.ratingBar);

        // Retrieve item data from intent
        Intent intent = getIntent();
        if (intent != null) {
            item = intent.getParcelableExtra("item");
        }

        // Set item data
        if (item != null) {
            itemImage.setImageResource(item.getThumbnailResId());
            topBar.setText(item.getTitle());
            itemDescription.setText(item.getDescription());
        }

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        float rating = getRatingFromSharedPreferences(item.getTitle());
        ratingBar.setRating(rating);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                saveRatingToSharedPreferences(item.getTitle(), rating);
            }
        });
    }

    private float getRatingFromSharedPreferences(String title) {
        SharedPreferences sharedPreferences = getSharedPreferences("ratings", MODE_PRIVATE);
        return sharedPreferences.getFloat(title, 0.0f);
    }

    private void saveRatingToSharedPreferences(String title, float rating) {
        SharedPreferences sharedPreferences = getSharedPreferences("ratings", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putFloat(title, rating);
        editor.apply();
    }
}
