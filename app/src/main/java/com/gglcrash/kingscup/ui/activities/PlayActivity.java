package com.gglcrash.kingscup.ui.activities;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gglcrash.kingscup.R;
import com.gglcrash.kingscup.utils.Card;
import com.gglcrash.kingscup.utils.ConstantManager;
import com.gglcrash.kingscup.utils.Rule;

import java.util.ArrayList;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTouch;

/**
 * Created by gglcrash on 20.09.2016.
 */
public class PlayActivity extends BaseActivity {

    private boolean isVibrationEnabled;
    private Vibrator v;
    private ArrayList<Card> tempCardList;
    private ArrayList<Card> myCardList;
    private ArrayList<Rule> currentRulesList = new ArrayList<>();
    private Card currentCard;
    private float x1,x2,y1,y2;
    private boolean gameOver;

    private Random rand;
    private int number;
    private int kingsCount;
    private int playedCards;

    @BindView(R.id.advice_text_view)
    TextView adviceText;
    @BindView(R.id.cards_in_deck_text_view)
    TextView cardsInDeck;
    @BindView(R.id.kings_played_text_view)
    TextView kingsPlayed;

    @BindView(R.id.btn_back)
    Button btnBack;

    @BindView(R.id.img_card_view)
    ImageView imgCardView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        ButterKnife.bind(this);

        //btnBack.setBackgroundColor(getResources().getColor(android.R.color.transparent));

        v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        rand = new Random();
        gameOver = false;
        number = 0;
        currentCard = null;
        imgCardView.setBackgroundResource(R.drawable.back);
        isVibrationEnabled = getIntent().getBooleanExtra(ConstantManager.VIBRATION,true);

        tempCardList = new ArrayList<>();
        myCardList = getIntent().getParcelableArrayListExtra(ConstantManager.CARD_LIST);

        copyArrayList(myCardList,tempCardList);
        currentRulesList = getIntent().getParcelableArrayListExtra(ConstantManager.ENABLED_RULES_LIST);

        currentCard = getIntent().getParcelableExtra(ConstantManager.SAVED_CARD);
        if(currentCard!=null){
            showDialog(ConstantManager.RESUME_RESTART_CONST);
        }
        playedCards = getIntent().getIntExtra(ConstantManager.PLAYED_CARDS_COUNT, ConstantManager.ZERO);
        kingsCount = getIntent().getIntExtra(ConstantManager.KINGS_COUNT,ConstantManager.ZERO);
        setSavedCard(currentCard);
        updateStats();

    }

    @Override
    protected void onResume() {

        super.onResume();
        hideStatusBar();
         }

    private void setSavedCard(Card card) {
        if (card != null) {
            imgCardView.setBackgroundResource(card.getImageId());
            adviceText.setText(card.getRuleTitle());
            adviceText.setTextSize(ConstantManager.TITLE_RULE_SIZE);
            adviceText.setTextColor(getResources().getColor(R.color.black));

        }
    }

    private void hideStatusBar(){
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }

    private void copyArrayList(ArrayList<Card> into, ArrayList<Card> to){
        for (Card card:into) {
            to.add(card);
        }
    }

    @OnClick(R.id.btn_back)
    public void onBack(){
        finish();
    }

    @OnTouch(R.id.img_card_view)
    public boolean onTouchImg(MotionEvent event){
        switch ( event.getAction() ){

            case MotionEvent.ACTION_DOWN:{
                x1 = event.getX();
                y1 = event.getY();
                break;
            }

            case MotionEvent.ACTION_UP:{
                x2 = event.getX();
                y2 = event.getY();

                if ( Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1))>ConstantManager.SWIPE_LENGTH) {


                    if(myCardList.size()>0) {
                        number = rand.nextInt(myCardList.size());
                        currentCard = myCardList.get(number);
                        myCardList.remove(currentCard);

                        imgCardView.setBackgroundResource(currentCard.getImageId());

                        playedCards++;

                        adviceText.setText(currentCard.getRuleTitle());
                        adviceText.setTextSize(ConstantManager.TITLE_RULE_SIZE);
                        adviceText.setTextColor(getResources().getColor(R.color.black));

                        updateStats();
                    }
                    else
                    {
                        adviceText.setText("");
                        if(gameOver){
                            restartGame();
                        }
                        else {
                            imgCardView.setBackgroundResource(R.drawable.clear_back);
                            currentCard = null;
                            gameOver = true;
                        }
                    }

                }

                break;
            }
        }
        return true;
    }

    private void restartGame(){
        copyArrayList(tempCardList,myCardList);
        kingsCount = 0;
        playedCards = 0;
        currentCard=null;
        gameOver = false;
        adviceText.setText("");
        imgCardView.setBackgroundResource(R.drawable.back);
        kingsPlayed.setTextColor(getResources().getColor(R.color.black));
        updateStats();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case ConstantManager.RESUME_RESTART_CONST:

                final String[] mCatsName ={getString(R.string.continue_game), getString(R.string.restart_game)};

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle(getString(R.string.choose_what_you_want)); // заголовок для диалога

                builder.setItems(mCatsName, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        if (item == 1) {
                            restartGame();
                        }
                    }
                });
                builder.setCancelable(false);
                return builder.create();

            default:
                return null;
        }
    }
/*
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
*/
    @OnClick(R.id.fab_info)
    public void showRuleTitle(){
        if(currentCard!=null) {
            for (Rule rule:currentRulesList) {
                if(rule.getValue()==currentCard.getValue()){
                    AlertDialog.Builder builder = new AlertDialog.Builder(PlayActivity.this);
                    builder.setTitle(getString(R.string.advice))
                            .setMessage(rule.getRuleText())
                            .setIcon(R.drawable.ic_advice_24dp)
                            .setCancelable(false)
                            .setNegativeButton(getString(R.string.ok_btn_text),
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();

                                            hideStatusBar();
                                        }
                                    });
                    AlertDialog alert = builder.create();
                    alert.show();
                }
            }

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

        cardsInDeck.setText(ConstantManager.CARDS_IN_DECK-playedCards+"");
        kingsPlayed.setText(kingsCount+"");

        Intent intentResult = new Intent();
        intentResult.putExtra(ConstantManager.SAVED_CARD,currentCard);
        intentResult.putParcelableArrayListExtra(ConstantManager.SAVED_DECK,myCardList);
        intentResult.putExtra(ConstantManager.PLAYED_CARDS_COUNT, playedCards);
        intentResult.putExtra(ConstantManager.KINGS_COUNT, kingsCount);
        setResult(ConstantManager.RESULT_SAVED_PLAY_DECK,intentResult);

    }
}


