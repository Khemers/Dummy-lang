import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

public class Parser {

    public String[] codigoFonte;
    protected Map<String, Variable> Variables;
 
    Parser(StringBuilder codigoFonte) {
        setCodigoFonte(codigoFonte);
        parseLines(this.codigoFonte);

        this.Variables = new HashMap<>();
    }

    public void parseLines(String[] lines) {
        for (int i = 0; i < lines.length; i++) {
            if (Pattern.compile("^\\s*int\\s").matcher(lines[i]).find()) {
                foundInt(lines[i]);
            }
            if (Pattern.compile("^\\s*float\\s").matcher(lines[i]).find()) {
                foundFloat(lines[i]);
            }
        }
    }

    private void foundInt(String line) {
        VInt integer; String[] arr;

        arr = line.split(" ");
        integer = new VInt(arr[1], parseInt(arr[3]));

        Variables.put(integer.name, integer);
    }

    private void foundFloat(String line) {
        VFloat floating; String[] arr;

        arr = line.split(" ");
        floating = new VFloat(arr[1], parseFloat(arr[3]));

        Variables.put(floating.name, floating);
    }

    public void setCodigoFonte(StringBuilder codigoFonte) {
        this.codigoFonte = codigoFonte.toString().split("\n");
    }
}
