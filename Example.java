public class Temp {
    static MyList list = new MyList();
    
    public static void main(String[] args) {
        MyList list2 = new MyList();
        for (int i = 0; i < 5; i++) {
            list2.append(i*10);
        }
        print();
        
        list.add(new Node(1));
        list.add(new Node(2));
        list.add(new Node(3));
        list.list();
        print();
        
        list.add(new Node(4), 1);
        list.list();
        print();
        
        list.remove();
        list.list();
        print();
        
        list.append(2);
        list.list();
        print();
        
        list.append(list2, 2);
        list.list();
        print();
        
        print(list.get(4).toString());
        print();
        
        list.listInverted();
        print();
        
        list.invert();
        list.list();
        print();

        
        print("\nEnding");
    }
    
    static public void print(String value) {
        System.out.println(value);
    }
    static public void print() {
        print("Len("+list.length()+")");
        print("\n--------------// \n");
    }
}

class Node {
    Node next;
    int item;
    
    public Node() {
        this.next = null;
    }
    public Node(Node next) {
        this.next = next;
    }
    public Node(int item) {
        this.item = item;
    }
    public Node(Node next, int item) {
        this.next = next;
        this.item = item;
    }
    
    public String toString() {
        return "Item: " + item;
    }
}

class MyList {
    Node first;
    
    public MyList() {
        this.first = null;
    }
    public MyList(Node first) {
        this.first = first;
    }
    
    public Node get(int index) {
        if( index < 0) return null;
        
        Node temp = first;
        int iteration = 0;
        
        while(temp != null && index > iteration) {
            temp = temp.next;
            iteration++;
        }
        return temp;
    }
    public Node getLast() {
        Node temp = first;
        while(temp.next != null) {
            temp = temp.next;
        }
        return temp;
    }
    
    public void add(Node n) {
        if(first == null) {
            first = n;
            return;
        } 
        Node temp = first;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = n;
    }
    public void add(Node n, int index) {
        if(first == null) {
            if( index == 0 ) {
                first = n;
            } else {
                System.out.println("List isn't properly set");
                return;
            }
        } 
        
        Node temp = first;
        Node old = null;
        
        int iteration = 0;
        while(temp != null && index > iteration) {
            old = temp;
            temp = temp.next;
            iteration++;
        }
        old.next = n;
        n.next = temp;
    }
    
    // Removes last element
    public Node remove() {
        Node temp = first;
        while(temp.next.next != null) {
            temp = temp.next;
        }
        
        Node old = temp.next;
        temp.next = null;
        
        return old;
    }    
    public Node remove(int index) {
        if( index < 0 ) return null;
        
        Node temp = first, old = null, nNext = null;
        int iteration = 0;
        
        while(index > iteration) {
            old = temp;
            temp = temp.next;
            iteration++;
            
            if(iteration > index) break; // Just in case sth breaks
        }
        
        if(temp.next != null) nNext = temp.next;
        old.next = nNext;
        
        return temp;
    }
    
    public int length() {
        int counter = 0;
        if(first == null) return counter;
        
        Node temp = first;
        while(temp != null) {
            temp = temp.next;
            counter++;
        }
        return counter;
    }
    public void list () {
        Node temp = first;
        while(temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }
    
    public void append(int index) {
        add(new Node(index));
    }
    public void append(Node n) {
        add(n);
    }
    public void append(MyList l) {
        add(l.first);
    }
    public void append(MyList l, int index) {
        if(first == null) return;
        
        Node n = l.first;
        Node temp = first;
        Node old = null;
        
        int iteration = 0;
        while(temp != null && index > iteration) {
            old = temp;
            temp = temp.next;
            iteration++;
        }
        old.next = n;
        Node last = l.getLast();
        last.next = temp;
    }
    
    public void listInverted() {
        if (first == null) return;
        listInverted(first);
    }
    public void listInverted(Node n) {
        if (first == null) return;
        
        if(n.next != null) listInverted(n.next);
        System.out.println(n);
    }
    
    public void invert() {
        if(first == null) return;
        invert(first);
    }
    public void invert(Node n)
    {
        if(n.next == null) {
            first = n;
            return;
        }
        
        invert(n.next);
        n.next = null;
        append(n);
    }
}

