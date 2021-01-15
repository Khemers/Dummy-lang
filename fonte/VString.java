public class VString extends Variable {
    public String value;

    VString(String name, String value) {
        this.type = "str";
        this.name = name;
        this.value = value;
    }
    VString(String name) {
        this.type = "str";
        this.name = name;
        this.value = null;
    }

    @Override
    public boolean ComparaIgual(String Value) {return this.value.equals(Value);}

    @Override
    public boolean ComparaMaior(String Value) { return false; }

    @Override
    public boolean ComparaMenor(String Value) { return false; }

    @Override
    public boolean ComparaMaiorIgual(String Value) { return false; }

    @Override
    public boolean ComparaMenorIgual(String Value) { return false; }

    @Override
    public boolean ComparaDiferente(String Value) { return !this.value.equals(Value); }

    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public Object sum(String i) { return this.value + i; }

    @Override
    void setValue(String Value) { this.value = Value; }

    @Override
    public Object sub(String i) { return this.value; }
}
