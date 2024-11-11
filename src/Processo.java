public class Processo {
    private String nome;
    private int tempoDeServico;
    private int tempoDeChegada;
    private int prioridade;
    private int tempoDeEspera;
    private int tempoDeRetorno;

    public Processo(String nome, int tempoDeServico, int tempoDeChegada, int prioridade) {
        this.nome = nome;
        this.tempoDeServico = tempoDeServico;
        this.tempoDeChegada = tempoDeChegada;
        this.prioridade = prioridade;
        this.tempoDeEspera = tempoDeChegada;
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

    public int getTempoDeEspera() {
        return tempoDeEspera;
    }

    public void setTempoDeEspera(int tempoDeEspera) {
        this.tempoDeEspera = tempoDeEspera;
    }

    public int getTempoDeRetorno() {
        return tempoDeRetorno;
    }

    public void setTempoDeRetorno(int tempoDeRetorno) {
        this.tempoDeRetorno = tempoDeRetorno;
    }
}
