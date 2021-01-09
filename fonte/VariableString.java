public class VariableString extends Variable {
    public String value;

    VariableString(String name, String value) {
        this.type = "string";
        this.name = name;
        this.value = value;
    }
    VariableString(String name) {
        this.type = "string";
        this.name = name;
        this.value = null;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public void setValue(Object value) {
        this.value = (String) value;
    }
}
