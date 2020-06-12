package utils;

import android.content.Context;
import android.content.SharedPreferences;

public class GlobalPref {
  private final static String TOKEN = "token";
    private final static String PREF = "vehicle_user";
    private SharedPreferences.Editor editor;
    private SharedPreferences sharedPreferences;

    GlobalPref() {
    }

    public GlobalPref(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.apply();
    }


    public void setToken(String s) {
        editor.putString(TOKEN, s);
        editor.apply();
    }

    public String getToken() {
        return sharedPreferences.getString(TOKEN,null);
    }


}
