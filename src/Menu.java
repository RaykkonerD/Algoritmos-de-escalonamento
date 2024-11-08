import java.util.Scanner;

public class Menu {
    private FilaDeProntos filaDeProntos;
    private Scanner entrada = new Scanner(System.in);

    public Menu(boolean temPrioridade){
        this.filaDeProntos = new FilaDeProntos(temPrioridade);
    }

    public FilaDeProntos execute() {
        System.out.println();
        System.out.println("====== Fila incial de processos ======");
        if (!filaDeProntos.getListaDeProcessos().isEmpty()) {
            System.out.print("Processos: ");
            for (Processo processo : filaDeProntos.getListaDeProcessos()) {
                System.out.print(processo.getNome() + " ");
            }
            System.out.println();
        }

        System.out.println("1 - Adiciionar processo");
        System.out.println("2 - Sair");
        System.out.print("Opção: ");
        int opcao = entrada.nextInt();
        if (opcao != 1) {
            System.out.print("Tempo de troca de contexto: ");
            int tempoDeTrocaDeContexto = entrada.nextInt();
            filaDeProntos.setTempoDeTrocaDeContexto(tempoDeTrocaDeContexto);
            return filaDeProntos;
        }

        System.out.println();
        System.out.println("====== Novo processo ======");
        System.out.print("Nome do processo: ");
        String nome = entrada.nextLine();
        nome = entrada.nextLine();
        System.out.print("Tempo de serviço: ");
        int tempoDeServico = entrada.nextInt();
        System.out.print("Tempo de chegada: ");
        int tempoDeChegada = entrada.nextInt();
        int prioridade = 1;
        if(filaDeProntos.temPrioridade()) {
            System.out.print("Prioridade: ");
            prioridade = entrada.nextInt();
        }

        filaDeProntos.addProceesso(new Processo(nome, tempoDeServico, tempoDeChegada, prioridade));
        return execute();
    }
}
