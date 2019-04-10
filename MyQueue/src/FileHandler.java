import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class FileHandler {

    public static void main(String[] arg) {
        var result = new ArrayList<String>();
        var text = ReadFile();
        for (String line : text) {
            result.add(processLine(line));
        }
        writeFile(result);

    }

    private static String processLine(String line) {
        var words = line.split(" ");
        var queuWord = new Queue<String>();
        var queuNumber = new Queue<String>();
        for (String word : words) {
            if (word.chars().allMatch(Character::isDigit))
                queuNumber.enqueue(word);
            else
                queuWord.enqueue(word);
        }
        var result = new StringBuilder();
        var countWords = queuWord.getSize();
        for (int i = 0; i < countWords; i++) {
            result.append(queuWord.dequeue());
            result.append(" ");
        }
        var countNumbers = queuNumber.getSize();
        for (int i = 0; i < countNumbers; i++) {
            result.append(queuNumber.dequeue());
            result.append(" ");
        }
        return result.toString();

    }

    private static ArrayList<String> ReadFile() {
        var text = new ArrayList<String>();
        try {
            var karlAndKlara = new FileReader("src/z4.txt");
            var reader = new BufferedReader(karlAndKlara);
            var line = "";
            while ((line = reader.readLine()) != null)
                text.add(line);
            reader.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return text;
    }

    private static void writeFile(ArrayList<String> processLine) {
        try {
            var writer = new FileWriter("src/result.txt");
            for (String line : processLine) {
                writer.write(line + '\n');
            }
            writer.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
