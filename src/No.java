public class No {
    private String palavra;
    private boolean flag;
    private No cabeca;
    private No cauda;

    public No() {
        cauda = cabeca = null;
        flag = false;
    }

    public No(String palavra, boolean flag, No cabeca, No cauda){
        this.palavra = palavra;
        this.flag = flag;
        this.cabeca = cabeca;
        this.cauda = cauda;
    }

    public int getTamanhoIgualdade(String info){
        int i=0;
        while (i<info.length() && i<palavra.length() && info.charAt(i)==palavra.charAt(i))
            i++;
        return i;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public No getCabeca() {
        return cabeca;
    }

    public void setCabeca(No cabeca) {
        this.cabeca = cabeca;
    }

    public No getCauda() {
        return cauda;
    }

    public void setCauda(No cauda) {
        this.cauda = cauda;
    }
}
