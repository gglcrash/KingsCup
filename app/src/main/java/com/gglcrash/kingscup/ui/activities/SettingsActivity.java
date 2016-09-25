package com.gglcrash.kingscup.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.WindowManager;
import android.widget.Switch;

import com.gglcrash.kingscup.R;
import com.gglcrash.kingscup.utils.ConstantManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

/**
 * Created by gglcrash on 22.09.2016.
 */
public class SettingsActivity extends BaseActivity {
    @BindView(R.id.switch_button_vibration)
    Switch switchButton;
    private boolean isVibrationEnabled;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ButterKnife.bind(this);

        isVibrationEnabled=getIntent().getBooleanExtra(ConstantManager.VIBRATION,true);
        switchButton.setChecked(isVibrationEnabled);
    }

    @Override
    protected void onResume() {
        super.onResume();
        hideStatusBar();
    }

    private void hideStatusBar(){
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @OnCheckedChanged(R.id.switch_button_vibration)
    public void onSwitchButton(){
        if(switchButton.isChecked()){
            isVibrationEnabled=true;
        }else{
            isVibrationEnabled=false;
        }
        Intent intentResult = new Intent();
        intentResult.putExtra(ConstantManager.VIBRATION,isVibrationEnabled);
        setResult(ConstantManager.RESULT_SETTINGS_CODE,intentResult);
    }

    @OnClick(R.id.btn_back_settings)
    public void onBack(){
        finish();
    }
}
