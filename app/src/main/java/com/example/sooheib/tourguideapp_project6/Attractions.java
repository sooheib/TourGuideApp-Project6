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
public class Attractions extends Fragment {
    ListView list;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.attractions, container, false);
        final LocationDetails location_attractions_data[] = new LocationDetails[]
                {

                        new LocationDetails(getContext().getString(R.string.attractions1Name),
                                getContext().getString(R.string.attractions1Desc)
                                , R.drawable.bardo,33.8869, 9.5375),
                        new LocationDetails(getContext().getString(R.string.attractions2Name),
                                getContext().getString(R.string.attractions2Desc) ,
                                R.drawable.mosquekairouan, 33.8869, 9.5375),
                        new LocationDetails(getContext().getString(R.string.attractions3Name),
                                getContext().getString(R.string.attractions3Desc), R.drawable.ghriba,
                                33.8869, 9.5375),
                        new LocationDetails(getContext().getString(R.string.attractions1Name),
                                getContext().getString(R.string.attractions1Desc), R.drawable.bardo,
                                33.8869, 9.5375),
                        new LocationDetails(getContext().getString(R.string.attractions1Name),
                                getContext().getString(R.string.attractions4Desc), R.drawable.jem,
                                33.8869, 9.5375)
                };

        list = (ListView) view.findViewById(R.id.list);
        list.setAdapter(new ListViewAdapter(view.getContext(), location_attractions_data));

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                LocationDetails current = location_attractions_data[position];
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