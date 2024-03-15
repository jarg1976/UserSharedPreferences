package jarg.com.usersharedpreferences.services;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;

import jarg.com.usersharedpreferences.models.User;

public class SharedPreferencesManager {

  private static final String SHARED_PREFERENCES_NAME = "MyPrefs";
  private static final String KEY_USER = "user";

  private SharedPreferences sharedPreferences;
  private Gson gson;

  public SharedPreferencesManager(Context context) {
    sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
    gson = new Gson();
  }

  public void saveUser(User user) {
    String userJson = gson.toJson(user);
    SharedPreferences.Editor editor = sharedPreferences.edit();
    editor.putString(KEY_USER, userJson);
    editor.apply();
  }

  public User getUser() {
    String userJson = sharedPreferences.getString(KEY_USER, null);
    if (userJson != null) {
      return gson.fromJson(userJson, User.class);
    }
    return null;
  }

  public boolean isRegistered() {
    return sharedPreferences.contains(KEY_USER);
  }
}
