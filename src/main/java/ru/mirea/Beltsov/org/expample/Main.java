package ru.mirea.Beltsov.org.expample;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import ru.mirea.Beltsov.Films.Movie;
import ru.mirea.Beltsov.Films.MovieApi;

import java.io.IOException;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Main {
    public static void main(String[] args) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/prust/wikipedia-movie-data/master/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        MovieApi movieApi = retrofit.create(MovieApi.class);


        Call<List<Movie>> call = movieApi.getMovies();

        Response<List<Movie>> response = call.execute();
        if (response.isSuccessful()) {
            List<Movie> movies = response.body();


            Movie maxActorsMovie = null;
            int maxActors = 0;

            for (Movie movie : movies) {
                if (movie.getYear() != 0 && movie.getYear() < 2000 && movie.getCast() != null) {
                    int actorsCount = movie.getCast().size();
                    if (actorsCount > maxActors) {
                        maxActors = actorsCount;
                        maxActorsMovie = movie;
                    }
                }
            }

            if (maxActorsMovie != null) {
                System.out.println("Фильм: " + maxActorsMovie.getTitle());
                System.out.println("Год выпуска: " + maxActorsMovie.getYear());
                System.out.println("Количество актеров: " + maxActors);
                System.out.println("Актерский состав: " + maxActorsMovie.getCast());
            } else {
                System.out.println("Не удалось найти подходящий фильм.");
            }
        } else {
            System.out.println("Ошибка: " + response.code());
        }
    }
}
