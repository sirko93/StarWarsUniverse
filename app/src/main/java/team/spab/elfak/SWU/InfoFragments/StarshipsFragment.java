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
import team.spab.elfak.SWU.swapi.models.Starship;
import team.spab.elfak.SWU.swapi.sw.StarWars;
import team.spab.elfak.SWU.swapi.sw.StarWarsApi;


public class StarshipsFragment extends Fragment {
    private static final String ARG_ID = "id";
    private int id;
    private View starshipsView;


    public StarshipsFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static StarshipsFragment newInstance(int id) {
        StarshipsFragment fragment = new StarshipsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_ID,id);
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
        starshipsView = inflater.inflate(R.layout.fragment_starships, container, false);

        Starship s = APIConstants.starshipList.results.get(id);

        ((TextView) starshipsView.findViewById(R.id.starships_name)).setText(s.name);
        ((TextView)starshipsView.findViewById(R.id.starships_MGLT)).setText(s.mglt);
        ((TextView)starshipsView.findViewById(R.id.starships_cargo_capacity)).setText(s.cargoCapacity);
        ((TextView)starshipsView.findViewById(R.id.starships_cost_in_credits)).setText(s.costInCredits);
        ((TextView)starshipsView.findViewById(R.id.starships_crew)).setText(s.crew);
        ((TextView)starshipsView.findViewById(R.id.starships_hyperdrive_rating)).setText(s.hyperdriveRating);
        ((TextView)starshipsView.findViewById(R.id.starships_length)).setText(s.length);
        ((TextView)starshipsView.findViewById(R.id.starships_manufacturer)).setText(s.manufacturer);
        ((TextView)starshipsView.findViewById(R.id.starships_max_atmosphering_speed)).setText(s.maxAtmospheringSpeed);
        ((TextView)starshipsView.findViewById(R.id.starships_model)).setText(s.model);
        ((TextView)starshipsView.findViewById(R.id.starships_passengers)).setText(s.passengers);
        ((TextView)starshipsView.findViewById(R.id.starships_starship_class)).setText(s.starshipClass);

        return starshipsView;
    }

}
