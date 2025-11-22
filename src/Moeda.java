import java.util.Map;

public record Moeda(String result,
                    String base_code,
                    String target_code,
                    Map<String, Double> conversion_rates, Map<String, Double> listaMap) {
}
