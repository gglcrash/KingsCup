package com.gglcrash.kingscup.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.gglcrash.kingscup.R;
import com.gglcrash.kingscup.utils.ConstantManager;
import com.gglcrash.kingscup.utils.Rule;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gglcrash on 22.09.2016.
 */
public class RulesActivity extends BaseActivity {

    Intent intentResult;

    private ArrayList<Rule> allOfMyRulesList;
    private ArrayList<Rule> enabledRulesList;

    @BindView(R.id.two_rule_img) ImageView twoImg;
    @BindView(R.id.two_rule_title) ImageView twoRuleTitle;
    @BindView(R.id.two_rule_text) ImageView twoRulteText;

    @BindView(R.id.three_rule_img) ImageView threeImg;
    @BindView(R.id.three_rule_title) ImageView threeRuleTitle;
    @BindView(R.id.three_rule_text) ImageView threeRulteText;

    @BindView(R.id.four_rule_img) ImageView fourImg;
    @BindView(R.id.four_rule_title) ImageView fourRuleTitle;
    @BindView(R.id.four_rule_text) ImageView fourRulteText;

    @BindView(R.id.five_rule_img) ImageView fiveImg;
    @BindView(R.id.five_rule_title) ImageView fiveRuleTitle;
    @BindView(R.id.five_rule_text) ImageView fiveRulteText;

    @BindView(R.id.six_rule_img) ImageView sixImg;
    @BindView(R.id.six_rule_title) ImageView sixRuleTitle;
    @BindView(R.id.six_rule_text) ImageView sixRulteText;

    @BindView(R.id.seven_rule_img) ImageView sevenImg;
    @BindView(R.id.seven_rule_title) ImageView sevenRuleTitle;
    @BindView(R.id.seven_rule_text) ImageView sevenRulteText;

    @BindView(R.id.eight_rule_img) ImageView eightImg;
    @BindView(R.id.eight_rule_title) ImageView eightRuleTitle;
    @BindView(R.id.eight_rule_text) ImageView eightRulteText;

    @BindView(R.id.nine_rule_img) ImageView nineImg;
    @BindView(R.id.nine_rule_title) ImageView nineRuleTitle;
    @BindView(R.id.nine_rule_text) ImageView nineRulteText;

    @BindView(R.id.ten_rule_img) ImageView tenImg;
    @BindView(R.id.ten_rule_title) ImageView tenRuleTitle;
    @BindView(R.id.ten_rule_text) ImageView tenRulteText;

    @BindView(R.id.jack_rule_img) ImageView jackImg;
    @BindView(R.id.jack_rule_title) ImageView jackRuleTitle;
    @BindView(R.id.jack_rule_text) ImageView jackRulteText;

    @BindView(R.id.queen_rule_img) ImageView queenImg;
    @BindView(R.id.queen_rule_title) ImageView queenRuleTitle;
    @BindView(R.id.queen_rule_text) ImageView queenRulteText;

    @BindView(R.id.king_rule_img) ImageView kingImg;
    @BindView(R.id.king_rule_title) ImageView kingRuleTitle;
    @BindView(R.id.king_rule_text) ImageView kingRulteText;

    @BindView(R.id.ace_rule_img) ImageView aceImg;
    @BindView(R.id.ace_rule_title) ImageView aceRuleTitle;
    @BindView(R.id.ace_rule_text) ImageView aceRulteText;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);
        ButterKnife.bind(this);

        intentResult=new Intent();
        allOfMyRulesList = new ArrayList<>();
        enabledRulesList = new ArrayList<>();

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        allOfMyRulesList = getIntent().getParcelableArrayListExtra(ConstantManager.ALL_RULES_LIST);
        enabledRulesList = getIntent().getParcelableArrayListExtra(ConstantManager.ENABLED_RULES_LIST);
        updateRules();
    }

    private void updateRules(){
        /*
        добавить к моменту создания нового правила
        intentResult.putParcelableArrayListExtra(ConstantManager.ENABLED_RULES_LIST,enabledRulesList);
        intentResult.putParcelableArrayListExtra(ConstantManager.ALL_RULES_LIST,allOfMyRulesList);
        setResult(ConstantManager.RESULT_RULES_CODE,intentResult);
        */


    }
}
