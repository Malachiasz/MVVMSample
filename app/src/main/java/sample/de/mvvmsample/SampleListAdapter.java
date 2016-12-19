package sample.de.mvvmsample;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import sample.de.mvvmsample.databinding.SampleRowBinding;

/**
 * Created by dkalinowski on 23.11.16.
 */

public class SampleListAdapter extends RecyclerView.Adapter<SampleRowHolder> {

    private final List<SampleModel> sampleModelList;
    private final Context context;

    public SampleListAdapter(List<SampleModel> sampleModelList, Context context) {
        this.sampleModelList = sampleModelList;
        this.context = context;
    }

    @Override
    public SampleRowHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        SampleRowBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.sample_row, parent, false);
        return new SampleRowHolder(binding);
    }

    @Override
    public void onBindViewHolder(SampleRowHolder holder, int position) {
        SampleModel sampleModel = sampleModelList.get(position);
        holder.setId(position);
        holder.getBinding().setVariable(sample.de.mvvmsample.BR.sampleModel, sampleModel);
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return sampleModelList.size();
    }
}
