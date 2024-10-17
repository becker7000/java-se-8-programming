import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeerArchivoTest {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("hola.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
