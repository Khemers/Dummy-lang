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
    public boolean ComparaMaior(Object Value) {
        
        return this.value > (float)Value;
    }

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
