package com.example.hmd;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

public class ColorFragment extends Fragment {

    private MyViewModel viewModel;
    private NavController navController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(requireActivity()).get(MyViewModel.class);
        View view = inflater.inflate(R.layout.fragment_color, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);


        view.findViewById(R.id.button_blue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.setColor(ContextCompat.getColor(requireContext(), R.color.blue));
                navToWord();
            }
        });

        view.findViewById(R.id.button_green).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.setColor(ContextCompat.getColor(requireContext(), R.color.green));
                navToWord();
            }
        });

        view.findViewById(R.id.button_orange).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.setColor(ContextCompat.getColor(requireContext(), R.color.orange));
                navToWord();
            }
        });

        view.findViewById(R.id.button_pink).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.setColor(ContextCompat.getColor(requireContext(), R.color.pink));
                navToWord();
            }
        });

        view.findViewById(R.id.button_purple).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.setColor(ContextCompat.getColor(requireContext(), R.color.purple));
                navToWord();
            }
        });

        view.findViewById(R.id.button_yellow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.setColor(ContextCompat.getColor(requireContext(), R.color.yellow));
                navToWord();
            }
        });
    }

    private void navToWord() {
        NavDirections action = ColorFragmentDirections.actionNavColorToNavWord();
        navController.navigate(action);
    }
}
