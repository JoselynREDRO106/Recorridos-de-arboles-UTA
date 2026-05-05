#include <iostream>
#include <queue>
#include <string>
using namespace std;

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

void preorden(Nodo* raiz) {
    if (raiz == nullptr) return;
    cout << raiz->dato << " ";
    preorden(raiz->izquierda);
    preorden(raiz->derecha);
}

void inorden(Nodo* raiz) {
    if (raiz == nullptr) return;
    inorden(raiz->izquierda);
    cout << raiz->dato << " ";
    inorden(raiz->derecha);
}

void postorden(Nodo* raiz) {
    if (raiz == nullptr) return;
    postorden(raiz->izquierda);
    postorden(raiz->derecha);
    cout << raiz->dato << " ";
}

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

int contarNodos(Nodo* raiz) {
    if (raiz == nullptr) return 0;
    return 1 + contarNodos(raiz->izquierda) + contarNodos(raiz->derecha);
}

int contarHojas(Nodo* raiz) {
    if (raiz == nullptr) return 0;
    if (raiz->izquierda == nullptr && raiz->derecha == nullptr) return 1;
    return contarHojas(raiz->izquierda) + contarHojas(raiz->derecha);
}

void preordenTexto(NodoTexto* raiz) {
    if (raiz == nullptr) return;
    cout << raiz->dato << " ";
    preordenTexto(raiz->izquierda);
    preordenTexto(raiz->derecha);
}

void postordenTexto(NodoTexto* raiz) {
    if (raiz == nullptr) return;
    postordenTexto(raiz->izquierda);
    postordenTexto(raiz->derecha);
    cout << raiz->dato << " ";
}

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
    Nodo* raiz = new Nodo(10);
    raiz->izquierda = new Nodo(5);
    raiz->derecha = new Nodo(15);
    raiz->izquierda->izquierda = new Nodo(2);
    raiz->izquierda->derecha = new Nodo(7);
    raiz->derecha->izquierda = new Nodo(12);
    raiz->derecha->derecha = new Nodo(20);

    cout << "RECORRIDOS DE ARBOLES BINARIOS - UTA" << endl;

    cout << "\nEJERCICIO 1: Arbol original" << endl;
    mostrarRecorridos(raiz);

    raiz->izquierda->izquierda->izquierda = new Nodo(1);
    raiz->izquierda->izquierda->derecha = new Nodo(3);
    raiz->derecha->derecha->izquierda = new Nodo(18);
    raiz->derecha->derecha->derecha = new Nodo(25);

    cout << "\nEJERCICIO 2: Arbol modificado con 1, 3, 18 y 25" << endl;
    mostrarRecorridos(raiz);

    cout << "\nEJERCICIO 3: Total de nodos" << endl;
    cout << "Total de nodos: " << contarNodos(raiz) << endl;

    cout << "\nEJERCICIO 4: Total de hojas" << endl;
    cout << "Total de hojas: " << contarHojas(raiz) << endl;

    NodoTexto* sistema = new NodoTexto("Sistema_Web");
    sistema->izquierda = new NodoTexto("Usuarios");
    sistema->derecha = new NodoTexto("Inventario");
    sistema->izquierda->izquierda = new NodoTexto("Registrar");
    sistema->izquierda->derecha = new NodoTexto("Buscar");
    sistema->derecha->izquierda = new NodoTexto("Productos");
    sistema->derecha->derecha = new NodoTexto("Reportes");

    cout << "\nEJERCICIO 5: Sistema web como arbol binario" << endl;
    cout << "1. Menu principal (Preorden): ";
    preordenTexto(sistema);

    cout << "\n2. Procesar primero modulos internos (Postorden): ";
    postordenTexto(sistema);

    cout << "\n3. Mostrar nivel por nivel (BFS): ";
    bfsTexto(sistema);

    cout << "\n\nExplicacion:" << endl;
    cout << "Para mostrar el menu principal se usa Preorden porque primero muestra el modulo raiz." << endl;
    cout << "Para procesar primero los modulos internos se usa Postorden porque atiende primero los hijos." << endl;
    cout << "Para mostrar modulos nivel por nivel se usa BFS porque recorre el arbol por niveles." << endl;

    return 0;
    }