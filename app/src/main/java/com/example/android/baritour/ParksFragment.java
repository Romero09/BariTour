package com.example.android.baritour;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ParksFragment extends Fragment {


    public ParksFragment() {
        // Required empty public constructor
    }

    //Array tah contains information about tourism objects
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(com.example.android.baritour.R.layout.information_list, container, false);

        final ArrayList<Information> info = new ArrayList<Information>();
        info.add(new Information(getString(R.string.name_lido_rena), getString(R.string.address_lido_rena), getString(R.string.description_lido_rena), com.example.android.baritour.R.drawable.lido_rena));
        info.add(new Information(getString(R.string.name_giugno), getString(R.string.address_giugno), getString(R.string.description_giugno), com.example.android.baritour.R.drawable.parco_giugno));
        info.add(new Information(getString(R.string.name_pane), getString(R.string.address_pane), getString(R.string.description_pane), com.example.android.baritour.R.drawable.pane_pomodoro));
        info.add(new Information(getString(R.string.name_tonino), getString(R.string.address_tonino), getString(R.string.description_tonino), com.example.android.baritour.R.drawable.parco_tonino_bello));


        InformationAdapter adapter = new InformationAdapter(getActivity(), info);

        ListView infoListView = (ListView) rootView.findViewById(com.example.android.baritour.R.id.info_list);

        infoListView.setAdapter(adapter);

        // listening to single list item on click
        infoListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                //storing objects for intent
                Information object = info.get(position);
                String name = object.getName();
                String adress = object.getAdress();
                String description = object.getDescription();
                int picture = object.getPictureId();
                int stars = object.getStars();


                // Launching new Activity on selecting single List Item
                Intent i = new Intent(getActivity(), DetailedActivity.class);
                // sending data to DetailedActivity activity
                i.putExtra("name", name)
                        .putExtra("adress", adress)
                        .putExtra("description", description)
                        .putExtra("picture", picture)
                        .putExtra("stars", stars);
                startActivity(i);

            }
        });


        return rootView;
    }

}
