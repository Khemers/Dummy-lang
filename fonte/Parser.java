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
    for(int i = 0; i < linhas.length; i ++) {
    
    //faz a verificação se é int
        if(linhas[i].indexOf("int") != -1){
            trataInt(linhas[i]);
        }
    
    //faz a verificação se é float
        else if(linhas[i].indexOf("float") != -1){
            trataFloat(linhas[i]);
        }

    //faz a verificação se é double
        else if(linhas[i].indexOf("double") != -1){
            trataDouble(linhas[i]);
        }

    //faz a verificação se é scan
        else if(linhas[i].indexOf("scan") != -1){
            trataScan(linhas[i]);
        }

    //faz a verificação se é print
        else if(linhas[i].indexOf("print") != -1){
            trataPrint(linhas[i]);
        }

        else{
            String concatenaLinha = "";
            int equivalePosicao = linhas[i].indexOf("=");
            String [] preEquivalencia = Util.lineInWordArray(linhas[i].substring(0, equivalePosicao));
            Variavel busca = this.variaveis.get(preEquivalencia[0]);

            if(busca == null){
                System.out.println("A variável não foi encontrada!");
                return;
            }

            else{
                if(equivalePosicao != -1){
                    String[] posEquivalencia = Util.lineInWordArray(linhas[i].substring(equivalePosicao+1, linhas[i].length()));
                    for(int j = 0 ; j < posEquivalencia.length ; j++){
                        concatenaLinha = concatenaLinha.concat(posEquivalencia[j]);
                    }

                    if(busca.type.equals("int")){
                        int value = (int) Operation.chooseOperation(concatenaLinha, "int");
                        busca.setValue(value);
                    }

                    else if(busca.type.equals("float")){
                        float value = (float) Operation.chooseOperation(concatenaLinha, "float");
                        busca.setValue(value);
                    }

                    else if(busca.type.equals("double")){
                        double value = (double) Operation.chooseOperation(concatenaLinha, "double");
                        busca.setValue(value);
                    }
                }
            }
        }
    }
}

private void trataInt(String linha){
    VariavelInt integer;
    String concatenaLinha = "";
    int equivalePosicao = linha.indexOf("=");
    String [] preEquivalencia = Util.lineInWordArray(linha);

    if(equivalePosicao != -1){
        preEquivalencia = Util.lineInWordArray(linha.substring(0, equivalePosicao));
        String[] posEquivalencia = Util.lineInWordArray(linha.substring(equivalePosicao+1, linha.length()));
        for(int j = 0 ; j < posEquivalencia.length ; j++){
            concatenaLinha = concatenaLinha.concat(posEquivalencia[j]);
        }

        int value = (int) Operation.chooseOperation(concatLine, "int");
        integer = new VariavelInt(preEquivalencia[1], value);
    }

    else{
        integer = new VariavelInt(preEquivalencia[1]);
    }
    variaveis.put(integer.nome, integer);
}

private void trataFloat(String linha){
    VariavelFloat pfloat;
    String concatenaLinha = "";
    int equivalePosicao = linha.indexOf("=");
    String [] preEquivalencia = Util.lineInWordArray(linha);

    if(equivalePosicao != -1){
        preEquivalencia = Util.lineInWordArray(linha.substring(0, equivalePosicao));
        String[] posEquivalencia = Util.lineInWordArray(linha.substring(equivalePosicao+1, linha.length()));
        for (int j = 0 ; j < posEquivalencia.length ; j++){
            concatenaLinha = concatenaLinha.concat(posEquivalencia[j]);
        }

        float value = (float) Operation.chooseOperation(concatenaLinha, "float");
        pfloat = new VariavelFloat(preEquivalencia[1], value);
    }

    else{
        pfloat = new VariavelFloat(preEquivalencia[1]);
    }
    variaveis.put(pfloat.nome, pfloat);
}

private void trataDouble(String linha){
    VariavelDouble pfloat;
    String concatenaLinha = "";
    int equivalePosicao = linha.indexOf("=");
    String [] preEquivalencia = Util.lineInWordArray(linha);

    if(equivalePosicao != -1){
        preEquivalencia = Util.lineInWordArray(linha.substring(0, equivalePosicao));
        String [] posEquivalencia = Util.lineInWordArray(linha.substring(equivalePosicao+1, linha.length()));
        for(int j = 0 ; j < posEquivalencia.length ; j++{
            concatenaLinha = concatenaLinha.concat(posEquivalencia[j]);
        }

        double value = (double) Operation.chooseOperation(concatenaLinha, "double");
        pfloat = new VariavelDouble(preEquivalencia[1], value);
    }

    else{
        pfloat = new VariavelDouble(preEquivalencia[1]);
    }
    variaveis.put(pfloat.nome, pfloat);
}

private void trataScan(String linha){
    String variavel = linha.substring(linha.indexOf("(")+1, linha.indexOf(")"));
    if(variaveis.containsKey(variavel)){
        Scanner scan = new Scanner(System.in);
            String lineScan = scan.nextLine();
            scan.close();
    
            if (variaveis.get(variavel).type.equals("int")){
                variaveis.get(variavel).setValue(Integer.parseInt(lineScan));
            }
        
            else if (variaveis.get(variavel).type.equals("float")){
                variaveis.get(variavel).setValue(Float.parseFloat(lineScan));
            }

            else if (variaveis.get(variavel).type.equals("double")){
                variaveis.get(variavel).setValue(Double.parseDouble(lineScan));
            }

            else{
                variaveis.get(variavel).setValue(lineScan);
            }
        }

        else{
            System.out.println("Variável não encontrada");
            System.exit(0);
        }
    }
}

private void trataPrint(String linha){
    if(linha.indexOf("(") != -1 && linha.indexOf(")") != -1 ){
        int primeiro = linha.indexOf("'");
        int segundo = linha.indexOf("'", primeiro+1);
        String inQuotes = linha.substring(primeiro+1, segundo);
        
        if(inQuotes.indexOf("{}") != -1){
            if(linha.indexOf(",", segundo) == -1){
                System.out.println("Não foram encontradas variáveis para serem impressas");
                System.exit(0);
            }
            String [] inComma = (linha.substring(linha.indexOf(",", segundo), linha.length()-1)).split(",");
            
            for(int j = 1; j < inComma.length; j++){
                inComma[j] = inComma[j].trim();
            }

            for(int k = 1; k < inComma.length; k++){
                if(inQuotes.indexOf("{}") != -1){

                    if(variaveis.containsKey(inComma[k])){
                        inComma[k] = (variaveis.get(inComma[k]).getValue()).toString();
                    }
                    
                    if(inComma[k].indexOf(".") != -1){
                        inQuotes = inQuotes.replaceFirst("\\{}", Operation.chooseOperation(inComma[k], "double").toString());
                    
                    } 
                    
                    else {
                        inQuotes = inQuotes.replaceFirst("\\{}", Operation.chooseOperation(inComma[k], "int").toString());
                    }
                }
                
                else{
                    System.out.println("Não foi possível imprimir");
                    System.exit(0);
                }
            }
        }
        inQuotes = inQuotes.replace("\\n", "\n");
        System.out.printf(inQuotes);
    } 
}