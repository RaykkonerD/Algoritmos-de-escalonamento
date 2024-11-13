import java.util.ArrayList;
import java.util.List;

public class FilaDeProntos {
    private List<Processo> listaDeProcessos;
    private boolean temPrioridade;
    private int tempoDeTrocaDeContexto;
    private int tamanho;

    public FilaDeProntos(boolean temPrioridade) {
        this.listaDeProcessos = new ArrayList<>();
        this.temPrioridade = temPrioridade;

        //Mock
        this.listaDeProcessos.add(new Processo("P1", 8, 0, 1));
        this.listaDeProcessos.add(new Processo("P2", 12, 2, 1));
        this.listaDeProcessos.add(new Processo("P3", 20, 9, 1));
        this.listaDeProcessos.add(new Processo("P4", 6, 11, 1));
        this.listaDeProcessos.add(new Processo("P5", 14, 12, 1));
//        this.listaDeProcessos.add(new Processo("Chrome", 4, 0, 5));
//        this.listaDeProcessos.add(new Processo("Photoshop", 10, 0, 4));
//        this.listaDeProcessos.add(new Processo("Excel", 3, 0, 3));
//        this.listaDeProcessos.add(new Processo("Discord", 7, 0, 2));
//        this.listaDeProcessos.add(new Processo("Notepad", 1, 0, 8));
//        this.listaDeProcessos.add(new Processo("Visual Studio", 12, 0, 6));
//        this.listaDeProcessos.add(new Processo("Terminal", 2, 0, 7));
//        this.listaDeProcessos.add(new Processo("File Explorer", 6, 0, 1));

    }

    public List<Processo> getListaDeProcessos() {
        return listaDeProcessos;
    }

    public void setListaDeProcessos(List<Processo> listaDeProcessos) {
        this.listaDeProcessos = listaDeProcessos;
    }

    public void addProceesso(Processo processo){
        listaDeProcessos.add(processo);
    }

    public int size(){
        return listaDeProcessos.size();
    }

    public boolean temPrioridade() {
        return temPrioridade;
    }

    public void setTemPrioridade(boolean temPrioridade) {
        this.temPrioridade = temPrioridade;
    }

    public int getTempoDeTrocaDeContexto() {
        return tempoDeTrocaDeContexto;
    }

    public void setTempoDeTrocaDeContexto(int tempoDeTrocaDeContexto) {
        this.tempoDeTrocaDeContexto = tempoDeTrocaDeContexto;
    }
}
