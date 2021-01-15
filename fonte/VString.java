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
    public boolean ComparaMaior(Object Value) {
        
        return false;
    }

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
