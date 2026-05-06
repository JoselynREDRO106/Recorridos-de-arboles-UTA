#include <iostream>
#include <queue>
#include <string>
#include <sstream>
#include <vector>
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

// ==================== RECORRIDOS PARA ÁRBOL DE NÚMEROS ====================

void preorden(Nodo* raiz, queue<int>& resultado) {
    if (raiz == nullptr) return;
    resultado.push(raiz->dato);
    preorden(raiz->izquierda, resultado);
    preorden(raiz->derecha, resultado);
}

void inorden(Nodo* raiz, queue<int>& resultado) {
    if (raiz == nullptr) return;
    inorden(raiz->izquierda, resultado);
    resultado.push(raiz->dato);
    inorden(raiz->derecha, resultado);
}

void postorden(Nodo* raiz, queue<int>& resultado) {
    if (raiz == nullptr) return;
    postorden(raiz->izquierda, resultado);
    postorden(raiz->derecha, resultado);
    resultado.push(raiz->dato);
}

void bfs(Nodo* raiz, queue<int>& resultado) {
    if (raiz == nullptr) return;

    queue<Nodo*> cola;
    cola.push(raiz);

    while (!cola.empty()) {
        Nodo* actual = cola.front();
        cola.pop();
        resultado.push(actual->dato);

        if (actual->izquierda != nullptr) cola.push(actual->izquierda);
        if (actual->derecha != nullptr) cola.push(actual->derecha);
    }
}

// ==================== RECORRIDOS PARA ÁRBOL DE TEXTO ====================

void preordenTexto(NodoTexto* raiz, queue<string>& resultado) {
    if (raiz == nullptr) return;
    resultado.push(raiz->dato);
    preordenTexto(raiz->izquierda, resultado);
    preordenTexto(raiz->derecha, resultado);
}

void postordenTexto(NodoTexto* raiz, queue<string>& resultado) {
    if (raiz == nullptr) return;
    postordenTexto(raiz->izquierda, resultado);
    postordenTexto(raiz->derecha, resultado);
    resultado.push(raiz->dato);
}

void bfsTexto(NodoTexto* raiz, queue<string>& resultado) {
    if (raiz == nullptr) return;

    queue<NodoTexto*> cola;
    cola.push(raiz);

    while (!cola.empty()) {
        NodoTexto* actual = cola.front();
        cola.pop();
        resultado.push(actual->dato);

        if (actual->izquierda != nullptr) cola.push(actual->izquierda);
        if (actual->derecha != nullptr) cola.push(actual->derecha);
    }
}

// ==================== FUNCIONES DE CONTEO ====================

int contarNodos(Nodo* raiz) {
    if (raiz == nullptr) return 0;
    return 1 + contarNodos(raiz->izquierda) + contarNodos(raiz->derecha);
}

int contarHojas(Nodo* raiz) {
    if (raiz == nullptr) return 0;
    if (raiz->izquierda == nullptr && raiz->derecha == nullptr) return 1;
    return contarHojas(raiz->izquierda) + contarHojas(raiz->derecha);
}

// ==================== FUNCIONES DE VALIDACIÓN ====================

bool validarRecorridoNumerico(queue<int> recorridoReal, vector<int> ingresado) {
    if (recorridoReal.size() != ingresado.size()) return false;
    
    queue<int> temp = recorridoReal;
    for (int i = 0; i < ingresado.size(); i++) {
        if (temp.front() != ingresado[i]) return false;
        temp.pop();
    }
    return true;
}

bool validarRecorridoTexto(queue<string> recorridoReal, vector<string> ingresado) {
    if (recorridoReal.size() != ingresado.size()) return false;
    
    queue<string> temp = recorridoReal;
    for (int i = 0; i < ingresado.size(); i++) {
        if (temp.front() != ingresado[i]) return false;
        temp.pop();
    }
    return true;
}

// ==================== FUNCIONES AUXILIARES ====================

string repeat(char c, int n) {
    return string(n, c);
}

string queueToString(queue<int> q) {
    stringstream ss;
    while (!q.empty()) {
        ss << q.front() << " ";
        q.pop();
    }
    return ss.str();
}

string queueTextoToString(queue<string> q) {
    stringstream ss;
    while (!q.empty()) {
        ss << q.front() << " ";
        q.pop();
    }
    return ss.str();
}

vector<int> splitToInt(string linea) {
    vector<int> resultado;
    stringstream ss(linea);
    int num;
    while (ss >> num) {
        resultado.push_back(num);
    }
    return resultado;
}

vector<string> splitToString(string linea) {
    vector<string> resultado;
    stringstream ss(linea);
    string palabra;
    while (ss >> palabra) {
        resultado.push_back(palabra);
    }
    return resultado;
}

// ==================== PROTOTIPOS DE FUNCIONES ====================
void menuEjercicio1();
void menuEjercicio2();
void menuEjercicio3();
void menuEjercicio4();
void menuEjercicio5();
void validarRecorridoNumericoInteractivo(queue<int> recorridoReal, string nombreRecorrido, string esperado);
void validarRecorridoTextoInteractivo(queue<string> recorridoReal, string nombreRecorrido, string esperado);

// Variables globales para los recorridos
queue<int> preordenEj1, inordenEj1, postordenEj1, bfsEj1;
queue<int> preordenEj2, inordenEj2, postordenEj2, bfsEj2;
queue<string> preordenTextoQ, postordenTextoQ, bfsTextoQ;

int main() {
    cout << repeat('=', 70) << endl;
    cout << "      RECORRIDOS DE ARBOLES BINARIOS - UTA" << endl;
    cout << repeat('=', 70) << endl;

    // ==================== CONSTRUIR ÁRBOL PARA EJERCICIO 1 ====================
    Nodo* raizEj1 = new Nodo(10);
    raizEj1->izquierda = new Nodo(5);
    raizEj1->derecha = new Nodo(15);
    raizEj1->izquierda->izquierda = new Nodo(2);
    raizEj1->izquierda->derecha = new Nodo(7);
    raizEj1->derecha->izquierda = new Nodo(12);
    raizEj1->derecha->derecha = new Nodo(20);

    // ==================== CONSTRUIR ÁRBOL PARA EJERCICIO 2 ====================
    Nodo* raizEj2 = new Nodo(10);
    raizEj2->izquierda = new Nodo(5);
    raizEj2->derecha = new Nodo(15);
    raizEj2->izquierda->izquierda = new Nodo(2);
    raizEj2->izquierda->derecha = new Nodo(7);
    raizEj2->derecha->izquierda = new Nodo(12);
    raizEj2->derecha->derecha = new Nodo(20);
    
    raizEj2->izquierda->izquierda->izquierda = new Nodo(1);
    raizEj2->izquierda->izquierda->derecha = new Nodo(3);
    raizEj2->derecha->derecha->izquierda = new Nodo(18);
    raizEj2->derecha->derecha->derecha = new Nodo(25);

    // ==================== CONSTRUIR ÁRBOL DE TEXTO ====================
    NodoTexto* sistema = new NodoTexto("Sistema_Web");
    sistema->izquierda = new NodoTexto("Usuarios");
    sistema->derecha = new NodoTexto("Inventario");
    sistema->izquierda->izquierda = new NodoTexto("Registrar");
    sistema->izquierda->derecha = new NodoTexto("Buscar");
    sistema->derecha->izquierda = new NodoTexto("Productos");
    sistema->derecha->derecha = new NodoTexto("Reportes");

    // ==================== CALCULAR RECORRIDOS REALES ====================
    preorden(raizEj1, preordenEj1);
    inorden(raizEj1, inordenEj1);
    postorden(raizEj1, postordenEj1);
    bfs(raizEj1, bfsEj1);
    
    preorden(raizEj2, preordenEj2);
    inorden(raizEj2, inordenEj2);
    postorden(raizEj2, postordenEj2);
    bfs(raizEj2, bfsEj2);
    
    preordenTexto(sistema, preordenTextoQ);
    postordenTexto(sistema, postordenTextoQ);
    bfsTexto(sistema, bfsTextoQ);

    // ==================== MENÚ PRINCIPAL ====================
    int opcion;
    do {
        cout << "\n" << repeat('-', 70) << endl;
        cout << "                     MENU PRINCIPAL" << endl;
        cout << repeat('-', 70) << endl;
        cout << "| 1. EJERCICIO 1 - Arbol original (10,5,15,2,7,12,20)          |" << endl;
        cout << "| 2. EJERCICIO 2 - Arbol modificado (con 1,3,18,25)             |" << endl;
        cout << "| 3. EJERCICIO 3 - Contar nodos totales                         |" << endl;
        cout << "| 4. EJERCICIO 4 - Contar hojas                                 |" << endl;
        cout << "| 5. EJERCICIO 5 - Sistema web como arbol binario               |" << endl;
        cout << "| 0. SALIR                                                      |" << endl;
        cout << repeat('-', 70) << endl;
        cout << "Seleccione un ejercicio: ";
        
        cin >> opcion;
        cin.ignore();
        
        switch(opcion) {
            case 1:
                menuEjercicio1();
                break;
            case 2:
                menuEjercicio2();
                break;
            case 3:
                menuEjercicio3();
                break;
            case 4:
                menuEjercicio4();
                break;
            case 5:
                menuEjercicio5();
                break;
            case 0:
                cout << "\n>>> PROGRAMA FINALIZADO <<<" << endl;
                break;
            default:
                cout << "\n>>> OPCION INVALIDA. Intente nuevamente <<<" << endl;
        }
        
    } while(opcion != 0);
    
    return 0;
}

// ==================== MENÚ EJERCICIO 1 ====================
void menuEjercicio1() {
    int opcion;
    do {
        cout << "\n" << repeat('-', 50) << endl;
        cout << "        EJERCICIO 1 - Arbol original" << endl;
        cout << "     Arbol: 10, 5, 15, 2, 7, 12, 20" << endl;
        cout << repeat('-', 50) << endl;
        cout << "  1. Validar Preorden" << endl;
        cout << "  2. Validar Inorden" << endl;
        cout << "  3. Validar Postorden" << endl;
        cout << "  4. Validar BFS (Niveles)" << endl;
        cout << "  5. Mostrar recorridos correctos" << endl;
        cout << "  0. Volver al menu principal" << endl;
        cout << repeat('-', 50) << endl;
        cout << "Seleccione una opcion: ";
        
        cin >> opcion;
        cin.ignore();
        
        switch(opcion) {
            case 1:
                validarRecorridoNumericoInteractivo(preordenEj1, "PREORDEN", 
                    "Esperado: 10, 5, 2, 7, 15, 12, 20");
                break;
            case 2:
                validarRecorridoNumericoInteractivo(inordenEj1, "INORDEN",
                    "Esperado: 2, 5, 7, 10, 12, 15, 20");
                break;
            case 3:
                validarRecorridoNumericoInteractivo(postordenEj1, "POSTORDEN",
                    "Esperado: 2, 7, 5, 12, 20, 15, 10");
                break;
            case 4:
                validarRecorridoNumericoInteractivo(bfsEj1, "BFS (NIVELES)",
                    "Esperado: 10, 5, 15, 2, 7, 12, 20");
                break;
            case 5:
                cout << "\n>>> RECORRIDOS CORRECTOS DEL ARBOL ORIGINAL <<<" << endl;
                cout << "Preorden:  " << queueToString(preordenEj1) << endl;
                cout << "Inorden:   " << queueToString(inordenEj1) << endl;
                cout << "Postorden: " << queueToString(postordenEj1) << endl;
                cout << "BFS:       " << queueToString(bfsEj1) << endl;
                break;
            case 0:
                cout << "\n>>> VOLVIENDO AL MENU PRINCIPAL <<<" << endl;
                break;
            default:
                cout << "\n>>> OPCION INVALIDA <<<" << endl;
        }
    } while(opcion != 0);
}

// ==================== MENÚ EJERCICIO 2 ====================
void menuEjercicio2() {
    int opcion;
    do {
        cout << "\n" << repeat('-', 50) << endl;
        cout << "      EJERCICIO 2 - Arbol modificado" << endl;
        cout << "  Arbol: 10,5,15,2,7,12,20 + (1,3,18,25)" << endl;
        cout << repeat('-', 50) << endl;
        cout << "  1. Validar Preorden" << endl;
        cout << "  2. Validar Inorden" << endl;
        cout << "  3. Validar Postorden" << endl;
        cout << "  4. Validar BFS (Niveles)" << endl;
        cout << "  5. Mostrar recorridos correctos" << endl;
        cout << "  0. Volver al menu principal" << endl;
        cout << repeat('-', 50) << endl;
        cout << "Seleccione una opcion: ";
        
        cin >> opcion;
        cin.ignore();
        
        switch(opcion) {
            case 1:
                validarRecorridoNumericoInteractivo(preordenEj2, "PREORDEN",
                    "Esperado: 10, 5, 2, 1, 3, 7, 15, 12, 20, 18, 25");
                break;
            case 2:
                validarRecorridoNumericoInteractivo(inordenEj2, "INORDEN",
                    "Esperado: 1, 2, 3, 5, 7, 10, 12, 15, 18, 20, 25");
                break;
            case 3:
                validarRecorridoNumericoInteractivo(postordenEj2, "POSTORDEN",
                    "Esperado: 1, 3, 2, 7, 5, 12, 18, 25, 20, 15, 10");
                break;
            case 4:
                validarRecorridoNumericoInteractivo(bfsEj2, "BFS (NIVELES)",
                    "Esperado: 10, 5, 15, 2, 7, 12, 20, 1, 3, 18, 25");
                break;
            case 5:
                cout << "\n>>> RECORRIDOS CORRECTOS DEL ARBOL MODIFICADO <<<" << endl;
                cout << "Preorden:  " << queueToString(preordenEj2) << endl;
                cout << "Inorden:   " << queueToString(inordenEj2) << endl;
                cout << "Postorden: " << queueToString(postordenEj2) << endl;
                cout << "BFS:       " << queueToString(bfsEj2) << endl;
                break;
            case 0:
                cout << "\n>>> VOLVIENDO AL MENU PRINCIPAL <<<" << endl;
                break;
            default:
                cout << "\n>>> OPCION INVALIDA <<<" << endl;
        }
    } while(opcion != 0);
}

// ==================== MENÚ EJERCICIO 3 ====================
void menuEjercicio3() {
    // Reconstruir árbol para contar
    Nodo* raiz = new Nodo(10);
    raiz->izquierda = new Nodo(5);
    raiz->derecha = new Nodo(15);
    raiz->izquierda->izquierda = new Nodo(2);
    raiz->izquierda->derecha = new Nodo(7);
    raiz->derecha->izquierda = new Nodo(12);
    raiz->derecha->derecha = new Nodo(20);
    raiz->izquierda->izquierda->izquierda = new Nodo(1);
    raiz->izquierda->izquierda->derecha = new Nodo(3);
    raiz->derecha->derecha->izquierda = new Nodo(18);
    raiz->derecha->derecha->derecha = new Nodo(25);
    
    int totalNodos = contarNodos(raiz);
    cout << "\n" << repeat('-', 50) << endl;
    cout << "           EJERCICIO 3 - Contar nodos totales" << endl;
    cout << repeat('-', 50) << endl;
    cout << "El arbol tiene " << totalNodos << " nodos en total." << endl;
    cout << "\nPresione ENTER para continuar...";
    cin.ignore();
    cin.get();
}

// ==================== MENÚ EJERCICIO 4 ====================
void menuEjercicio4() {
    Nodo* raiz = new Nodo(10);
    raiz->izquierda = new Nodo(5);
    raiz->derecha = new Nodo(15);
    raiz->izquierda->izquierda = new Nodo(2);
    raiz->izquierda->derecha = new Nodo(7);
    raiz->derecha->izquierda = new Nodo(12);
    raiz->derecha->derecha = new Nodo(20);
    raiz->izquierda->izquierda->izquierda = new Nodo(1);
    raiz->izquierda->izquierda->derecha = new Nodo(3);
    raiz->derecha->derecha->izquierda = new Nodo(18);
    raiz->derecha->derecha->derecha = new Nodo(25);
    
    int totalHojas = contarHojas(raiz);
    cout << "\n" << repeat('-', 50) << endl;
    cout << "              EJERCICIO 4 - Contar hojas" << endl;
    cout << repeat('-', 50) << endl;
    cout << "El arbol tiene " << totalHojas << " nodos hoja." << endl;
    cout << "\nPresione ENTER para continuar...";
    cin.ignore();
    cin.get();
}

// ==================== MENÚ EJERCICIO 5 ====================
void menuEjercicio5() {
    int opcion;
    do {
        cout << "\n" << repeat('-', 50) << endl;
        cout << "     EJERCICIO 5 - Sistema Web como arbol binario" << endl;
        cout << repeat('-', 50) << endl;
        cout << "  1. Validar Preorden" << endl;
        cout << "  2. Validar Postorden" << endl;
        cout << "  3. Validar BFS (Niveles)" << endl;
        cout << "  4. Mostrar recorridos correctos" << endl;
        cout << "  5. Explicacion de recorridos" << endl;
        cout << "  0. Volver al menu principal" << endl;
        cout << repeat('-', 50) << endl;
        cout << "Seleccione una opcion: ";
        
        cin >> opcion;
        cin.ignore();
        
        switch(opcion) {
            case 1:
                validarRecorridoTextoInteractivo(preordenTextoQ, "PREORDEN",
                    "Esperado: Sistema_Web, Usuarios, Registrar, Buscar, Inventario, Productos, Reportes");
                break;
            case 2:
                validarRecorridoTextoInteractivo(postordenTextoQ, "POSTORDEN",
                    "Esperado: Registrar, Buscar, Usuarios, Productos, Reportes, Inventario, Sistema_Web");
                break;
            case 3:
                validarRecorridoTextoInteractivo(bfsTextoQ, "BFS (NIVELES)",
                    "Esperado: Sistema_Web, Usuarios, Inventario, Registrar, Buscar, Productos, Reportes");
                break;
            case 4:
                cout << "\n>>> RECORRIDOS CORRECTOS DEL SISTEMA WEB <<<" << endl;
                cout << "Preorden:  " << queueTextoToString(preordenTextoQ) << endl;
                cout << "Postorden: " << queueTextoToString(postordenTextoQ) << endl;
                cout << "BFS:       " << queueTextoToString(bfsTextoQ) << endl;
                break;
            case 5:
                cout << "\n>>> EXPLICACION DE RECORRIDOS PARA SISTEMA WEB <<<" << endl;
                cout << "1. PREORDEN (Raiz -> Izquierda -> Derecha):" << endl;
                cout << "   - Muestra primero el modulo principal (Sistema_Web)" << endl;
                cout << "   - Util para mostrar menu principal" << endl;
                cout << "\n2. POSTORDEN (Izquierda -> Derecha -> Raiz):" << endl;
                cout << "   - Procesa primero los submodulos internos" << endl;
                cout << "   - Util para validar permisos antes de acceder al padre" << endl;
                cout << "\n3. BFS / NIVELES:" << endl;
                cout << "   - Muestra todos los modulos por nivel jerarquico" << endl;
                cout << "   - Ideal para interfaces de usuario" << endl;
                break;
            case 0:
                cout << "\n>>> VOLVIENDO AL MENU PRINCIPAL <<<" << endl;
                break;
            default:
                cout << "\n>>> OPCION INVALIDA <<<" << endl;
        }
    } while(opcion != 0);
}

// ==================== VALIDACIÓN PARA NÚMEROS ====================
void validarRecorridoNumericoInteractivo(queue<int> recorridoReal, string nombreRecorrido, string esperado) {
    cout << "\n>>> VALIDANDO RECORRIDO " << nombreRecorrido << " <<<" << endl;
    cout << "Ingrese la secuencia de numeros separados por espacios:" << endl;
    cout << "Ejemplo: " << esperado.substr(esperado.find(": ") + 2) << endl;
    cout << "→ ";
    
    string linea;
    getline(cin, linea);
    vector<int> ingresado = splitToInt(linea);
    
    cout << "\n>>> CORRIENDO VALIDACION PARA " << nombreRecorrido << " <<<" << endl;
    
    if (validarRecorridoNumerico(recorridoReal, ingresado)) {
        cout << "✓ ¡RECORRIDO CORRECTO!" << endl;
        cout << "  La secuencia ingresada coincide con el recorrido " << nombreRecorrido << endl;
    } else {
        cout << "✗ ERROR: RECORRIDO INCORRECTO" << endl;
        cout << "  " << esperado << endl;
    }
}

// ==================== VALIDACIÓN PARA TEXTO ====================
void validarRecorridoTextoInteractivo(queue<string> recorridoReal, string nombreRecorrido, string esperado) {
    cout << "\n>>> VALIDANDO RECORRIDO " << nombreRecorrido << " (SISTEMA WEB) <<<" << endl;
    cout << "Ingrese la secuencia de palabras separadas por espacios:" << endl;
    cout << "Ejemplo: " << esperado.substr(esperado.find(": ") + 2) << endl;
    cout << "→ ";
    
    string linea;
    getline(cin, linea);
    vector<string> ingresado = splitToString(linea);
    
    cout << "\n>>> CORRIENDO VALIDACION PARA " << nombreRecorrido << " <<<" << endl;
    
    if (validarRecorridoTexto(recorridoReal, ingresado)) {
        cout << "✓ ¡RECORRIDO CORRECTO!" << endl;
        cout << "  La secuencia ingresada coincide con el recorrido " << nombreRecorrido << endl;
    } else {
        cout << "✗ ERROR: RECORRIDO INCORRECTO" << endl;
        cout << "  " << esperado << endl;
    }
}