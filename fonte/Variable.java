abstract class Variable {
    public java.lang.String type;
    public String name;

    abstract Object getValue();

    abstract void setValue(Object value);
}