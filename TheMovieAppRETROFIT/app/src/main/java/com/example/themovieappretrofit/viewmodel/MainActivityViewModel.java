package com.example.themovieappretrofit.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.themovieappretrofit.model.Movie;
import com.example.themovieappretrofit.model.MovieRepository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    //ViewModel : suitable for non-android specific logic
    //AndroidViewModel : used when viewModel class needs android specific components
    private MovieRepository movieRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.movieRepository = new MovieRepository(application);
    }
    //LiveData
    public LiveData<List<Movie>> getAllMovies(){
        return movieRepository.getMutableLiveData();
    }
}
