package com.gglcrash.kingscup.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.gglcrash.kingscup.R;
import com.gglcrash.kingscup.data.managers.DataManager;
import com.gglcrash.kingscup.utils.Card;
import com.gglcrash.kingscup.utils.ConstantManager;
import com.gglcrash.kingscup.utils.Rule;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    public enum CardValue {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT,
        NINE, TEN, JACK, QUEEN, KING, ACE
    }
    Card savedCard;
    DataManager mDataManager;
    private int savedPlayedCards, savedKingsCount;
    private boolean isVibrationEnabled;
    private ArrayList<Rule> enabledRulesList = new ArrayList<>();
    private ArrayList<Rule> allOfMyRulesList = new ArrayList<>();
    private ArrayList<Card> myCardList = new ArrayList<>();
    private ArrayList<Card> savedDeck = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mDataManager = DataManager.getInstance();
        isVibrationEnabled = mDataManager.getPreferencesManager().loadVibrationValue();
        savedCard = mDataManager.getPreferencesManager().loadSavedCard();
        savedDeck = mDataManager.getPreferencesManager().loadDeck();
        savedKingsCount = mDataManager.getPreferencesManager().loadKingsCount();
        savedPlayedCards = mDataManager.getPreferencesManager().loadPlayedCardsCount();
        setCards();
        setRules();
    }

    @Override
    protected void onResume() {
        super.onResume();
        hideStatusBar();
    }

    private void hideStatusBar(){
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }

    @OnClick(R.id.fab_settings)
    public void fabSettingsClick(){
        Intent intent = new Intent(this, SettingsActivity.class);
        intent.putExtra(ConstantManager.VIBRATION,isVibrationEnabled);
        startActivityForResult(intent, ConstantManager.RESULT_SETTINGS_CODE);
    }

    @OnClick(R.id.fab_quit)
    public void fabQuitClick(){
        System.exit(1);
    }

    @OnClick(R.id.play_btn)
    public void playClick(){
        Intent intent = new Intent(this, PlayActivity.class);
        if(savedDeck == null) {
            intent.putParcelableArrayListExtra(ConstantManager.CARD_LIST, myCardList);
        }else{
            intent.putParcelableArrayListExtra(ConstantManager.CARD_LIST, savedDeck);
            intent.putExtra(ConstantManager.SAVED_CARD, savedCard);
            intent.putExtra(ConstantManager.PLAYED_CARDS_COUNT,savedPlayedCards);
            intent.putExtra(ConstantManager.KINGS_COUNT,savedKingsCount);
        }
        intent.putParcelableArrayListExtra(ConstantManager.ENABLED_RULES_LIST,enabledRulesList);
        intent.putExtra(ConstantManager.VIBRATION,isVibrationEnabled);
        startActivityForResult(intent,ConstantManager.RESULT_SAVED_PLAY_DECK);
    }

    @OnClick(R.id.rules_btn)
    public void onRulesClick(){
        Intent intent = new Intent(this, RulesActivity.class);
        intent.putParcelableArrayListExtra(ConstantManager.ALL_RULES_LIST,allOfMyRulesList);
        intent.putParcelableArrayListExtra(ConstantManager.ENABLED_RULES_LIST,enabledRulesList);
        startActivityForResult(intent,ConstantManager.RESULT_RULES_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch(requestCode){
            case ConstantManager.RESULT_RULES_CODE:
            {
                if(data!=null) {
                    allOfMyRulesList = data.getParcelableArrayListExtra(ConstantManager.ALL_RULES_LIST);
                    enabledRulesList = data.getParcelableArrayListExtra(ConstantManager.ENABLED_RULES_LIST);
                }
            }
            break;
            case ConstantManager.RESULT_SETTINGS_CODE: {
                if (data != null) {
                    isVibrationEnabled = data.getBooleanExtra(ConstantManager.VIBRATION, true);
                    mDataManager.getPreferencesManager().saveVibrationValue(isVibrationEnabled);
                }
            }
            break;
            case ConstantManager.RESULT_SAVED_PLAY_DECK:
            {
                if(data!=null){
                    savedDeck = data.getParcelableArrayListExtra(ConstantManager.SAVED_DECK);
                    savedCard = data.getParcelableExtra(ConstantManager.SAVED_CARD);
                    savedPlayedCards = data.getIntExtra(ConstantManager.PLAYED_CARDS_COUNT,ConstantManager.ZERO);
                    savedKingsCount = data.getIntExtra(ConstantManager.KINGS_COUNT,ConstantManager.ZERO);

                    mDataManager.getPreferencesManager().saveDeck(savedDeck);
                    mDataManager.getPreferencesManager().saveCard(savedCard);
                    mDataManager.getPreferencesManager().savePlayedCardsValue(savedPlayedCards);
                    mDataManager.getPreferencesManager().saveKingsCount(savedKingsCount);
                }
            }
            break;
        }
    }

    private void setCards(){
        myCardList.add(new Card(CardValue.TWO,R.drawable.two_of_clubs,getString(R.string.rule_two)));
        myCardList.add(new Card(CardValue.TWO,R.drawable.two_of_diamonds,getString(R.string.rule_two)));
        myCardList.add(new Card(CardValue.TWO,R.drawable.two_of_hearts,getString(R.string.rule_two)));
        myCardList.add(new Card(CardValue.TWO,R.drawable.two_of_spades,getString(R.string.rule_two)));

        myCardList.add(new Card(CardValue.THREE,R.drawable.three_of_clubs,getString(R.string.three_rule)));
        myCardList.add(new Card(CardValue.THREE,R.drawable.three_of_diamonds,getString(R.string.three_rule)));
        myCardList.add(new Card(CardValue.THREE,R.drawable.three_of_hearts,getString(R.string.three_rule)));
        myCardList.add(new Card(CardValue.THREE,R.drawable.three_of_spades,getString(R.string.three_rule)));

        myCardList.add(new Card(CardValue.FOUR,R.drawable.four_of_clubs,getString(R.string.rule_four)));
        myCardList.add(new Card(CardValue.FOUR,R.drawable.four_of_diamonds,getString(R.string.rule_four)));
        myCardList.add(new Card(CardValue.FOUR,R.drawable.four_of_hearts,getString(R.string.rule_four)));
        myCardList.add(new Card(CardValue.FOUR,R.drawable.four_of_spades,getString(R.string.rule_four)));

        myCardList.add(new Card(CardValue.FIVE,R.drawable.five_of_clubs,getString(R.string.rule_five)));
        myCardList.add(new Card(CardValue.FIVE,R.drawable.five_of_diamonds,getString(R.string.rule_five)));
        myCardList.add(new Card(CardValue.FIVE,R.drawable.five_of_hearts,getString(R.string.rule_five)));
        myCardList.add(new Card(CardValue.FIVE,R.drawable.five_of_spades,getString(R.string.rule_five)));

        myCardList.add(new Card(CardValue.SIX,R.drawable.six_of_clubs,getString(R.string.rule_six)));
        myCardList.add(new Card(CardValue.SIX,R.drawable.six_of_diamonds,getString(R.string.rule_six)));
        myCardList.add(new Card(CardValue.SIX,R.drawable.six_of_hearts,getString(R.string.rule_six)));
        myCardList.add(new Card(CardValue.SIX,R.drawable.six_of_spades,getString(R.string.rule_six)));

        myCardList.add(new Card(CardValue.SEVEN,R.drawable.seven_of_clubs,getString(R.string.rule_seven)));
        myCardList.add(new Card(CardValue.SEVEN,R.drawable.seven_of_diamonds,getString(R.string.rule_seven)));
        myCardList.add(new Card(CardValue.SEVEN,R.drawable.seven_of_hearts,getString(R.string.rule_seven)));
        myCardList.add(new Card(CardValue.SEVEN,R.drawable.seven_of_spades,getString(R.string.rule_seven)));

        myCardList.add(new Card(CardValue.EIGHT,R.drawable.eight_of_clubs,getString(R.string.rule_eight)));
        myCardList.add(new Card(CardValue.EIGHT,R.drawable.eight_of_diamonds,getString(R.string.rule_eight)));
        myCardList.add(new Card(CardValue.EIGHT,R.drawable.eight_of_hearts,getString(R.string.rule_eight)));
        myCardList.add(new Card(CardValue.EIGHT,R.drawable.eight_of_spades,getString(R.string.rule_eight)));

        myCardList.add(new Card(CardValue.NINE,R.drawable.nine_of_clubs,getString(R.string.rule_nine)));
        myCardList.add(new Card(CardValue.NINE,R.drawable.nine_of_diamonds,getString(R.string.rule_nine)));
        myCardList.add(new Card(CardValue.NINE,R.drawable.nine_of_hearts,getString(R.string.rule_nine)));
        myCardList.add(new Card(CardValue.NINE,R.drawable.nine_of_spades,getString(R.string.rule_nine)));

        myCardList.add(new Card(CardValue.TEN,R.drawable.ten_of_clubs,getString(R.string.rule_ten)));
        myCardList.add(new Card(CardValue.TEN,R.drawable.ten_of_diamonds,getString(R.string.rule_ten)));
        myCardList.add(new Card(CardValue.TEN,R.drawable.ten_of_hearts,getString(R.string.rule_ten)));
        myCardList.add(new Card(CardValue.TEN,R.drawable.ten_of_spades,getString(R.string.rule_ten)));

        myCardList.add(new Card(CardValue.JACK,R.drawable.jack_of_clubs,getString(R.string.rule_jack)));
        myCardList.add(new Card(CardValue.JACK,R.drawable.jack_of_diamonds,getString(R.string.rule_jack)));
        myCardList.add(new Card(CardValue.JACK,R.drawable.jack_of_hearts,getString(R.string.rule_jack)));
        myCardList.add(new Card(CardValue.JACK,R.drawable.jack_of_spades,getString(R.string.rule_jack)));

        myCardList.add(new Card(CardValue.QUEEN,R.drawable.queen_of_clubs,getString(R.string.rule_queen)));
        myCardList.add(new Card(CardValue.QUEEN,R.drawable.queen_of_diamonds,getString(R.string.rule_queen)));
        myCardList.add(new Card(CardValue.QUEEN,R.drawable.queen_of_hearts,getString(R.string.rule_queen)));
        myCardList.add(new Card(CardValue.QUEEN,R.drawable.queen_of_spades,getString(R.string.rule_queen)));

        myCardList.add(new Card(CardValue.KING,R.drawable.king_of_clubs,getString(R.string.rule_king)));
        myCardList.add(new Card(CardValue.KING,R.drawable.king_of_diamonds,getString(R.string.rule_king)));
        myCardList.add(new Card(CardValue.KING,R.drawable.king_of_hearts,getString(R.string.rule_king)));
        myCardList.add(new Card(CardValue.KING,R.drawable.king_of_spades,getString(R.string.rule_king)));

        myCardList.add(new Card(CardValue.ACE,R.drawable.ace_of_clubs,getString(R.string.rule_ace)));
        myCardList.add(new Card(CardValue.ACE,R.drawable.ace_of_diamonds,getString(R.string.rule_ace)));
        myCardList.add(new Card(CardValue.ACE,R.drawable.ace_of_hearts,getString(R.string.rule_ace)));
        myCardList.add(new Card(CardValue.ACE,R.drawable.ace_of_spades,getString(R.string.rule_ace)));
    }

    private void setRules(){
        Rule basicTwoRule = new Rule(CardValue.TWO,getString(R.string.two_rule_title),
                getString(R.string.two_rule_text),R.drawable.two_of_hearts);
        allOfMyRulesList.add(basicTwoRule);
        enabledRulesList.add(basicTwoRule);

        Rule basicThreeRule = new Rule(CardValue.THREE,getString(R.string.three_rule_title),
                getString(R.string.three_rule_text),R.drawable.three_of_hearts);
        allOfMyRulesList.add(basicThreeRule);
        enabledRulesList.add(basicThreeRule);

        Rule basicFourRule = new Rule(CardValue.FOUR,getString(R.string.four_rule_title),
                getString(R.string.four_rule_text),R.drawable.four_of_hearts);
        allOfMyRulesList.add(basicFourRule);
        enabledRulesList.add(basicFourRule);

        Rule basicFiveRule = new Rule(CardValue.FIVE,getString(R.string.five_rule_title),
                getString(R.string.five_rule_text),R.drawable.five_of_hearts);
        allOfMyRulesList.add(basicFiveRule);
        enabledRulesList.add(basicFiveRule);

        Rule basicSixRule = new Rule(CardValue.SIX,getString(R.string.six_rule_title),
                getString(R.string.six_rule_text),R.drawable.six_of_hearts);
        allOfMyRulesList.add(basicSixRule);
        enabledRulesList.add(basicSixRule);

        Rule basicSevenRule = new Rule(CardValue.SEVEN,getString(R.string.seven_rule_title),
                getString(R.string.seven_rule_text),R.drawable.seven_of_hearts);
        allOfMyRulesList.add(basicSevenRule);
        enabledRulesList.add(basicSevenRule);

        Rule basicEightRule = new Rule(CardValue.EIGHT,getString(R.string.eight_rule_title),
                getString(R.string.eight_rule_text),R.drawable.eight_of_hearts);
        allOfMyRulesList.add(basicEightRule);
        enabledRulesList.add(basicEightRule);

        Rule basicNineRule = new Rule(CardValue.NINE,getString(R.string.nine_rule_title),
                getString(R.string.nine_rule_text),R.drawable.nine_of_hearts);
        allOfMyRulesList.add(basicNineRule);
        enabledRulesList.add(basicNineRule);

        Rule basicTenRule = new Rule(CardValue.TEN,getString(R.string.ten_rule_title),
                getString(R.string.ten_rule_text),R.drawable.ten_of_hearts);
        allOfMyRulesList.add(basicTenRule);
        enabledRulesList.add(basicTenRule);

        Rule basicJackRule = new Rule(CardValue.JACK,getString(R.string.jack_rule_title),
                getString(R.string.jack_rule_text),R.drawable.jack_of_hearts);
        allOfMyRulesList.add(basicJackRule);
        enabledRulesList.add(basicJackRule);

        Rule basicQueenRule = new Rule(CardValue.QUEEN,getString(R.string.queen_rule_title),
                getString(R.string.queen_rule_text),R.drawable.queen_of_hearts);
        allOfMyRulesList.add(basicQueenRule);
        enabledRulesList.add(basicQueenRule);

        Rule basicKingRule = new Rule(CardValue.KING,getString(R.string.king_rule_title),
                getString(R.string.king_rule_text),R.drawable.king_of_hearts);
        allOfMyRulesList.add(basicKingRule);
        enabledRulesList.add(basicKingRule);

        Rule basicAceRule = new Rule(CardValue.ACE,getString(R.string.ace_rule_title),
                getString(R.string.ace_rule_text),R.drawable.ace_of_hearts);
        allOfMyRulesList.add(basicAceRule);
        enabledRulesList.add(basicAceRule);


    }
}
