package sample.de.mvvmsample;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import sample.de.mvvmsample.databinding.SampleRowBinding;


/**
 * Created by dkalinowski on 23.11.16.
 */

public class SampleRowHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private SampleRowBinding binding;

    public SampleRowHolder(SampleRowBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
        binding.setHolder(this);
        binding.textView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(view.getContext(), "Clicked a button", Toast.LENGTH_LONG).show();
    }

    public SampleRowBinding getBinding() {
        return binding;
    }
}
