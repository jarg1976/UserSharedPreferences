package jarg.com.usersharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import jarg.com.usersharedpreferences.models.User;
import jarg.com.usersharedpreferences.services.SharedPreferencesManager;

public class MainActivity extends AppCompatActivity {
  private static final long SPLASH_DELAY = 2000; // Tempo de atraso em milissegundos (2 segundos)
  private SharedPreferencesManager sharedPreferencesManager;
  private EditText editTextEmail, editTextPassword, editTextQuestion1, editTextAnswer1, editTextQuestion2, editTextAnswer2;
  private Button buttonRegister;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_intro);

    sharedPreferencesManager = new SharedPreferencesManager(this);
    //Toast.makeText(this, "" + sharedPreferencesManager.getUser().toString(), Toast.LENGTH_SHORT).show();
    new Handler().postDelayed(new Runnable() {
      @Override
      public void run() {
        if(sharedPreferencesManager.isRegistered()) {
          setContentView(R.layout.login);
        } else {
          setContentView(R.layout.register);
        }
      }
    }, SPLASH_DELAY);
  }

  public void register(View v) {
    editTextEmail = findViewById(R.id.editTextEmail);
    editTextPassword = findViewById(R.id.editTextPassword);
    editTextQuestion1 = findViewById(R.id.editTextQuestion1);
    editTextAnswer1 = findViewById(R.id.editTextAnswer1);
    editTextQuestion2 = findViewById(R.id.editTextQuestion2);
    editTextAnswer2 = findViewById(R.id.editTextAnswer2);
    buttonRegister = findViewById(R.id.buttonRegister);

    String email = editTextEmail.getText().toString();
    String password = editTextPassword.getText().toString();
    String question1 = editTextQuestion1.getText().toString();
    String answer1 = editTextAnswer1.getText().toString();
    String question2 = editTextQuestion2.getText().toString();
    String answer2 = editTextAnswer2.getText().toString();

    User user = new User(email, password);

    this.sharedPreferencesManager.saveUser(user);

    new Handler().postDelayed(new Runnable() {
      @Override
      public void run() {
        setContentView(R.layout.login);
      }
    }, SPLASH_DELAY);
  }
}