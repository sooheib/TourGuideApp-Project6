package com.example.sooheib.tourguideapp_project6;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by sooheib on 8/26/16.
 */
public class Restaurant extends Fragment {
    ListView list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.restaurant, container, false);
        final LocationDetails location_restoran_data[] = new LocationDetails[]
                {

                        new LocationDetails(getContext().getString(R.string.restoran1Name),
                                getContext().getString(R.string.restoran1Desc)
                                , R.drawable.le_carpe_diem,14.5234, 12.3123),
                        new LocationDetails(getContext().getString(R.string.restoran2Name),
                                getContext().getString(R.string.restoran2Desc) ,
                                R.drawable.dareljeld, 14.5234, 12.3123)

                };

        list = (ListView) view.findViewById(R.id.list);
        list.setAdapter(new ListViewAdapter(view.getContext(), location_restoran_data));

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                LocationDetails current = location_restoran_data[position];
//                    Toast.makeText(view.getContext(), "Wait..." , Toast.LENGTH_SHORT).show();
                Intent details = new Intent(getActivity(),LocationFullDisplay.class);
                details.putExtra("locationName" , current.getLocationName());
                details.putExtra("locationDesc",current.getLocationDesc());
                details.putExtra("locationLON", current.getLon());
                details.putExtra("locationLAT", current.getLat());
                details.putExtra("locationIcon", current.getLocationIcon());
                startActivity(details);
            }
        });
        return view;
    }
}