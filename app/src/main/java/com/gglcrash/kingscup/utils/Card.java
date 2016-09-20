package com.gglcrash.kingscup.utils;

import android.os.Parcel;
import android.os.Parcelable;

import com.gglcrash.kingscup.ui.activities.MainActivity;

/**
 * Created by gglcrash on 20.09.2016.
 */
public class Card implements Parcelable{


    private MainActivity.CardValue value;
    private int imageId;
    private String ruleTitle;
    private boolean enabled;
    public Card(MainActivity.CardValue val, int img, String title){
        value = val;
        imageId = img;
        ruleTitle = title;
        enabled = false;
    }

    protected Card(Parcel in) {
        imageId = in.readInt();
        ruleTitle = in.readString();
        enabled = in.readByte() != 0;
        value = MainActivity.CardValue.valueOf(in.readString());
    }

    public static final Creator<Card> CREATOR = new Creator<Card>() {
        @Override
        public Card createFromParcel(Parcel in) {
            return new Card(in);
        }

        @Override
        public Card[] newArray(int size) {
            return new Card[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imageId);
        dest.writeString(ruleTitle);
        dest.writeByte((byte) (enabled ? 1 : 0));
        dest.writeString(value.name());

    }


    public void setRuleTitle(String ruleTitle) {
        this.ruleTitle = ruleTitle;
    }

    public void setValue(MainActivity.CardValue value) {
        this.value = value;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public String getRuleTitle() {
        return ruleTitle;
    }

    public int getImageId() {
        return imageId;
    }

    public MainActivity.CardValue getValue() {
        return value;
    }
}
