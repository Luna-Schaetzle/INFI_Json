package movieDatabase;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;

import com.google.gson.Gson;

public class jsonExampless {

    private static void printOut(Movie movie) {
        System.out.printf("The name of the movie is:  %s", movie.Title);
    }

    public static void main(String[] args) {
        var client = HttpClient.newHttpClient();

        try {
            var request = HttpRequest
                    // ANGABE URL
                    .newBuilder(new URI("http://www.omdbapi.com/?apikey=831561c6&t="
                            + "0"
                            + ""))
                    // Abholen von Daten % noBody(), das keine Daten gesendet werden
                    //Wie soll die URL aufgerufen werden
                    .method("GET", BodyPublishers.noBody())
                    .build(); //Request wird erzeugt

            try {

                var response = client.send(request, BodyHandlers.ofString()); //Antwort vom Server

                if(response.statusCode() == 200) {

                    var gson = new Gson();
                    Movie  result = gson.fromJson(response.body(), Movie.class);
                    printOut(result);

                } else {
                    System.out.println("Anfrage nicht möglich");
                }

            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}