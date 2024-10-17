import model.Sumador;

import java.util.concurrent.ForkJoinPool;

public class SumadorTest {

    public static void main(String[] args) {

        // Crear un ForkJoinPool (Clase base de RecursiveTask<>)
        ForkJoinPool pool = new ForkJoinPool();

        // Crear una tarea para sumar los números del 0 al 100
        Sumador sumaTarea = new Sumador(0, 100);

        // Ejecutar la tarea y obtener el resultado
        int resultado = pool.invoke(sumaTarea);

        // Mostrar el resultado
        System.out.println("La suma de los números del 0 al 99 es: " + resultado);

    }

}
