package com.gglcrash.kingscup.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.gglcrash.kingscup.R;
import com.gglcrash.kingscup.utils.Card;
import com.gglcrash.kingscup.utils.ConstantManager;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    public enum CardValue {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT,
        NINE, TEN, JACK, QUEEN, KING, ACE
    }

    private ArrayList<Card> myCardList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        setCards();
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
        Intent intent = new Intent(this, PlayActivity.class);
        intent.putParcelableArrayListExtra(ConstantManager.CARD_LIST, myCardList);
        startActivity(intent);
    }

    @OnClick(R.id.rules_btn)
    public void onRulesClick(){
        Intent intent = new Intent(this, RulesActivity.class);
        startActivity(intent);
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
}
