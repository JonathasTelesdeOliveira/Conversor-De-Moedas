import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ConsultarMoeda consultarMoeda = new ConsultarMoeda();

        while (true) {
            System.out.println("Digite o código da MOEDA: (ou 'sair' para encerrar): ");
            String base_code = entrada.nextLine().trim();

            if (base_code.equalsIgnoreCase("sair")){
                System.out.println("Encerramento pipeline de execução.");
                break;
            }

            // Validação de campo crítico
            if (!base_code.matches("^[A-Za-z]{3}$")) {
                System.out.println("Código de moeda inválido. Use o padrão ISO-4217 (ex: USD, BRL, EUR).");
                continue;
            }

            System.out.println("""
                    Escolha a operação:
                    1 - Consultar Moeda");
                    2 - Conversão (indisponível)
                    """);
                int num;
                try {
                    num = Integer.parseInt(entrada.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida!!!");
                    continue;
                }
                switch (num) {
                    case 1:
                        Moeda moeda =
                                consultarMoeda.ConsultarMoeda(base_code);
                        System.out.println(moeda);
                    break;
                    case 2:
                        System.out.println("Opão fora do ar");
                    break;
                    default:
                        throw new IllegalStateException("Invalid day: " + base_code);
                }
        }
    }
}