package com.gglcrash.kingscup.ui.activities;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.gglcrash.kingscup.R;
import com.gglcrash.kingscup.utils.ConstantManager;

/**
 * Created by gglcrash on 20.09.2016.
 */
public class BaseActivity extends AppCompatActivity {
    protected ProgressDialog mProgressDialog;
    static final String TAG = ConstantManager.TAG_PREFIX+"BaseActivity";
    /**
     * показать кружок загрузки
     */
    public void showProgress(){
        if(mProgressDialog==null){
            mProgressDialog=new ProgressDialog(this, R.style.custom_dialog);
            mProgressDialog.setCancelable(false);
            mProgressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            mProgressDialog.show();

            mProgressDialog.setContentView(R.layout.progress_splash);
        }
        else{
            mProgressDialog.show();
            mProgressDialog.setContentView(R.layout.progress_splash);
        }
    }

    public void hideProgress(){

        if(mProgressDialog!=null) {
            if (mProgressDialog.isShowing()) {
                mProgressDialog.hide();
            }
        }
    }

    public void showError(String message,Exception error){
        showToast(message);
        Log.e(TAG, String.valueOf(error));
    }

    public void showToast(String message){
        (Toast.makeText(this,message,Toast.LENGTH_LONG)).show();
    }
}
