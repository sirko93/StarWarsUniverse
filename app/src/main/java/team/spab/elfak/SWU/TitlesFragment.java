package team.spab.elfak.SWU;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.*;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import team.spab.elfak.SWU.InfoFragments.*;
import team.spab.elfak.SWU.swapi.APIConstants;
import team.spab.elfak.SWU.swapi.models.*;
import team.spab.elfak.SWU.swapi.sw.StarWars;
import team.spab.elfak.SWU.swapi.sw.StarWarsApi;
import team.spab.elfak.SWU.swapi.utils.SWUtils;

public class TitlesFragment extends ListFragment implements AdapterView.OnItemClickListener {
    private static final String ARG_ID = "id";
    private static final String CURRENT_PAGE = "current";
    private static int previous =-1;
    private static int next=-1;
    StarWars sw;

    private int id;
    private int current;
    private View listView;
    public ArrayList<String> list;
    private ArrayAdapter<String> adapter;
    private Timer timer;

    private Button bPrevious;
    private Button bNext;



    public TitlesFragment() {
        // Required empty public constructor
}

    public static TitlesFragment newInstance(int id, int page) {
        TitlesFragment fragment = new TitlesFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_ID,id);
        args.putInt(CURRENT_PAGE,page);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            id = getArguments().getInt(ARG_ID);
            current = getArguments().getInt(CURRENT_PAGE);
        }
    }

    private void checkVisibility()
    {
        if(previous!=-1)
            bPrevious.setVisibility(View.VISIBLE);
        else
            bPrevious.setVisibility(View.INVISIBLE);
        if(next!=-1)
            bNext.setVisibility(View.VISIBLE);
        else
            bNext.setVisibility(View.INVISIBLE);
    }



    private Callback<SWModelList<Film>> allFilmsCallback = new Callback<SWModelList<Film>>() {
        @Override
        public void success(SWModelList<Film> filmSWModelList, Response response) {
            APIConstants.filmList=filmSWModelList;
            int numOfFilms = filmSWModelList.count;
            for(int i = 0; i< numOfFilms; i++)
                list.add(filmSWModelList.results.get(i).title);
            previous= SWUtils.pageUrlToNumber(filmSWModelList.previous);
            next=SWUtils.pageUrlToNumber(filmSWModelList.next);
            checkVisibility();
            adapter.notifyDataSetChanged();
        }

        @Override
        public void failure(RetrofitError error) {
            Snackbar.make(getView(),"Could not load list",Snackbar.LENGTH_INDEFINITE).setAction("RETRY", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TitlesFragment titlesFragment = TitlesFragment.newInstance(id,current);
                    FragmentManager manager = getFragmentManager();
                    manager.beginTransaction().replace(R.id.content_main, titlesFragment).commit();
                }
            }).show();
        }
    };

    private Callback<SWModelList<People>> allPeopleCallback = new Callback<SWModelList<People>>() {
        @Override
        public void success(SWModelList<People> peopleSWModelList, Response response) {
            APIConstants.peopleList=peopleSWModelList;
            int numOfPeople = peopleSWModelList.results.size();
            for(int i = 0; i< numOfPeople; i++)
                list.add(peopleSWModelList.results.get(i).name);
            previous= SWUtils.pageUrlToNumber(peopleSWModelList.previous);
            next=SWUtils.pageUrlToNumber(peopleSWModelList.next);
            checkVisibility();

            adapter.notifyDataSetChanged();
        }

        @Override
        public void failure(RetrofitError error) {
            Snackbar.make(getView(),"Could not load list",Snackbar.LENGTH_INDEFINITE).setAction("RETRY", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TitlesFragment titlesFragment = TitlesFragment.newInstance(id,current);
                    FragmentManager manager = getFragmentManager();
                    manager.beginTransaction().replace(R.id.content_main, titlesFragment).commit();
                }
            }).show();
        }
    };

    private Callback<SWModelList<Planet>> allPlanetsCallback = new Callback<SWModelList<Planet>>() {
        @Override
        public void success(SWModelList<Planet> planetSWModelList, Response response) {
            APIConstants.planetList=planetSWModelList;
            int numOfPlanets = planetSWModelList.results.size();
            for(int i = 0; i< numOfPlanets; i++)
                list.add(planetSWModelList.results.get(i).name);
            previous= SWUtils.pageUrlToNumber(planetSWModelList.previous);
            next=SWUtils.pageUrlToNumber(planetSWModelList.next);
            checkVisibility();

            adapter.notifyDataSetChanged();
        }

        @Override
        public void failure(RetrofitError error) {
            Snackbar.make(getView(),"Could not load list",Snackbar.LENGTH_INDEFINITE).setAction("RETRY", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TitlesFragment titlesFragment = TitlesFragment.newInstance(id,current);
                    FragmentManager manager = getFragmentManager();
                    manager.beginTransaction().replace(R.id.content_main, titlesFragment).commit();
                }
            }).show();
        }
    };

    private Callback<SWModelList<Starship>> allStarshipsCallback = new Callback<SWModelList<Starship>>() {
        @Override
        public void success(SWModelList<Starship> starshipSWModelList, Response response) {
            APIConstants.starshipList=starshipSWModelList;
            int numOfStarships = starshipSWModelList.results.size();
            for(int i = 0; i< numOfStarships; i++)
                list.add(starshipSWModelList.results.get(i).name);
            previous= SWUtils.pageUrlToNumber(starshipSWModelList.previous);
            next=SWUtils.pageUrlToNumber(starshipSWModelList.next);
            checkVisibility();

            adapter.notifyDataSetChanged();
        }

        @Override
        public void failure(RetrofitError error) {
            Snackbar.make(getView(),"Could not load list",Snackbar.LENGTH_INDEFINITE).setAction("RETRY", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TitlesFragment titlesFragment = TitlesFragment.newInstance(id,current);
                    FragmentManager manager = getFragmentManager();
                    manager.beginTransaction().replace(R.id.content_main, titlesFragment).commit();
                }
            }).show();
                //Toast.makeText(getContext(),"NECE",Toast.LENGTH_SHORT).show();
        }
    };

    private Callback<SWModelList<Vehicle>> allVehiclesCallback = new Callback<SWModelList<Vehicle>>() {
        @Override
        public void success(SWModelList<Vehicle> vehicleSWModelList, Response response) {
            APIConstants.vehicleList=vehicleSWModelList;
            int numOfVehicles = vehicleSWModelList.results.size();
            for(int i = 0; i< numOfVehicles; i++)
                list.add(vehicleSWModelList.results.get(i).name);
            previous= SWUtils.pageUrlToNumber(vehicleSWModelList.previous);
            next=SWUtils.pageUrlToNumber(vehicleSWModelList.next);
            checkVisibility();

            adapter.notifyDataSetChanged();
        }

        @Override
        public void failure(RetrofitError error) {
            Snackbar.make(getView(),"Could not load list",Snackbar.LENGTH_INDEFINITE).setAction("RETRY", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TitlesFragment titlesFragment = TitlesFragment.newInstance(id,current);
                    FragmentManager manager = getFragmentManager();
                    manager.beginTransaction().replace(R.id.content_main, titlesFragment).commit();
                }
            }).show();
        }
    };

    private Callback<SWModelList<Species>> allSpeciesCallback = new Callback<SWModelList<Species>>() {
        @Override
        public void success(SWModelList<Species> speciesSWModelList, Response response) {
            APIConstants.speciesList=speciesSWModelList;
            int numOfSpecies = speciesSWModelList.results.size();
            for(int i = 0; i< numOfSpecies; i++)
                list.add(speciesSWModelList.results.get(i).name);
            previous= SWUtils.pageUrlToNumber(speciesSWModelList.previous);
            next=SWUtils.pageUrlToNumber(speciesSWModelList.next);
            checkVisibility();

            adapter.notifyDataSetChanged();
        }

        @Override
        public void failure(RetrofitError error) {
            Snackbar.make(getView(),"Could not load list",Snackbar.LENGTH_INDEFINITE).setAction("RETRY", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TitlesFragment titlesFragment = TitlesFragment.newInstance(id,current);
                    FragmentManager manager = getFragmentManager();
                    manager.beginTransaction().replace(R.id.content_main, titlesFragment).commit();
                }
            }).show();
        }
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        listView = inflater.inflate(R.layout.fragment_list, container, false);
        StarWarsApi.init();
        sw = StarWarsApi.getApi();
        list = new ArrayList<String>();
        adapter=new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1,
                list);
        ((ListView) listView.findViewById(android.R.id.list)).setAdapter(adapter);

        final EditText searchBar = (EditText) listView.findViewById(R.id.list_search);

        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (timer != null) {
                    timer.cancel();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

                if(s.toString().length()>1) {
                    timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            String s = searchBar.getText().toString();
                            list.clear();

                            switch (id) {
                                case R.id.nav_films:
                                    sw.searchFilms(s.toString(), allFilmsCallback);
                                    break;
                                case R.id.nav_people:
                                    sw.searchPeople(s.toString(), allPeopleCallback);
                                    break;
                                case R.id.nav_planets:
                                    sw.searchPlanets(s.toString(), allPlanetsCallback);
                                    break;
                                case R.id.nav_species:
                                    sw.searchSpecies(s.toString(), allSpeciesCallback);
                                    break;
                                case R.id.nav_starships:
                                    sw.searchStarships(s.toString(), allStarshipsCallback);
                                    break;
                                case R.id.nav_vehicle:
                                    sw.searchVehicles(s.toString(), allVehiclesCallback);
                                    break;
                            }
                        }
                    }, 300);
                    bNext.setVisibility(View.INVISIBLE);
                    bPrevious.setVisibility(View.INVISIBLE);
                }
                else {
                    if(s.toString().length()==0) {
                        TitlesFragment titlesFragment = TitlesFragment.newInstance(id, current);
                        FragmentManager manager = getFragmentManager();
                        manager.beginTransaction().replace(R.id.content_main, titlesFragment).commit();
                    }
                }
            }
        });

        bPrevious= (Button) listView.findViewById(R.id.button_previous);
        bNext= (Button) listView.findViewById(R.id.button_next);
        if(previous==-1)
            bPrevious.setVisibility(View.INVISIBLE);
        if(next==-1)
            bNext.setVisibility(View.INVISIBLE);
        bPrevious.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TitlesFragment titlesFragment = TitlesFragment.newInstance(id,previous);
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.content_main, titlesFragment).commit();
            }
        });
        bNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TitlesFragment titlesFragment = TitlesFragment.newInstance(id,next);
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.content_main, titlesFragment).commit();
            }
        });

        switch (id) {
            case R.id.nav_films:
                sw.getAllFilms(current, allFilmsCallback);
                break;
            case R.id.nav_people:
                sw.getAllPeople(current, allPeopleCallback);
                break;
            case R.id.nav_planets:
                sw.getAllPlanets(current, allPlanetsCallback);
                break;
            case R.id.nav_species:
                sw.getAllSpecies(current,allSpeciesCallback);
                break;
            case R.id.nav_starships:
                sw.getAllStarships(current,allStarshipsCallback);
                break;
            case R.id.nav_vehicle:
                sw.getAllVehicles(current,allVehiclesCallback);
                break;
        }
		return listView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        FragmentManager manager = getFragmentManager();
        switch (this.id) {
            case R.id.nav_films:
                FilmsFragment filmFragment = FilmsFragment.newInstance(position);
                manager.beginTransaction().replace(R.id.content_main, filmFragment).addToBackStack(null).commit();
                break;
            case R.id.nav_people:
                PeopleFragment peopleFragment = PeopleFragment.newInstance(position);
                manager.beginTransaction().replace(R.id.content_main, peopleFragment).addToBackStack(null).commit();
                break;
            case R.id.nav_planets:
                PlanetsFragment planetFragment = PlanetsFragment.newInstance(position);
                manager.beginTransaction().replace(R.id.content_main, planetFragment).addToBackStack(null).commit();
                break;
            case R.id.nav_species:
                SpeciesFragment speciesFragment = SpeciesFragment.newInstance(position);
                manager.beginTransaction().replace(R.id.content_main, speciesFragment).addToBackStack(null).commit();
                break;
            case R.id.nav_starships:
                StarshipsFragment starshipsFragment = StarshipsFragment.newInstance(position);
                manager.beginTransaction().replace(R.id.content_main, starshipsFragment).addToBackStack(null).commit();
                break;
            case R.id.nav_vehicle:
                VehicleFragment vehicleFragment = VehicleFragment.newInstance(position);
                manager.beginTransaction().replace(R.id.content_main, vehicleFragment).addToBackStack(null).commit();
                break;
        }
    }
}
