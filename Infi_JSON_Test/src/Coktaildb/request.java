package Coktaildb;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.invoke.ConstantCallSite;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class request {

    public static void main(String[] args) {

        var client = HttpClient.newHttpClient();
        try {
            var request = HttpRequest
                    // Angabe der Server-URL
                    .newBuilder(new URI("https://www.thecocktaildb.com/api/json/v1/1/random.php"))
                    // GET zum Abholen von Daten
                    // noBody(), dass keine Daten zum Server gesendet werden
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();

            var response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {

                var gson = new Gson();
                Drinks result = gson.fromJson(response.body(), Drinks.class);
                //Root result = gson.fromJson(response.body(), Root.class);
                printOut(result);


            } else {
                System.out.printf("Anfrage nicht möglich: %d\n", response.statusCode());
            }

        } catch (URISyntaxException | IOException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    private static void printOut(Drinks coktail) {
        System.out.printf("Possibly you try out %s", coktail.drinks);
        System.out.println("");
    }
/*
    private static void printOut(Root root) {
        System.out.printf("Possibly you try out %s", root.toString());
        System.out.println("");
    }

 */


}
