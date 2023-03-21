package movieDatabase;

import java.util.ArrayList;

public class Movie {
    public String Title;
    public String Year;
    public String Rated;
    public String Released;
    public String Runtime;
    public String Genre;
    public String Director;
    public String Writer;
    public String Actors;
    public String Plot;
    public String Language;
    public String Country;
    public String Awards;
    public String Poster;
    public ArrayList<Rating> ratings;
    public String Metascore;
    public String imbdRating;
    public String imdbVotes;
    public String imdbID;
    public String type;
    public String DVD;
    public String boxOffice;
    public String production;
    public String website;
    public String response;
}

class Rating{
    public String source;
    public String value;
}