package gestao_academica;

public class FilaEspera {
    public NOFila inicio;
    public NOFila fim;
    protected int tamanho;
    public FilaEspera() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }
    public boolean estaVazia() {
        return this.tamanho == 0;
    }
    public void inserir(Aluno aluno) {
        NOFila novo = new NOFila(aluno);
        if(this.estaVazia()) {
            this.inicio = novo;
            this.fim = novo;
        }else{
            this.fim.setProx(novo);
            this.fim = novo;
        }
        this.tamanho++;
    }
    public Aluno remover() {
        if(this.estaVazia()) {
            return null;
        }
        Aluno removido = this.inicio.getAluno();
        this.inicio = this.inicio.getProx();
        if(this.inicio == null) {
            this.fim = null;
        }
        this.tamanho--;
        return removido;
    }
    public Aluno buscar(int matricula) {
        NOFila atual = this.inicio;
        while(atual != null) {
            if(atual.aluno.getmatricula() == matricula) {
                return atual.getAluno();
            }
            atual = atual.getProx();
        }
        return null;
    }
    public boolean excluirpormatricula(int matricula) {
        NOFila atual = this.inicio;
        NOFila anterior = null;
        while(atual != null) {
            if(atual.aluno.getmatricula() == matricula) {
                if(anterior == null) {
                    this.inicio = this.inicio.getProx();
                    if(this.inicio == null) {
                        this.fim = null;
                    }
                }else{
                    if(atual == this.fim) {
                        this.fim = anterior;
                    }
                }
                this.tamanho--;
                return true;
            }
            anterior = atual;
            atual = atual.getProx();
        }
        return false;
    }
    public void listar() {
        if(this.estaVazia()) {
        System.out.println("Fila de espera vazia.");
        return;
        }
        NOFila atual = this.inicio;
        int pos = 1;
        while(atual != null) {
            System.out.println(pos + ". Matrícula: " + atual.getAluno().getmatricula() + ", Nome: " + atual.getAluno().getNome() );
            atual = atual.getProx();
            pos++;
        }
    }
    public int getTamanho() {
        return this.tamanho;
    }
}
