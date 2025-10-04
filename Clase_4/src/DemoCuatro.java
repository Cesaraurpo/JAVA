import java.io.*;
import java.util.*;

public class DemoCuatro {
    public static void main(String[] args) {
        File archivo = new File("datos.txt");


        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))){
            bw.write("10"); bw.newLine();
            bw.write("20"); bw.newLine();
            bw.write("30"); bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }


        int suma = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))){
            String linea;
            while ((linea = br.readLine()) != null) {
                suma += Integer.parseInt(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Suma (BR): " + suma);


        try (Scanner sc = new Scanner(archivo)){
            int count = 0;
            while (sc.hasNextInt()) {
                count += sc.nextInt();
            }
            System.out.println("Suma (Scanner): " + count);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        try (PrintWriter out = new PrintWriter(new FileWriter("reporte.txt"))){
            out.printf("Total: %d%n", suma);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
