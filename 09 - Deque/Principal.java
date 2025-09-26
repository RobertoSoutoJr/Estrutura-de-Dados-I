public class Principal {
    public static void main(String[] args) {
        Deque<String> deque = new Deque<>();

        System.out.println("Inserindo elementos no início e no fim:");
        deque.addInicio("Miguel");
        deque.addInicio("Rafael");
        deque.addFinal("Gabriel");
        deque.addFinal("Daniel");

        deque.imprimeDeque();

        System.out.println("\nRemovendo elementos do início e do fim:");
        System.out.println("Removido do início: " + deque.removeInicio());
        System.out.println("Removido do fim: " + deque.removeFinal());

        deque.imprimeDeque();

        System.out.println("\nElementos na frente e atrás do deque:");
        System.out.println("Primeiro: " + deque.peekInicio());
        System.out.println("Último: " + deque.peekFinal());

        System.out.println("\nTamanho do deque: " + deque.size());
    }
}
