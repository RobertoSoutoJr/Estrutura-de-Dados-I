public class PrincipalLista {
    public static void main(String[] args) {
        ListaDuplamenteEncadeada<Produto> lista = new ListaDuplamenteEncadeada<>();

        // Criando produtos
        Produto p1 = new Produto("RTX 5060 TI", 3500.0);
        Produto p2 = new Produto("X-Tudo c/ Melancia", 50.0);
        Produto p3 = new Produto("Barril de Chope sem álcool", 120.0);

        // Adicionando produtos
        lista.adicionarInicio(p1);      // primeiro no início
        lista.adicionarFim(p2);         // segundo no final
        lista.adicionarEmIndice(p3, 1); // terceiro no índice 1

        // Imprimindo a lista
        lista.imprimir();

        // Removendo o segundo produto (índice 1)
        Produto removido = lista.removerPorIndice(1);
        System.out.println("Produto removido: " + removido);

        // Imprimindo a lista após remoção
        lista.imprimir();

        // Adicionando um produto no início
        Produto p4 = new Produto("Pneu Michelin Primacy 4", 900.0);
        lista.adicionarInicio(p4);

        // Adicionando um produto no final
        Produto p5 = new Produto("Munição 7.62x51mm M80A1 Tracer (UN)", 250.0);
        lista.adicionarFim(p5);

        // Imprimindo a lista final
        lista.imprimir();
    }
}
