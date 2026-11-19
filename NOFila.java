package gestao_academica;

public class NOFila {
    protected Aluno aluno;
    protected NOFila prox;
    public NOFila(Aluno aluno) {
        this.aluno = aluno;
        this.prox = null;
    }
    public Aluno getAluno() {
        return this.aluno;
    }
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    public NOFila getProx() {
        return this.prox;
    }
    public void setProx(NOFila prox) {
        this.prox = prox;
    }
}
