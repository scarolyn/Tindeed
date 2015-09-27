package com.tindeed;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    // api call to bluemix to fill the listview
    private ListView activityList;

    private Button toErrands;
    private Button chores;

    public MainActivityFragment() {
        // Nothing to do here
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        activityList = (ListView)view.findViewById(R.id.listView);
        toErrands = (Button) view.findViewById(R.id.errandsButton);
        toErrands.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ErrandsActivity.class);
                startActivity(intent);
            }
        });
        chores = (Button) view.findViewById(R.id.choresButton);

        new RefreshListTask().execute();


        return view;
    }

    public Context getContext() {
        return getActivity();
    }

    private class RefreshListTask extends AsyncTask<Void, Void, String[]> {

        @Override
        protected String[] doInBackground(Void... params) {
            String[] list = {"I hate you"};
            return list;
        }

        @Override
        protected void onPostExecute(String[] result) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, result);
            activityList.setAdapter(adapter);

        }
    }
}
