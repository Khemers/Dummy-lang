package fonte;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Parser{
    public static int LinhaAtual;
    protected Map<String, Variavel> variaveis;

    public static void main(String[] args) {
        String[] oi = new String[3];
        oi[0] = "string a";
        oi[1] = "scan(a)";
        oi[2] = "print('kkkkk\n{} {} jjjjj\n', 6.666, a )";

        Parser alo = new Parser();
        alo.ParseLinhas(oi);

}

Parser(){
    this.variaveis = new HashMap<>();
    LinhaAtual = 1;
}


