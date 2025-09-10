class No<T>{ //classe com visibilidade package-private (visível apenas dentro do mesmo pacote em que está definida)
    private T dado;
    private No<T> nextNo; //Referência ao próximo nó vinculado

    public No(T dado){
        this(dado, null);
    }

    public No(T dado, No<T> no){
        this.dado = dado;
        this.nextNo = no;
    }

    public void setDado(T dado){
        this.dado = dado;
    }

    public T getDado(){
        return this.dado;
    }

    public void setNextNo(No<T> nextNo){
        this.nextNo = nextNo;
    }

    public No<T> getNextNo(){
        return this.nextNo;
    }

    @Override
    public String toString(){
        return "{ " + getDado() + " }";
    }
}