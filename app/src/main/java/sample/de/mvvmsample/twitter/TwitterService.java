package sample.de.mvvmsample.twitter;

import android.support.annotation.WorkerThread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Created by darek on 18.12.16.
 */

public class TwitterService {

    public void requestTwits(final TwitsLoader twitsLoader) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<Twit> twits = getTwits();
                twitsLoader.onTwitsLoaded(twits);
            }
        }).start();

    }

    @WorkerThread
    private List<Twit> getTwits(){
        List<Twit> twits = new ArrayList<>();
        for (int i=0; i<10; i++){
            twits.add(new Twit(randomWord(10), randomWord(10), randomWord(10)));
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return twits;
    }


    private String randomWord(int wordLength) {
        Random r = new Random(); // Intialize a Random Number Generator with SysTime as the seed
        StringBuilder sb = new StringBuilder(wordLength);
        for(int i = 0; i < wordLength; i++) { // For each letter in the word
            int tmp = 'a' + r.nextInt('z' - 'a'); // Generate a letter between a and z
            sb.append(tmp); // Add it to the String
        }
        return sb.toString();
    }

    public interface TwitsLoader {
        void onTwitsLoaded(List<Twit> twits);
    }
}
