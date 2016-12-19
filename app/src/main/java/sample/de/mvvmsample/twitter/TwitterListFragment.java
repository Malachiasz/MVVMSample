package sample.de.mvvmsample.twitter;

import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.parceler.Parcels;

import sample.de.mvvmsample.BR;
import sample.de.mvvmsample.R;
import sample.de.mvvmsample.databinding.TwitterFragmentBinding;

/**
 * Created by darek on 18.12.16.
 */

public class TwitterListFragment extends Fragment{

    public static TwitterListFragment getInstance(){
        return new TwitterListFragment();
    }

    private static final String VIEW_MODEL_INSTANCE_STATE = "VIEW_MODEL_INSTANCE_STATE";
    private TwitterListViewModel twitterListViewModel = new TwitterListViewModel();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        TwitterFragmentBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.twitter_fragment, container, false);

        if (savedInstanceState != null) {
            twitterListViewModel = Parcels.unwrap(savedInstanceState.getParcelable(VIEW_MODEL_INSTANCE_STATE));
        }
        twitterListViewModel.onAttach(getActivity());
        twitterListViewModel.setTwitterService(new TwitterService());

        View view = binding.getRoot();
        binding.setVariable(BR.viewModel, twitterListViewModel);
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
        TwitterListAdapter twitterListAdapter = new TwitterListAdapter(getActivity());
        binding.tvTwitterList.setAdapter(twitterListAdapter);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelable(VIEW_MODEL_INSTANCE_STATE, Parcels.wrap(twitterListViewModel));
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onDetach() {
        twitterListViewModel.onDetach();
        super.onDetach();
    }
}
