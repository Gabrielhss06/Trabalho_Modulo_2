import service.ComandoService;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo ao Text Adventure Game!");
        System.out.println("Digite 'help' para ver os comandos disponíveis.");

        while (true) {
            System.out.print("> ");  // Prompt para o jogador inserir o comando
            String comando = scanner.nextLine();

            try {
                // Processa o comando inserido pelo jogador
                ComandoService comandoService = new ComandoService(comando);
                comandoService.processarComando();
            } catch (SQLException e) {
                System.out.println("Erro ao processar o comando: " + e.getMessage());
            }

            // Condição de saída do jogo
            if (comando.equalsIgnoreCase("exit")) {
                System.out.println("Saindo do jogo...");
                break;
            }
        }
        scanner.close();
    }
}
