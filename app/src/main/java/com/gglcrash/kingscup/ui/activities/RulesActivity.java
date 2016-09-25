package com.gglcrash.kingscup.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.gglcrash.kingscup.R;
import com.gglcrash.kingscup.utils.ConstantManager;
import com.gglcrash.kingscup.utils.Rule;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by gglcrash on 22.09.2016.
 */
public class RulesActivity extends BaseActivity {

    Intent intentResult;

    private ArrayList<Rule> allOfMyRulesList;
    private ArrayList<Rule> enabledRulesList;

    @BindView(R.id.two_rule_img) ImageView twoImg;
    @BindView(R.id.two_rule_title) TextView twoRuleTitle;
    @BindView(R.id.two_rule_text) TextView twoRulteText;

    @BindView(R.id.three_rule_img) ImageView threeImg;
    @BindView(R.id.three_rule_title) TextView threeRuleTitle;
    @BindView(R.id.three_rule_text) TextView threeRulteText;

    @BindView(R.id.four_rule_img) ImageView fourImg;
    @BindView(R.id.four_rule_title) TextView fourRuleTitle;
    @BindView(R.id.four_rule_text) TextView fourRulteText;

    @BindView(R.id.five_rule_img) ImageView fiveImg;
    @BindView(R.id.five_rule_title) TextView fiveRuleTitle;
    @BindView(R.id.five_rule_text) TextView fiveRulteText;

    @BindView(R.id.six_rule_img) ImageView sixImg;
    @BindView(R.id.six_rule_title) TextView sixRuleTitle;
    @BindView(R.id.six_rule_text) TextView sixRulteText;

    @BindView(R.id.seven_rule_img) ImageView sevenImg;
    @BindView(R.id.seven_rule_title) TextView sevenRuleTitle;
    @BindView(R.id.seven_rule_text) TextView sevenRulteText;

    @BindView(R.id.eight_rule_img) ImageView eightImg;
    @BindView(R.id.eight_rule_title) TextView eightRuleTitle;
    @BindView(R.id.eight_rule_text) TextView eightRulteText;

    @BindView(R.id.nine_rule_img) ImageView nineImg;
    @BindView(R.id.nine_rule_title) TextView nineRuleTitle;
    @BindView(R.id.nine_rule_text) TextView nineRulteText;

    @BindView(R.id.ten_rule_img) ImageView tenImg;
    @BindView(R.id.ten_rule_title) TextView tenRuleTitle;
    @BindView(R.id.ten_rule_text) TextView tenRulteText;

    @BindView(R.id.jack_rule_img) ImageView jackImg;
    @BindView(R.id.jack_rule_title) TextView jackRuleTitle;
    @BindView(R.id.jack_rule_text) TextView jackRulteText;

    @BindView(R.id.queen_rule_img) ImageView queenImg;
    @BindView(R.id.queen_rule_title) TextView queenRuleTitle;
    @BindView(R.id.queen_rule_text) TextView queenRulteText;

    @BindView(R.id.king_rule_img) ImageView kingImg;
    @BindView(R.id.king_rule_title) TextView kingRuleTitle;
    @BindView(R.id.king_rule_text) TextView kingRulteText;

    @BindView(R.id.ace_rule_img) ImageView aceImg;
    @BindView(R.id.ace_rule_title) TextView aceRuleTitle;
    @BindView(R.id.ace_rule_text) TextView aceRulteText;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);
        ButterKnife.bind(this);

        intentResult=new Intent();
        allOfMyRulesList = new ArrayList<>();
        enabledRulesList = new ArrayList<>();

        allOfMyRulesList = getIntent().getParcelableArrayListExtra(ConstantManager.ALL_RULES_LIST);
        enabledRulesList = getIntent().getParcelableArrayListExtra(ConstantManager.ENABLED_RULES_LIST);
        updateRules();

    }

    @Override
    protected void onResume() {
        super.onResume();
        hideStatusBar();
    }

    @OnClick(R.id.btn_back_rules)
    public void onBack(){
        finish();
    }

    private void hideStatusBar(){
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    private void updateRules(){
        /*
        добавить к моменту создания нового правила
        intentResult.putParcelableArrayListExtra(ConstantManager.ENABLED_RULES_LIST,enabledRulesList);
        intentResult.putParcelableArrayListExtra(ConstantManager.ALL_RULES_LIST,allOfMyRulesList);
        setResult(ConstantManager.RESULT_RULES_CODE,intentResult);
        */
        for (Rule enRule:enabledRulesList) {
            switch (enRule.getValue()){
                case TWO:{
                    Picasso.with(this)
                            .load(enRule.getImageId())
                            .resize(ConstantManager.MINI_CARD_WIDTH,ConstantManager.MINI_CARD_HEIGHT)
                            .into(twoImg);
                    twoRuleTitle.setText(enRule.getRuleTitle());
                    twoRulteText.setText(enRule.getRuleText());
                }
                case THREE:{
                    Picasso.with(this)
                        .load(enRule.getImageId())
                        .resize(ConstantManager.MINI_CARD_WIDTH,ConstantManager.MINI_CARD_HEIGHT)
                        .into(threeImg);
                    threeRuleTitle.setText(enRule.getRuleTitle());
                    threeRulteText.setText(enRule.getRuleText());
                }
                case FOUR:{
                    Picasso.with(this)
                            .load(enRule.getImageId())
                            .resize(ConstantManager.MINI_CARD_WIDTH,ConstantManager.MINI_CARD_HEIGHT)
                            .into(fourImg);
                    fourRuleTitle.setText(enRule.getRuleTitle());
                    fourRulteText.setText(enRule.getRuleText());
                }
                case FIVE:{
                    Picasso.with(this)
                            .load(enRule.getImageId())
                            .resize(ConstantManager.MINI_CARD_WIDTH,ConstantManager.MINI_CARD_HEIGHT)
                            .into(fiveImg);
                    fiveRuleTitle.setText(enRule.getRuleTitle());
                    fiveRulteText.setText(enRule.getRuleText());
                }
                case SIX:{
                    Picasso.with(this)
                            .load(enRule.getImageId())
                            .resize(ConstantManager.MINI_CARD_WIDTH,ConstantManager.MINI_CARD_HEIGHT)
                            .into(sixImg);
                    sixRuleTitle.setText(enRule.getRuleTitle());
                    sixRulteText.setText(enRule.getRuleText());
                }
                case SEVEN:{
                    Picasso.with(this)
                            .load(enRule.getImageId())
                            .resize(ConstantManager.MINI_CARD_WIDTH,ConstantManager.MINI_CARD_HEIGHT)
                            .into(sevenImg);
                    sevenRuleTitle.setText(enRule.getRuleTitle());
                    sevenRulteText.setText(enRule.getRuleText());
                }
                case EIGHT:{
                    Picasso.with(this)
                            .load(enRule.getImageId())
                            .resize(ConstantManager.MINI_CARD_WIDTH,ConstantManager.MINI_CARD_HEIGHT)
                            .into(eightImg);
                    eightRuleTitle.setText(enRule.getRuleTitle());
                    eightRulteText.setText(enRule.getRuleText());
                }
                case NINE:{
                    Picasso.with(this)
                            .load(enRule.getImageId())
                            .resize(ConstantManager.MINI_CARD_WIDTH,ConstantManager.MINI_CARD_HEIGHT)
                            .into(nineImg);
                    nineRuleTitle.setText(enRule.getRuleTitle());
                    nineRulteText.setText(enRule.getRuleText());
                }
                case TEN:{
                    Picasso.with(this)
                            .load(enRule.getImageId())
                            .resize(ConstantManager.MINI_CARD_WIDTH,ConstantManager.MINI_CARD_HEIGHT)
                            .into(tenImg);
                    tenRuleTitle.setText(enRule.getRuleTitle());
                    tenRulteText.setText(enRule.getRuleText());
                }
                case JACK:{
                    Picasso.with(this)
                            .load(enRule.getImageId())
                            .resize(ConstantManager.MINI_CARD_WIDTH,ConstantManager.MINI_CARD_HEIGHT)
                            .into(jackImg);
                    jackRuleTitle.setText(enRule.getRuleTitle());
                    jackRulteText.setText(enRule.getRuleText());
                }
                case QUEEN:{
                    Picasso.with(this)
                            .load(enRule.getImageId())
                            .resize(ConstantManager.MINI_CARD_WIDTH,ConstantManager.MINI_CARD_HEIGHT)
                            .into(queenImg);
                    queenRuleTitle.setText(enRule.getRuleTitle());
                    queenRulteText.setText(enRule.getRuleText());
                }
                case KING:{
                    Picasso.with(this)
                            .load(enRule.getImageId())
                            .resize(ConstantManager.MINI_CARD_WIDTH,ConstantManager.MINI_CARD_HEIGHT)
                            .into(kingImg);
                    kingRuleTitle.setText(enRule.getRuleTitle());
                    kingRulteText.setText(enRule.getRuleText());
                }
                case ACE:{
                    Picasso.with(this)
                            .load(enRule.getImageId())
                            .resize(ConstantManager.MINI_CARD_WIDTH,ConstantManager.MINI_CARD_HEIGHT)
                            .into(aceImg);
                    aceRuleTitle.setText(enRule.getRuleTitle());
                    aceRulteText.setText(enRule.getRuleText());
                }
            }
        }

    }
}
