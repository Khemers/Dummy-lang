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

    @Override
    public boolean ComparaMaior(Object Value) {
        
        return false;
    }

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
