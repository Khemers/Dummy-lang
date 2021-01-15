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
    public boolean ComparaIgual(Object Value) {return this.value == (float) Value; }

    @Override
    public boolean ComparaMaior(Object Value) { return this.value > (float)Value; }

    @Override
    public boolean ComparaMenor(Object Value) { return this.value < (float) Value; }

    @Override
    public boolean ComparaMaiorIgual(Object Value) { return this.value >= (float) Value; }

    @Override
    public boolean ComparaMenorIgual(Object Value) { return this.value <= (float) Value; }

    @Override
    public boolean ComparaDiferente(Object Value) { return this.value != (float) Value; }

    @Override
    public boolean ComparaStringIgual(Object Value) {return this.value == Float.parseFloat((String) Value);}

    @Override
    public boolean ComparaStringMaior(Object Value) {return this.value > Float.parseFloat((String) Value);}

    @Override
    public boolean ComparaStringMenor(Object Value) {return this.value < Float.parseFloat((String) Value);}

    @Override
    public boolean ComparaStringMaiorIgual(Object Value) {return this.value >= Float.parseFloat((String) Value);}

    @Override
    public boolean ComparaStringMenorIgual(Object Value) {return this.value <= Float.parseFloat((String) Value);}

    @Override
    public boolean ComparaStringDiferente(Object Value) {return this.value != Float.parseFloat((String) Value);}

    @Override
    public Float getValue() {
        return value;
    }

    @Override
    public Object sum(String i) { return this.value + Float.parseFloat(i); }

    @Override
    void setValue(Object value) { this.value = (float) value; }

    @Override
    void setInputValue(Object value) { this.value = Float.parseFloat((String) value); }
}
