package team.spab.elfak.SWU.InfoFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import team.spab.elfak.SWU.R;
import team.spab.elfak.SWU.swapi.APIConstants;
import team.spab.elfak.SWU.swapi.models.People;
import team.spab.elfak.SWU.swapi.models.Planet;
import team.spab.elfak.SWU.swapi.sw.StarWars;
import team.spab.elfak.SWU.swapi.sw.StarWarsApi;


public class PlanetsFragment extends Fragment {
    private static final String ARG_ID = "id";
    private int id;
    private View planetView;

    public PlanetsFragment() {
        // Required empty public constructor
    }

    public static PlanetsFragment newInstance(int id) {
        PlanetsFragment fragment = new PlanetsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_ID, id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            id = getArguments().getInt(ARG_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        planetView =  inflater.inflate(R.layout.fragment_planets, container, false);

        Planet p= APIConstants.planetList.results.get(id);

        ((TextView) planetView.findViewById(R.id.planets_name)).setText(p.name);
        ((TextView)planetView.findViewById(R.id.planets_climate)).setText(p.climate);
        ((TextView)planetView.findViewById(R.id.planets_diameter)).setText(p.diameter);
        ((TextView)planetView.findViewById(R.id.planets_gravity)).setText(p.gravity);
        ((TextView)planetView.findViewById(R.id.planets_orbital_period)).setText(p.orbitalPeriod);
        ((TextView)planetView.findViewById(R.id.planets_population)).setText(p.population);
        ((TextView)planetView.findViewById(R.id.planets_rotation_period)).setText(p.rotationPeriod);
        ((TextView)planetView.findViewById(R.id.planets_surface_water)).setText(p.surfaceWater);
        ((TextView)planetView.findViewById(R.id.planets_terrain)).setText(p.terrain);


        return planetView;
    }

}
