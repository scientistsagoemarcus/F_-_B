package com.example.fb.side_drawer.reviews;

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

public class ReviewsFragment extends Fragment {

    private ReviewsViewModel reviewsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        reviewsViewModel =
                new ViewModelProvider(this).get(ReviewsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_reviews, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        reviewsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}