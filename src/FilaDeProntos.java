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
