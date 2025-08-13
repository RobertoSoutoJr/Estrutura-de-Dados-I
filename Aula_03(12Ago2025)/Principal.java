public class Principal{
    public static void main (String[] args){
        Pessoa obj1 = new Pessoa("Roberto",20);
        Pessoa obj2 = new Pessoa("Filipim", 24);
        Pessoa obj3 = new Pessoa("Mabely Desprezada", 20);

        System.out.println(obj1.toString());
        System.out.println(obj2.toString());
        System.out.println(obj3.toString());
    }
}