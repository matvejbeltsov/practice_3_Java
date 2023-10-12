package ru.mirea.Beltsov.Films;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {
    private String title;

    private int year;

    private List<String> cast;

    private double rating;

    public String getTitle(){
        return title;
    }

    public int getYear(){
        return year;
    }

    public List<String> getCast(){
        return cast;
    }

    public double getRating(){
        return rating;
    }
}
