package sample.de.mvvmsample.twitter;

/**
 * Created by darek on 18.12.16.
 */

public class Twit {

    private final String content;
    private final String title;
    private final String author;

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
