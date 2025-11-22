import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("=== Conversor de Moedas ===");
        System.out.println("Bem-vindo ao conversor de MOEDAS!!!!!!!!!!!\n");

        String opcao = "";
        while (!opcao.equalsIgnoreCase("sair")) {
            System.out.println("Painel de opções:");
            System.out.println("1 - Converter moedas");
            System.out.println("Digite 'sair' para encerrar");
            System.out.print("Escolha: ");
            opcao = entrada.nextLine().trim();

            if (opcao.equalsIgnoreCase("sair")) {
                System.out.println("Encerrando o programa...");
                break;
            }
            if (opcao.equals("1")) {
                System.out.println("Digite o valor da Conversão: ");
                Double valor = entrada.nextDouble();
                entrada.nextLine(); // consumir quebra de linha

                System.out.println("Moeda De Origem (ex: USD, BRL, ARS): ");
                String base_code = entrada.nextLine().trim();

                System.out.println("Moeda De Destino (ex: USD, BRL, ARS): ");
                String target_code = entrada.nextLine().trim();

                if (base_code.equalsIgnoreCase("sair") | target_code.equalsIgnoreCase("sair")) {
                    System.out.println("Encerramento pipeline de execução." + base_code + " , " + target_code);
                    return;
                }
                // Validação
                if (!base_code.matches("^[A-Za-z]{3}$") | !target_code.matches("^[A-Za-z]{3}$")) {
                    System.out.println("Código de moeda inválido. Use o padrão ISO-4217 (ex: USD, BRL, EUR)." + base_code + " , " + target_code);
                }

                try {
                   ConsultarMoedaManualmente consultarMoedas = new ConsultarMoedaManualmente();
                    Moeda moeda = consultarMoedas.ConsultarMoeda(base_code);

                    GeradorArquivo geradorArquivo = new GeradorArquivo();
                    geradorArquivo.salvaJson(moeda,"resultado_"+ base_code + "para_"+ target_code);

                    //converter
                    Map<String, Double> taxas = moeda.listaMap();
                    double resultado = consultarMoedas.Converter(valor, base_code, target_code, taxas);

                    // CONVERSÃO AUTOMÁTICA
                    ConsultarMoedaAutomaticamente consultarMoedaAutomaticamente = new ConsultarMoedaAutomaticamente();
                    MoedaPair moedaPair = consultarMoedaAutomaticamente.ConsultarMoedaAutomaticamente(base_code, target_code);

                    ResultadoDaConversao resultadoDaConversao = new ResultadoDaConversao(
                            base_code,
                            target_code,
                            valor,
                            moedaPair.conversion_rate(),
                            resultado);
                    GeradorArquivo geradorArquivoConversao = new GeradorArquivo();
                    geradorArquivoConversao.salvaJson(resultadoDaConversao, "resultado_"+ base_code + "para_"+ target_code);

                    if (moedaPair == null) {
                        System.out.println("Falha ao consultar API. Pipeline encerrado.");
                        return;
                    }
                    System.out.println("\n_______________________________________________________________________________________\n");
                    System.out.printf("Moeda Base: %s %.2f", base_code, valor);
                    System.out.printf("\nMoeda Destino: %s%n", target_code);
                    System.out.printf("Taxa de conversão: %.4f%n", moedaPair.conversion_rate());
                    System.out.printf("Conversão realizada: %.2f %s = %.2f %s%n",
                            valor, base_code, resultado, target_code);
                    System.out.println("\n_______________________________________________________________________________________\n");
                } catch (Exception e) {
                    System.out.println("Errror::::" + e.getMessage());
                }
            } else {
                System.out.println("Opção inválida, tente novamente.");
            }
        }
        entrada.close();
    }
}
