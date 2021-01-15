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
    public boolean ComparaIgual(Object Value) {return this.value == Value;}

    @Override
    public boolean ComparaMaior(Object Value) { return false; }

    @Override
    public boolean ComparaMenor(Object Value) { return false; }

    @Override
    public boolean ComparaMaiorIgual(Object Value) { return false; }

    @Override
    public boolean ComparaMenorIgual(Object Value) { return false; }

    @Override
    public boolean ComparaDiferente(Object Value) { return false; }

    @Override
    public boolean ComparaStringIgual(Object Value) {return this.value == ((String) Value);}

    @Override
    public boolean ComparaStringMaior(Object Value) {return false;}

    @Override
    public boolean ComparaStringMenor(Object Value) {return false;}

    @Override
    public boolean ComparaStringMaiorIgual(Object Value) {return false;}

    @Override
    public boolean ComparaStringMenorIgual(Object Value) {return false;}

    @Override
    public boolean ComparaStringDiferente(Object Value) {return this.value != ((String) Value);}

    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public Object sum(String i) { return this.value + i; }

    @Override
    void setValue(Object value) { this.value = (String) value; }

    @Override
    void setInputValue(Object value) { this.value = (String) value; }
}
