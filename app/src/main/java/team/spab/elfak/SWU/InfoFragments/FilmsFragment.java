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
import team.spab.elfak.SWU.swapi.models.Film;
import team.spab.elfak.SWU.swapi.sw.StarWars;
import team.spab.elfak.SWU.swapi.sw.StarWarsApi;

public class FilmsFragment extends Fragment {
    private static final String ARG_ID = "id";
    private int id;
    private View filmView;


    public FilmsFragment() {
        // Required empty public constructor
    }

    public static FilmsFragment newInstance(int id) {
        FilmsFragment fragment = new FilmsFragment();
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
        filmView = inflater.inflate(R.layout.fragment_films, container, false);

        Film f= APIConstants.filmList.results.get(id);

        ((TextView) filmView.findViewById(R.id.films_title)).setText(f.title);
        ((TextView)filmView.findViewById(R.id.films_director)).setText(f.director);
        ((TextView)filmView.findViewById(R.id.films_opening_crawl)).setText(f.openingCrawl);
        ((TextView)filmView.findViewById(R.id.films_producer)).setText(f.producer);
        ((TextView)filmView.findViewById(R.id.films_release_date)).setText(f.releaseDate);

        return filmView;
    }

}
