package sample.de.mvvmsample.twitter;

import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import sample.de.mvvmsample.R;
import sample.de.mvvmsample.SampleModel;
import sample.de.mvvmsample.databinding.TwitterFragmentBinding;

/**
 * Created by darek on 18.12.16.
 */

public class TwitterListFragment extends Fragment{

    public static TwitterListFragment getInstance(){
        return new TwitterListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        TwitterFragmentBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.twitter_fragment, container, false);
        View view = binding.getRoot();

        setAdapter(binding);
        setLayoutManager(binding);

        return view;
    }

    private void setLayoutManager(TwitterFragmentBinding binding) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        binding.tvTwitterList.setLayoutManager(layoutManager);
    }

    private void setAdapter(TwitterFragmentBinding binding) {
        TwitterListAdapter twitterListAdapter = new TwitterListAdapter(new ArrayList<SampleModel>(0), getActivity());
        binding.tvTwitterList.setAdapter(twitterListAdapter);
    }
}
