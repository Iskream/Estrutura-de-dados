package gestao_academica;

public class ListaAluno {

    protected NOAluno inicio;
    protected int tamanho;

    public ListaAluno() {
        this.inicio = null;
        this.tamanho = 0;
    }

    public boolean estaVazia() {
        return this.inicio == null;
    }

    public boolean inserir(Aluno aluno) {
        NOAluno novo = new NOAluno(aluno);

        if (this.estaVazia()) {
            this.inicio = novo;
        } else {
            NOAluno atual = this.inicio;

            while (atual.getProx() != null) {
                atual = atual.getProx();
            }

            atual.setProx(novo);
        }

        this.tamanho++;
        return true;
    }

    public Aluno buscar(int matricula) {
        NOAluno atual = this.inicio;

        while (atual != null) {
            if (atual.getAluno().getmatricula() == matricula) {
                return atual.getAluno();
            }

            atual = atual.getProx();
        }

        return null;
    }
    public boolean excluir(int matricula) {
        NOAluno atual = this.inicio;
        NOAluno anterior = null;

        while (atual != null) {

            if (atual.getAluno().getmatricula() == matricula) {

                if (anterior == null) {
                    this.inicio = atual.getProx();
                } else {
                    anterior.setProx(atual.getProx());
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
        if (this.estaVazia()) {
            System.out.println("Nenhum aluno matriculado.");
            return;
        }

        NOAluno atual = this.inicio;

        while (atual != null) {
            System.out.println(
                "Matrícula: " + atual.getAluno().getmatricula()
                + " | Nome: " + atual.getAluno().getNome()
            );

            atual = atual.getProx();
        }
    }

    public int getTamanho() {
        return this.tamanho;
    }
}