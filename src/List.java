public class List<E> {
    Node<E> firstNode;

    public List() {
        this.firstNode = null;
    }

    public List(Node<E> firstNode) {
        this.firstNode = firstNode;
    }

    public Node<E> getFirstNode() {
        return firstNode;
    }

    public void insertAtFirstPosition(E value) {
        Node<E> nodeToInsert = new Node<>(value);
        nodeToInsert.next = firstNode;
        firstNode = nodeToInsert;
    }

    public void show() {
        Node<E> currentNode = this.firstNode;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }
}