package gestao_academica;

public class NO {
    protected int codigo;
    protected String nome;
    protected int vagas;
    private NO esq;
    private NO dir;
    protected ListaAluno matriculados;
    protected FilaEspera fila_espera;
    public NO(int codigo, String nome, int vagas){
        this.codigo = codigo;
        this.nome = nome;
        this.vagas = vagas;
        this.esq = null;
        this.dir = null;
        this.matriculados = new ListaAluno();
        this.fila_espera = new FilaEspera();
    }
    public int getcodigo()
    {
        return this.codigo;
    }
    public void setcodigo(int codigo){
        this.codigo = codigo;
    }
    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public NO getEsq(){
        return this.esq;
    }
    public void setEsq(NO esq){
        this.esq = esq;
    }
    public NO getDir(){
        return this.dir;
    }
    public void setDir(NO dir){
        this.dir = dir;
    }
    public int getVagas() {
        return vagas;
    }
    public void setVagas(int vagas) {
        this.vagas = vagas;
    }
    public boolean matricular(Aluno aluno) {
    if (this.matriculados.buscar(aluno.getmatricula()) != null) {
        System.out.println("Aluno já matriculado neste curso.");
        return false;
    }
    if (this.vagas > 0) {
        this.matriculados.inserir(aluno);
        this.vagas--;

        System.out.println("Aluno matriculado com sucesso!");
        return true;
    } else {
        System.out.println("Sem vagas! Escolha a opção 3 para inserir o aluno na lista de espera.");
        return false;
    }
}
    public boolean desmatricular(int matricula) {
    if (this.matriculados.excluir(matricula)) 
        {
            this.vagas++;
            System.out.println("Aluno desmatriculado com sucesso!");
            return true;
        } else {
            System.out.println("Aluno não está matriculado neste curso.");
            return false;
        }
    }
    public Aluno buscarMatriculado(int matricula) {
    return this.matriculados.buscar(matricula);
    }
}

