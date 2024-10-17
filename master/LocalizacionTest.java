import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class LocalizacionTest {

    public static void main(String[] args) {
        // Lectura del locale del usuario
        Scanner scanner = new Scanner(System.in);
        System.out.print("Seleccione un idioma (en/es): ");
        String idioma = scanner.nextLine();

        // Establecimiento del locale
        Locale locale;
        if (idioma.equals("es")) {
            locale = new Locale("es", "ES"); // Español
        } else {
            locale = new Locale("en", "US"); // Inglés
        }

        // Cargar el resource bundle correspondiente
        ResourceBundle mensajes = ResourceBundle.getBundle("MessagesBundle", locale);

        // Llamar a los mensajes del resource bundle
        System.out.println(mensajes.getString("greeting"));
        System.out.println(mensajes.getString("farewell"));

        // Cierre del scanner
        scanner.close();
    }

}
