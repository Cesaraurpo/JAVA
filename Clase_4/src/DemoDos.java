import java.util.*;

public class DemoDos {
    public static void main(String[] args) {

        List<String> a = new ArrayList<>();
        a.add("A"); a.add("c"); a.add(1, "B");
        System.out.println("ArrayList: " + a); //[A,B,C]

        Deque<String> dq = new LinkedList<>();
        dq.addFirst("B"); dq.addLast("c"); dq.addFirst("A");
        System.out.println("LinkedList/Deque: " + dq);
        System.out.println("Pop: " + dq.removeFirst());

        Set<String> set = new HashSet<>(Arrays.asList("rojo","verde","rojo","azul"));
        System.out.println("HashSet: " + set);

        Set<String> orden = new TreeSet<>(Arrays.asList("z","b","a","c"));
        System.out.println("TreeSet: " + orden);

        Map<String, Integer> edades = new HashMap<>();
        edades.put("Ana", 28);
        edades.put("Luis", 35);
        edades.put("Ana", 29); //Sobrescribe
        System.out.println("HashMap: " + edades);

        Map<String, Integer> puntuacion = new TreeMap<>();
        puntuacion.put("Mar", 80);
        puntuacion.put("Alba", 95);
        puntuacion.put("Zoe", 77);
        System.out.println("TreeMap: " + puntuacion);
        System.out.println("Primero: " + ((TreeMap<String,Integer>)puntuacion).firstEntry());
    }
}
