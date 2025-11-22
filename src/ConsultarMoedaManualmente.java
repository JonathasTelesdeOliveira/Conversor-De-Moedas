import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class ConsultarMoedaManualmente {
    private final String KEY = Config.get("APIKEY");
    public Moeda ConsultarMoeda(String base_code) {
        try {
            URI url = URI.create("https://v6.exchangerate-api.com/v6/" + KEY + "/latest/" + base_code);

            HttpClient cliente = HttpClient.newHttpClient();

            // Criando a requisição
            HttpRequest requisicao = HttpRequest.newBuilder()
                    .uri(url)
                    .GET()
                    .build();
            try {
                // Enviando requisição e recebendo resposta
                HttpResponse<String> resposta = cliente.send(requisicao, HttpResponse.BodyHandlers.ofString());

                JsonObject root = JsonParser.parseString(resposta.body()).getAsJsonObject();

                String result = root.get("result").getAsString();
                String base = root.get("base_code").getAsString();

                // pega todas as moedas
                JsonObject Maps = root.getAsJsonObject("conversion_rates");

                Map<String, Double> listaMap = new HashMap<>();

                String[] moedasSelecionadas = {"USD", "ARS", "BOB", "BRL", "CLP", "COP"};
                for (String codigo : moedasSelecionadas) {
                    if (Maps.has(codigo)) {
                        listaMap.put(codigo, Maps.get(codigo).getAsDouble());
                    }
                }
                // imprime só as 6 moedas pedidas
                System.out.println("==== 6 Moedas Selecionadas ====");
                listaMap.forEach((sigla, taxa) -> System.out.println(sigla + " → " + taxa));


                // retorna o record preenchido 6 MOEDAS
                return new Moeda(result, base, null, null, listaMap);

                // retorna o record preenchido inteiro
                //return new Gson().fromJson(root, Moeda.class);

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

