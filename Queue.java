public class Queue<Item>  {
    private int n;         // quantidade de elementos na queue
    private Node first;    // cabeça da queue
    private Node last;     // fim da queue

    private class Node {
        private Item item;
        private Node next;
    }
    public Queue() {
        first = null;
        last  = null;
        n = 0;
    }
    public boolean isEmpty(){return first == null;}
    public int size()   {return n;}
    public int length() {return n;}
    public Item peek() {
        if (isEmpty()) return null;
        return first.item;
    }
    public void add(Item item) {
        if(item==null) return;
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else           oldlast.next = last;
        n++;
    }
    public Item remove(){
        if (isEmpty()) return null;
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) last = null;
        return item;
    }
}