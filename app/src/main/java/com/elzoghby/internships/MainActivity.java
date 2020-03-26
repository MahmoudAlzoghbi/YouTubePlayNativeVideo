package com.elzoghby.internships;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.elzoghby.internships.pojo.ApiServices;
import com.elzoghby.internships.pojo.RetrofitClient;
import com.elzoghby.internships.pojo.YouTubeData;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends FragmentActivity {

    public static final String DEVELOPER_KEY="AIzaSyB43vfEpUD3NFH5ZV3l1UXcJOZ5aZ7SIZQ";
    private static final String VIDEO_ID = "lAM9sNoxzIw";
    private static final int RECOVERY_DIALOG_REQUEST = 1;

    YouTubePlayerFragment myYouTubePlayerFragment;

    ApiServices apiServices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*myYouTubePlayerFragment = (YouTubePlayerFragment)getFragmentManager().findFragmentById(R.id.youtubeplayerfragment);
        myYouTubePlayerFragment.initialize(DEVELOPER_KEY , this);

        apiServices = RetrofitClient.getClient().create(ApiServices.class);

        apiServices.getChannel().enqueue(new Callback<YouTubeData>() {
            @Override
            public void onResponse(Call<YouTubeData> call, Response<YouTubeData> response) {
                if (response.isSuccessful())
                    Log.i("a7a" , "a7a");
                Toast.makeText(MainActivity.this , response.body().getEtag() , Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<YouTubeData> call, Throwable t) {
                    Log.i("a7a" , t.getMessage());
                Toast.makeText(MainActivity.this , t.getMessage() , Toast.LENGTH_LONG).show();
            }
        });*/
    }

    /*@Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        if (!b)
            youTubePlayer.cueVideo(VIDEO_ID);
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            if (youTubeInitializationResult.isUserRecoverableError())
                youTubeInitializationResult.getErrorDialog(this , RECOVERY_DIALOG_REQUEST);
            else {
                String errorMessage = String.format(
                        "There is an Error in Initializing YouTubePlayer" ,
                        youTubeInitializationResult.toString()
                        );
                Toast.makeText(this , errorMessage , Toast.LENGTH_LONG).show();
            }
    }
    @Override
    protected void onActivityResult(int requestCode , int resultCode , Intent intent){
         if (requestCode == RECOVERY_DIALOG_REQUEST)
             getYouTubePlayerProvider().initialize(DEVELOPER_KEY , this);
    }

    protected YouTubePlayer.Provider getYouTubePlayerProvider (){
        return (YouTubePlayerView)findViewById(R.id.youtubeplayerfragment);
    }*/
}
