

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarMoedaAutomaticamente {
    private final String KEY = Config.get("APIKEY");

    public MoedaPair ConsultarMoedaAutomaticamente(String base_code, String target_code) {
        try {
            URI link = URI.create("https://v6.exchangerate-api.com/v6/" + KEY + "/pair/" + base_code +"/"+ target_code);

            // Criando a requisição
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(link)
                    .GET()
                    .build();
            try {
                // Criando cliente HTTP
                HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

                return new Gson().fromJson(response.body(), MoedaPair.class);
            } catch (Exception e) {
                System.out.println("Erro no client HTTP"+ e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Erro operacional"+ e.getMessage());
            System.out.println("Finalizando a aplicação!");
        }
        return null;
    }
}


