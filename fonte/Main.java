public class Main {
    public static void main(String[] args) {

        String fileName = args[0];
        Scan Teste = new Scan();
        Parser parser = new Parser();
        Teste.readFile(fileName);
        parser.parseLines(Teste.lines);
    }
}
