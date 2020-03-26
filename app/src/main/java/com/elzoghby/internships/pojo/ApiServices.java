package com.elzoghby.internships.pojo;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServices {

    @GET("videos?id=HZnLbJ3nvMc&key=AIzaSyB43vfEpUD3NFH5ZV3l1UXcJOZ5aZ7SIZQ&part=snippet,contentDetails,statistics,status")
    Call<YouTubeData> getChannel();

}
