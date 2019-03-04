import java.util.Scanner;
public class Test {

    public static void main(String[] args)
    {
        var sc = new Scanner(System.in);
        System.out.println("Введите сообщение ");
        var input = sc.nextLine();
        var message = new Message(input);
        System.out.println("В сообщении " + message.CountWords() + " слов");
        System.out.println("В сообщении " + message.Count('м') + " букв м");
        System.out.println("Перевёрнутое сообщение выглядит вот так: " + message.Reverse());
        System.out.println("В сообщении задана серия: " + message.Seria());
        System.out.println("В сообщении задан номер: " + message.Nomer());
    }

}
