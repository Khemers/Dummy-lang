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
    public String getValue() {
        return this.value;
    }

    @Override
    void setValue(Object value) {
        this.value = (String) value;
    }
}
