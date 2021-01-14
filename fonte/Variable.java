abstract class Variable {
    public String type;
    public String name;
    public Object value;

    abstract Object getValue();

    abstract Object getType();

    abstract Object sum(String i);

    abstract void setValue(Object value);
}
