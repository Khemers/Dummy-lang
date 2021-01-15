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
    public boolean ComparaIgual(Object Value) {return this.value == (int) Value; }

    @Override
    public boolean ComparaMaior(Object Value) { return this.value > (int) Value; }

    @Override
    public boolean ComparaMenor(Object Value) { return this.value < (int) Value; }

    @Override
    public boolean ComparaMaiorIgual(Object Value) { return this.value >= (int) Value; }

    @Override
    public boolean ComparaMenorIgual(Object Value) { return this.value <= (int) Value; }

    @Override
    public boolean ComparaDiferente(Object Value) { return this.value != (int) Value; }

    @Override
    public boolean ComparaStringIgual(Object Value) {return this.value == Integer.parseInt((String) Value);}

    @Override
    public boolean ComparaStringMaior(Object Value) {return this.value > Integer.parseInt((String) Value);}

    @Override
    public boolean ComparaStringMenor(Object Value) {return this.value < Integer.parseInt((String) Value);}

    @Override
    public boolean ComparaStringMaiorIgual(Object Value) {return this.value >= Integer.parseInt((String) Value);}

    @Override
    public boolean ComparaStringMenorIgual(Object Value) {return this.value <= Integer.parseInt((String) Value);}

    @Override
    public boolean ComparaStringDiferente(Object Value) {return this.value != Integer.parseInt((String) Value);}

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public Object sum(String i) { return this.value + Integer.parseInt(i); }

    @Override
    void setValue(Object value) { this.value = (int) value; }

    @Override
    void setInputValue(Object value) { this.value = Integer.parseInt((String) value); }
}
