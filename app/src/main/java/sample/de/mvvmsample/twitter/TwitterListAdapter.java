package sample.de.mvvmsample.twitter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import sample.de.mvvmsample.R;
import sample.de.mvvmsample.SampleModel;
import sample.de.mvvmsample.databinding.TwitterRowBinding;

/**
 * Created by dkalinowski on 23.11.16.
 */

public class TwitterListAdapter extends RecyclerView.Adapter<TwitterRowHolder> {

    private final List<SampleModel> sampleModelList;
    private final Context context;

    public TwitterListAdapter(List<SampleModel> sampleModelList, Context context) {
        this.sampleModelList = sampleModelList;
        this.context = context;
    }

    @Override
    public TwitterRowHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        TwitterRowBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.twitter_row, parent, false);
        return new TwitterRowHolder(binding);
    }

    @Override
    public void onBindViewHolder(TwitterRowHolder holder, int position) {
//        SampleModel sampleModel = sampleModelList.get(position);
//        holder.getBinding().setVariable(BR.sampleModel, sampleModel);
//        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return sampleModelList.size();
    }
}
