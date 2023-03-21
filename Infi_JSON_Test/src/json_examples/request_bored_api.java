package json_examples;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;

import com.google.gson.Gson;

public class request_bored_api {

	private static void printOut(Coktail bored) {
		System.out.printf("Possibly you try to %s", bored.activity);
		System.out.println("");
	}
	
	public static void main(String[] args) {
		var client = HttpClient.newHttpClient();
		try {
			var request = HttpRequest
					// Angabe der Server-URL
					.newBuilder(new URI("https://www.boredapi.com/api/activity"))
					// GET zum Abholen von Daten
					// noBody(), dass keine Daten zum Server gesendet werden
					.method("GET", BodyPublishers.noBody())
					.build();
			
			var response = client.send(request, BodyHandlers.ofString());
			
			if (response.statusCode() == 200) {
				
				var gson = new Gson();
				Coktail result = gson.fromJson(response.body(), Coktail.class);
				printOut(result);
				
				
			} else {
				System.out.printf("Anfrage nicht möglich: %d\n", response.statusCode());
			}
			
		} catch (URISyntaxException | IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
