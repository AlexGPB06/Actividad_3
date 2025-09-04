public class Divide {

    private Stack<Integer> a = new Stack<>();
    private Stack<Integer> b = new Stack<>();
    private Stack<Integer> c = new Stack<>();
    private int discos;
    private long paso = 0;

    public Divide(int discos) {
        this.discos = discos;
        // Inicializar torre A con todos los discos
        for (int i = discos; i >= 1; i--) {
            a.push(i);
        }
    }

    public void resolver() {
        imprimirEstado("Estado inicial");
        hanoi(discos, a, c, b, "A", "C", "B");
        System.out.println("¡Completado! Todos los discos están en la torre C.");
    }

    private void hanoi(int n, Stack<Integer> origen, Stack<Integer> destino, Stack<Integer> auxiliar,
                       String nombreOrigen, String nombreDestino, String nombreAux) {
        if (n == 0) return;

        hanoi(n - 1, origen, auxiliar, destino, nombreOrigen, nombreAux, nombreDestino);
        mover(origen, destino, nombreOrigen, nombreDestino);
        hanoi(n - 1, auxiliar, destino, origen, nombreAux, nombreDestino, nombreOrigen);
    }

    private void mover(Stack<Integer> origen, Stack<Integer> destino,
                       String nombreOrigen, String nombreDestino) {
        int disco = origen.pop();
        destino.push(disco);
        paso++;
        System.out.printf("Paso %d: mover disco %d de %s -> %s%n", paso, disco, nombreOrigen, nombreDestino);
        imprimirTorres();
        System.out.println("-----------------------------------");
    }

    private void imprimirEstado(String titulo) {
        System.out.println(titulo);
        imprimirTorres();
        System.out.println("-----------------------------------");
    }

    private void imprimirTorres() {
        System.out.println("A: " + a.toInlineString());
        System.out.println("B: " + b.toInlineString());
        System.out.println("C: " + c.toInlineString());
    }
}
