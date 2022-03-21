public class Example {
    public static void main(String[] args) {
        List l = new List();
         int index, temp;
        index = 3;
        temp = 25;
        
        for (int i = 0; i < 3; i++) {
            l.add(i);
        }
        
        l.add(index, temp);
        
        l.get(index);
        System.out.println("-------------/// " + l.getTotal());
        l.getAll();
        
        l.remove(0);
        System.out.println("-------------/// " + l.getTotal());
         l.getAll();
         
         l.remove(1);
         l.add(2, 23);
        System.out.println("-------------/// " + l.getTotal());
         l.getAll();
    }
}

class List {
    Node first;
    static int counter;
    
    public List() {
        counter = 0;
    }
    
    // Counter Getters / setters
    public int getTotal() {
        return counter;
    }
    public void cAdd() {
        counter++;
    }
    public void cRm() {
        counter--;
    }
    
    // Code
    public void add(int value) {
        Node temp = new Node(value);
        
        if (first == null) {
            first = temp;
        } else {
            Node temp02 = first;
            while (temp02.getNext() != null) {            
                temp02 = temp02.getNext();
            }
            temp02.setNext(temp);
        }
        // Increment
        cAdd();
    }
    public void add(int index, int value) {
        Node temp = new Node(value);
        
        if(index == 0) {
            temp.setNext(first);
            first = temp;
        } 
        if (first == null && (index > 0 || index < 0)) return;
        if (index < 0) return;

        if(index > getTotal() && index == getTotal() + 1) { add(value); return; }
        
        Node temp02 = first;
        Node old = null;
        for (int i = 0; i <= index && temp02.getNext() != null; i++) {
            old = temp02;
            temp02 = temp02.getNext();
        }
        
        temp02.setNext(temp);
        old.setNext(temp02);
        
        // Increment
        cAdd();
    }
    
    public Node get(int index) {
        if (first == null && (index > 0 || index < 0)) return null;
        if (index < 0) return null;
        
        Node temp02 = first;
        for (int i = 0; i < index && temp02.getNext() != null; i++) {
            temp02 = temp02.getNext();
        }
        
        return temp02;
    }
    public void getAll() {
        for (int i = 0; i < getTotal(); i++) {
            System.out.println(get(i));
        }
    }
    
    public void remove(int index) {
        if (index < 0) return;
        if (index == 0) {
            first = first.getNext();
            cRm();
            return;
        }
        
        Node temp02 = first;
        Node old = null;
        for (int i = 0; i < index && temp02.getNext() != null; i++) {
            old = temp02;
            temp02 = temp02.getNext();
        }
        if (temp02.getNext() != null) {
            old.setNext(temp02.getNext());
        } else {
            old.setNext(null);
        }
        
        //decrementing
        cRm();
    }
}

class Node {
    Node next;
    int item;
    
    public Node(int item) {
        this.item = item;
    }
    
    public Node getNext() {
        return next;
    }
    public void setNext(Node next) {
        this.next = next; 
    }
    
    public String toString() {
        return "[item] -> "+item;
    }
} 