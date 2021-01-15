abstract class Variable {
    public String type;
    public String name;

    abstract boolean ComparaIgual(String Value);

    abstract boolean ComparaMaior(String Value);

    abstract boolean ComparaMenor(String Value);

    abstract boolean ComparaMaiorIgual(String Value);

    abstract boolean ComparaMenorIgual(String Value);

    abstract boolean ComparaDiferente(String Value);

    abstract Object getValue();

    abstract Object sum(String i);

    abstract void setValue(String Value);

    abstract Object sub(String i);

    abstract Object mult(String i);

    abstract Object div(String i);
}

