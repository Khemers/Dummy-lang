public class VFloat extends Variable {
    public Float value;

    VFloat(String name, Float value) {
        this.type = "float";
        this.name = name;
        this.value = value;
    }
    VFloat(String name) {
        this.type = "float";
        this.name = name;
        this.value = 0f;
    }

    @Override
    public boolean ComparaIgual(String Value) {return this.value == Float.parseFloat(Value); }

    @Override
    public boolean ComparaMaior(String Value) { return this.value > Float.parseFloat(Value); }

    @Override
    public boolean ComparaMenor(String Value) { return this.value < Float.parseFloat(Value); }

    @Override
    public boolean ComparaMaiorIgual(String Value) { return this.value >= Float.parseFloat(Value); }

    @Override
    public boolean ComparaMenorIgual(String Value) { return this.value <= Float.parseFloat(Value); }

    @Override
    public boolean ComparaDiferente(String Value) { return this.value != Float.parseFloat(Value); }

    @Override
    public Float getValue() {
        return value;
    }

    @Override
    public Object sum(String i) { return this.value + Float.parseFloat(i); }

    @Override
    void setValue(String Value) { this.value = Float.parseFloat(Value); }
}
