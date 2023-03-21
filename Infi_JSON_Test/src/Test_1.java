import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

import com.google.gson.Gson;

public class Test_1 {


    private static void printOut (Bored bored){
        //System.out.println("Possibly you try to %s", bored.activity);
    }


    public static void main(String[] args) {
        var client = HttpClient.newHttpClient();

        try {        //U need the try bc of the new URI bild will throw in an exception so u need a try catch bc every exception needs a try/catch
            // prepare the request
            var request = HttpRequest
                    .newBuilder(new URI("https://www.boredapi.com/api/activity"))     //URI from our test URI
                    //GET zum Holen der Daten
                    // noBody(), das keine Daten zum Server gesendet werden
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();

            
            var response = client.send(request,BodyHandlers.ofString());

            if (response.statusCode() == 200){


                var gson = new Gson();
                gson.fromJson(response.body(), Bored.class);
                //printOut();
            }
            else {
                System.out.print("Anfrage nicht möglich: ");
                System.out.println(response.statusCode());
            }

            System.out.println("Test");

        } catch (URISyntaxException | InterruptedException | IOException e) {
            e.printStackTrace();
        }


    }


}
