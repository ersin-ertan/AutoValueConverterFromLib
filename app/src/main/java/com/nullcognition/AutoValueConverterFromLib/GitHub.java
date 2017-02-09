package com.nullcognition.AutoValueConverterFromLib;

import com.nullcognition.mylibrary.Contributor2;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by mms on 2/9/17.
 */

public interface GitHub {
  @GET("/repos/{owner}/{repo}/contributors") Call<List<Contributor2>> contributors2(
      @Path("owner") String owner, @Path("repo") String repo);

  @GET("/repos/{owner}/{repo}/contributors") Call<List<Contributor>> contributors(
      @Path("owner") String owner, @Path("repo") String repo);
}