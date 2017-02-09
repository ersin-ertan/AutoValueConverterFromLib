package com.nullcognition.mylibrary;

import com.ryanharter.auto.value.moshi.MoshiAdapterFactory;
import com.squareup.moshi.JsonAdapter;

/**
 * Created by mms on 2/9/17.
 */

@MoshiAdapterFactory public abstract class MyAdapterFactory2 implements JsonAdapter.Factory {

  public static JsonAdapter.Factory create() {
    return new AutoValueMoshi_MyAdapterFactory2();
  }
}
