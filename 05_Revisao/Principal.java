public class Principal{
    public static void main(String[] args){
        System.out.println("=== Testando a Fila ===");
        Fila<Integer> fila = new Fila<Integer>("Números Inteiros");
        fila.enfileirar(1);
        fila.enfileirar(2);
        fila.enfileirar(3);
        fila.imprimeFila();

        System.out.println("Elemento removido: ");
        fila.imprimeFila();
    }
}