import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrenciaTest {

    // Contador atómico para mantener un valor seguro en un entorno concurrente
    // Ayuda a evitar el uso de synchronized
    private static final AtomicInteger contador = new AtomicInteger(0);

    public static void main(String[] args) {

        // Crear un ExecutorService con un grupo fijo de 3 hilos
        ExecutorService ejecutor = Executors.newFixedThreadPool(3);

        // Lista para almacenar los resultados de las tareas
        List<Future<String>> resultados = new ArrayList<>();

        // Crear 5 tareas usando Callable
        for (int i = 0; i < 15; i++) {
            int idTarea = i; // Almacenar el ID de la tarea actual
            // Enviar la tarea al ejecutor y almacenar el futuro en la lista
            // Submit se implementa con Callable (interfaz funcional)
            resultados.add(ejecutor.submit(() -> {
                // Simular un trabajo que toma tiempo
                Thread.sleep(800); // Implementa a la interfaz Runnable
                // Incrementar el contador de manera atómica y obtener el nuevo valor
                int nuevoValor = contador.incrementAndGet();
                // Retornar un mensaje indicando el resultado de la tarea
                return "Tarea " + idTarea + " incrementó contador a: " + nuevoValor;
            }));
        }

        // Cerrar el ExecutorService para que no acepte más tareas
        ejecutor.shutdown();

        // Recoger y mostrar los resultados de las tareas completadas
        for (Future<String> resultado : resultados) {
            try {
                // Obtener y mostrar el resultado de cada tarea
                System.out.println(resultado.get());
            } catch (InterruptedException | ExecutionException e) {
                // Manejar posibles excepciones y mostrar un mensaje de error
                System.err.println("Error en la ejecución: " + e.getMessage());
            }
        }

        // Ejemplo de uso de colecciones concurrentes
        // Crear un mapa concurrente que permite acceso seguro desde múltiples hilos
        ConcurrentMap<String, Integer> mapaConcurrente = new ConcurrentHashMap<>();
        // Agregar elementos al mapa concurrente
        mapaConcurrente.put("A", 1);
        mapaConcurrente.put("B", 2);
        mapaConcurrente.put("C", 3);

        // Mostrar el contenido del mapa concurrente
        mapaConcurrente.forEach((clave, valor) -> System.out.println(clave + ": " + valor));
    }

}
