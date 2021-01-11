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
    public Float getValue() {
        return value;
    }

    @Override
    void setValue(Object value) {
        this.value = (float) value;
    }
}
