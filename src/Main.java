import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcao = 0;
        while (opcao != 6) {
            switch (opcao){
                case 1:
                    fifo();
                    break;
                case 2:
                    sjf();
                    break;
                case 3:
                    rr();
                    break;
                case 4:
                    prioridade();
                    break;
                case 5:
                    lot();
                    break;
            }

            System.out.println("""
                    ====== JROS ======
                    1 - FIFO
                    2 - Shortest Job First (SJF)
                    3 - Round Robin
                    4 - Prioridade
                    5 - Loteria (LOT)
                    6 - Sair
                    """);
            System.out.print("Opção: ");
            opcao = entrada.nextInt();
        }
        entrada.close();
    }

    private static void fifo() {
        Menu menu = new Menu(false);
        FilaDeProntos listaDeProcessos = menu.execute();
        Apresentacao.execute(listaDeProcessos.getListaDeProcessos(), listaDeProcessos.getTempoDeTrocaDeContexto());
    }

    private static void sjf() {
    }

    private static void rr() {
    }

    private static void prioridade() {
    }

    private static void lot() {
    }
}