package sample.de.mvvmsample.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.net.Uri;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import sample.de.mvvmsample.R;
import sample.de.mvvmsample.model.Twit;

/**
 * Created by dkalinowski on 19.12.16.
 */

public class TwitterRowViewModel extends BaseObservable {

    private Twit twit;

    public TwitterRowViewModel(Twit twit) {
        this.twit = twit;
    }

    public void update(Twit twit) {
        this.twit = twit;
        notifyChange();
    }

    @Bindable
    public String getTitle() {
        return twit.getTitle();
    }

    @Bindable
    public String getContentText() {
        return twit.getContent();
    }

    @Bindable
    public Uri getImageUrl() {
        return twit.getUri();
    }

    @BindingAdapter({"app:imageUrl"})
    public static void loadImage(final ImageView view, Uri imageUrl) {
        Picasso.with(view.getContext()).load(imageUrl).placeholder(R.drawable.placeholder).into(view);
    }
}
