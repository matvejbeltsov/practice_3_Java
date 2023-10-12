package ru.mirea.Beltsov.Films;

import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface MovieApi {
    @GET("https://raw.githubusercontent.com/prust/wikipedia-movie-data/master/movies.json")
    Call<List<Movie>> getMovies();
}
