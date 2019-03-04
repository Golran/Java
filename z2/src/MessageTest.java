import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MessageTest {

    @Test
    public void countWords()
    {
        var message = new Message("Я люблю программировать");
        var result = message.CountWords();
        assertEquals(3,result);
    }

    @Test
    public void reverse()
    {
        var message = new Message("Абра кадабра");
        var result = message.Reverse();
        assertEquals("арбадак арбА",result);
    }

    @Test
    public void count()
    {
        var message = new Message("Я люблю программировать");
        var result = message.Count('м');
        assertEquals(2,result);
    }

    @Test
    public void upperCaseSeries()
    {
        var result = new Message("Имеем игру сЕриЯ 123");

        assertEquals("123",result.Seria());
    }

    @Test
    public void SeriesIsMissingSeries()
    {
        var result = new Message("Имеем игру серия ");

        assertEquals("Серия отсутствует",result.Seria());
    }


    @Test
    public void NomerIsMissing()
    {
        var result = new Message("Имеем игру №");

        assertEquals("Номер отсутствует",result.Nomer());
    }

    @Test
    public void numberWithSpace()
    {
        var result = new Message("Имеем игру № 12");

        assertEquals("12",result.Nomer());
    }

    @Test
    public void numberWithOutSpace()
    {
        var result = new Message("Имеем игру №12");

        assertEquals("12",result.Nomer());
    }
}