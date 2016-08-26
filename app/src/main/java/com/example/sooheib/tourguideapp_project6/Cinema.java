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
public class Cinema extends Fragment {
    ListView list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.cinema, container, false);
        final LocationDetails location_cinemas_data[] = new LocationDetails[]
                {
                        new LocationDetails(getContext().getString(R.string.cinema1Name),
                                getContext().getString(R.string.cinema1Desc)
                                , R.drawable.agora,33.8869, 9.5375),
                        new LocationDetails(getContext().getString(R.string.cinema2Name),
                                getContext().getString(R.string.cinema2Desc) ,
                                R.drawable.theatre, 33.8869, 9.5375)

                };

        list = (ListView) view.findViewById(R.id.list);
        list.setAdapter(new ListViewAdapter(view.getContext(), location_cinemas_data));

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                LocationDetails current = location_cinemas_data[position];
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