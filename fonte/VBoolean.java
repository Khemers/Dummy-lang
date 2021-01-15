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

    public boolean ComparaIgual(Object Value) {return this.value == (boolean) Value;}

    @Override
    public boolean ComparaMaior(Object Value) { return false; }

    @Override
    public boolean ComparaMenor(Object Value) { return false; }

    @Override
    public boolean ComparaMaiorIgual(Object Value) { return false; }

    @Override
    public boolean ComparaMenorIgual(Object Value) { return false; }

    @Override
    public boolean ComparaDiferente(Object Value) { return this.value != (boolean) Value; }

    @Override
    public boolean ComparaStringIgual(Object Value) {return this.value == Boolean.parseBoolean((String) Value);}

    @Override
    public boolean ComparaStringMaior(Object Value) {return false;}

    @Override
    public boolean ComparaStringMenor(Object Value) {return false;}

    @Override
    public boolean ComparaStringMaiorIgual(Object Value) {return false;}

    @Override
    public boolean ComparaStringMenorIgual(Object Value) {return false;}

    @Override
    public boolean ComparaStringDiferente(Object Value) {return false;}

    @Override
    public Boolean getValue() {
        return value;
    }

    @Override
    public Boolean sum(String i) { return this.value; }

    @Override
    void setValue(Object value) { this.value = (boolean) value; }

    @Override
    void setInputValue(Object value) { this.value = (boolean) value; }
}
