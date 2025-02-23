import java.util.Arrays;

public class Math {

    public static void sum(Variable var, String a, String b) {
        switch (var.type) {
            case "int" -> var.setValue(String.valueOf(Integer.parseInt(a) + Integer.parseInt(b)));
            case "float" -> var.setValue(String.valueOf(Float.parseFloat(a) + Float.parseFloat(b)));
            case "double" -> var.setValue(String.valueOf(Double.parseDouble(a) + Double.parseDouble(b)));
            case "str" -> var.setValue(a + b);
        }
    }

    public static void sub(Variable var, String a, String b) {
        switch (var.type) {
            case "int" -> var.setValue(String.valueOf(Integer.parseInt(a) - Integer.parseInt(b)));
            case "float" -> var.setValue(String.valueOf(Float.parseFloat(a) - Float.parseFloat(b)));
            case "double" -> var.setValue(String.valueOf(Double.parseDouble(a) - Double.parseDouble(b)));
        }
    }

    public static void mult(Variable var, String a, String b) {
        switch (var.type) {
            case "int" -> var.setValue(String.valueOf(Integer.parseInt(a) * Integer.parseInt(b)));
            case "float" -> var.setValue(String.valueOf(Float.parseFloat(a) * Float.parseFloat(b)));
            case "double" -> var.setValue(String.valueOf(Double.parseDouble(a) * Double.parseDouble(b)));
        }
    }

    public static void div(Variable var, String a, String b) {
        switch (var.type) {
            case "int" -> var.setValue(String.valueOf(Integer.parseInt(a) / Integer.parseInt(b)));
            case "float" -> var.setValue(String.valueOf(Float.parseFloat(a) / Float.parseFloat(b)));
            case "double" -> var.setValue(String.valueOf(Double.parseDouble(a) / Double.parseDouble(b)));
        }
    }

    public static void rest(Variable var, String a, String b) {
        switch (var.type) {
            case "int" -> var.setValue(String.valueOf(Integer.parseInt(a) % Integer.parseInt(b)));
            case "float" -> var.setValue(String.valueOf(Float.parseFloat(a) % Float.parseFloat(b)));
            case "double" -> var.setValue(String.valueOf(Double.parseDouble(a) % Double.parseDouble(b)));
        }
    }

    public static boolean comparaIgual(String a, String b) {
        return (Arrays.equals(a.getBytes(), b.getBytes()));
    }

    public static boolean comparaMaior(String a, String b) {
        return (Double.parseDouble(a) > Double.parseDouble(b));
    }

    public static boolean comparaMenor(String a, String b) {
        return (Double.parseDouble(a) < Double.parseDouble(b));
    }

    public static boolean comparaMaiorIgual(String a, String b) {
        return (Double.parseDouble(a) >= Double.parseDouble(b));
    }

    public static boolean comparaMenorIgual(String a, String b) {
        return (Double.parseDouble(a) <= Double.parseDouble(b));
    }

    public static boolean comparaDiferente(String a, String b) {
        return (!Arrays.equals(a.getBytes(), b.getBytes()));
    }
}