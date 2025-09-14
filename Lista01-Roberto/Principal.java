public class Principal {
    public static void main(String[] args) {
        Pilha<String> pilha = new Pilha<>();

        // Adicionando três linguagens
        pilha.adicionar("Java");
        pilha.adicionar("Python");
        pilha.adicionar("C++");

        // Imprimindo a pilha
        pilha.imprimir();

        // Removendo o topo e imprimindo
        String removido = pilha.remover();
        System.out.println("Elemento removido do topo: " + removido);

        // Imprimindo a pilha após remoção
        pilha.imprimir();

        // Adicionando mais duas linguagens
        pilha.adicionar("JavaScript");
        pilha.adicionar("Go");

        // Imprimindo novamente
        pilha.imprimir();
    }
}