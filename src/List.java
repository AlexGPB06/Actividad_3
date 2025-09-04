public class  List<E> {

    Node<E> firstNode;

    /**
     * Constructors
     */

    public List() {

        this.firstNode = null;

    }


    public List(Node firstNode) {

        this.firstNode = firstNode;

    }

    /**
     * Setters y getters
     */

    public Node getFirstNode() {

        return firstNode;

    }

    public void insertAtFirstPosition(int value) {

        Node nodeToInsert = new Node(value);

        nodeToInsert.next = firstNode;

        firstNode = nodeToInsert;

    }

    /**

     * Muestra toda la lista

     */

    public void show(){

        //Nodo que recorre la lista

        Node currentNode= this.firstNode;

        //Mientras que el nodo no haya encontrado el final

        //muestra el valor del nodo actual

        while (currentNode!= null){

            System.out.print(currentNode.data+" ");

            currentNode= currentNode.next;

        }

    }

}