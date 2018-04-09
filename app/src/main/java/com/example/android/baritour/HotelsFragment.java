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
public class HotelsFragment extends Fragment {


    public HotelsFragment() {
        // Required empty public constructor
    }

    //Array tah contains information about tourism objects
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(com.example.android.baritour.R.layout.information_list, container, false);

        final ArrayList<Information> info = new ArrayList<Information>();
        info.add(new Information(getString(R.string.name_vittoria), getString(R.string.address_vittoria), getString(R.string.description_vittoria), com.example.android.baritour.R.drawable.vittoria_parc_hotel, 5));
        info.add(new Information(getString(R.string.name_mercure), getString(R.string.address_mercure), getString(R.string.description_mercure), com.example.android.baritour.R.drawable.mercure_villa, 5));
        info.add(new Information(getString(R.string.name_hi_hotel), getString(R.string.address_hi_hotel), getString(R.string.description_hi_hotel), com.example.android.baritour.R.drawable.hi_hotel_bari, 4));
        info.add(new Information(getString(R.string.name_rondo), getString(R.string.address_rondo), getString(R.string.description_rondo), com.example.android.baritour.R.drawable.rondo_hotel, 3));
        info.add(new Information(getString(R.string.name_residence_moderno), getString(R.string.address_residence_moderno), getString(R.string.description_residence_moderno), com.example.android.baritour.R.drawable.residence_moderno, 2));


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
