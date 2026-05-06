#include <iostream>
#include <queue>
#include <string>
using namespace std;

// Estructura de nodo para valores enteros
struct Nodo {
    int dato;
    Nodo* izquierda;
    Nodo* derecha;

    Nodo(int valor) {
        dato = valor;
        izquierda = nullptr;
        derecha = nullptr;
    }
};

// Estructura de nodo para texto
struct NodoTexto {
    string dato;
    NodoTexto* izquierda;
    NodoTexto* derecha;

    NodoTexto(string valor) {
        dato = valor;
        izquierda = nullptr;
        derecha = nullptr;
    }
};

// Recorrido preorden: primero raíz
void preorden(Nodo* raiz) {
    if (raiz == nullptr) return;
    cout << raiz->dato << " ";
    preorden(raiz->izquierda);
    preorden(raiz->derecha);
}

// Recorrido inorden: raíz en medio
void inorden(Nodo* raiz) {
    if (raiz == nullptr) return;
    inorden(raiz->izquierda);
    cout << raiz->dato << " ";
    inorden(raiz->derecha);
}

// Recorrido postorden: raíz al final
void postorden(Nodo* raiz) {
    if (raiz == nullptr) return;
    postorden(raiz->izquierda);
    postorden(raiz->derecha);
    cout << raiz->dato << " ";
}

// Recorrido por niveles usando cola (BFS)
void bfs(Nodo* raiz) {
    if (raiz == nullptr) return;

    queue<Nodo*> cola;
    cola.push(raiz);

    while (!cola.empty()) {
        Nodo* actual = cola.front();
        cola.pop();

        cout << actual->dato << " ";

        if (actual->izquierda != nullptr) cola.push(actual->izquierda);
        if (actual->derecha != nullptr) cola.push(actual->derecha);
    }
}

// Cuenta todos los nodos del árbol
int contarNodos(Nodo* raiz) {
    if (raiz == nullptr) return 0;
    return 1 + contarNodos(raiz->izquierda) + contarNodos(raiz->derecha);
}

// Cuenta solo los nodos hoja
int contarHojas(Nodo* raiz) {
    if (raiz == nullptr) return 0;
    if (raiz->izquierda == nullptr && raiz->derecha == nullptr) return 1;
    return contarHojas(raiz->izquierda) + contarHojas(raiz->derecha);
}

// Recorrido preorden para árbol de texto
void preordenTexto(NodoTexto* raiz) {
    if (raiz == nullptr) return;
    cout << raiz->dato << " ";
    preordenTexto(raiz->izquierda);
    preordenTexto(raiz->derecha);
}

// Recorrido postorden para texto
void postordenTexto(NodoTexto* raiz) {
    if (raiz == nullptr) return;
    postordenTexto(raiz->izquierda);
    postordenTexto(raiz->derecha);
    cout << raiz->dato << " ";
}

// Recorrido BFS para texto
void bfsTexto(NodoTexto* raiz) {
    if (raiz == nullptr) return;

    queue<NodoTexto*> cola;
    cola.push(raiz);

    while (!cola.empty()) {
        NodoTexto* actual = cola.front();
        cola.pop();

        cout << actual->dato << " ";

        if (actual->izquierda != nullptr) cola.push(actual->izquierda);
        if (actual->derecha != nullptr) cola.push(actual->derecha);
    }
}

// Muestra todos los recorridos del árbol
void mostrarRecorridos(Nodo* raiz) {
    cout << "Preorden: ";
    preorden(raiz);

    cout << "\nInorden: ";
    inorden(raiz);

    cout << "\nPostorden: ";
    postorden(raiz);

    cout << "\nBFS: ";
    bfs(raiz);

    cout << endl;
}

int main() {
    // Crear árbol inicial
    Nodo* raiz = new Nodo(10);
    raiz->izquierda = new Nodo(5);
    raiz->derecha = new Nodo(15);
    raiz->izquierda->izquierda = new Nodo(2);
    raiz->izquierda->derecha = new Nodo(7);
    raiz->derecha->izquierda = new Nodo(12);
    raiz->derecha->derecha = new Nodo(20);

    cout << "RECORRIDOS DE ARBOLES BINARIOS - UTA" << endl;

    // Mostrar árbol original
    cout << "\nEJERCICIO 1: Arbol original" << endl;
    mostrarRecorridos(raiz);

    // Agregar nuevos nodos
    raiz->izquierda->izquierda->izquierda = new Nodo(1);
    raiz->izquierda->izquierda->derecha = new Nodo(3);
    raiz->derecha->derecha->izquierda = new Nodo(18);
    raiz->derecha->derecha->derecha = new Nodo(25);

    // Mostrar árbol modificado
    cout << "\nEJERCICIO 2: Arbol modificado" << endl;
    mostrarRecorridos(raiz);

    // Contar nodos
    cout << "\nEJERCICIO 3: Total de nodos" << endl;
    cout << "Total de nodos: " << contarNodos(raiz) << endl;

    // Contar hojas
    cout << "\nEJERCICIO 4: Total de hojas" << endl;
    cout << "Total de hojas: " << contarHojas(raiz) << endl;

    // Crear árbol de texto
    NodoTexto* sistema = new NodoTexto("Sistema_Web");
    sistema->izquierda = new NodoTexto("Usuarios");
    sistema->derecha = new NodoTexto("Inventario");
    sistema->izquierda->izquierda = new NodoTexto("Registrar");
    sistema->izquierda->derecha = new NodoTexto("Buscar");
    sistema->derecha->izquierda = new NodoTexto("Productos");
    sistema->derecha->derecha = new NodoTexto("Reportes");

    // Recorridos del sistema
    cout << "\nEJERCICIO 5: Sistema web como arbol binario" << endl;
    cout << "Preorden: ";
    preordenTexto(sistema);

    cout << "\nPostorden: ";
    postordenTexto(sistema);

    cout << "\nBFS: ";
    bfsTexto(sistema);

    return 0;
}