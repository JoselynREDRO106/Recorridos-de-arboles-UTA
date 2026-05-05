import java.util.LinkedList;
import java.util.Queue;

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

    public static void preorden(Nodo raiz) {
        if (raiz == null) return;
        System.out.print(raiz.dato + " ");
        preorden(raiz.izquierda);
        preorden(raiz.derecha);
    }

    public static void inorden(Nodo raiz) {
        if (raiz == null) return;
        inorden(raiz.izquierda);
        System.out.print(raiz.dato + " ");
        inorden(raiz.derecha);
    }

    public static void postorden(Nodo raiz) {
        if (raiz == null) return;
        postorden(raiz.izquierda);
        postorden(raiz.derecha);
        System.out.print(raiz.dato + " ");
    }

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

    public static int contarNodos(Nodo raiz) {
        if (raiz == null) return 0;
        return 1 + contarNodos(raiz.izquierda) + contarNodos(raiz.derecha);
    }

    public static int contarHojas(Nodo raiz) {
        if (raiz == null) return 0;
        if (raiz.izquierda == null && raiz.derecha == null) return 1;
        return contarHojas(raiz.izquierda) + contarHojas(raiz.derecha);
    }

    public static void preordenTexto(NodoTexto raiz) {
        if (raiz == null) return;
        System.out.print(raiz.dato + " ");
        preordenTexto(raiz.izquierda);
        preordenTexto(raiz.derecha);
    }

    public static void postordenTexto(NodoTexto raiz) {
        if (raiz == null) return;
        postordenTexto(raiz.izquierda);
        postordenTexto(raiz.derecha);
        System.out.print(raiz.dato + " ");
    }

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
        Nodo raiz = new Nodo(10);
        raiz.izquierda = new Nodo(5);
        raiz.derecha = new Nodo(15);
        raiz.izquierda.izquierda = new Nodo(2);
        raiz.izquierda.derecha = new Nodo(7);
        raiz.derecha.izquierda = new Nodo(12);
        raiz.derecha.derecha = new Nodo(20);

        System.out.println("RECORRIDOS DE ARBOLES BINARIOS - UTA");

        System.out.println("\nEJERCICIO 1: Arbol original");
        mostrarRecorridos(raiz);

        raiz.izquierda.izquierda.izquierda = new Nodo(1);
        raiz.izquierda.izquierda.derecha = new Nodo(3);
        raiz.derecha.derecha.izquierda = new Nodo(18);
        raiz.derecha.derecha.derecha = new Nodo(25);

        System.out.println("\nEJERCICIO 2: Arbol modificado con 1, 3, 18 y 25");
        mostrarRecorridos(raiz);

        System.out.println("\nEJERCICIO 3: Total de nodos");
        System.out.println("Total de nodos: " + contarNodos(raiz));

        System.out.println("\nEJERCICIO 4: Total de hojas");
        System.out.println("Total de hojas: " + contarHojas(raiz));

        NodoTexto sistema = new NodoTexto("Sistema_Web");
        sistema.izquierda = new NodoTexto("Usuarios");
        sistema.derecha = new NodoTexto("Inventario");
        sistema.izquierda.izquierda = new NodoTexto("Registrar");
        sistema.izquierda.derecha = new NodoTexto("Buscar");
        sistema.derecha.izquierda = new NodoTexto("Productos");
        sistema.derecha.derecha = new NodoTexto("Reportes");

        System.out.println("\nEJERCICIO 5: Sistema web como arbol binario");
        System.out.print("1. Menu principal (Preorden): ");
        preordenTexto(sistema);

        System.out.print("\n2. Procesar primero modulos internos (Postorden): ");
        postordenTexto(sistema);

        System.out.print("\n3. Mostrar nivel por nivel (BFS): ");
        bfsTexto(sistema);

        System.out.println("\n\nExplicacion:");
        System.out.println("Para mostrar el menu principal se usa Preorden porque primero muestra el modulo raiz.");
        System.out.println("Para procesar primero los modulos internos se usa Postorden porque atiende primero los hijos.");
        System.out.println("Para mostrar modulos nivel por nivel se usa BFS porque recorre el arbol por niveles.");
    }
}