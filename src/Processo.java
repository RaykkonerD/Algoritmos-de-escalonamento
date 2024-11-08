public class Processo {
    private String nome;
    private int tempoDeServico;
    private int tempoDeChegada;
    private int prioridade;
    private int tempoDeInicio;

    public Processo(String nome, int tempoDeServico, int tempoDeChegada, int prioridade) {
        this.nome = nome;
        this.tempoDeServico = tempoDeServico;
        this.tempoDeChegada = tempoDeChegada;
        this.prioridade = prioridade;
        this.tempoDeInicio = tempoDeChegada;
    }

    public Processo(String nome, int tempoDeServico) {
        this.nome = nome;
        this.tempoDeServico = tempoDeServico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTempoDeServico() {
        return tempoDeServico;
    }

    public void setTempoDeServico(int tempoDeServico) {
        this.tempoDeServico = tempoDeServico;
    }

    public int getTempoDeChegada() {
        return tempoDeChegada;
    }

    public void setTempoDeChegada(int tempoDeChegada) {
        this.tempoDeChegada = tempoDeChegada;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public int getTempoDeInicio() {
        return tempoDeInicio;
    }

    public void setTempoDeInicio(int tempoDeInicio) {
        this.tempoDeInicio = tempoDeInicio;
    }
}
