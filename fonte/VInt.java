public class VInt extends Variable {
    public int value;

    VInt(String name, int value) {
        this.type = "int";
        this.name = name;
        this.value = value;
    }
    VInt(String name) {
        this.type = "int";
        this.name = name;
        this.value = 0;
    }

    @Override
    public boolean ComparaIgual(String Value) {return this.value == Integer.parseInt(Value); }

    @Override
    public boolean ComparaMaior(String Value) { return this.value > Integer.parseInt(Value); }

    @Override
    public boolean ComparaMenor(String Value) { return this.value < Integer.parseInt(Value); }

    @Override
    public boolean ComparaMaiorIgual(String Value) { return this.value >= Integer.parseInt(Value); }

    @Override
    public boolean ComparaMenorIgual(String Value) { return this.value <= Integer.parseInt(Value); }

    @Override
    public boolean ComparaDiferente(String Value) { return this.value != Integer.parseInt(Value); }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public Object sum(String i) { return this.value + Integer.parseInt(i); }

    @Override
    void setValue(String Value) { this.value = Integer.parseInt(Value); }

    @Override
    public Object sub(String i) { return this.value - Integer.parseInt(i); }
}
