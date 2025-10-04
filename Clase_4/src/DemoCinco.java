import java.util.*;

public class DemoCinco {

    static class Util {
        static int doble(int x) { return x * 2; }
    }

    class Validador {
        boolean noVacio(String s) { return s != null && !s.isBlank(); }
    }

    public void ejemplo() {

        class Par {
            int a,b; Par(int a, int b){ this.a = a; this.b = b; }
            int suma(){return a + b;}
        }
        System.out.println(new Par(2,3).suma());


        List<String> l = new ArrayList<>(Arrays.asList("zzz","a","mm"));
        l.sort(new Comparator<String>() {
            @Override public int compare(String o1, String o2) { return Integer.compare(o1.length(), o2.length());}
        });


        l.sort(Comparator.comparingInt(String::length));
        System.out.println(l);
    }

    public static void main(String[] args) {
        System.out.println(Util.doble(5));
        new DemoCinco().ejemplo();
    }
}
