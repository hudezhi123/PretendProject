package com.hdz.pretendproject.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hdz.pretendproject.R;
import com.hdz.pretendproject.adapter.IpGetAdapter;



/**
 * A simple {@link Fragment} subclass.
 */
public class IpGetFragment extends Fragment {

    public IpGetFragment() {
        // Required empty public constructor
    }

    private RecyclerView mListView;
    private IpGetAdapter mAdapter;
    private LinearLayoutManager mManager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_ip_get, container, false);
        init(rootView);
        return rootView;
    }

    private void init(View rootView) {
        mManager = new LinearLayoutManager(getContext());
        mAdapter = new IpGetAdapter(getContext());
        mListView = rootView.findViewById(R.id.recyclerview_ip_get);
        mListView.setLayoutManager(mManager);
        mListView.setAdapter(mAdapter);
    }

    private void getData(){

    }

}
