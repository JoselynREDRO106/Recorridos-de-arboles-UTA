import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

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

    // ==================== RECORRIDOS PARA ÁRBOL DE NÚMEROS ====================
    
    // Recorrido preorden: raíz primero
    public static void preorden(Nodo raiz, Queue<Integer> resultado) {
        if (raiz == null) return;
        resultado.add(raiz.dato);
        preorden(raiz.izquierda, resultado);
        preorden(raiz.derecha, resultado);
    }

    // Recorrido inorden: raíz en medio
    public static void inorden(Nodo raiz, Queue<Integer> resultado) {
        if (raiz == null) return;
        inorden(raiz.izquierda, resultado);
        resultado.add(raiz.dato);
        inorden(raiz.derecha, resultado);
    }

    // Recorrido postorden: raíz al final
    public static void postorden(Nodo raiz, Queue<Integer> resultado) {
        if (raiz == null) return;
        postorden(raiz.izquierda, resultado);
        postorden(raiz.derecha, resultado);
        resultado.add(raiz.dato);
    }

    // Recorrido por niveles usando cola (BFS)
    public static void bfs(Nodo raiz, Queue<Integer> resultado) {
        if (raiz == null) return;

        Queue<Nodo> cola = new LinkedList<>();
        cola.add(raiz);

        while (!cola.isEmpty()) {
            Nodo actual = cola.poll();
            resultado.add(actual.dato);

            if (actual.izquierda != null) cola.add(actual.izquierda);
            if (actual.derecha != null) cola.add(actual.derecha);
        }
    }

    // ==================== RECORRIDOS PARA ÁRBOL DE TEXTO ====================
    
    public static void preordenTexto(NodoTexto raiz, Queue<String> resultado) {
        if (raiz == null) return;
        resultado.add(raiz.dato);
        preordenTexto(raiz.izquierda, resultado);
        preordenTexto(raiz.derecha, resultado);
    }

    public static void postordenTexto(NodoTexto raiz, Queue<String> resultado) {
        if (raiz == null) return;
        postordenTexto(raiz.izquierda, resultado);
        postordenTexto(raiz.derecha, resultado);
        resultado.add(raiz.dato);
    }

    public static void bfsTexto(NodoTexto raiz, Queue<String> resultado) {
        if (raiz == null) return;

        Queue<NodoTexto> cola = new LinkedList<>();
        cola.add(raiz);

        while (!cola.isEmpty()) {
            NodoTexto actual = cola.poll();
            resultado.add(actual.dato);

            if (actual.izquierda != null) cola.add(actual.izquierda);
            if (actual.derecha != null) cola.add(actual.derecha);
        }
    }

    // ==================== FUNCIONES DE CONTEO ====================
    
    public static int contarNodos(Nodo raiz) {
        if (raiz == null) return 0;
        return 1 + contarNodos(raiz.izquierda) + contarNodos(raiz.derecha);
    }

    public static int contarHojas(Nodo raiz) {
        if (raiz == null) return 0;
        if (raiz.izquierda == null && raiz.derecha == null) return 1;
        return contarHojas(raiz.izquierda) + contarHojas(raiz.derecha);
    }

    // ==================== FUNCIÓN PARA VALIDAR RECORRIDO DE NÚMEROS ====================
    public static boolean validarRecorrido(Queue<Integer> recorridoReal, int[] ingresado) {
        if (recorridoReal.size() != ingresado.length) return false;
        
        int i = 0;
        for (int valor : recorridoReal) {
            if (valor != ingresado[i]) return false;
            i++;
        }
        return true;
    }
    
    // ==================== FUNCIÓN PARA VALIDAR RECORRIDO DE TEXTO ====================
    public static boolean validarRecorridoTexto(Queue<String> recorridoReal, String[] ingresado) {
        if (recorridoReal.size() != ingresado.length) return false;
        
        int i = 0;
        for (String valor : recorridoReal) {
            if (!valor.equals(ingresado[i])) return false;
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=".repeat(70));
        System.out.println("      RECORRIDOS DE ARBOLES BINARIOS - UTA");
        System.out.println("=".repeat(70));

        // ==================== CONSTRUIR ÁRBOL PARA EJERCICIO 1 (Original) ====================
        Nodo raizEj1 = new Nodo(10);
        raizEj1.izquierda = new Nodo(5);
        raizEj1.derecha = new Nodo(15);
        raizEj1.izquierda.izquierda = new Nodo(2);
        raizEj1.izquierda.derecha = new Nodo(7);
        raizEj1.derecha.izquierda = new Nodo(12);
        raizEj1.derecha.derecha = new Nodo(20);

        // ==================== CONSTRUIR ÁRBOL PARA EJERCICIO 2 (Modificado) ====================
        Nodo raizEj2 = new Nodo(10);
        raizEj2.izquierda = new Nodo(5);
        raizEj2.derecha = new Nodo(15);
        raizEj2.izquierda.izquierda = new Nodo(2);
        raizEj2.izquierda.derecha = new Nodo(7);
        raizEj2.derecha.izquierda = new Nodo(12);
        raizEj2.derecha.derecha = new Nodo(20);
        
        // Agregar nodos del ejercicio 2
        raizEj2.izquierda.izquierda.izquierda = new Nodo(1);
        raizEj2.izquierda.izquierda.derecha = new Nodo(3);
        raizEj2.derecha.derecha.izquierda = new Nodo(18);
        raizEj2.derecha.derecha.derecha = new Nodo(25);

        // ==================== CONSTRUIR ÁRBOL DE TEXTO (Ejercicio 5) ====================
        NodoTexto sistema = new NodoTexto("Sistema_Web");
        sistema.izquierda = new NodoTexto("Usuarios");
        sistema.derecha = new NodoTexto("Inventario");
        sistema.izquierda.izquierda = new NodoTexto("Registrar");
        sistema.izquierda.derecha = new NodoTexto("Buscar");
        sistema.derecha.izquierda = new NodoTexto("Productos");
        sistema.derecha.derecha = new NodoTexto("Reportes");

        // ==================== CALCULAR RECORRIDOS REALES ====================
        Queue<Integer> preordenEj1 = new LinkedList<>();
        Queue<Integer> inordenEj1 = new LinkedList<>();
        Queue<Integer> postordenEj1 = new LinkedList<>();
        Queue<Integer> bfsEj1 = new LinkedList<>();
        
        preorden(raizEj1, preordenEj1);
        inorden(raizEj1, inordenEj1);
        postorden(raizEj1, postordenEj1);
        bfs(raizEj1, bfsEj1);
        
        Queue<Integer> preordenEj2 = new LinkedList<>();
        Queue<Integer> inordenEj2 = new LinkedList<>();
        Queue<Integer> postordenEj2 = new LinkedList<>();
        Queue<Integer> bfsEj2 = new LinkedList<>();
        
        preorden(raizEj2, preordenEj2);
        inorden(raizEj2, inordenEj2);
        postorden(raizEj2, postordenEj2);
        bfs(raizEj2, bfsEj2);
        
        Queue<String> preordenTexto = new LinkedList<>();
        Queue<String> postordenTexto = new LinkedList<>();
        Queue<String> bfsTexto = new LinkedList<>();
        
        preordenTexto(sistema, preordenTexto);
        postordenTexto(sistema, postordenTexto);
        bfsTexto(sistema, bfsTexto);

        // ==================== MENÚ PRINCIPAL POR EJERCICIOS ====================
        int opcion;
        do {
            System.out.println("\n" + "-".repeat(70));
            System.out.println("                     MENU PRINCIPAL");
            System.out.println("-".repeat(70));
            System.out.println("| 1. EJERCICIO 1 - Árbol original (10,5,15,2,7,12,20)          |");
            System.out.println("| 2. EJERCICIO 2 - Árbol modificado (con 1,3,18,25)             |");
            System.out.println("| 3. EJERCICIO 3 - Contar nodos totales                         |");
            System.out.println("| 4. EJERCICIO 4 - Contar hojas                                 |");
            System.out.println("| 5. EJERCICIO 5 - Sistema web como árbol binario               |");
            System.out.println("| 0. SALIR                                                      |");
            System.out.println("-".repeat(70));
            System.out.print("Seleccione un ejercicio: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            
            switch(opcion) {
                case 1:
                    menuEjercicio1(scanner, preordenEj1, inordenEj1, postordenEj1, bfsEj1);
                    break;
                case 2:
                    menuEjercicio2(scanner, preordenEj2, inordenEj2, postordenEj2, bfsEj2);
                    break;
                case 3:
                    menuEjercicio3(scanner, raizEj2);
                    break;
                case 4:
                    menuEjercicio4(scanner, raizEj2);
                    break;
                case 5:
                    menuEjercicio5(scanner, preordenTexto, postordenTexto, bfsTexto);
                    break;
                case 0:
                    System.out.println("\n>>> PROGRAMA FINALIZADO <<<");
                    break;
                default:
                    System.out.println("\n>>> OPCIÓN INVÁLIDA. Intente nuevamente <<<");
            }
            
        } while(opcion != 0);
        
        scanner.close();
    }
    
    // ==================== MENÚ EJERCICIO 1 ====================
    public static void menuEjercicio1(Scanner scanner, Queue<Integer> preorden, Queue<Integer> inorden, 
                                       Queue<Integer> postorden, Queue<Integer> bfs) {
        int opcion;
        do {
            System.out.println("\n" + "-".repeat(50));
            System.out.println("        EJERCICIO 1 - Árbol original");
            System.out.println("     Árbol: 10, 5, 15, 2, 7, 12, 20");
            System.out.println("-".repeat(50));
            System.out.println("  1. Validar Preorden");
            System.out.println("  2. Validar Inorden");
            System.out.println("  3. Validar Postorden");
            System.out.println("  4. Validar BFS (Niveles)");
            System.out.println("  5. Mostrar recorridos correctos");
            System.out.println("  0. Volver al menú principal");
            System.out.println("-".repeat(50));
            System.out.print("Seleccione una opción: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch(opcion) {
                case 1:
                    validarRecorridoNumerico(scanner, preorden, "PREORDEN", 
                        "Esperado: 10, 5, 2, 7, 15, 12, 20");
                    break;
                case 2:
                    validarRecorridoNumerico(scanner, inorden, "INORDEN",
                        "Esperado: 2, 5, 7, 10, 12, 15, 20");
                    break;
                case 3:
                    validarRecorridoNumerico(scanner, postorden, "POSTORDEN",
                        "Esperado: 2, 7, 5, 12, 20, 15, 10");
                    break;
                case 4:
                    validarRecorridoNumerico(scanner, bfs, "BFS (NIVELES)",
                        "Esperado: 10, 5, 15, 2, 7, 12, 20");
                    break;
                case 5:
                    System.out.println("\n>>> RECORRIDOS CORRECTOS DEL ÁRBOL ORIGINAL <<<");
                    System.out.println("Preorden:  " + recorridoToString(preorden));
                    System.out.println("Inorden:   " + recorridoToString(inorden));
                    System.out.println("Postorden: " + recorridoToString(postorden));
                    System.out.println("BFS:       " + recorridoToString(bfs));
                    break;
                case 0:
                    System.out.println("\n>>> VOLVIENDO AL MENÚ PRINCIPAL <<<");
                    break;
                default:
                    System.out.println("\n>>> OPCIÓN INVÁLIDA <<<");
            }
        } while(opcion != 0);
    }
    
    // ==================== MENÚ EJERCICIO 2 ====================
    public static void menuEjercicio2(Scanner scanner, Queue<Integer> preorden, Queue<Integer> inorden,
                                       Queue<Integer> postorden, Queue<Integer> bfs) {
        int opcion;
        do {
            System.out.println("\n" + "-".repeat(50));
            System.out.println("      EJERCICIO 2 - Árbol modificado");
            System.out.println("  Árbol: 10,5,15,2,7,12,20 + (1,3,18,25)");
            System.out.println("-".repeat(50));
            System.out.println("  1. Validar Preorden");
            System.out.println("  2. Validar Inorden");
            System.out.println("  3. Validar Postorden");
            System.out.println("  4. Validar BFS (Niveles)");
            System.out.println("  5. Mostrar recorridos correctos");
            System.out.println("  0. Volver al menú principal");
            System.out.println("-".repeat(50));
            System.out.print("Seleccione una opción: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch(opcion) {
                case 1:
                    validarRecorridoNumerico(scanner, preorden, "PREORDEN",
                        "Esperado: 10, 5, 2, 1, 3, 7, 15, 12, 20, 18, 25");
                    break;
                case 2:
                    validarRecorridoNumerico(scanner, inorden, "INORDEN",
                        "Esperado: 1, 2, 3, 5, 7, 10, 12, 15, 18, 20, 25");
                    break;
                case 3:
                    validarRecorridoNumerico(scanner, postorden, "POSTORDEN",
                        "Esperado: 1, 3, 2, 7, 5, 12, 18, 25, 20, 15, 10");
                    break;
                case 4:
                    validarRecorridoNumerico(scanner, bfs, "BFS (NIVELES)",
                        "Esperado: 10, 5, 15, 2, 7, 12, 20, 1, 3, 18, 25");
                    break;
                case 5:
                    System.out.println("\n>>> RECORRIDOS CORRECTOS DEL ÁRBOL MODIFICADO <<<");
                    System.out.println("Preorden:  " + recorridoToString(preorden));
                    System.out.println("Inorden:   " + recorridoToString(inorden));
                    System.out.println("Postorden: " + recorridoToString(postorden));
                    System.out.println("BFS:       " + recorridoToString(bfs));
                    break;
                case 0:
                    System.out.println("\n>>> VOLVIENDO AL MENÚ PRINCIPAL <<<");
                    break;
                default:
                    System.out.println("\n>>> OPCIÓN INVÁLIDA <<<");
            }
        } while(opcion != 0);
    }
    
    // ==================== MENÚ EJERCICIO 3 ====================
    public static void menuEjercicio3(Scanner scanner, Nodo raiz) {
        int totalNodos = contarNodos(raiz);
        System.out.println("\n" + "-".repeat(50));
        System.out.println("           EJERCICIO 3 - Contar nodos totales");
        System.out.println("-".repeat(50));
        System.out.println("El árbol tiene " + totalNodos + " nodos en total.");
        System.out.println("\nPresione ENTER para continuar...");
        scanner.nextLine();
    }
    
    // ==================== MENÚ EJERCICIO 4 ====================
    public static void menuEjercicio4(Scanner scanner, Nodo raiz) {
        int totalHojas = contarHojas(raiz);
        System.out.println("\n" + "-".repeat(50));
        System.out.println("              EJERCICIO 4 - Contar hojas");
        System.out.println("-".repeat(50));
        System.out.println("El árbol tiene " + totalHojas + " nodos hoja.");
        System.out.println("\nPresione ENTER para continuar...");
        scanner.nextLine();
    }
    
    // ==================== MENÚ EJERCICIO 5 ====================
    public static void menuEjercicio5(Scanner scanner, Queue<String> preorden, 
                                       Queue<String> postorden, Queue<String> bfs) {
        int opcion;
        do {
            System.out.println("\n" + "-".repeat(50));
            System.out.println("     EJERCICIO 5 - Sistema Web como árbol binario");
            System.out.println("-".repeat(50));
            System.out.println("  1. Validar Preorden");
            System.out.println("  2. Validar Postorden");
            System.out.println("  3. Validar BFS (Niveles)");
            System.out.println("  4. Mostrar recorridos correctos");
            System.out.println("  5. Explicación de recorridos");
            System.out.println("  0. Volver al menú principal");
            System.out.println("-".repeat(50));
            System.out.print("Seleccione una opción: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch(opcion) {
                case 1:
                    validarRecorridoTexto(scanner, preorden, "PREORDEN",
                        "Esperado: Sistema_Web, Usuarios, Registrar, Buscar, Inventario, Productos, Reportes");
                    break;
                case 2:
                    validarRecorridoTexto(scanner, postorden, "POSTORDEN",
                        "Esperado: Registrar, Buscar, Usuarios, Productos, Reportes, Inventario, Sistema_Web");
                    break;
                case 3:
                    validarRecorridoTexto(scanner, bfs, "BFS (NIVELES)",
                        "Esperado: Sistema_Web, Usuarios, Inventario, Registrar, Buscar, Productos, Reportes");
                    break;
                case 4:
                    System.out.println("\n>>> RECORRIDOS CORRECTOS DEL SISTEMA WEB <<<");
                    System.out.println("Preorden:  " + recorridoTextoToString(preorden));
                    System.out.println("Postorden: " + recorridoTextoToString(postorden));
                    System.out.println("BFS:       " + recorridoTextoToString(bfs));
                    break;
                case 5:
                    System.out.println("\n>>> EXPLICACIÓN DE RECORRIDOS PARA SISTEMA WEB <<<");
                    System.out.println("1. PREORDEN (Raíz → Izquierda → Derecha):");
                    System.out.println("   - Muestra primero el módulo principal (Sistema_Web)");
                    System.out.println("   - Útil para mostrar menú principal");
                    System.out.println("\n2. POSTORDEN (Izquierda → Derecha → Raíz):");
                    System.out.println("   - Procesa primero los submódulos internos");
                    System.out.println("   - Útil para validar permisos antes de acceder al padre");
                    System.out.println("\n3. BFS / NIVELES:");
                    System.out.println("   - Muestra todos los módulos por nivel jerárquico");
                    System.out.println("   - Ideal para interfaces de usuario");
                    break;
                case 0:
                    System.out.println("\n>>> VOLVIENDO AL MENÚ PRINCIPAL <<<");
                    break;
                default:
                    System.out.println("\n>>> OPCIÓN INVÁLIDA <<<");
            }
        } while(opcion != 0);
    }
    
    // ==================== FUNCIÓN PARA VALIDAR RECORRIDO DE NÚMEROS ====================
    public static void validarRecorridoNumerico(Scanner scanner, Queue<Integer> recorridoReal, 
                                                 String nombreRecorrido, String esperado) {
        System.out.println("\n>>> VALIDANDO RECORRIDO " + nombreRecorrido + " <<<");
        System.out.println("Ingrese la secuencia de números separados por espacios:");
        System.out.print("Ejemplo: " + esperado.split("Esperado: ")[1] + "\n→ ");
        
        String linea = scanner.nextLine();
        String[] partes = linea.trim().split("\\s+");
        int[] ingresado = new int[partes.length];
        
        try {
            for (int i = 0; i < partes.length; i++) {
                ingresado[i] = Integer.parseInt(partes[i]);
            }
            
            System.out.println("\n>>> CORRIENDO VALIDACIÓN PARA " + nombreRecorrido + " <<<");
            
            if (validarRecorrido(recorridoReal, ingresado)) {
                System.out.println("✓ ¡RECORRIDO CORRECTO!");
                System.out.println("  La secuencia ingresada coincide con el recorrido " + nombreRecorrido);
            } else {
                System.out.println("✗ ERROR: RECORRIDO INCORRECTO");
                System.out.println("  Secuencia ingresada: " + arrayToString(ingresado));
                System.out.println("  " + esperado);
            }
        } catch (NumberFormatException e) {
            System.out.println("\n>>> ERROR: Debe ingresar solo números enteros <<<");
        }
    }
    
    // ==================== FUNCIÓN PARA VALIDAR RECORRIDO DE TEXTO ====================
    public static void validarRecorridoTexto(Scanner scanner, Queue<String> recorridoReal,
                                              String nombreRecorrido, String esperado) {
        System.out.println("\n>>> VALIDANDO RECORRIDO " + nombreRecorrido + " (SISTEMA WEB) <<<");
        System.out.println("Ingrese la secuencia de palabras separadas por espacios:");
        System.out.print("Ejemplo: " + esperado.split("Esperado: ")[1] + "\n→ ");
        
        String linea = scanner.nextLine();
        String[] ingresado = linea.trim().split("\\s+");
        
        System.out.println("\n>>> CORRIENDO VALIDACIÓN PARA " + nombreRecorrido + " <<<");
        
        if (validarRecorridoTexto(recorridoReal, ingresado)) {
            System.out.println("✓ ¡RECORRIDO CORRECTO!");
            System.out.println("  La secuencia ingresada coincide con el recorrido " + nombreRecorrido);
        } else {
            System.out.println("✗ ERROR: RECORRIDO INCORRECTO");
            System.out.println("  Secuencia ingresada: " + arrayTextoToString(ingresado));
            System.out.println("  " + esperado);
        }
    }
    
    // ==================== FUNCIONES AUXILIARES ====================
    public static String recorridoToString(Queue<Integer> cola) {
        StringBuilder sb = new StringBuilder();
        for (int valor : cola) {
            sb.append(valor).append(" ");
        }
        return sb.toString().trim();
    }
    
    public static String recorridoTextoToString(Queue<String> cola) {
        StringBuilder sb = new StringBuilder();
        for (String valor : cola) {
            sb.append(valor).append(" ");
        }
        return sb.toString().trim();
    }
    
    public static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(num).append(" ");
        }
        return sb.toString().trim();
    }
    
    public static String arrayTextoToString(String[] arr) {
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s).append(" ");
        }
        return sb.toString().trim();
    }
}