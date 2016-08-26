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
public class Shopping extends Fragment {
    ListView list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.shopping, container, false);
        final LocationDetails location_shopping_data[] = new LocationDetails[]
                {

                        new LocationDetails(getContext().getString(R.string.shopping1Name),
                                getContext().getString(R.string.shopping1Desc)
                                , R.drawable.tunisia_mall,14.5234, 12.3123),
                        new LocationDetails(getContext().getString(R.string.shopping2Name),
                                getContext().getString(R.string.shopping2Desc) ,
                                R.drawable.carrefour_tunisie, 14.5234, 12.3123),
                        new LocationDetails(getContext().getString(R.string.shopping3Name),
                                getContext().getString(R.string.shopping3Desc), R.drawable.geant,
                                14.5234, 12.3123)
                };


        list = (ListView) view.findViewById(R.id.list);
        list.setAdapter(new ListViewAdapter(view.getContext(), location_shopping_data));

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                LocationDetails current = location_shopping_data[position];
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