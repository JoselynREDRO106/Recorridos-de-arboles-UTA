import java.util.LinkedList;
import java.util.Queue;

// Clase nodo para valores enteros
class Nodo {
    int dato;
    Nodo izquierda;
    Nodo derecha;

    public Nodo(int dato) {
        this.dato = dato;
        this.izquierda = null;
        this.derecha = null;
    }
}

// Clase nodo para texto
class NodoTexto {
    String dato;
    NodoTexto izquierda;
    NodoTexto derecha;

    public NodoTexto(String dato) {
        this.dato = dato;
        this.izquierda = null;
        this.derecha = null;
    }
}

public class Main {

    // Recorrido preorden: raíz primero
    public static void preorden(Nodo raiz) {
        if (raiz == null) return;
        System.out.print(raiz.dato + " ");
        preorden(raiz.izquierda);
        preorden(raiz.derecha);
    }

    // Recorrido inorden: raíz en medio
    public static void inorden(Nodo raiz) {
        if (raiz == null) return;
        inorden(raiz.izquierda);
        System.out.print(raiz.dato + " ");
        inorden(raiz.derecha);
    }

    // Recorrido postorden: raíz al final
    public static void postorden(Nodo raiz) {
        if (raiz == null) return;
        postorden(raiz.izquierda);
        postorden(raiz.derecha);
        System.out.print(raiz.dato + " ");
    }

    // Recorrido por niveles usando cola (BFS)
    public static void bfs(Nodo raiz) {
        if (raiz == null) return;

        Queue<Nodo> cola = new LinkedList<>();
        cola.add(raiz);

        while (!cola.isEmpty()) {
            Nodo actual = cola.poll();
            System.out.print(actual.dato + " ");

            if (actual.izquierda != null) cola.add(actual.izquierda);
            if (actual.derecha != null) cola.add(actual.derecha);
        }
    }

    // Cuenta todos los nodos
    public static int contarNodos(Nodo raiz) {
        if (raiz == null) return 0;
        return 1 + contarNodos(raiz.izquierda) + contarNodos(raiz.derecha);
    }

    // Cuenta los nodos hoja
    public static int contarHojas(Nodo raiz) {
        if (raiz == null) return 0;
        if (raiz.izquierda == null && raiz.derecha == null) return 1;
        return contarHojas(raiz.izquierda) + contarHojas(raiz.derecha);
    }

    // Recorrido preorden para árbol de texto
    public static void preordenTexto(NodoTexto raiz) {
        if (raiz == null) return;
        System.out.print(raiz.dato + " ");
        preordenTexto(raiz.izquierda);
        preordenTexto(raiz.derecha);
    }

    // Recorrido postorden para texto
    public static void postordenTexto(NodoTexto raiz) {
        if (raiz == null) return;
        postordenTexto(raiz.izquierda);
        postordenTexto(raiz.derecha);
        System.out.print(raiz.dato + " ");
    }

    // Recorrido BFS para texto
    public static void bfsTexto(NodoTexto raiz) {
        if (raiz == null) return;

        Queue<NodoTexto> cola = new LinkedList<>();
        cola.add(raiz);

        while (!cola.isEmpty()) {
            NodoTexto actual = cola.poll();
            System.out.print(actual.dato + " ");

            if (actual.izquierda != null) cola.add(actual.izquierda);
            if (actual.derecha != null) cola.add(actual.derecha);
        }
    }

    // Muestra todos los recorridos
    public static void mostrarRecorridos(Nodo raiz) {
        System.out.print("Preorden: ");
        preorden(raiz);

        System.out.print("\nInorden: ");
        inorden(raiz);

        System.out.print("\nPostorden: ");
        postorden(raiz);

        System.out.print("\nBFS: ");
        bfs(raiz);

        System.out.println();
    }

    public static void main(String[] args) {

        // Crear árbol inicial
        Nodo raiz = new Nodo(10);
        raiz.izquierda = new Nodo(5);
        raiz.derecha = new Nodo(15);
        raiz.izquierda.izquierda = new Nodo(2);
        raiz.izquierda.derecha = new Nodo(7);
        raiz.derecha.izquierda = new Nodo(12);
        raiz.derecha.derecha = new Nodo(20);

        System.out.println("RECORRIDOS DE ARBOLES BINARIOS - UTA");

        // Mostrar árbol original
        System.out.println("\nEJERCICIO 1: Arbol original");
        mostrarRecorridos(raiz);

        // Agregar nuevos nodos
        raiz.izquierda.izquierda.izquierda = new Nodo(1);
        raiz.izquierda.izquierda.derecha = new Nodo(3);
        raiz.derecha.derecha.izquierda = new Nodo(18);
        raiz.derecha.derecha.derecha = new Nodo(25);

        // Mostrar árbol modificado
        System.out.println("\nEJERCICIO 2: Arbol modificado");
        mostrarRecorridos(raiz);

        // Contar nodos
        System.out.println("\nEJERCICIO 3: Total de nodos");
        System.out.println("Total de nodos: " + contarNodos(raiz));

        // Contar hojas
        System.out.println("\nEJERCICIO 4: Total de hojas");
        System.out.println("Total de hojas: " + contarHojas(raiz));

        // Crear árbol de texto
        NodoTexto sistema = new NodoTexto("Sistema_Web");
        sistema.izquierda = new NodoTexto("Usuarios");
        sistema.derecha = new NodoTexto("Inventario");
        sistema.izquierda.izquierda = new NodoTexto("Registrar");
        sistema.izquierda.derecha = new NodoTexto("Buscar");
        sistema.derecha.izquierda = new NodoTexto("Productos");
        sistema.derecha.derecha = new NodoTexto("Reportes");

        // Recorridos del sistema
        System.out.println("\nEJERCICIO 5: Sistema web como arbol binario");

        System.out.print("Preorden: ");
        preordenTexto(sistema);

        System.out.print("\nPostorden: ");
        postordenTexto(sistema);

        System.out.print("\nBFS: ");
        bfsTexto(sistema);

        // Explicación breve
        System.out.println("\n\nExplicacion:");
        System.out.println("Preorden muestra primero la raiz.");
        System.out.println("Postorden procesa primero los hijos.");
        System.out.println("BFS recorre el arbol por niveles.");
    }
}
