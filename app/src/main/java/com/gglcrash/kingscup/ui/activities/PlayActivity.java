package com.gglcrash.kingscup.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.gglcrash.kingscup.R;
import com.gglcrash.kingscup.utils.Card;
import com.gglcrash.kingscup.utils.ConstantManager;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gglcrash on 20.09.2016.
 */
public class PlayActivity extends BaseActivity {

    private ArrayList<Card> myCardList = new ArrayList<>();

    @BindView(R.id.img_card_view)
    ImageView imgCardView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        ButterKnife.bind(this);

        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        myCardList = getIntent().getParcelableArrayListExtra(ConstantManager.CARD_LIST);

    }
}


