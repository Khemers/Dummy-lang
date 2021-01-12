import java.util.regex.Pattern;
//import java.util.regex.Matcher;

public class Parser {

    public String[] codigoFonte;
 
    public Parser(StringBuilder codigoFonte, int lines) {
        setCodigoFonte(codigoFonte);
        parseLines(this.codigoFonte, lines);
    }

    public void parseLines(String[] lines, int size) {
        for (int i = 0; i < size; i++) {
            if (Pattern.compile("^\\s*int\\s").matcher(lines[i]).find()) {
                foundInt(lines[i]);
            }
            System.out.println(lines[i]);
        }
    }





    private void foundInt(String line) {

    }

    public void setCodigoFonte(StringBuilder codigoFonte) {
        String[] codigo;

        codigo = codigoFonte.toString().split("\n");
        this.codigoFonte = codigo;
    }
}
