package model;

import java.util.concurrent.RecursiveTask;

public class Sumador extends RecursiveTask<Integer> {

    private final int inicio;
    private final int fin;
    private static final int LIMITE = 10; // Umbral para dividir la tarea

    public Sumador(int inicio, int fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    @Override
    protected Integer compute() {
        // Si el rango es menor o igual al umbral, sumar directamente
        if (fin - inicio <= LIMITE) {
            int suma = 0;
            for (int i = inicio; i < fin; i++) {
                suma += i;
            }
            return suma;
        } else {

            // Dividir la tarea en subtareas
            int medio = (inicio + fin) / 2;
            Sumador tareaIzquierda = new Sumador(inicio, medio);
            Sumador tareaDerecha = new Sumador(medio, fin);

            // Fork (dividir)
            tareaIzquierda.fork();

            // Compute (calcular) la tarea derecha
            int resultadoDerecho = tareaDerecha.compute();

            // Join (unir) el resultado de la tarea izquierda
            int resultadoIzquierdo = tareaIzquierda.join();

            // Retornar la suma de ambos resultados
            return resultadoIzquierdo + resultadoDerecho;
        }
    }

}
