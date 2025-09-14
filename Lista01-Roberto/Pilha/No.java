class No<T>{

    private T dado;
    private No<T> nextNo;

    public No(T dado){
        this(dado, null);
    }
    
    public No(T dado, No<T> no){
        this.dado = dado;
        this.nextNo = no;
    }

    public T getDado(){
        return dado;
    }

    public void setDado(T dado){
        this.dado = dado;
    }

    public No<T> getNextNo(){
        return this.nextNo;
    }

    public void setNextNo(No<T> no){
        this.nextNo = no;
    }

    @Override
    public String toString(){
        return "Dado{" + getDado() + "}";
    }
}