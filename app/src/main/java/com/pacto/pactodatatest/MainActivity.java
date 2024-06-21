package com.pacto.pactodatatest;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

  private TextView tvMessagePacto;
  private MainViewModel mainViewModel;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    EdgeToEdge.enable(this);
    setContentView(R.layout.activity_main);

    setupViews();
    setupViewModel();
    setupViewObservers();

    mainViewModel.getUser();
  }

  private void setupViews() {
    tvMessagePacto = findViewById(R.id.tv_message_pacto);
  }

  private void setupViewModel() {
    mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
  }

  @SuppressLint("SetTextI18n") private void setupViewObservers() {
    mainViewModel.getUserLiveData()
        .observe(this, user -> tvMessagePacto.setText(
            "User: " + user.getName() + ", Email: " + user.getEmail()));

    mainViewModel.getErrorLiveData()
        .observe(this,
            error -> Toast.makeText(this, "Error: " + error.getMessage(), Toast.LENGTH_SHORT)
                .show());
  }
}
