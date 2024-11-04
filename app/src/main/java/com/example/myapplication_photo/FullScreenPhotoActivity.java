package com.example.myapplication_photo;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import java.io.File;

public class FullScreenPhotoActivity extends AppCompatActivity {
    public static final String EXTRA_IMAGE_PATH = "image_path";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_photo);

        // 显示返回按钮
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        ImageView fullScreenImageView = findViewById(R.id.fullScreenImageView);
        String imagePath = getIntent().getStringExtra(EXTRA_IMAGE_PATH);

        if (imagePath != null) {
            Glide.with(this)
                    .load(new File(imagePath))
                    .into(fullScreenImageView);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed(); // 处理返回按钮点击
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}