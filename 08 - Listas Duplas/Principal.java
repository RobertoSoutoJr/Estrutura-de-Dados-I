public class Principal {

    public static void main(String[] args) {
        ListaDupla<String> lista = new ListaDupla<String>("Alunos");

        lista.addInicio("Rafael");
        lista.addInicio("Miguel");
        lista.addFinal("Gabriel");

        lista.imprimeLista();

        lista.removeInicio();
        lista.imprimeLista();
        
        lista.removeFinal();

        lista.imprimeLista();
    }
}