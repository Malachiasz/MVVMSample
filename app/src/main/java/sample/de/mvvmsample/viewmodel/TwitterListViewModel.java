package sample.de.mvvmsample.viewmodel;

import android.app.Activity;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableList;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import org.parceler.Parcel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import sample.de.mvvmsample.R;
import sample.de.mvvmsample.model.Twit;
import sample.de.mvvmsample.platform.TwitterListAdapter;
import sample.de.mvvmsample.service.TwitterService;

/**
 * Created by darek on 18.12.16.
 */

@Parcel(analyze = {ObservableBoolean.class, ObservableField.class, List.class})
public class TwitterListViewModel extends BaseObservable implements TwitterService.TwitsLoader, View.OnClickListener {

    private ObservableBoolean isLoading = new ObservableBoolean();
    private ObservableField<String> lastSynced = new ObservableField<>();
    private ObservableList<Twit> twits = new ObservableArrayList<>();

    private TwitterService twitterService;
    private Activity activity;

    public TwitterListViewModel() {
        lastSynced.set("Never synced");
    }

    public void setTwitterService(TwitterService twitterService) {
        this.twitterService = twitterService;
    }

    public void onAttach(Activity activity) {
        this.activity = activity;
    }

    public void onDetach() {
        this.activity = null;
    }

    private void loadTwits() {
        isLoading.set(true);
        twitterService.requestTwits(this);
    }

    public ObservableBoolean getIsLoading() {
        return isLoading;
    }

    public ObservableField<String> getLastSynced() {
        return lastSynced;
    }

    public ObservableList<Twit> getTwits() {
        return twits;
    }

    @Override
    public void onTwitsLoaded(List<Twit> twits) {
        this.twits.clear();
        this.twits.addAll(twits);
        isLoading.set(false);

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.GERMANY);
        lastSynced.set("Synced: " + dateFormat.format(getDate()));
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLoad:
                loadTwits();
                break;
            default:
                Log.w("loadTwits", "Not supported element clicked");
                break;
        }
    }

    @BindingAdapter("app:items")
    public static void setItems(RecyclerView view, List<Twit> items) {
        RecyclerView.Adapter<?> adapter = view.getAdapter();
        if (adapter instanceof TwitterListAdapter) {
            ((TwitterListAdapter) adapter).updateList(items);
        } else {
            throw new IllegalArgumentException("RecyclerView.Adapter is not TwitterListAdapter");
        }
    }

    //TODO: inject with Dagger
    Date getDate(){
        return new Date();
    }
}
