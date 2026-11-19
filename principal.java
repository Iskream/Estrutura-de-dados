package gestao_academica;
import java.util.Scanner;
public class principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Arvore arvore = new Arvore();
        ListaAluno alunos = new ListaAluno();
        NO no1 = new NO(111, "ADS", 6);
        NO no2 = new NO(666, "Medicina", 4);
        NO no3 = new NO(333, "Engenharia", 1);
        arvore.inserir(no1);
        arvore.inserir(no2);
        arvore.inserir(no3);
        Aluno aluno1 = new Aluno("João", 20);
        Aluno aluno2 = new Aluno("Maria", 22);
        Aluno aluno3 = new Aluno("Pedro", 23);
        alunos.inserir(aluno1);
        alunos.inserir(aluno2);
        alunos.inserir(aluno3);
        int opcao = -1;
        while(opcao !=0){
            System.out.println("Bem vindo ao sistema de gestão acadêmica");
            System.out.println("O que deseja fazer? :");
            System.out.println("1. Gerenciar cursos");
            System.out.println("2. Gerenciar alunos matriculados");
            System.out.println("3. Gerenciar fila de espera");
            System.out.println("0. Sair");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Gestão de Cursos");
                    arvore.percursos();
                    System.out.println("Escolha uma opção:");
                    System.out.println("1. Inserir um curso");
                    System.out.println("2. Buscar um curso");
                    System.out.println("3. Excluir um curso");
                    System.out.println("4. Mostre a ordem.");
                    int escolha = sc.nextInt();
                    switch (escolha) 
                    {
                        case 1:
                            System.out.println("Digite o código do curso:");
                            int codigo = sc.nextInt();
                            System.out.println("Digite o nome do curso:");
                            String nome = sc.next();
                            System.out.println("Digite o número de vagas do curso:");
                            int vagas = sc.nextInt();
                            NO novoCurso = new NO(codigo, nome, vagas);
                            arvore.inserir(novoCurso);
                            System.out.println("Curso inserido com sucesso!");
                            break;
                        case 2:
                            System.out.println("Digite o código do curso a ser buscado:");
                            int codigoBusca = sc.nextInt();
                            NO cursoEncontrado = arvore.buscar(codigoBusca);
                            if (cursoEncontrado != null) {
                                System.out.println("Curso encontrado: " + cursoEncontrado.getNome());
                            } else {
                                System.out.println("Curso não encontrado.");
                            }
                            break;
                        case 3:
                            System.out.println("Digite o código do curso a ser excluído:");
                            int codigoExclusao = sc.nextInt();
                            NO cursoExcluido = arvore.excluir(codigoExclusao);
                            if (cursoExcluido != null) {
                                System.out.println("Curso excluído: " + cursoExcluido.getNome());
                            } else {
                                System.out.println("Curso não encontrado para exclusão.");
                            }
                            break;
                        case 4:
                            arvore.percursos();
                            break;
                        default:
                            System.out.println("Opção inválida.");
                            break;            
                    }
                break;
            case 2:
                alunos.listar();
                System.out.println("Gestão de Alunos Matriculados");
                System.out.println("Escolha uma opção:");
                System.out.println("1. Inserir um aluno no curso");
                System.out.println("2. Buscar um aluno");
                System.out.println("3. Excluir um aluno");
                int escolhaAluno = sc.nextInt();
                switch (escolhaAluno) 
                {
                    case 1:
                        System.out.println("Gestão de Alunos Matriculados");
                        System.out.println("Digite o código do curso:");
                        int codCurso = sc.nextInt();
                        NO curso = arvore.buscar(codCurso);
                        if (curso != null) {
                            System.out.println("Digite a matrícula do aluno:");
                            int matricula = sc.nextInt();
                            Aluno aluno = alunos.buscar(matricula);
                            if (aluno != null) {
                                curso.matricular(aluno);
                            } else {
                                System.out.println("Aluno não encontrado.");
                            }
                        } else {
                            System.out.println("Curso não encontrado.");
                        }   
                    break;
                    case 2:
                        System.out.println("Digite o código do curso");
                        int busca = sc.nextInt();
                        NO cursobusca = arvore.buscar(busca);
                        if(cursobusca != null) {
                            System.out.println("Digite a matrricula do aluno");
                            int matricula_busca = sc.nextInt();
                            Aluno alunoBusca = cursobusca.buscarMatriculado(matricula_busca);
                            if(alunoBusca != null) {
                                System.out.println("Aluno está matriculado neste curso");
                                System.out.println("Nome: " + alunoBusca.getNome());
                            }else{
                                System.out.println("Aluno não está matriculado neste curso");
                            }
                        }else{
                            System.out.println("Curso não encontrado");
                        }
                    break;
                    case 3:
                        System.out.println("Digite o código do curso:");
                        int codCursoExcluir = sc.nextInt();
                        NO cursoExcluir = arvore.buscar(codCursoExcluir);
                        if (cursoExcluir != null) {
                            System.out.println("Digite a matrícula do aluno que deseja desmatricular:");
                            int matriculaExcluir = sc.nextInt();
                                if (cursoExcluir.desmatricular(matriculaExcluir)) {
                                    System.out.println("Aluno desmatriculado com sucesso!");
                                } else {
                                    System.out.println("Aluno não está matriculado neste curso.");
                                }
                        } else {
                            System.out.println("Curso não encontrado.");
                        }
                        break;
                } 
            case 3:
                System.out.println("Gerenciar fila de espera");
                System.out.println("Digite o código do curso:");
                int codCursoFila = sc.nextInt();
                NO cursoFila = arvore.buscar(codCursoFila);
                if (cursoFila != null) {
                    System.out.println("Escolha uma opção:");
                    System.out.println("1. Inserir aluno na fila");
                    System.out.println("2. Buscar aluno na fila");
                    System.out.println("3. Excluir aluno da fila");
                    System.out.println("4. Listar fila de espera");
                    int escolhaFila = sc.nextInt();
                    switch (escolhaFila) {
                        case 1:
                            System.out.println("Digite a matrícula do aluno:");
                            int matriculaFila = sc.nextInt();
                            Aluno alunoFila = alunos.buscar(matriculaFila);
                                if (alunoFila != null) {
                                    cursoFila.fila_espera.inserir(alunoFila);
                                    System.out.println("Aluno adicionado à fila!");
                                } else {
                                    System.out.println("Aluno não encontrado.");
                                }
                                break;
                        case 2:
                            System.out.println("Digite a matrícula do aluno:");
                            int matriculaBuscaFila = sc.nextInt();
                            Aluno encontradoFila = cursoFila.fila_espera.buscar(matriculaBuscaFila);
                            if (encontradoFila != null) {
                                System.out.println("Aluno encontrado na fila: " + encontradoFila.getNome());
                            } else {
                                System.out.println("Aluno não está na fila.");
                            }
                            break;
                        case 3:
                            System.out.println("Digite a matrícula do aluno que deseja excluir:");
                            int matriculaExcluirFila = sc.nextInt();
                            if (cursoFila.fila_espera.excluirpormatricula(matriculaExcluirFila)) {
                                System.out.println("Aluno removido da fila!");
                            } else {
                                System.out.println("Aluno não encontrado na fila.");
                            }
                            break;
                        case 4:
                            cursoFila.fila_espera.listar();
                            break;
                        default:
                            System.out.println("Opção inválida.");
                            break;
                        }
                } else {
                    System.out.println("Curso não encontrado.");
                }
                break;
            }
        }
    }
}

