package com.gglcrash.kingscup.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.gglcrash.kingscup.R;

import butterknife.ButterKnife;

/**
 * Created by gglcrash on 22.09.2016.
 */
public class RulesActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);
        ButterKnife.bind(this);
        
        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }
}
