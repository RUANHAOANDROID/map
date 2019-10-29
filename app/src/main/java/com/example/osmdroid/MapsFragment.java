package com.example.osmdroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import com.example.osmdroid.basic.MapActivity;
import com.example.osmdroid.wms.WmsActivity;

import java.util.Arrays;

/**
 * Date: 2019-10-29
 * Author: 锅得铁
 * #
 */
public class MapsFragment extends ListFragment {
    final static String[] map = {
            "basic",
            "wms"
    };

    private ArrayAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, Arrays.asList(map));
        setListAdapter(adapter);
        return view;
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        String item = getListView().getItemAtPosition(position).toString();
        if (item.equals(map[0])) {
            start(MapActivity.class);
        }
        if (item.equals(map[1])) {
            start(WmsActivity.class);
        }
    }

    void start(Class clazz) {
        Intent intent = new Intent(getActivity(), clazz);
        getActivity().startActivity(intent);
    }
}
