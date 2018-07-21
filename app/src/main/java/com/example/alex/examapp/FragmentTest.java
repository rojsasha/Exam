package com.example.alex.examapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FragmentTest extends Fragment implements View.OnClickListener {
    private TextView mTextView;
    private EditText mEditText;
    private Button btnFragment;
    private String casheText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test, container, false);

        mTextView = view.findViewById(R.id.textViewFragment);
        mEditText = view.findViewById(R.id.etInputFragment);
        btnFragment = view.findViewById(R.id.btnFragment);

        btnFragment.setOnClickListener(this);

        mEditText.addTextChangedListener(mTextWatcher);

        setRetainInstance(true);

        return view;
    }

    TextWatcher mTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            mTextView.setText(editable.toString());
            casheText = editable.toString();
        }
    };

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        intent.setAction("ShowActivity");
        intent.putExtra("text", casheText);
        startActivity(intent);

    }
}
