package com.wenthkim.blogs.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wenthkim.blogs.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShopCarFragment extends Fragment {


    public ShopCarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shop_car, container, false);
    }

}
