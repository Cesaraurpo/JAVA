import java.util.*;

public class DemoUno {
    public static void main(String[] args) {
        //wrappers
        int p = 10; //Primitivo
        Integer w = p; //Autoboxing. integer sirve para trabajar valores primitivos como objetos
        int q = w; //Unboxing. se pasa otra vez de objeto a primitivo

        List<Integer> nums = Arrays.asList(1,2,3);
        int suma = 0;
        for (Integer n : nums) suma += n;

        Integer a = 128, b = 128;
        System.out.println(a == b);
        System.out.println(a.equals(b));

        int x = Integer.parseInt("42");
        double y = Double.parseDouble("3.14");
        System.out.println("Resultado: " + (suma + x + y));
    }
}
