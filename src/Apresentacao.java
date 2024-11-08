import java.util.List;

public class Apresentacao {
    public static void execute(List<Processo> listaDeProcessos, int tempoDeTrocaDeContexto) {
        System.out.println();
        int tempo = listaDeProcessos.get(0).getTempoDeInicio();
        System.out.print(tempo);
        for (int i = 0; i < listaDeProcessos.size(); i++) {
            System.out.print("|--- " + listaDeProcessos.get(i).getNome() + " ---|");
            tempo += listaDeProcessos.get(i).getTempoDeServico();
            System.out.print(tempo);
            if (i < listaDeProcessos.size() - 1) {
                System.out.print("|---|");
                tempo += tempoDeTrocaDeContexto;
                System.out.print(tempo);
            }
        }

        System.out.println();
        System.out.println();
    }
}
