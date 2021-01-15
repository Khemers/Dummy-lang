abstract class Variable {
    public String type;
    public String name;
    public Object value;

    abstract boolean ComparaIgual(Object Value);

    abstract boolean ComparaMaior(Object Value);

    abstract boolean ComparaMenor(Object Value);

    abstract boolean ComparaMaiorIgual(Object Value);

    abstract boolean ComparaMenorIgual(Object Value);

    abstract boolean ComparaDiferente(Object Value);

    abstract Object getValue();

    abstract Object sum(String i);

    abstract void setValue(Object value);

    abstract void setInputValue(Object value);
}