//Alejandro Garcia Pelayo Banda 04/09/2025
// Node.java
public class Node<E> {
    E data;           // Almacena el elemento de datos del nodo
    Node<E> next;     // Referencia al siguiente nodo en la lista

    /**
     * Constructor que crea un nodo con datos y siguiente nodo especificados
     * @param data El elemento de datos a almacenar
     * @param next Referencia al siguiente nodo en la lista
     */
    public Node(E data, Node<E> next) {
        this.data = data;
        this.next = next;
    }

    /**
     * Constructor que crea un nodo con datos y siguiente nodo nulo
     * @param data El elemento de datos a almacenar
     */
    public Node(E data) {
        this.data = data;
        this.next = null;
    }
}
