package com.example.sardor.waterwave;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;

import me.itangqi.waveloadingview.WaveLoadingView;

public class MainActivity extends AppCompatActivity {

    WaveLoadingView waveLoadingView;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        waveLoadingView = findViewById(R.id.waterWave);
        seekBar = findViewById(R.id.seekBar);

        waveLoadingView.setProgressValue(0);
        waveLoadingView.startAnimation();
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                waveLoadingView.setProgressValue(progress);
                if (progress < 30){
                    waveLoadingView.setWaveColor(-65536);
                }else if (progress > 85){
                    waveLoadingView.setWaveColor(-65536);
                }else{
                    waveLoadingView.setWaveColor(Color.parseColor("#059bff"));
                }

                if(progress < 50){
                    waveLoadingView.setBottomTitle(String.format("%d%%", progress));
                    waveLoadingView.setCenterTitle("");
                    waveLoadingView.setTopTitle("");
                }else if (progress < 80){
                    waveLoadingView.setBottomTitle("");
                    waveLoadingView.setCenterTitle(String.format("%d%%", progress));
                    waveLoadingView.setTopTitle("");
                }else{
                    waveLoadingView.setBottomTitle("");
                    waveLoadingView.setCenterTitle("");
                    waveLoadingView.setTopTitle(String.format("%d%%", progress));

                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
