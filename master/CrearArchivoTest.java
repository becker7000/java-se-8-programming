import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CrearArchivoTest {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        String nombreArchivo;

        System.out.print("\n\t Escribe el nombre del archivo: ");
        nombreArchivo = entrada.nextLine();

        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            String contenido;
            System.out.print("\n\t Contenido: ");
            contenido = entrada.nextLine();
            writer.write(contenido);
        } catch (IOException e) {
            e.printStackTrace();
        }

        entrada.close();
    }

}
