import java.util.ArrayList;

public class Principal{
    public static void main (String[] args){
        /*Pessoa obj1 = new Pessoa("Roberto",20);
        Pessoa obj2 = new Pessoa("Filipim", 24);
        Pessoa obj3 = new Pessoa("Mabely Desprezada", 20);

        System.out.println(obj1.toString());
        System.out.println(obj2.toString());
        System.out.println(obj3.toString()); */
        

        
        
        // listaP.add(obj3);
        // listaP.add(obj2);
        // listaP.add(obj1);

        //System.out.println(listaP.get(0).toString()); 

        ArrayList<Pessoa> listaP = new ArrayList<Pessoa>();
        listaP.add(new Pessoa("Robim", 20));
        listaP.add(new Pessoa("Filipim", 24));
        listaP.add(new Pessoa("Mabelidesgraça", 20));

        for(Pessoa auxP : listaP){
            System.out.println(auxP.toString());
        }
        
        
    }
}