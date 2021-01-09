public class Main {
    public static void main(String[] args) {

        String fileName = args[0];
        Scan File = new Scan();
        Parser parser = new Parser();
        File.readFile(fileName);
        parser.parseLines(File.lines);
    }
}
