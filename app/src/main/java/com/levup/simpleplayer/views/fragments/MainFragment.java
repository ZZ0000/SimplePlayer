package com.levup.simpleplayer.views.fragments;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.levup.simpleplayer.R;
import com.levup.simpleplayer.views.MenuActivityListner;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private MenuActivityListner mListener = null;

    public static final String SOME_VALUE = "SOME_VALUE";

    public static MainFragment newInstance(int value) {

        Bundle args = new Bundle();
        args.putInt(SOME_VALUE, value);

        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public void showText(CharSequence text){

        if(getView() == null) return;
        final TextView textView = (TextView) getView().findViewById(R.id.tv);
        textView.setText(text);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof MenuActivityListner){
            mListener = (MenuActivityListner) activity;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.btn).setOnClickListener(btn->{
            final int value = getArguments().getInt(SOME_VALUE);
            mListener.onMainFragmentEventListner(value);
        });

        //Toast.makeText(getActivity(), ""+getArguments().getInt(SOME_VALUE),Toast.LENGTH_SHORT).show();
        getArguments().getInt(SOME_VALUE);

    }
}
