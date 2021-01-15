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
    public boolean ComparaIgual(Object Value) { return this.value == (double) Value; }

    @Override
    public boolean ComparaMaior(Object Value) { return this.value > (double)Value; }

    @Override
    public boolean ComparaMenor(Object Value) { return this.value < (double) Value; }

    @Override
    public boolean ComparaMaiorIgual(Object Value) { return this.value >= (float) Value; }

    @Override
    public boolean ComparaMenorIgual(Object Value) { return this.value <= (double) Value; }

    @Override
    public boolean ComparaDiferente(Object Value) { return this.value != (double) Value; }

    @Override
    public boolean ComparaStringIgual(Object Value) {return this.value == Double.parseDouble((String) Value);}

    @Override
    public boolean ComparaStringMaior(Object Value) {return this.value > Double.parseDouble((String) Value);}

    @Override
    public boolean ComparaStringMenor(Object Value) {return this.value < Double.parseDouble((String) Value);}

    @Override
    public boolean ComparaStringMaiorIgual(Object Value) {return this.value >= Double.parseDouble((String) Value);}

    @Override
    public boolean ComparaStringMenorIgual(Object Value) {return this.value <= Double.parseDouble((String) Value);}

    @Override
    public boolean ComparaStringDiferente(Object Value) {return this.value != Double.parseDouble((String) Value);}

    @Override
    public Double getValue() {
        return value;
    }

    @Override
    public Object sum(String i) { return this.value + Double.parseDouble(i); }

    @Override
    void setValue(Object value) { this.value = (double) value; }

    @Override
    void setInputValue(Object value) { this.value = Double.parseDouble((String) value); }
}
