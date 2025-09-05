//Alejandro Garcia Pelayo Banda 04/09/2025
public class List<E> {
    Node<E> firstNode;

    /**
     * Constructor vacío: inicializa la lista sin nodos.
     */
    public List() {
        this.firstNode = null;
    }

    /**
     * Constructor que inicializa la lista con un nodo.
     *
     * @param firstNode el primer nodo de la lista.
     */
    public List(Node<E> firstNode) {
        this.firstNode = firstNode;
    }

    /**
     * Retorna el primer nodo de la lista.
     *
     * @return el primer nodo de la lista.
     */
    public Node<E> getFirstNode() {
        return firstNode;
    }

    /**
     * Inserta un nuevo nodo al inicio de la lista.
     *
     * @param value el valor que se almacenará en el nodo.
     */
    public void insertAtFirstPosition(E value) {
        Node<E> nodeToInsert = new Node<>(value);
        nodeToInsert.next = firstNode;
        firstNode = nodeToInsert;
    }

    /**
     * Muestra todos los elementos de la lista en orden.
     * Recorre la lista de forma iterativa.
     *
     * No utiliza recursividad ni backtracking.
     */
    public void show() {
        Node<E> currentNode = this.firstNode;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }
}
