package ru.mirea.Beltsov.Films;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public interface MovieApi {
    @GET("https://raw.githubusercontent.com/prust/wikipedia-movie-data/master/movies.json")
    Call<List<Movie>> getMovies();
}
