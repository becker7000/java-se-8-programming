import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AgrupacionParticionTest {

    public static void main(String[] args) {
        // Crear una lista de nombres (con algunos repetidos)
        List<String> nombres = Arrays.asList(
                "Ana", "Juan", "Pedro", "Ana", "Luis",
                "Pedro", "Juan", "María", "José", "Luis"
        );

        // Ordenar la lista en forma ascendente
        List<String> nombresOrdenados = nombres.stream()
                .sorted()
                .collect(Collectors.toList());

        // Agrupar por incidencia
        Map<String, Long> nombresAgrupados = nombres.stream()
                .collect(Collectors.groupingBy(nombre -> nombre, Collectors.counting()));

        // Particionar en dos listas: una con más de 3 letras y otra con 3 o menos
        Map<Boolean, List<String>> particionados = nombres.stream()
                .collect(Collectors.partitioningBy(nombre -> nombre.length() > 3));

        // Mostrar resultados
        System.out.println("Nombres ordenados: " + nombresOrdenados);
        System.out.println("Nombres agrupados: " + nombresAgrupados);
        System.out.println("Partición (más de 3 letras): " + particionados.get(true));
        System.out.println("Partición (3 letras o menos): " + particionados.get(false));

    }

}
