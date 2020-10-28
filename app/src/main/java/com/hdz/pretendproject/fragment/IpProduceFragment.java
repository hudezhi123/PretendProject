package com.hdz.pretendproject.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hdz.pretendproject.R;
import com.hdz.pretendproject.adapter.IpProduceAdapter;
import com.hdz.pretendproject.data.IpProduce;


/**
 * A simple {@link Fragment} subclass.
 */
public class IpProduceFragment extends Fragment {

    public IpProduceFragment() {
        // Required empty public constructor
    }

    private RecyclerView mListView;
    private IpProduceAdapter mAdapter;
    private LinearLayoutManager mManager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_ip_produce, container, false);
        init(rootView);
        return rootView;
    }

    private void init(View rootView) {
        mManager = new LinearLayoutManager(getContext());
        mAdapter = new IpProduceAdapter(getContext());
        mListView = rootView.findViewById(R.id.recyclerview_ip_produce);
        mListView.setLayoutManager(mManager);
        mListView.setAdapter(mAdapter);
    }

    private void getData(){

    }
}
