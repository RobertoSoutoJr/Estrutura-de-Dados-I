package Pilhas;
public class Pilha<T> {
    private No<T> topo;
    private String nomePilha;

    public Pilha(){
        this("");
    }

    public Pilha(String nomePilha){
        this.nomePilha = nomePilha;
        this.topo = null;
    }

    public void push(T dado){
        No<T> novoNo = new No<T>(dado);

        if(topo == null){
            topo = novoNo;
        }else{
            novoNo.setNextNo(topo);
            topo = novoNo;
        }
    }

    public T pop(){
        if(topo == null){
            System.out.println("Pilha vazia!");
            return null;
        }else{
            T dadoTemp = topo.getDado();
            topo = topo.getNextNo();
            return dadoTemp;
        }
    }

    public T peek() {
    if (topo == null) {
        System.out.println("Pilha vazia!");
        return null;
    } else {
        return topo.getDado();
    }
}


    public void imprimePilha(){
    if (topo == null)  {
        System.out.println("Pilha vazia!");
    }
        No<T> aux = topo;
        while (aux != null) {
            System.out.println(aux.getDado());
            aux = aux.getNextNo();
        }
    }
}