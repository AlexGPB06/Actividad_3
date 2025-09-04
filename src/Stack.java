@SuppressWarnings("unchecked")
public class Stack<E> {
    public static final int CAPACITY = 1000;
    private E[] data;
    private int size = 0;

    public Stack() {
        this.data = (E[]) new Object[CAPACITY];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void push(E e) {
        if (size >= CAPACITY) {
            throw new IllegalStateException("Capacidad de la pila alcanzada");
        }
        data[size++] = e;
    }

    public E pop() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila está vacía");
        }
        E e = data[--size];
        data[size] = null;
        return e;
    }

    public E peek() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila está vacía");
        }
        return data[size - 1];
    }

    public String toInlineString() {
        if (isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = size - 1; i >= 0; i--) {
            sb.append(data[i]);
            if (i > 0) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
