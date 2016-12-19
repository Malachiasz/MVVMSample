package sample.de.mvvmsample.platform;

import android.app.Activity;
import android.os.Bundle;

import sample.de.mvvmsample.R;

/**
 * Created by darek on 18.12.16.
 */

public class TwitterActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.twitter_activity);

        if (savedInstanceState == null) {
            // Create a new Fragment to be placed in the activity layout
            TwitterListFragment twitterFragment = TwitterListFragment.getInstance();

            getFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, twitterFragment).commit();
        }
    }
}