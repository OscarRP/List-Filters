package com.ruizpatricio.oscar.filters;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String yearSelected;
    private String genreSelected;

    private SeriesAdapter seriesAdapter;

    private ArrayList<Serie> series;
    private ArrayList<Serie> filteredSeries;

    private Serie serie;

    private ListView listView;

    private Spinner genreSpinner, yearSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getViews();
        setInfo();
        setListeners();
    }

    //Method to get views
    private void getViews() {
        listView = (ListView)findViewById(R.id.listview);
        genreSpinner = (Spinner)findViewById(R.id.genre_spinner);
        yearSpinner = (Spinner)findViewById(R.id.year_spinner);
    }

    // Method to set listeners
    private void setListeners() {
        //on genre selected listener
        genreSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //get genre and year selected
                genreSelected = parent.getSelectedItem().toString();
                yearSelected = yearSpinner.getSelectedItem().toString();
                showFiltered(genreSelected, yearSelected);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        //on year selected listener
        yearSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //get genre and year selected
                yearSelected = parent.getSelectedItem().toString();
                genreSelected = genreSpinner.getSelectedItem().toString();
                showFiltered(genreSelected, yearSelected);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    //Method to show selected series
    private void showFiltered(String genre, String year) {

        //initialize array
        filteredSeries = new ArrayList<>();

        for (int i=0; i<series.size(); i++) {

            if (genreOk(genre, series.get(i)) && yearOk(year, series.get(i))) {
                filteredSeries.add(series.get(i));
            }
        }

        seriesAdapter = new SeriesAdapter(filteredSeries, this);
        listView.setAdapter(seriesAdapter);
    }

    // Method to check if year selected equals year of the serie
    private boolean yearOk(String year, Serie serie) {
        boolean isYearOk = false;
        if (String.valueOf(serie.getYear()).equals(year) || year.equals("Todos")) {
            isYearOk = true;
        }
        return isYearOk;
    }

    // Method to check if genre selected equals genre of the serie
    private boolean genreOk(String genre, Serie serie) {
        boolean isOk = false;
        if (serie.getGenre().equals(genre) || genre.equals("Todos")) {
            isOk = true;
        }
        return isOk;
    }

    // Method to set info in listview and spinners
    private void setInfo() {

        // List View info
        series = new ArrayList<>();

        serie = new Serie("Los 100", 2014, Constants.ACTION);
        series.add(serie);
        serie = new Serie("Silicon Valley", 2012, Constants.COMEDY);
        series.add(serie);
        serie = new Serie("Vikings", 2013, Constants.ACTION);
        series.add(serie);
        serie = new Serie("American Horror Story", 2012, Constants.TERROR);
        series.add(serie);
        serie = new Serie("Los Simpson", 1999, Constants.COMEDY);
        series.add(serie);
        serie = new Serie("Dexter", 2011, Constants.DRAMA);
        series.add(serie);
        serie = new Serie("Breaking Bad", 2010, Constants.DRAMA);
        series.add(serie);
        serie = new Serie("Family Guy", 2014, Constants.COMEDY);
        series.add(serie);

        seriesAdapter = new SeriesAdapter(series, this);
        listView.setAdapter(seriesAdapter);

        // Spinners info
        ArrayAdapter genreAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Constants.GENRES);
        genreSpinner.setAdapter(genreAdapter);
        ArrayAdapter yearAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Constants.YEARS);
        yearSpinner.setAdapter(yearAdapter);

    }
}
