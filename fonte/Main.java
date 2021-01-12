import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        int lines = 0;

        Scanner file = new Scanner(Paths.get(args[0]));
        StringBuilder code = new StringBuilder();

        while (file.hasNextLine()) {
            code.append(file.nextLine());
            code.append("\n");
            lines++;
        }

        Parser p = new Parser(code, lines);
    }
}
