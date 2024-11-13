import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Apresentacao {
    public static void execute(List<Processo> listaDeProcessos, int tempoDeTrocaDeContexto) {
        System.out.println("""
                
                ===== Legenda ======
                |:::| => Troca de contexto
                |xxx| => Processador ocioso
                """);

        int tempo = 0;
        int tempoDeOciosidade = 0;
        List<Processo> processosCompletos = new ArrayList<>();
        System.out.print(tempo);

        for (int i = 0; i < listaDeProcessos.size(); i++) {
            Processo processoAtual = listaDeProcessos.get(i);
            if (processoAtual.getTempoDeChegada() > tempo) {
                System.out.print("|xxx|");
                tempoDeOciosidade += processoAtual.getTempoDeChegada() - tempo;
                tempo = processoAtual.getTempoDeChegada();
                System.out.print(tempo);
            }

            if (i > 0) {
                System.out.print("|:::|");
                tempo += tempoDeTrocaDeContexto;
                System.out.print(tempo);
            }

            processoAtual.setTempoDeEspera(tempo - processoAtual.getTempoDeChegada());
            System.out.print("|--- " + processoAtual.getNome() + " ---|");
            tempo += processoAtual.getTempoDeServico();
            System.out.print(tempo);
            processoAtual.setTempoDeRetorno(tempo - processoAtual.getTempoDeChegada());

            if(processosCompletos.stream().anyMatch(p -> p.getNome().equals(processoAtual.getNome()))){
                Processo processoExistente = processosCompletos.stream().filter(p -> Objects.equals(p.getNome(), processoAtual.getNome())).findFirst().get();
                processoExistente.setTempoDeRetorno(tempo - processoExistente.getTempoDeChegada());
            } else {
                processosCompletos.add(processoAtual);
            }
        }

        System.out.println("\n");
        int tme = 0;
        int tmr = 0;
        for (Processo processo : processosCompletos) {
            System.out.println(
                    processo.getNome() +
                    ":   tempo de espera = " + processo.getTempoDeEspera() +
                    "   tempo de retorno = " + processo.getTempoDeRetorno());
            tme += processo.getTempoDeEspera();
            tmr += processo.getTempoDeRetorno();
        }

        tme /= processosCompletos.size();
        tmr /= processosCompletos.size();
        System.out.println("Tempo Médio de Espera: " + tme);
        System.out.println("Tempo Médio de Retorno: " + tmr);
        System.out.println("Tempo de Ociosidade: " + tempoDeOciosidade);
        System.out.println();
    }
}
