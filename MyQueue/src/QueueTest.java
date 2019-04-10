public class QueueTest
{
    public static void main(String[] arg)
    {
        var queue = new Queue<String>();

        for(int i=0; i<10; i++)
            queue.enqueue("Строка:" + i);
        for (int i=0; i<queue.getSize(); i++)
        {
            var s = queue.getItem(i);
            System.out.println(s);
            System.out.println("Размер очереди:" + queue.getSize());
        }
        while (queue.getSize() > 0)
        {
            var s = queue.dequeue();
            System.out.println(s);
            System.out.println("Размер очереди:" + queue.getSize());
        }
    }
}