package sample.de.mvvmsample.service;

import android.net.Uri;
import android.support.annotation.WorkerThread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import sample.de.mvvmsample.model.Twit;


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
            String author = randomWord(5);
            Uri uri = Uri.parse("https://dummyimage.com/200x200/000/fff&text=" + author);
            String content = randomWord(155);
            twits.add(new Twit("lorem ipsum title", content, author, uri));
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return twits;
    }


    private static String randomWord(int length) {
        Random random = new Random();
        StringBuilder word = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            word.append((char)('a' + random.nextInt(26)));
        }

        return word.toString();
    }

    public interface TwitsLoader {
        void onTwitsLoaded(List<Twit> twits);
    }
}
