package gestao_academica;

public class NOAluno {
    protected Aluno aluno;
    protected NOAluno prox;

    public NOAluno(Aluno aluno) {
        this.aluno = aluno;
        this.prox = null;
    }

    public Aluno getAluno() {
        return this.aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public NOAluno getProx() {
        return this.prox;
    }

    public void setProx(NOAluno prox) {
        this.prox = prox;
    }
}

