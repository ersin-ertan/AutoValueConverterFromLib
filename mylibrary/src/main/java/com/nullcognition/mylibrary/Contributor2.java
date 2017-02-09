package com.nullcognition.mylibrary;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

/**
 * Created by mms on 2/9/17.
 */

@AutoValue public abstract class Contributor2 {
  public abstract String login();

  public abstract int contributions();

  public static Contributor2 create(String login, int contributions) {
    return new AutoValue_Contributor2(login, contributions);
  }

  public static JsonAdapter<Contributor2> jsonAdapter(Moshi moshi) {
    return new AutoValue_Contributor2.MoshiJsonAdapter(moshi);
  }
}
