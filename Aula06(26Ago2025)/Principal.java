public class Principal{
    public static void main(String[] args) {
        
        Lista<String> lista = new Lista<String>("Alunos");

        // lista.imprimeLista();
        // lista.addInicio("Rafael");
        // lista.addInicio("Gabriel");
        // lista.imprimeLista();
        // lista.addFinal("Daniel");
        // lista.imprimeLista();
        lista.removeInicio();
        // lista.removeInicio();
        // lista.removeInicio();
        lista.imprimeLista();
    }
}