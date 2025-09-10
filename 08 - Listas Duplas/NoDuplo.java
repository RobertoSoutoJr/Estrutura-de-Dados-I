public class NoDuplo<T>{
    private T dado;
    private NoDuplo proximoNo;
    private NoDuplo<T> anteriorNo;
    private int indice;

    public NoDuplo(T Dado, int indice){
        this.dado = dado;
        this.indice = indice;
        this.proximoNo = null;
        this.anteriorNo = null;
    }
}