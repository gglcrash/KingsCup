package com.gglcrash.kingscup.ui.activities;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gglcrash.kingscup.R;
import com.gglcrash.kingscup.utils.Card;
import com.gglcrash.kingscup.utils.ConstantManager;

import java.util.ArrayList;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;

/**
 * Created by gglcrash on 20.09.2016.
 */
public class PlayActivity extends BaseActivity {

    private boolean isVibrationEnabled;
    private Vibrator v;
    private ArrayList<Card> myCardList = new ArrayList<>();
    private Card currentCard;
    Random rand;
    int number;
    int kingsCount;
    int playedCards;

    @BindView(R.id.advice_text_view)
    TextView adviceText;
    @BindView(R.id.cards_in_deck_text_view)
    TextView cardsInDeck;
    @BindView(R.id.cards_played_text_view)
    TextView cardsPlayed;
    @BindView(R.id.kings_played_text_view)
    TextView kingsPlayed;

    @BindView(R.id.img_card_view)
    ImageView imgCardView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        ButterKnife.bind(this);

        v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        rand = new Random();
        number = 0;
        kingsCount = 0;
        playedCards = 0;
        currentCard = null;
        isVibrationEnabled = getIntent().getBooleanExtra(ConstantManager.VIBRATION,true);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        myCardList = getIntent().getParcelableArrayListExtra(ConstantManager.CARD_LIST);
        updateStats();

    }

    @OnLongClick(R.id.img_card_view)
    public boolean onLongClickCard(){

        adviceText.setVisibility(View.INVISIBLE);
        if(myCardList.size()>0) {
            number = rand.nextInt(myCardList.size());
            currentCard = myCardList.get(number);
            myCardList.remove(currentCard);

            imgCardView.setBackgroundResource(currentCard.getImageId());

            playedCards++;

            updateStats();
        }
        else
        {
            imgCardView.setBackgroundResource(R.drawable.clear_back);
            currentCard=null;
        }


        return true;
    }

    @OnClick(R.id.fab_info)
    public void showRuleTitle(){
        if(currentCard!=null) {
            showToast(currentCard.getRuleTitle());
        }
    }

    private void updateStats(){
        if((currentCard!=null) && (currentCard.getValue()== MainActivity.CardValue.KING)){
            kingsCount++;
            if(kingsCount==4){
                kingsPlayed.setTextColor(getResources().getColor(R.color.red));
                if(isVibrationEnabled) {
                    v.vibrate(ConstantManager.LONG_VIBRATION_DURATION);
                }
            }
            else{
                if(isVibrationEnabled) {
                    v.vibrate(ConstantManager.SHORT_VIBRATION_DURATION);
                }
            }
        }

        cardsPlayed.setText(playedCards+"");
        cardsInDeck.setText(ConstantManager.CARDS_IN_DECK-playedCards+"");
        kingsPlayed.setText(kingsCount+"");

    }
}


