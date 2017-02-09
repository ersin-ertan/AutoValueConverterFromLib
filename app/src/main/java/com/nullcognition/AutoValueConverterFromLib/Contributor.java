package com.nullcognition.AutoValueConverterFromLib;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

/**
 * Created by mms on 2/9/17.
 */

@AutoValue public abstract class Contributor {
  public abstract String login();

  public abstract int contributions();

  public static Contributor create(String login, int contributions) {
    return new AutoValue_Contributor(login, contributions);
  }

  public static JsonAdapter<Contributor> jsonAdapter(Moshi moshi) {
    return new AutoValue_Contributor.MoshiJsonAdapter(moshi);
  }
}

//public class Contributor {
//  public final String login;
//  public final int contributions;
//
//  public Contributor(String login, int contributions) {
//    this.login = login;
//    this.contributions = contributions;
//  }
//
//  public String login() {
//    return login;
//  }
//
//  public int contributions() {
//    return contributions;
//  }
//}
