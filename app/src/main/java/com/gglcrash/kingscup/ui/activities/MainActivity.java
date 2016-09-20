package com.gglcrash.kingscup.ui.activities;

import android.os.Bundle;
import android.view.View;

import com.gglcrash.kingscup.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }

    @OnClick(R.id.fab_settings)
    public void fabSettingsClick(){
        showToast("settings!");
    }

    @OnClick(R.id.fab_quit)
    public void fabQuitClick(){
        finish();
    }

    @OnClick(R.id.play_btn)
    public void playClick(){
        showToast("play!");
    }

    @OnClick(R.id.rules_btn)
    public void fabRulesClick(){
        showToast("rules!");
    }
}
