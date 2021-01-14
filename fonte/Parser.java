import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import static java.lang.Double.parseDouble;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

public class Parser {
    public static int atualLinha;
    public String[] codigoFonte;
    protected Map<String, Variable> Variables;
 
    Parser(StringBuilder codigoFonte) {
        this.Variables = new HashMap<> ();

        setCodigoFonte(codigoFonte);
        parseLines(this.codigoFonte);
    }

    Parser(){
        this.Variables = new HashMap<>();
        atualLinha = 1;
    }

    Parser(Map<String, Variable> Variables){
        this.Variables = new HashMap<>();
        this.Variables.putAll(Variables);
    }

    public void parseLines(String[] line) {
        for (int i = 0; i < line.length ; i++) {

            if (Pattern.compile("^\\s*int\\s").matcher(line[i]).find()) {
                foundInt(line[i]);
            } else if (Pattern.compile("^\\s*float\\s").matcher(line[i]).find()) {
                foundFloat(line[i]);
            } else if (Pattern.compile("^\\s*double\\s").matcher(line[i]).find()) {
                foundDouble(line[i]);
            } else if (Pattern.compile("^\\s*string\\s").matcher(line[i]).find()) {
                foundString(line[i]);
            } else if (Pattern.compile("^\\s*println[\\s]*[(]").matcher(line[i]).find()) {
                foundPrintLn(line[i]);
            } else if (Pattern.compile("^\\s*print[\\s]*[(]").matcher(line[i]).find()) {
                foundPrint(line[i]);
            } else if(Pattern.compile("^\\s*if[\\s]*[(]").matcher(line[i]).find()) {
                i = foundIf(line[i], i);  
            } else {
                foundAssignment(line[i]);
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
            String = new VString(arr[1], arr[3].replace('"', Character.MIN_VALUE));
        } catch (ArrayIndexOutOfBoundsException e) {
            String = new VString(arr[1]);
        }

        Variables.put(String.name, String);
    }

    private void foundPrint(String line) {
        String print = line.replace('(', Character.MIN_VALUE).replaceAll("print", String.valueOf(Character.MIN_VALUE)).replace(')', Character.MIN_VALUE);
        String[] strings = print.split(",");

        for (String string : strings) {

            if (string.contains("'")) {
                System.out.print(string.replace('\'', Character.MIN_VALUE));
            } else {
                System.out.print(Variables.get(string.trim()).getValue());
            }
        }
    }

    private void foundPrintLn(String line) {
        String print = line.replace('(', Character.MIN_VALUE).replaceAll("println", String.valueOf(Character.MIN_VALUE)).replace(')', Character.MIN_VALUE);
        String[] strings = print.split(",");

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
    
    private int foundIf(String line[], int positionLine) {
        Parser newParser = new Parser(Variables);
        int contadordeIf = 1;
        String condition =  conteudoParenteses(line[positionLine]);
        String [] parseToIf = new String[0];
        String [] parseToElse = new String[0];

        boolean buscadordeElse = false;
        
        while(contadordeIf > 0){
            positionLine++;
        }

        if(!buscadordeElse){
            parseToIf = Util.appendArray(parseToIf.length, parseToIf, line[positionLine]);
        }
        else{
            parseToElse = Util.appendArray(parseToElse.length, parseToElse, line[positionLine]);
        }
        if(Pattern.compile("^\\s*else[\\s]*$").matcher(line[positionLine]).find() && contadordeIf == 1){
            buscadordeElse = true;
        }
        if(Pattern.compile("^\\s*endif[\\s]*$").matcher(line[positionLine]).find()){
            contadordeIf--;
        }
        else if(Pattern.compile("^\\s*if[\\s]*[(]").matcher(line[positionLine]).find()){
            contadordeIf++;
        }
    }


    private String conteudoParenteses(String line) {
        int primeiroParenteses = line.indexOf("(");
        int ultimoParenteses = line.lastIndexOf(")");

        String entreParenteses = line.substring(primeiroParenteses+1,ultimoParenteses);
        return entreParenteses.replaceAll("\\s+", " ").trim();
    }

    public void setCodigoFonte(StringBuilder codigoFonte) {
        this.codigoFonte = codigoFonte.toString().split("\n");
    }
}
