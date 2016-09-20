package com.gglcrash.kingscup.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.gglcrash.kingscup.R;

import butterknife.ButterKnife;

/**
 * Created by gglcrash on 20.09.2016.
 */
public class PlayActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        ButterKnife.bind(this);
    }
}


