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
    public Integer getValue() {
        return value;
    }

    @Override
    public Object sum(String i) { return this.value + Integer.parseInt(i); }

    @Override
    void setValue(Object value) {
        this.value = (int) value;
    }
}
