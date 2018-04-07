package com.example.android.rigatour;


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


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.information_list, container, false);

        final ArrayList<Information> info = new ArrayList<Information>();
        info.add(new Information("Raddison Blue", "Elizabetes iela 55, Rīga", "blankDescription", R.mipmap.ic_launcher));
        info.add(new Information("Raddison Blue", "Elizabetes iela 55, Rīga", "blankDescription", R.mipmap.ic_launcher));
        info.add(new Information("Raddison Blue", "Elizabetes iela 55, Rīga", "blankDescription", R.mipmap.ic_launcher));
        info.add(new Information("Raddison Blue", "Elizabetes iela 55, Rīga", "blankDescription", R.mipmap.ic_launcher));


        InformationAdapter adapter = new InformationAdapter(getActivity(), info);

        ListView infoListView = (ListView) rootView.findViewById(R.id.info_list);

        infoListView.setAdapter(adapter);

        // listening to single list item on click
        infoListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Information object = info.get(position);
                String name = object.getName();
                String adress = object.getAdress();
                String description = object.getDescription();
                int picture = object.getPictureId();



                // Launching new Activity on selecting single List Item
                Intent i = new Intent(getActivity(), DetailedFragment.class);
                // sending data to new activity
                i.putExtra("name", name).putExtra("adress", adress).putExtra("description", description).putExtra("picture", picture);
                startActivity(i);

            }
        });


        return rootView;
    }

}
