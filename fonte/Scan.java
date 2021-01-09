import java.io.File;
import java.util.Scanner;

public class Scan {
    String[] lines;

    public void readFile(String fileName){
        try {
            this.lines = new String[0];
            File file = new File(fileName);
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                String line = input.nextLine();
                this.lines = Util.appendArray(this.lines.length, this.lines, line);
            }
            input.close();
        } catch (Exception e) {
            System.out.println("Nao foi possivel abrir o arquivo "+fileName);
            e.printStackTrace();
        }
    }
}