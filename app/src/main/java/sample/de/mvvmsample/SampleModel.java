package sample.de.mvvmsample;

/**
 * Created by dkalinowski on 23.11.16.
 */

public class SampleModel {

    public String title;
    public int number;
    public String buttonTitle;

    public SampleModel(String buttonTitle, int number, String title) {
        this.buttonTitle = buttonTitle;
        this.number = number;
        this.title = title;
    }

    public String getFormattedTitle() {
        return "@" + title + "@";
    }
}
