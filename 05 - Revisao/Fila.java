
public class Fila<T>{
    private No<T> primeiroNo;
    private No<T> ultimoNo;
    private String nomeFila;

    public Fila(){
        this("");
    }

    public Fila(String nomeFila){
        this.nomeFila = nomeFila;
        this.primeiroNo = null;
        this.ultimoNo = null;
    }

    public void enfileirar(T dado){ //enqueue, adiciona um elemento ao final da fila
        No<T> novoNo = new No<T>(dado);
        if(ultimoNo == null){
            primeiroNo = ultimoNo = novoNo;
        }else{
            ultimoNo.setNextNo(novoNo);
            ultimoNo = novoNo;
        }
    }

    public T desenfileirar(){ //dequeue, remove o elemento no início da fila
        if(primeiroNo == null){
            System.out.println("Fila Vazia");
            return null;
        }
        T dadoTemp = primeiroNo.getDado();
        primeiroNo = primeiroNo.getNextNo();
        if(primeiroNo == null){
            ultimoNo = null;
        }
        return dadoTemp;
    }

    public boolean isEmpty() { //verificar se a fila está vazia
        return primeiroNo == null;
    }

    public void imprimeFila(){
        if(primeiroNo == null){
            System.out.println("Fila Vazia");
        }else{
            System.out.printf("Dados da fila %s:\n",nomeFila);
            No<T> aux = primeiroNo;
            while (aux != null) {
                System.out.printf(" %s ", aux.toString());
                aux = aux.getNextNo();
            }
            System.out.println();
        }
    }

}