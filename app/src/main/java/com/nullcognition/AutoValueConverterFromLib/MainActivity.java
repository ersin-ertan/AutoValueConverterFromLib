package com.nullcognition.AutoValueConverterFromLib;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import com.nullcognition.mylibrary.Contributor2;
import com.nullcognition.mylibrary.MyAdapterFactory2;
import com.squareup.moshi.Moshi;
import java.io.IOException;
import java.util.List;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class MainActivity extends AppCompatActivity {

  public static final String API_URL = "https://api.github.com";
  TextView textView;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Moshi moshi =
        // MyAdapterFactory2 from the lib is needed to adapt models from the lib
        new Moshi.Builder().add(MyAdapterFactory.create()).add(MyAdapterFactory2.create()).build();
    //Moshi moshi = new Moshi.Builder().build();

    Retrofit retrofit = new Retrofit.Builder().baseUrl(API_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build();

    // Create an instance of our GitHub API interface.
    GitHub github = retrofit.create(GitHub.class);

    // Create a call instance for looking up Retrofit contributors.
    final Call<List<Contributor2>> call = github.contributors2("square", "retrofit");

    // Fetch and print a list of the contributors to the library.

    new Thread(new Runnable() {

      @Override public void run() {
        try {
          final List<Contributor2> contributors = call.execute().body();
          runOnUiThread(new Runnable() {
            @Override public void run() {
              textView = (TextView) findViewById(R.id.textView);
              textView.setText(contributors.get(0).login());
            }
          });
          for (final Contributor2 contributor : contributors) {
            System.out.println(contributor.login() + " (" + contributor.contributions() + ")");
          }
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }).start();
  }
}