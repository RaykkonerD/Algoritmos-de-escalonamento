import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcao = 0;
        while (opcao != 6) {
            switch (opcao) {
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
        Menu menu = new Menu(false);
        FilaDeProntos filaDeProntos = menu.execute();
        filaDeProntos.getListaDeProcessos().sort((p1, p2) -> Integer.compare(p1.getTempoDeServico(), p2.getTempoDeServico()));

        List<Processo> processosProntos = filaDeProntos.getListaDeProcessos();
        ArrayList<Processo> processosEmOrdemDeExecucao = new ArrayList<>();
        int utCorrent = 0;

        while (!processosProntos.isEmpty()) {
            for (int i = 0; i < processosProntos.size(); i++) {
                if (processosProntos.get(i).getTempoDeChegada() <= utCorrent) {
                    Processo processo = processosProntos.remove(i);
                    processosEmOrdemDeExecucao.add(processo);
                    utCorrent += processo.getTempoDeServico();
                    break;
                }
            }

        }
        Apresentacao.execute(processosEmOrdemDeExecucao, filaDeProntos.getTempoDeTrocaDeContexto());
    }

    private static void rr() {
        Menu menu = new Menu(false);
        FilaDeProntos filaDeProntos = menu.execute();
        filaDeProntos.getListaDeProcessos().sort((p1, p2) -> Integer.compare(p1.getTempoDeChegada(), p2.getTempoDeChegada()));

        Scanner entrada = new Scanner(System.in);
        System.out.print("Fatia de tempo: ");
        int fatiaDeTempo = entrada.nextInt();

        List<Processo> filaDeExecucao = new ArrayList<>();
        int totalDeTempoAExecutar = filaDeProntos.getListaDeProcessos().stream().map(Processo::getTempoDeServico).reduce(Integer::sum).get();
        while (totalDeTempoAExecutar > 0) {
            for (Processo p : filaDeProntos.getListaDeProcessos()) {
                if (p.getTempoDeServico() > 0) {
                    int tempoRodado = Math.min(fatiaDeTempo, p.getTempoDeServico());
                    Processo processoFatiado = new Processo(p.getNome(), tempoRodado, p.getTempoDeChegada());
                    filaDeExecucao.add(processoFatiado);
                    p.setTempoDeServico(p.getTempoDeServico() - tempoRodado);
                    System.out.println(p.getNome() + " " + p.getTempoDeServico());
                }
            }
            totalDeTempoAExecutar = filaDeProntos.getListaDeProcessos().stream().map(Processo::getTempoDeServico).reduce(Integer::sum).get();
        }
        Apresentacao.execute(filaDeExecucao, filaDeProntos.getTempoDeTrocaDeContexto());
    }

    private static void prioridade() {
        Menu menu = new Menu(true);
        FilaDeProntos filaDeProntos = menu.execute();
        List<Processo> listaDeProcessos = filaDeProntos.getListaDeProcessos();
        listaDeProcessos.sort(Comparator.comparingInt(Processo::getTempoDeChegada));
        ordenaPorPrioridade(listaDeProcessos);
        Apresentacao.execute(listaDeProcessos, filaDeProntos.getTempoDeTrocaDeContexto());
    }

    private static void lot() {
        Menu menu = new Menu(false);
        FilaDeProntos filaDeProntos = menu.execute();
        List<Processo> listaDeProcessos = filaDeProntos.getListaDeProcessos();
        listaDeProcessos.sort(Comparator.comparingInt(Processo::getTempoDeChegada));
        
        for(Processo processo : listaDeProcessos){
          Random prioridadeAleatoria = new Random(listaDeProcessos.size());
          processo.setPrioridade(prioridadeAleatoria.nextInt());
        }

        ordenaPorPrioridade(listaDeProcessos);
        Apresentacao.execute(listaDeProcessos, filaDeProntos.getTempoDeTrocaDeContexto());
    }

    private static void ordenaPorPrioridade(List<Processo> listaDeProcessos){
        int utCorrent = 0;

        for (int i = 0; i < listaDeProcessos.size(); ) {
            List<Processo> aExecutarEmSeguida = new ArrayList<>();
            aExecutarEmSeguida.add(listaDeProcessos.get(i));
            int j = i + 1;
            while (j < listaDeProcessos.size() && listaDeProcessos.get(j).getTempoDeChegada() <= utCorrent) {
                aExecutarEmSeguida.add(listaDeProcessos.get(j));
                j++;
            }
            utCorrent += listaDeProcessos.get(i).getTempoDeServico();
            aExecutarEmSeguida.sort(Comparator.comparingInt(Processo::getPrioridade));
            listaDeProcessos.removeAll(aExecutarEmSeguida);
            listaDeProcessos.addAll(i, aExecutarEmSeguida);
            i = j;
        }
    }
}