package com.elzoghby.internships;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.elzoghby.internships.pojo.ApiServices;
import com.elzoghby.internships.pojo.RetrofitClient;
import com.elzoghby.internships.pojo.YouTubeData;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerView;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityChannel1 extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    public static final String DEVELOPER_KEY="AIzaSyB43vfEpUD3NFH5ZV3l1UXcJOZ5aZ7SIZQ";
    //private static final String VIDEO_ID = "lAM9sNoxzIw";
    private static final int RECOVERY_DIALOG_REQUEST = 1;

    YouTubePlayerFragment myYouTubePlayerFragment;

    ApiServices apiServices;

    String videoId ;
    String photoURL;
    String channelTitle;

    ImageView channel1Image;
    TextView channelTitleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel1);

        apiServices = RetrofitClient.getClient().create(ApiServices.class);

        apiServices.getChannel().enqueue(new Callback<YouTubeData>() {
            @Override
            public void onResponse(Call<YouTubeData> call, Response<YouTubeData> response) {
                if (response.isSuccessful()){
                       videoId = response.body().getItems().get(0).getId();
                       photoURL = response.body().getItems().get(0).getSnippet().getThumbnails().getHigh().getUrl();
                       channelTitle = response.body().getItems().get(0).getSnippet().getChannelTitle();
                }

                //Toast.makeText(ActivityChannel1.this , response.body().getEtag() , Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<YouTubeData> call, Throwable t) {
                Log.i("Failed" , t.getMessage());

                Toast.makeText(ActivityChannel1.this , t.getMessage() , Toast.LENGTH_LONG).show();
            }
        });

        myYouTubePlayerFragment = (YouTubePlayerFragment)getFragmentManager().findFragmentById(R.id.channel1);
        myYouTubePlayerFragment.initialize(DEVELOPER_KEY , ActivityChannel1.this);

        channel1Image = findViewById(R.id.channel_photo);
        channelTitleTextView = findViewById(R.id.channel_name);

        Picasso.with(ActivityChannel1.this).load(photoURL).into(channel1Image);
        channelTitleTextView.setText(channelTitle);

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        if (!b)
            youTubePlayer.cueVideo(videoId);
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
    }

    public String getID(String id){
        return id;
    }
}
