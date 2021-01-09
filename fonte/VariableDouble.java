public class VariableDouble extends Variable {
    public double value;

    VariableDouble(String name, double value) {
        this.type = "double";
        this.name = name;
        this.value = value;
    }
    VariableDouble(String name) {
        this.type= "double";
        this.name= name;
        this.value= 0;
    }

    @Override
    public Double getValue() {
        return value;
    }

    @Override
    void setValue(Object value) {
        this.value = (double) value;
    }
}
