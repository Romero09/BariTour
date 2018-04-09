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
public class RestaurantsFragment extends Fragment {


    public RestaurantsFragment() {
        // Required empty public constructor
    }

    //Array tah contains information about tourism objects
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(com.example.android.baritour.R.layout.information_list, container, false);

        final ArrayList<Information> info = new ArrayList<Information>();
        info.add(new Information(getString(R.string.name_gola), getString(R.string.address_gola), getString(R.string.description_gola), com.example.android.baritour.R.drawable.gola_gourmet, 5));
        info.add(new Information(getString(R.string.name_santa_rita), getString(R.string.address_santa_rita), getString(R.string.description_santa_rita), com.example.android.baritour.R.drawable.santa_rita, 4));
        info.add(new Information(getString(R.string.name_ciccio), getString(R.string.address_ciccio), getString(R.string.description_ciccio), com.example.android.baritour.R.drawable.mastro_ciccio, 4));
        info.add(new Information(getString(R.string.name_fiore), getString(R.string.address_fiore), getString(R.string.description_fiore), com.example.android.baritour.R.drawable.panificio_fiore, 4));


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
