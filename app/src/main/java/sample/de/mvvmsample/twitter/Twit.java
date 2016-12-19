package sample.de.mvvmsample.twitter;

import org.parceler.Parcel;

/**
 * Created by darek on 18.12.16.
 */

@Parcel
public class Twit {

    private String content;
    private String title;
    private String author;

    public Twit() {
    }

    public Twit(String content, String title, String author) {
        this.content = content;
        this.title = title;
        this.author = author;
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
}
