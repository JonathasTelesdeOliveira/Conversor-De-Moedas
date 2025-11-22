import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Bem vindo ao conversor de MOEDAS!!!!!!!!!!!\n");
        System.out.println("Convert USD para BRL");

        entrada.nextLine();
        System.out.println("\nMoeda De Origem: ");
        System.out.println("De: ");
        String base_code = entrada.nextLine().trim();

        if (base_code.equalsIgnoreCase("sair")) {
            System.out.println("Encerramento pipeline de execução.");
            return;
        }
        // Validação
        if (!base_code.matches("^[A-Za-z]{3}$")) {
            System.out.println("Código de moeda inválido. Use o padrão ISO-4217 (ex: USD, BRL, EUR)."+ base_code);
        }
        try {
            /*      *************************************************           */

            ConsultarMoedaManualmente consultarMoedas = new ConsultarMoedaManualmente();
            Moeda moeda = consultarMoedas.ConsultarMoeda(base_code);

            GeradorArquivo geradorArquivo = new GeradorArquivo();
            geradorArquivo.salvaJson(moeda);
        } catch (Exception e) {
            System.out.println("Errror::::" + e.getMessage());
        }
    }
}