package com.example.hmd;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

public class WelcomeFragment extends Fragment {
    private MyViewModel viewModel;
    private NavController navController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(requireActivity()).get(MyViewModel.class);
        View view = inflater.inflate(R.layout.fragment_welcome, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        Button button = view.findViewById(R.id.button_not_round);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navToColor();
            }
        });

        Button button2 = view.findViewById(R.id.button_round);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navToColor();
            }
        });

        Button button3 = view.findViewById(R.id.button_round_numbers);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navToColor();
            }
        });


    }

    private void navToColor() {
        NavDirections action = WelcomeFragmentDirections.actionNavWelcomeToNavColor();
        navController.navigate(action);
    }

}
