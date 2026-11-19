package gestao_academica;

public class Arvore {
    private NO raiz;
    NO atual = this.raiz;
    public Arvore() {
        this.raiz = null;
    }
    public boolean inserir(NO novo) {
        return inserir(null,raiz,novo);
    }
    private boolean inserir(NO pai, NO atual, NO novo) {
        if (atual== null) {
            if(pai == null) {
                raiz = novo;
            }else{
                 if(novo.getcodigo()< pai.getcodigo()){
                    pai.setEsq(novo);
                }else{
                    pai.setDir(novo);
                }
            }
            return true;
        }else{
            int codigonovo = novo.getcodigo();
            int codigoatual = atual.getcodigo();
            if (codigonovo < codigoatual) {
                return inserir(atual, atual.getEsq(), novo);
            }else if (codigonovo> codigoatual) {
                return inserir(atual, atual.getDir(), novo);
            }else{
                return false;
            }
        }
    }

    public NO buscar(int codigo) {

        NO atual = this.raiz;

        while (atual != null && atual.getcodigo() != codigo) {

            if (codigo < atual.getcodigo()) {
                atual = atual.getEsq();

            } else {
            atual = atual.getDir();
            }
        }
        return atual;
    }

    public NO excluir(int codigo) {
        NO pai = null;
        NO atual = this.raiz;

        while (atual != null && atual.getcodigo() != codigo) {
            pai = atual;
            if (codigo < atual.getcodigo()) {
                atual = atual.getEsq();
            } else {
                atual = atual.getDir();
            }
        }

        if (atual == null) {
            return (null);
        }

        if (atual.getEsq() == null && atual.getDir() == null) {
            if (atual == this.raiz) {
                this.raiz = null;
            } else if (pai.getEsq() == atual) {
                pai.setEsq(null);
            } else {
                pai.setDir(null);
            }
        } else if (atual.getEsq() == null || atual.getDir() == null) {
            NO filho = (atual.getEsq() != null) ? atual.getEsq() : atual.getDir();
            if (atual == this.raiz) {
                this.raiz = filho;
            } else if (pai.getEsq() == atual) {
                pai.setEsq(filho);
            } else {
                pai.setDir(filho);
            }
        } else {
            NO paiSucessor = atual;
            NO sucessor = atual.getDir();
            while (sucessor.getEsq() != null) {
                paiSucessor = sucessor;
                sucessor = sucessor.getEsq();
            }
            atual.setcodigo(sucessor.getcodigo());
            atual.setNome(sucessor.getNome());
            if (paiSucessor == atual) {
                paiSucessor.setDir(sucessor.getDir());
            } else {
                paiSucessor.setEsq(sucessor.getDir());
            }
        }
        return atual;
    }
    public void percursos() {
        System.out.println("In-ordem:");
        inOrdem(this.raiz);

        System.out.println("Pré-ordem:");
        preOrdem(this.raiz);

        System.out.println("Pós-ordem:");
        posOrdem(this.raiz);
    }

    public void preOrdem(NO atual){
        if(atual!=null){
            System.out.println(atual.getcodigo());
            preOrdem(atual.getEsq());
            preOrdem(atual.getDir());
        }
    }
    public void inOrdem(NO atual){
        if(atual!=null){
            inOrdem(atual.getEsq());
            System.out.println(atual.getcodigo());
            inOrdem(atual.getDir());
        }
    }
    public void posOrdem(NO atual){
        if(atual!=null){
            posOrdem(atual.getEsq());
            posOrdem(atual.getDir());
            System.out.println(atual.getcodigo());
        }
    }
}
