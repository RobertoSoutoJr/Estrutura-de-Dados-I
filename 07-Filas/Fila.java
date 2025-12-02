public class Fila<T> {
    private No<T> primeiroNo;
    private No<T> ultimoNo;
    private String nomeFila;

    public Fila() {
        this("");
    }

    public Fila(String nomeFila) {
        this.nomeFila = nomeFila;
        primeiroNo = null;
        ultimoNo = null;
    }

    public void enfileirar(T dado) {
        No<T> novoNo = new No<T>(dado);

        if (ultimoNo == null) {
            // Fila está vazia
            primeiroNo = novoNo;
            ultimoNo = novoNo;
        } else {
            // Fila já possui elementos
            ultimoNo.setNextNo(novoNo);
            ultimoNo = novoNo;
        }
    }

    public void desenfileirar() {
        if (ultimoNo == null) {
            System.out.println("Filza vazia!");
        } else {

        }
    }

    public void imprimeFila(){
        if(primeiroNo == null){
            System.out.println("Fila vazia!");
        } else {
            System.out.println("Dados da Fila: ");
            No<T> aux = primeiroNo;
            while (aux != null){
                System.out.printf("{ %s }", aux.getDado());
                aux = aux.getNextNo();
            }
        }
    }
}