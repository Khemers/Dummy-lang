public class Math {

    public static void sum(Variable var, String a, String b) {
        if (var.type.equals("int")) {
            var.setValue(String.valueOf(Integer.parseInt(a) + Integer.parseInt(b)));
        }
    }

    public static void sub(Variable var, String a, String b) {
        if (var.type.equals("int")) {
            var.setValue(String.valueOf(Integer.parseInt(a) - Integer.parseInt(b)));
        }
    }

    public static void mult(Variable var, String a, String b) {
        if (var.type.equals("int")) {
            var.setValue(String.valueOf(Integer.parseInt(a) * Integer.parseInt(b)));
        }

    }
    public static void div(Variable var, String a, String b) {
        if (var.type.equals("int")) {
            var.setValue(String.valueOf(Integer.parseInt(a) / Integer.parseInt(b)));
        }

    }
    public static void rest(Variable var, String a, String b) {
        if (var.type.equals("int")) {
            var.setValue(String.valueOf(Integer.parseInt(a) % Integer.parseInt(b)));
        }

    }
}