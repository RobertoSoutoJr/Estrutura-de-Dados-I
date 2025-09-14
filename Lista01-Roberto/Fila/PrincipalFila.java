public class PrincipalFila {
    public static void main(String[] args) {
        Fila<String> fila = new Fila<>();

        // Adicionando três nomes de alunos
        fila.adicionar("Alice");
        fila.adicionar("Bruno");
        fila.adicionar("Carla");

        // Imprimindo a fila
        fila.imprimir();

        // Removendo o primeiro aluno e imprimindo
        String removido = fila.remover();
        System.out.println("Aluno removido da frente da fila: " + removido);

        // Imprimindo a fila após remoção
        fila.imprimir();

        // Adicionando mais dois alunos
        fila.adicionar("Daniel");
        fila.adicionar("Elisa");

        // Imprimindo a fila final
        fila.imprimir();
    }
}
