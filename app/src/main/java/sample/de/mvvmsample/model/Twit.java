package sample.de.mvvmsample.model;

import android.net.Uri;

import org.parceler.Parcel;

/**
 * Created by darek on 18.12.16.
 */

@Parcel
public class Twit {

    private String content;
    private String title;
    private String author;
    private Uri uri;

    public Twit() {
    }

    public Twit(String title, String content, String author, Uri uri) {
        this.content = content;
        this.title = title;
        this.author = author;
        this.uri = uri;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }

    public Uri getUri() {
        return uri;
    }
}
