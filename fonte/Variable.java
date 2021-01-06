abstract class Variable {
    public java.lang.String type;
    public String name;
    public Object value;

    abstract Object getValue();

    abstract void setValue(Object value);
}