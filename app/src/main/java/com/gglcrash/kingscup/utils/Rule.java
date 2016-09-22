package com.gglcrash.kingscup.utils;

import android.os.Parcel;
import android.os.Parcelable;

import com.gglcrash.kingscup.ui.activities.MainActivity;

/**
 * Created by gglcrash on 22.09.2016.
 */
public class Rule implements Parcelable {


    private MainActivity.CardValue value;
    private int imageId;
    private String ruleTitle;
    private String ruleText;

    public Rule(MainActivity.CardValue val, String title, String ruleTxt, int img) {
        value = val;
        imageId = img;
        ruleTitle = title;
        ruleText = ruleTxt;
    }

    protected Rule(Parcel in) {
        imageId = in.readInt();
        ruleTitle = in.readString();
        ruleText = in.readString();
        value = MainActivity.CardValue.valueOf(in.readString());
    }

    public static final Creator<Rule> CREATOR = new Creator<Rule>() {
        @Override
        public Rule createFromParcel(Parcel in) {
            return new Rule(in);
        }

        @Override
        public Rule[] newArray(int size) {
            return new Rule[size];
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
        dest.writeString(ruleText);
        dest.writeString(value.name());

    }
}