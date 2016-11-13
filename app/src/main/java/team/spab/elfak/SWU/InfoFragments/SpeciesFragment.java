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
import team.spab.elfak.SWU.swapi.models.Species;
import team.spab.elfak.SWU.swapi.sw.StarWars;
import team.spab.elfak.SWU.swapi.sw.StarWarsApi;


public class SpeciesFragment extends Fragment {
    private static final String ARG_ID = "id";
    private int id;
    private View speciesView;

    public SpeciesFragment() {
        // Required empty public constructor
    }

    public static SpeciesFragment newInstance(int id) {
        SpeciesFragment fragment = new SpeciesFragment();
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
        speciesView = inflater.inflate(R.layout.fragment_species, container, false);

        Species s = APIConstants.speciesList.results.get(id);

        ((TextView) speciesView.findViewById(R.id.species_name)).setText(s.name);
        ((TextView)speciesView.findViewById(R.id.species_average_height)).setText(s.averageHeight);
        ((TextView)speciesView.findViewById(R.id.species_average_lifespan)).setText(s.averageLifespan);
        ((TextView)speciesView.findViewById(R.id.species_classificiation)).setText(s.classification);
        ((TextView)speciesView.findViewById(R.id.species_hair_color)).setText(s.hairColors);
        ((TextView)speciesView.findViewById(R.id.species_eye_color )).setText(s.eyeColors);
        ((TextView)speciesView.findViewById(R.id.species_designation)).setText(s.designation);
        ((TextView)speciesView.findViewById(R.id.species_language)).setText(s.language);
        ((TextView)speciesView.findViewById(R.id.species_skin_colors)).setText(s.skinColors);

        return speciesView;
    }

}
