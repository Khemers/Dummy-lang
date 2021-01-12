import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import static java.lang.Double.parseDouble;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

public class Parser {

    public String[] codigoFonte;
    protected Map<String, Variable> Variables;
 
    Parser(StringBuilder codigoFonte) {
        this.Variables = new HashMap<> ();

        setCodigoFonte(codigoFonte);
        parseLines(this.codigoFonte);
    }

    public void parseLines(String[] lines) {
        for (String line : lines) {

            if (Pattern.compile("^\\s*int\\s").matcher(line).find()) {
                foundInt(line);
            }
            if (Pattern.compile("^\\s*float\\s").matcher(line).find()) {
                foundFloat(line);
            }
            if (Pattern.compile("^\\s*double\\s").matcher(line).find()) {
                foundDouble(line);
            }
            if (Pattern.compile("^\\s*string\\s").matcher(line).find()) {
                foundString(line);
            }
        }
    }

    private void foundInt(String line) {
        VInt Int; String[] arr;

        arr = line.split(" ");
        try {
            Int = new VInt(arr[1], parseInt(arr[3]));
        } catch (ArrayIndexOutOfBoundsException e) {
            Int = new VInt(arr[1]);
        }

        Variables.put(Int.name, Int);
    }

    private void foundFloat(String line) {
        VFloat Float; String[] arr;

        arr = line.split(" ");
        try {
            Float = new VFloat(arr[1], parseFloat(arr[3]));
        } catch (ArrayIndexOutOfBoundsException e) {
            Float = new VFloat(arr[1]);
        }

        Variables.put(Float.name, Float);
    }

    private void foundDouble(String line) {
        VDouble Double; String[] arr;

        arr = line.split(" ");
        try {
            Double = new VDouble(arr[1], parseDouble(arr[3]));
        } catch (ArrayIndexOutOfBoundsException e) {
            Double = new VDouble(arr[1]);
        }

        Variables.put(Double.name, Double);
    }

    private void foundString(String line) {
        VString String; String[] arr;

        arr = line.split(" ");
        try {
            String = new VString(arr[1], arr[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            String = new VString(arr[1]);
        }

        Variables.put(String.name, String);
    }

    public void setCodigoFonte(StringBuilder codigoFonte) {
        this.codigoFonte = codigoFonte.toString().split("\n");
    }
}
