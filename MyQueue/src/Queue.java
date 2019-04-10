public class Queue<TItem> {
    private QueueItem<TItem> head;
    private QueueItem<TItem> tail;
    private int size = 0;

    public int getSize() {
        return size;
    }

    public void enqueue(TItem item) {
        var qItem = new QueueItem<TItem>();
        qItem.setItem(item);
        if (head == null)
            head = qItem;
        else
            tail.setNext(qItem);
        tail = qItem;
        size++;
    }

    public TItem dequeue() {
        if (size == 0)
            return null;
        var result = head.item;
        head = head.getNext();
        size--;
        return result;
    }

    public TItem getItem(int index) {
        if (size == 0 || index >= size || index < 0)
            return null;
        var qItem = head;
        for (int i = 0; i < index; i++) {
            qItem = qItem.getNext();
        }
        return qItem.getItem();
    }


    private class QueueItem<TItem> {
        private TItem item;
        private QueueItem<TItem> next;

        public TItem getItem() {
            return item;
        }

        public void setItem(TItem item) {
            this.item = item;
        }

        public QueueItem<TItem> getNext() {
            return next;
        }

        public void setNext(QueueItem<TItem> next) {
            this.next = next;
        }
    }
}
