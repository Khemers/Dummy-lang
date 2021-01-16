import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

import static java.lang.Double.parseDouble;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import static java.lang.Boolean.parseBoolean;

public class Parser {

    public String[] codigoFonte;
    protected static Map<String, Variable> Variables;

    Parser(StringBuilder codigoFonte) {
        Variables = new HashMap<> ();

        setCodigoFonte(codigoFonte);
        parseLines(this.codigoFonte);
    }

    public static void parseLines(String[] lines) {
        for (int i = 0; i < lines.length; i++) {

            if (Pattern.compile("^\\s*int\\s").matcher(lines[i]).find()) {
                foundInt(lines[i]);
            } else if (Pattern.compile("^\\s*float\\s").matcher(lines[i]).find()) {
                foundFloat(lines[i]);
            } else if (Pattern.compile("^\\s*double\\s").matcher(lines[i]).find()) {
                foundDouble(lines[i]);
            } else if (Pattern.compile("^\\s*string\\s").matcher(lines[i]).find()) {
                foundString(lines[i]);
            } else if (Pattern.compile("^\\s*boolean\\s").matcher(lines[i]).find()) {
                foundBoolean(lines[i]);
            } else if (Pattern.compile("^\\s*println[\\s]*[(]").matcher(lines[i]).find()) {
                foundPrintLn(lines[i]);
            } else if (Pattern.compile("^\\s*print[\\s]*[(]").matcher(lines[i]).find()) {
                foundPrint(lines[i]);
            } else if(Pattern.compile("^\\s*input[\\s]*[(]").matcher(lines[i]).find()) {
                foundInput(lines[i]);
            } else if(Pattern.compile("^\\s*if[\\s]*[(]").matcher(lines[i]).find()) {
                i = foundIf(lines, i);
            } else if(Pattern.compile("^\\s*while[\\s]*[(]").matcher(lines[i]).find()) {
                i = foundWhile(lines, i);
            } else {
                foundAssignment(lines[i]);
            }
        }
    }

    private static void foundInt(String line) {
        VInt Int; String[] arr;

        arr = line.substring(line.indexOf("i")).split(" ");
        try {
            Int = new VInt(arr[1], parseInt(arr[3]));
        } catch (ArrayIndexOutOfBoundsException e) {
            Int = new VInt(arr[1]);
        }

        Variables.put(Int.name, Int);
    }

    private static void foundFloat(String line) {
        VFloat Float; String[] arr;

        arr = line.substring(line.indexOf("f")).split(" ");
        try {
            Float = new VFloat(arr[1], parseFloat(arr[3]));
        } catch (ArrayIndexOutOfBoundsException e) {
            Float = new VFloat(arr[1]);
        }

        Variables.put(Float.name, Float);
    }

    private static void foundDouble(String line) {
        VDouble Double; String[] arr;

        arr = line.substring(line.indexOf("d")).split(" ");
        try {
            Double = new VDouble(arr[1], parseDouble(arr[3]));
        } catch (ArrayIndexOutOfBoundsException e) {
            Double = new VDouble(arr[1]);
        }

        Variables.put(Double.name, Double);
    }

    private static void foundString(String line) {
        VString String; String[] arr;
        int indexOfEqual = 0;

        arr = line.substring(line.indexOf("s")).split(" ");

        if (arr.length == 2) {
            String = new VString(arr[1]);
            Variables.put(String.name, String);
            return;
        }

        for (int i = 0; i <= arr.length; i++) {
            if (arr[i].equals("=")) {
                indexOfEqual = i;
                break;
            }
        }

        StringBuilder str = new StringBuilder();
        str.append(arr[indexOfEqual + 1]);
        for (int x = indexOfEqual + 2; x <= arr.length - 1; x++) {
            str.append(" ").append(arr[x]);
        }
        String = new VString(arr[1], str.toString().replace("'", ""));

        Variables.put(String.name, String);
    }

    private static void foundBoolean(String line) {
        VBoolean Boolean; String[] arr;

        arr = line.substring(line.indexOf("b")).split(" ");
        try {
            Boolean = new VBoolean(arr[1], parseBoolean(arr[3]));
        } catch (ArrayIndexOutOfBoundsException e) {
            Boolean = new VBoolean(arr[1]);
        }

        Variables.put(Boolean.name, Boolean);
    }

    private static void foundPrint(String line) {
        line = line.substring(line.indexOf("(") + 1).replace(')', Character.MIN_VALUE);
        String[] strings = line.split(",");

        for (String string : strings) {

            if (string.contains("'")) {
                System.out.print(string.replace('\'', Character.MIN_VALUE));
            } else if (Variables.containsKey(string.trim())) {
                System.out.print(Variables.get(string.trim()).getValue());
            } else {
                System.out.print(string);
            }
        }
    }

    private static void foundPrintLn(String line) {
        line = line.substring(line.indexOf("(") + 1).replace(')', Character.MIN_VALUE);
        String[] strings = line.split(",");

        for (String string : strings) {

            if (string.contains("'")) {
                System.out.println(string.replace('\'', Character.MIN_VALUE));
            } else if (Variables.containsKey(string.trim())) {
                System.out.println(Variables.get(string.trim()).getValue());
            } else {
                System.out.println(string);
            }
        }
    }

    private static int foundIf(String[] lines, int currentLine) {
        String line; int endIfLine = 0;
        line = lines[currentLine].trim().substring(3).replace(')', Character.MIN_VALUE);

        int countIf = 0; int countEndIf = 0; int z = 0;
        int[] endIfLines = new int[lines.length];
        for (int i = currentLine; i < lines.length; i++) {
            if (lines[i].contains("endif")) {
                countEndIf++;
                endIfLines[z] = i;
                z++;
                if (countIf == 1) {
                    endIfLine = i;
                    break;
                } else if ((countEndIf - countIf) == 0) {
                    endIfLine = endIfLines[z - 1];
                    break;
                }
            } else if (lines[i].contains("if")) {
                countIf++;
            }
        }

        return Operations.parse(Variables, lines, line, currentLine, endIfLine, "if");
    }

    private static int foundWhile(String[] lines, int currentLine) {
        String line; int endWhileLine = 0;
        line = lines[currentLine].trim().substring(6).replace(')', Character.MIN_VALUE);

        int countWhile = 0; int countEndWhile = 0; int z = 0;
        int[] endWhileLines = new int[lines.length];
        for (int i = currentLine; i < lines.length; i++) {
            if (lines[i].contains("endwhile")) {
                countEndWhile++;
                endWhileLines[z] = i;
                z++;
                if (countWhile == 1) {
                    endWhileLine = i;
                    break;
                } else if ((countEndWhile - countWhile) == 0) {
                    endWhileLine = endWhileLines[z - 1];
                    break;
                }
            } else if (lines[i].contains("while")) {
                countWhile++;
            }
        }

        return Operations.parse(Variables, lines, line, currentLine, endWhileLine, "while");
    }

    private static void foundAssignment(String line) {
        String[] s;

        if (line.contains("=")) {
            s = line.trim().split(" ");

            if (line.contains("+")) {
                if (Variables.containsKey(s[2]) && Variables.containsKey(s[4])) {
                    Variables.get(s[0]).setValue(Variables.get(s[2]).sum(Variables.get(s[4]).getValue().toString()).toString());
                } else if (Variables.containsKey(s[4])) {
                    Variables.get(s[0]).setValue(Variables.get(s[4]).sum(s[2]).toString());
                } else if (Variables.containsKey(s[2])) {
                    Variables.get(s[0]).setValue(Variables.get(s[2]).sum(s[4]).toString());
                } else {
                    Math.sum(Variables.get(s[0]), s[2], s[4]);
                }
            }
            else if (line.contains("-") && s.length > 3) {
                if (Variables.containsKey(s[2]) && Variables.containsKey(s[4])) {
                    Variables.get(s[0]).setValue(Variables.get(s[2]).sub(Variables.get(s[4]).getValue().toString()).toString());
                } else if (Variables.containsKey(s[4])) {
                    Variables.get(s[0]).setValue(Variables.get(s[4]).sub(s[2]).toString());
                } else if (Variables.containsKey(s[2])) {
                    Variables.get(s[0]).setValue(Variables.get(s[2]).sub(s[4]).toString());
                } else {
                    Math.sub(Variables.get(s[0]), s[2], s[4]);
                }
            }
            else if (line.contains("*")) {
                if (Variables.containsKey(s[2]) && Variables.containsKey(s[4])) {
                    Variables.get(s[0]).setValue(Variables.get(s[2]).mult(Variables.get(s[4]).getValue().toString()).toString());
                } else if (Variables.containsKey(s[4])) {
                    Variables.get(s[0]).setValue(Variables.get(s[4]).mult(s[2]).toString());
                } else if (Variables.containsKey(s[2])) {
                    Variables.get(s[0]).setValue(Variables.get(s[2]).mult(s[4]).toString());
                } else {
                    Math.mult(Variables.get(s[0]), s[2], s[4]);
                }
            }
            else if (line.contains("/")) {
                if (Variables.containsKey(s[2]) && Variables.containsKey(s[4])) {
                    Variables.get(s[0]).setValue(Variables.get(s[2]).div(Variables.get(s[4]).getValue().toString()).toString());
                } else if (Variables.containsKey(s[4])) {
                    Variables.get(s[0]).setValue(Variables.get(s[4]).div(s[2]).toString());
                } else if (Variables.containsKey(s[2])) {
                    Variables.get(s[0]).setValue(Variables.get(s[2]).div(s[4]).toString());
                } else {
                    Math.div(Variables.get(s[0]), s[2], s[4]);
                }
            }else if (line.contains("%")) {
                if (Variables.containsKey(s[2]) && Variables.containsKey(s[4])) {
                    Variables.get(s[0]).setValue(Variables.get(s[2]).rest(Variables.get(s[4]).getValue().toString()).toString());
                } else if (Variables.containsKey(s[4])) {
                    Variables.get(s[0]).setValue(Variables.get(s[4]).rest(s[2]).toString());
                } else if (Variables.containsKey(s[2])) {
                    Variables.get(s[0]).setValue(Variables.get(s[2]).rest(s[4]).toString());
                } else {
                    Math.rest(Variables.get(s[0]), s[2], s[4]);
                }
            }
            else {
                if (Variables.containsKey(s[2])) {
                    Variables.get(s[0]).setValue(Variables.get(s[2]).getValue().toString());
                } else {
                    Variables.get(s[0]).setValue(s[2]);
                }
            }
            if (Variables.get(s[0]).getValue().toString().contains("'")) {
                Variables.get(s[0]).setValue(Variables.get(s[0]).getValue().toString().replace('\'', Character.MIN_VALUE));
            }
        }
    }

    private static void foundInput(String line) {
        line = line.trim().substring(6).replace(')', Character.MIN_VALUE);

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        Variables.get(line.trim()).setValue(input);
    }
    
    public void setCodigoFonte(StringBuilder codigoFonte) {
        this.codigoFonte = codigoFonte.toString().split("\n");
    }
}
