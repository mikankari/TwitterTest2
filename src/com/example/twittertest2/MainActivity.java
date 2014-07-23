package com.example.twittertest2;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import twitter4j.ResponseList;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // •ÊƒXƒŒƒbƒh‚¶‚á‚È‚¢‚Æ‚¨‚±
       	ArrayList<Status> list = parseTimeline();
       	for(int i = 0; i < list.size(); i++){
       		TableLayout container = (TableLayout)findViewById(R.id.container); 
       		TableRow row = new TableRow(this);
       		ImageView imageview = new ImageView(this);
       		imageview.setImageResource(R.drawable.dummy);
//       		try{
//       			imageview.setImageDrawable(Drawable.createFromStream(new URL(list.get(i).getProfileImageUrl()).openStream(), ""));
//       		}catch(IOException error){
//       			error.printStackTrace();
//       		}
       		row.addView(imageview);
       		TextView textview = new TextView(this);
       		textview.setText("@" + list.get(i).getScreenName() + "\n" + list.get(i).getText());
       		row.addView(textview);
       		container.addView(row);
       	}
       	
//        String text = "";
//        for(int i = 0; i < list.size(); i++){
//        	text = text.concat(list.get(i).getText() + "\n");
//        }
//        TextView textview = (TextView)findViewById(R.id.textview2);
//System.err.println(""+list.size());
//Toast.makeText(this, "" + list.size(), Toast.LENGTH_SHORT).show();
//        textview.setText(text);

    }

        private ArrayList<Status> parseTimeline() {
            ArrayList<Status> list = new ArrayList<Status>();
            String consumerKey = "EW5z6GixlmldAlo0l6gLItYOT";
            String consumerKeySecret = "nqRsY1s27De4zsG9IoFsAGpCp8i4mq3wmUXXmyjQH9Urox8suK";
            String accessToken = "995222642-rzx4SbYdjmHvaRTRNyuNLrtLtniwZAJQC88FzPzG";
            String accessTokenSecret = "JtX3IIBq8093mCmoU816TSdGdbKBDR3vUk6wnPQqd2DQ1";
            ConfigurationBuilder cbuilder = new ConfigurationBuilder();
            cbuilder.setOAuthConsumerKey(consumerKey);
            cbuilder.setOAuthConsumerSecret(consumerKeySecret);
            cbuilder.setOAuthAccessToken(accessToken);
            cbuilder.setOAuthAccessTokenSecret(accessTokenSecret);      // 3
            cbuilder.setRestBaseURL("https://api.twitter.com/1.1/");
            TwitterFactory twitterFactory = new TwitterFactory(cbuilder.build());
            Twitter mTwitter = twitterFactory.getInstance();
            ResponseList<twitter4j.Status> statuses;
            try {
                statuses = mTwitter.getHomeTimeline();  // 4
Toast.makeText(this, "" + statuses.size(), Toast.LENGTH_SHORT).show();
//System.out.println("ok");
                for (twitter4j.Status status : statuses) {
                    Status s = new Status();
                    s.setScreenName(status.getUser().getScreenName());
                    s.setProfileImageUrl(status.getUser().getProfileImageURL().toString());       // 5
                    s.setText(status.getText());
                    list.add(s);
//                    System.out.println(status.getText());
                }
            } catch (TwitterException e) {
                e.printStackTrace();
            }
            return list;
        }
}

