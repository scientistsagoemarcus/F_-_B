package com.example.fb.side_drawer.save;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.fb.R;

public class SaveFragment extends Fragment {

    private SaveViewModel saveViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        saveViewModel =
                new ViewModelProvider(this).get(SaveViewModel.class);
        View root = inflater.inflate(R.layout.fragment_save, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        saveViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}