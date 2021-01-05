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

public void ParseLinhas(String [] linhas){
    for(int i = 0; i < linhas.length; i ++);
    
    //faz a verificação se é int
    if(linhas[i].indexOf("int") != -1){
        trataInt(linhas[i]);
    }
    
    //verifica se é float
    else if(linhas[i].indexOf("float") != -1){
        trataFloat(linhas[i]);
    }

    //verifica se é double
    else if(linhas[i].indexOf("double") != -1){
        trataDouble(linhas[i]);
    }

    //verifica se é scan
    else if(linhas[i].indexOf("scan") != -1){
        trataScan(linhas[i]);
    }

    //verifica se é print
    else if(linhas[i].indexOf("print") != -1){
        trataPrint(linhas[i]);
    }
}