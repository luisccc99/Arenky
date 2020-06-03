package com.example.arenky.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.arenky.QueryToMain;
import com.example.arenky.R;

public class HotelsFragment extends Fragment {

    private EditText txtQuery;
    private Button btnGetSuggestions;
    private String query;
    private QueryToMain queryToMain;

    public HotelsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hotels, container, false);
        txtQuery = view.findViewById(R.id.txt_query);
        btnGetSuggestions = view.findViewById(R.id.btn_search_suggestions);

        btnGetSuggestions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (queryToMain != null) {
                    query = txtQuery.getText() + "";
                    queryToMain.setQuery(query);
                }
            }
        });
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof QueryToMain) {
            queryToMain = (QueryToMain) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        queryToMain = null;
    }
}
