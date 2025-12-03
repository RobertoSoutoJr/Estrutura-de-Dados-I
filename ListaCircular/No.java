class No<T>{
    private T dado;
    private No<T> nextNo;

    public No(T dado){
        this(dado, null);
    }

    public No(T dado, No<T> nextNo){
        this.dado = dado;
        this.nextNo = nextNo;
    }

    public T getDado(){
        return this.dado;
    }

    public void setDado(T dado){
        this.dado = dado;
    }

    public No<T> getNextNo(){
        return this.nextNo;
    }

    public void setNextNo(No<T> nextNo){
        this.nextNo = nextNo;
    }

    @Override
    public String toString(){
        return "Dado{" + getDado() + "}";
    }
}