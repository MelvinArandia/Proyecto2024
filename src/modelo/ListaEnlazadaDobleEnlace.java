
package modelo;
// Clase ListaEnlazadaDobleEnlace
class ListaEnlazadaDobleEnlace {
    Nodo cabeza;
    Nodo cola;

    ListaEnlazadaDobleEnlace() {
        cabeza = null;
        cola = null;
    }

    void agregarTarea(Tarea tarea) {
        Nodo nuevoNodo = new Nodo(tarea);
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            cola.siguiente = nuevoNodo;
            nuevoNodo.anterior = cola;
            cola = nuevoNodo;
        }
    }

    void eliminarTarea(Tarea tarea) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.tarea.getTitulo().equals(tarea.getTitulo())) { // Comparar los titulos de las tareas
                if (actual == cabeza) {
                    cabeza = actual.siguiente;
                    if (cabeza != null) {
                        cabeza.anterior = null;
                    } else {
                        cola = null;
                    }
                } else if (actual == cola) {
                    cola = actual.anterior;
                    cola.siguiente = null;
                } else {
                    actual.anterior.siguiente = actual.siguiente;
                    actual.siguiente.anterior = actual.anterior;
                }
                return;
            }
            actual = actual.siguiente;
        }
    }

    void modificarTarea(Tarea tareaAntigua, Tarea tareaNueva) {
        Nodo actual = cabeza;
        while (actual != null) {
            // Utilizamos equalsIgnoreCase para comparar los titulos sin distinguir entre mayusculas y minusculas
            if (actual.tarea.getTitulo().equalsIgnoreCase(tareaAntigua.getTitulo())) {
                actual.tarea = tareaNueva;
                return;
            }
            actual = actual.siguiente;
        }
    }


    void mostrarTareas() {
        Nodo actual = cabeza;
        System.out.println("-----------------------Tareas-------------------");
        while (actual != null) {
            System.out.println(actual.tarea); // Utilizamos el método toString() de Tarea
            System.out.println(); // Agregar una línea en blanco para separar las tareas
            actual = actual.siguiente;
            System.out.println("------------------------------------------------");
        }
    }


    ListaEnlazadaDobleEnlace filtrarTareas(String estado) {
        ListaEnlazadaDobleEnlace tareasFiltradas = new ListaEnlazadaDobleEnlace();
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.tarea.getEstado().equals(estado)) {
                tareasFiltradas.agregarTarea(actual.tarea);
            }
            actual = actual.siguiente;
        }
        return tareasFiltradas;
    }
}

// Clase Nodo para la Lista Enlazada Doble Enlace
class Nodo {
    Tarea tarea;
    Nodo siguiente;
    Nodo anterior;

    Nodo(Tarea tarea) {
        this.tarea = tarea;
        siguiente = null;
        anterior = null;
    }
}
