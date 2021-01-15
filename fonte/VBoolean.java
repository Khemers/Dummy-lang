public class VBoolean extends Variable {
    public Boolean value;

    VBoolean(String name, Boolean value) {
        this.type = "double";
        this.name = name;
        this.value = value;
    }
    VBoolean(String name) {
        this.type = "double";
        this.name = name;
        this.value = null;
    }

    public boolean ComparaIgual(String Value) {return this.value == Boolean.parseBoolean(Value);}

    @Override
    public boolean ComparaMaior(String Value) { return false; }

    @Override
    public boolean ComparaMenor(String Value) { return false; }

    @Override
    public boolean ComparaMaiorIgual(String Value) { return false; }

    @Override
    public boolean ComparaMenorIgual(String Value) { return false; }

    @Override
    public boolean ComparaDiferente(String Value) { return this.value != Boolean.parseBoolean(Value); }

    @Override
    public Boolean getValue() {
        return value;
    }

    @Override
    public Boolean sum(String i) { return this.value; }

    @Override
    void setValue(String Value) { this.value = Boolean.parseBoolean(Value); }

    @Override
    public Boolean sub(String i) { return this.value; }

    @Override
    public Boolean mult(String i) { return this.value; }

    @Override
    public Boolean div(String i) { return this.value; }

    @Override
    public Boolean rest(String i) { return this.value; }

}
