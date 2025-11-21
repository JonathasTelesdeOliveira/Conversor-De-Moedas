import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarMoeda {

    private final String KEY = Config.get("APIKEY");

    public Moeda ConsultarMoeda(String base_code) {

        try {
            URI moeda = URI.create("https://v6.exchangerate-api.com/v6/" + KEY + "/latest/" + base_code);

            // );
            // Setting URL
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(moeda)
                    .build();

            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), Moeda.class);

        } catch (Exception e) {
            System.out.println("Erro operacional"+ e.getMessage());
            System.out.println("Finalizando a aplicação!");
        }
        return null;
    }
}




