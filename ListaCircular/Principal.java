public class Principal {
    public static void main(String[] args) {
        ListaCircular<Integer> lista = new ListaCircular<>();

        lista.addInicio(10);
        lista.addFinal(20);
        lista.addInicio(5);
        lista.addFinal(25);

        System.out.print("Lista: ");
        lista.imprimeLista(); // Saída: 5 10 20 25

        lista.removeInicio();
        System.out.print("Após remover do início: ");
        lista.imprimeLista(); // Saída: 10 20 25

        lista.removeFinal();
        System.out.print("Após remover do final: ");
        lista.imprimeLista(); // Saída: 10 20
    }
}
