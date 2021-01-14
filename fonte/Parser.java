import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
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
            } else if (Pattern.compile("^\\s*float\\s").matcher(line).find()) {
                foundFloat(line);
            } else if (Pattern.compile("^\\s*double\\s").matcher(line).find()) {
                foundDouble(line);
            } else if (Pattern.compile("^\\s*string\\s").matcher(line).find()) {
                foundString(line);
            } else if (Pattern.compile("^\\s*boolean\\s").matcher(line).find()) {
                foundBoolean(line);
            } else if (Pattern.compile("^\\s*println[\\s]*[(]").matcher(line).find()) {
                foundPrintLn(line);
            } else if (Pattern.compile("^\\s*print[\\s]*[(]").matcher(line).find()) {
                foundPrint(line);
            } else if(Pattern.compile("^\\s*input[\\s]*[(]").matcher(line).find()) {
                foundInput(line);
            } else {
                foundAssignment(line);
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
        int indexOfEqual = 0;

        arr = line.split(" ");

        for (int i = 0; i <= arr.length; i++) {
            if (arr[i].equals("=")) {
                indexOfEqual = i;
                break;
            }
        }

        StringBuilder str = new StringBuilder();
        for (int x = indexOfEqual + 1; x <= arr.length - 1; x++) {
            str.append(arr[x]).append(" ");
        }
        String = new VString(arr[1], str.toString().replace("'", ""));

        Variables.put(String.name, String);
    }

    private void foundBoolean(String line) {
        //TODO
    }

    private void foundPrint(String line) {
        line = line.substring(6).replace(')', Character.MIN_VALUE);
        String[] strings = line.split(",");

        for (String string : strings) {

            if (string.contains("'")) {
                System.out.print(string.replace('\'', Character.MIN_VALUE));
            } else {
                System.out.print(Variables.get(string.trim()).getValue());
            }
        }
    }

    private void foundPrintLn(String line) {
        line = line.substring(8).replace(')', Character.MIN_VALUE);
        String[] strings = line.split(",");

        for (String string : strings) {

            if (string.contains("'")) {
                System.out.println(string.replace('\'', Character.MIN_VALUE));
            } else {
                System.out.println(Variables.get(string.trim()).getValue());
            }
        }
    }

    private void foundAssignment(String line) {
        String[] s;

        if (line.contains("=")) {
            s = line.split(" ");

            if (line.contains("+")) {
                if (Variables.containsKey(s[2]) && Variables.containsKey(s[4])) {
                    Variables.get(s[0]).setValue(Variables.get(s[2]).sum(Variables.get(s[4]).getValue().toString()));
                } else if (Variables.containsKey(s[4])) {
                    Variables.get(s[0]).setValue(Variables.get(s[4]).sum(s[2]));
                } else if (Variables.containsKey(s[2])) {
                    Variables.get(s[0]).setValue(Variables.get(s[2]).sum(s[4]));
                }
            } else {
                Variables.get(s[0]).setValue(Variables.get(s[2]).getValue());
            }
            if (Variables.get(s[0]).getValue().toString().contains("'")) {
                Variables.get(s[0]).setValue(Variables.get(s[0]).getValue().toString().replace('\'', Character.MIN_VALUE));
            }
        }
    }

    private void foundInput(String line) {
        line = line.substring(6).replace(')', Character.MIN_VALUE);

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();

        Variables.get(line.trim()).setInputValue(input);
    }
    
    public void setCodigoFonte(StringBuilder codigoFonte) {
        this.codigoFonte = codigoFonte.toString().split("\n");
    }
}
