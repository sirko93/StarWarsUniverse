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
import team.spab.elfak.SWU.swapi.models.Vehicle;
import team.spab.elfak.SWU.swapi.sw.StarWars;
import team.spab.elfak.SWU.swapi.sw.StarWarsApi;

public class VehicleFragment extends Fragment {
    private static final String ARG_ID = "id";
    private int id;
    private View vehicleView;


    public VehicleFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static VehicleFragment newInstance(int id) {
        VehicleFragment fragment = new VehicleFragment();
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
        vehicleView = inflater.inflate(R.layout.fragment_vehicle, container, false);

        Vehicle v= APIConstants.vehicleList.results.get(id);

        ((TextView) vehicleView.findViewById(R.id.vehicles_name)).setText(v.name);
        ((TextView)vehicleView.findViewById(R.id.vehicles_cargo_capacity)).setText(v.cargoCapacity);
        ((TextView)vehicleView.findViewById(R.id.vehicles_cost_in_credits)).setText(v.costInCredits);
        ((TextView)vehicleView.findViewById(R.id.vehicles_crew)).setText(v.crew);
        ((TextView)vehicleView.findViewById(R.id.vehicles_length)).setText(v.length);
        ((TextView)vehicleView.findViewById(R.id.vehicles_manufacturer)).setText(v.manufacturer);
        ((TextView)vehicleView.findViewById(R.id.vehicles_max_atmosphering_speed)).setText(v.maxAtmospheringSpeed);
        ((TextView)vehicleView.findViewById(R.id.vehicles_model)).setText(v.model);
        ((TextView)vehicleView.findViewById(R.id.vehicles_passengers)).setText(v.passengers);
        ((TextView)vehicleView.findViewById(R.id.vehicles_vehicles_class)).setText(v.vehicleClass);


        return vehicleView;
    }

}
