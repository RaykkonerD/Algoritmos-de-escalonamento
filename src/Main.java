import java.util.ArrayList;
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
        FilaDeProntos filaDeProntos = menu.execute();
        filaDeProntos.getListaDeProcessos().sort((p1, p2) -> Integer.compare(p1.getTempoDeChegada(), p2.getTempoDeChegada()));
        Apresentacao.execute(filaDeProntos.getListaDeProcessos(), filaDeProntos.getTempoDeTrocaDeContexto());
    }

    private static void sjf() {
    }

    private static void rr() {
        Menu menu = new Menu(false);
        FilaDeProntos filaDeProntos = menu.execute();

        Scanner entrada = new Scanner(System.in);
        System.out.println("\n");
        System.out.print("Fatia de tempo: ");
        int fatiaDeTempo = entrada.nextInt();

        List<Processo> filaDeExecucao = new ArrayList<>();
        int totalDeTempoAExecutar = filaDeProntos.getListaDeProcessos().stream().map(Processo::getTempoDeServico).reduce(Integer::sum).get();
        while (totalDeTempoAExecutar > 0) {
            for(Processo p : filaDeProntos.getListaDeProcessos()) {
                if (p.getTempoDeServico() > 0) {
                    int tempoRodado = Math.min(fatiaDeTempo, p.getTempoDeServico());
                    Processo processoFatiado = new Processo(p.getNome(), tempoRodado);
                    filaDeExecucao.add(processoFatiado);
                    p.setTempoDeServico(p.getTempoDeServico() - tempoRodado);
                    System.out.println(p.getNome() + " " + p.getTempoDeServico());
                }
            }
            totalDeTempoAExecutar = filaDeProntos.getListaDeProcessos().stream().map(Processo::getTempoDeServico).reduce(Integer::sum).get();
        };
        Apresentacao.execute(filaDeExecucao, filaDeProntos.getTempoDeTrocaDeContexto());
    }

    private static void prioridade() {
    }

    private static void lot() {
    }
}