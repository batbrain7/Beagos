package com.example.beagosand.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.beagosand.GetScoreTask;
import com.example.beagosand.R;
import com.example.beagosand.utils.FontsOverride;

import me.itangqi.waveloadingview.WaveLoadingView;

public class LoadingActivity extends AppCompatActivity {

    WaveLoadingView loadingView;
    Button btn;
    Float score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        startTask();

        FontsOverride.applyFontForToolbarTitle(this, FontsOverride.FONT_PROXIMA_NOVA,getWindow());
        btn = (Button) findViewById(R.id.loading_temp);
        loadingView = (WaveLoadingView) findViewById(R.id.activity_loading_waveLoading);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadingView.setProgressValue(100);
            }
        });

    }

    private void startTask() {
        new GetScoreTask(){
            @Override
            protected void onPostExecute(Float aFloat) {
                super.onPostExecute(aFloat);
                score = aFloat;
                loadingView.setProgressValue(100);
                Intent intent = new Intent(LoadingActivity.this, RatingLogoActivity.class);
                intent.putExtra("Score", score);
                startActivity(intent);
            }
        };
    }

}
