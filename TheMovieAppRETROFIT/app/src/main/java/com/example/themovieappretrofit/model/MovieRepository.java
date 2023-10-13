package com.example.themovieappretrofit.model;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.example.themovieappretrofit.R;
import com.example.themovieappretrofit.serviceapi.MovieApiService;
import com.example.themovieappretrofit.serviceapi.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {
    private ArrayList<Movie> movies = new ArrayList<>();
    private MutableLiveData<List<Movie>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public MovieRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Movie>> getMutableLiveData() {
        MovieApiService movieApiService = RetrofitInstance.getService();
        Call<Result> call = movieApiService.getPopularMovies(application.getApplicationContext().getString(R.string.api_key));
        //enqueue() method - asynchronous method, handles the request in the background
        //thread and handles the response in the main UI thread
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Result result = response.body();
                if(result!=null && result.getResults()!=null){
                    movies = (ArrayList<Movie>) result.getResults();
                    mutableLiveData.setValue(movies);
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }
        });
        return mutableLiveData;
    }
}
