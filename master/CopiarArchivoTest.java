import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class CopiarArchivoTest {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        String nombreArchivo;
        System.out.print("\n\t Escribe el nombre del archivo a copiar: ");
        nombreArchivo = entrada.nextLine();

        Path path = Paths.get(nombreArchivo);
        if (Files.exists(path)) {
            System.out.println("\n\t El archivo existe.");
            try {
                Path origen = Paths.get(nombreArchivo);
                String nombreCopia;
                System.out.print("\n\t Nombra la copia: ");
                nombreCopia = entrada.nextLine();
                Path destino = Paths.get(nombreCopia);
                Files.copy(origen, destino, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("\n\t El archivo no existe.");
        }

        entrada.close();
    }

}
