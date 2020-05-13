package com.example.hmd;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

public class ResultsFragment extends Fragment {
    private MyViewModel viewModel;
    private NavController navController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(requireActivity()).get(MyViewModel.class);
        View view = inflater.inflate(R.layout.fragment_results, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        view.findViewById(R.id.button_results).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navToCelebrate();
            }
        });

    }

    private void navToCelebrate() {
        NavDirections action = ResultsFragmentDirections.actionNavResultsToNavCelebrate();
        navController.navigate(action);
    }
}
