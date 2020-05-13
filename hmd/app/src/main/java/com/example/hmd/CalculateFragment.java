package com.example.hmd;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import java.util.concurrent.Executors;

public class CalculateFragment extends Fragment {


    private MyViewModel viewModel;
    private NavController navController;
    private Switch privacy;
    private ProgressBar progressBar;
    private Boolean progressFinished = false;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(requireActivity()).get(MyViewModel.class);
        View view = inflater.inflate(R.layout.fragment_calculate, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        viewModel.getFinishedCalc().observe(getViewLifecycleOwner(), new Observer<Boolean>() {

            @Override
            public void onChanged(Boolean finished) {
                if (finished) {
                    viewModel.postFinishedCalc(false);
                    navToResults();
                }
            }
        });

        viewModel.getSetChecked().observe(getViewLifecycleOwner(), new Observer<Boolean>() {

            @Override
            public void onChanged(Boolean check) {
                if (check) {
                    setChecked();
                    viewModel.setSetChecked(false);
                }
            }
        });

        privacy = view.findViewById(R.id.switch_privacy);

        progressBar = view.findViewById(R.id.progressBar);

        final Button calcButton = view.findViewById(R.id.button_calculate);

        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setChecked();
                calcButton.setVisibility(View.GONE);
                doProgressBar();
            }
        });
    }

    private void setChecked() {
        privacy.setChecked(true);
        privacy.setSelected(true);
    }


    private void doProgressBar() {
        Executors.newSingleThreadExecutor().execute(progress);
    }

    private Runnable progress = new Runnable() {
        @Override
        public void run() {
            for (int i = 1; i <= 100; i ++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                progressBar.setMax(100);
                progressBar.setProgress(i);

                if (i % 30 == 0) {
                    viewModel.postSetChecked(true);
                }
            }
            viewModel.postFinishedCalc(true);
        }
    };


    private void navToResults() {
        NavDirections action = CalculateFragmentDirections.actionNavCalculateToNavResults();
        navController.navigate(action);
    }
}
