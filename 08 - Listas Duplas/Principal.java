public class Principal {

    public static void main(String[] args) {
        ListaDupla<String> lista = new ListaDupla<String>("Alunos");

        lista.addInicio("Rafael");
        lista.addInicio("Miguel");
        lista.addFinal("Gabriel");
        lista.addFinal("Daniel");

        lista.imprimeLista();

        lista.addMeio("Pedro", 2);

        lista.imprimeLista();

        lista.removeMeio(1);
        
        lista.imprimeLista();
    }
}