package sample.de.mvvmsample.platform;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import sample.de.mvvmsample.BR;
import sample.de.mvvmsample.R;
import sample.de.mvvmsample.databinding.TwitterRowBinding;
import sample.de.mvvmsample.model.Twit;
import sample.de.mvvmsample.viewmodel.TwitterRowViewModel;

/**
 * Created by dkalinowski on 23.11.16.
 */

public class TwitterListAdapter extends RecyclerView.Adapter<TwitterListAdapter.TwitterRowViewHolder> {

    private final Context context;
    private final List<TwitterRowViewModel> twitterRows = new ArrayList();

    public TwitterListAdapter(Context context) {
        this.context = context;
    }

    public void updateList(List<Twit> twits) {
        twitterRows.clear();
        for (Twit twit : twits) {
            twitterRows.add(new TwitterRowViewModel(twit));
        }
        notifyDataSetChanged();
    }

    @Override
    public TwitterRowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        TwitterRowBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.twitter_row, parent, false);
        return new TwitterRowViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(TwitterRowViewHolder holder, int position) {
        TwitterRowViewModel twitterRowViewModel = twitterRows.get(position);
        holder.getBinding().setVariable(BR.viewModel, twitterRowViewModel);
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return twitterRows.size();
    }


    public static class TwitterRowViewHolder extends RecyclerView.ViewHolder {

        private TwitterRowBinding binding;

        public TwitterRowViewHolder(TwitterRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public TwitterRowBinding getBinding() {
            return binding;
        }
    }
}
