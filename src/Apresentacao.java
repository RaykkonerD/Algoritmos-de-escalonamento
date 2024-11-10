import java.util.List;

public class Apresentacao {
    public static void execute(List<Processo> listaDeProcessos, int tempoDeTrocaDeContexto) {
        System.out.println("""
                
                ===== Legenda ======
                |---| => Troca de contexto
                |xxx| => Processador ocioso
                """);

        int tempo = 0;
        System.out.print(tempo);

        for (int i = 0; i < listaDeProcessos.size(); i++) {
            Processo processoAtual = listaDeProcessos.get(i);
            if (processoAtual.getTempoDeChegada() > tempo) {
                System.out.print("|xxx|");
                tempo = processoAtual.getTempoDeChegada();
                System.out.print(tempo);
            }

            if (i > 0) {
                System.out.print("|---|");
                tempo += tempoDeTrocaDeContexto;
                System.out.print(tempo);
            }

            System.out.print("|--- " + processoAtual.getNome() + " ---|");
            tempo += processoAtual.getTempoDeServico();
            System.out.print(tempo);
        }

        System.out.println("\n");
    }
}
