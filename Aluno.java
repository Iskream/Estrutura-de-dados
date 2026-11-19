package gestao_academica;

public class Aluno {
    protected String nome;
    protected int matricula;
        public Aluno(String nome, int matricula){
        this.nome = nome;
        this.matricula = matricula;
    }
    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public int getmatricula(){
        return this.matricula;
    }
    public void setmatricula(int matricula){
        this.matricula = matricula;
    }
}


