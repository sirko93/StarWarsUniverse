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
import team.spab.elfak.SWU.swapi.sw.StarWars;
import team.spab.elfak.SWU.swapi.sw.StarWarsApi;


public class PeopleFragment extends Fragment {
    private static final String ARG_ID = "id";
    private int id;
    private View peopleView;

    public PeopleFragment() {
        // Required empty public constructor
    }

    public static PeopleFragment newInstance (int id) {
        PeopleFragment fragment = new PeopleFragment();
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
        // Inflate the layout for this fragment
        peopleView = inflater.inflate(R.layout.fragment_people, container, false);

        People p= APIConstants.peopleList.results.get(id);

        ((TextView) peopleView.findViewById(R.id.people_name)).setText(p.name);
        ((TextView)peopleView.findViewById(R.id.people_birth_year)).setText(p.birthYear);
        ((TextView)peopleView.findViewById(R.id.people_gender)).setText(p.gender);
        ((TextView)peopleView.findViewById(R.id.people_height)).setText(p.height);
        ((TextView)peopleView.findViewById(R.id.people_mass)).setText(p.mass);
        ((TextView)peopleView.findViewById(R.id.people_hair_color)).setText(p.hairColor);
        ((TextView)peopleView.findViewById(R.id.people_skin_color)).setText(p.skinColor);
        ((TextView)peopleView.findViewById(R.id.people_eye_color)).setText(p.eyeColor);

        return peopleView;
    }


}
