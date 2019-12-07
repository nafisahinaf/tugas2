package com.example.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;

public class SharePrefManager {
    private static final  String SP_Name = "SharePref";

    private static SharePrefManager mInstance;
    private Context mContext;

    public SharePrefManager(Context mContext){
        this.mContext = mContext;
    }

    public static synchronized SharePrefManager getInstance(Context mContext){
        if (mInstance==null){
            mInstance = new SharePrefManager(mContext);
        }
        return mInstance;
    }

    public void saveContact(ContactModel contact){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(SP_Name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("name", contact.getName());
        editor.putString("phone", contact.getPhone());
        editor.putString("address", contact.getAddress());

        editor.apply();
    }

    public ContactModel getContact(){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(SP_Name, Context.MODE_PRIVATE);
        return new ContactModel(
                sharedPreferences.getString("name", null),
                sharedPreferences.getString("phone", null),
                sharedPreferences.getString("address", null)
        );
    }

    public void clear(){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(SP_Name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}
