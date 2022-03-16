// random ass Assignment (ifpr)

public class MyList {
	// Main
    public static void main(String[] args) {
    	LinkedList list = new LinkedList();
    	
	// Adicionar 3 itens (tem um a +, mas n faz diff)
	list.add(new Cama("nome", "marca"));
    	list.add(new Cama("nome1", "marca"));
    	list.add(new Cama("nome2", "marca"));
        list.add(new Cama("nome3", "marca"));
    	
	// Listar tudo
    	list.show();
        System.out.println("\n----//\n");

	// Mostrar 2° item na tela
        list.show(1);
    }
    
}

class Node {
    ItemCasa data;
    int index;
    Node next;
}

class LinkedList {
    Node head;
    int currentIndex = 0;
    
    public void add(ItemCasa data) {
        Node node = new Node();
        node.data = data;
        node.index = currentIndex;
        
        if(head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {                
                temp = temp.next;
            }
            
            temp.next = node;
        }
        currentIndex++;
    }
    public void show() {
        Node temp = head;
        while (temp.next != null) {            
            System.out.println("["+temp.index+"] - "+ temp.data);
            temp = temp.next;
        }
        System.out.println("["+temp.index+"] - "+ temp.data);
    }
    public void show(int index) {
        Node temp = head;
        if(index >= currentIndex) {
            System.err.println("Index [" + index + "] isn't set");
            return;
        }
        while (temp.index != index) {
            temp = temp.next;
        }
        System.out.println("["+temp.index+"] - "+ temp.data);
    }
}

interface ItemCasa {
}

abstract class Mobilia implements ItemCasa {
}

class Cama extends Mobilia {
    String name, brand;
    double size[];
    
    public Cama(String name, String brand, double size[]) {
        this.name = name;
        this.brand = brand;
    }
     public Cama(String name, String brand) {
        this.name = name;
        this.brand = brand;
    }
    @Override
    public String toString() {
        return "Name: "+name
                +"\n      Brand: "+brand+"\n";
    }
}