public class VDouble extends Variable {
    public Double value;

    VDouble(String name, Double value) {
        this.type = "double";
        this.name = name;
        this.value = value;
    }
    VDouble(String name) {
        this.type = "double";
        this.name = name;
        this.value = 0.0;
    }

    @Override
    public boolean ComparaIgual(String Value) { return this.value == Double.parseDouble(Value); }

    @Override
    public boolean ComparaMaior(String Value) { return this.value > Double.parseDouble(Value); }

    @Override
    public boolean ComparaMenor(String Value) { return this.value < Double.parseDouble(Value); }

    @Override
    public boolean ComparaMaiorIgual(String Value) { return this.value >= Double.parseDouble(Value); }

    @Override
    public boolean ComparaMenorIgual(String Value) { return this.value <= Double.parseDouble(Value); }

    @Override
    public boolean ComparaDiferente(String Value) { return this.value != Double.parseDouble(Value); }

    @Override
    public Double getValue() {
        return value;
    }

    @Override
    public Object sum(String i) { return this.value + Double.parseDouble(i); }

    @Override
    void setValue(String Value) { this.value = Double.parseDouble(Value); }

    @Override
    public Object sub(String i) { return this.value - Double.parseDouble(i); }

    @Override
    public Object mult(String i) { return this.value * Double.parseDouble(i); }

    @Override
    public Object div(String i) { return this.value / Double.parseDouble(i); }

    @Override
    public Object rest(String i) { return this.value % Double.parseDouble(i); }
}
