

public class Message
{
    private String InputStr;
    private char[] CharArray;

    public Message(String str)
    {
        InputStr = str;
        CharArray = str.toCharArray();
    }

    public int CountWords()
    {
        return InputStr.split(" ").length;
    }

    public String Reverse()
    {
        return new StringBuilder().append(InputStr).reverse().toString();
    }

    public int Count(char c)
    {
        var count = 0;
        for (char element : CharArray)
        {
            if(element == c)
                count++;
        }
        return count;
    }

    public String Seria()
    {
        var words = InputStr.split(" ");
        for (int i = 0; i < words.length; i++)
        {
            if(words[i].toLowerCase().equals("серия") && i+1<words.length)
                return words[i+1];
        }
        return "Серия отсутствует";
    }

    public String Nomer()
    {
        var words = InputStr.split(" ");
        for (int i = 0; i < words.length; i++)
        {
            var word = words[i];
            if(word.length() == 1 && word.equals("№")  && i+1<words.length)
                return words[i+1];
            if(word.length() >1 && word.charAt(0) == '№')
                return word.substring(1);
        }
        return "Номер отсутствует";
    }// возвращает номер (номер находится после №, но после № может пробела и не быть)
}
