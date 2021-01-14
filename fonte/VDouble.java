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
    public Double getValue() {
        return value;
    }

    @Override
    Object getType() { return this.type; }

    @Override
    public Object sum(String i) { return this.value + Double.parseDouble(i); }

    @Override
    void setValue(Object value) {
        this.value = (double) value;
    }
}
