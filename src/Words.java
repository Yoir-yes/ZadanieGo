import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Words {
    private static final File plik = new File("C:\\Users\\Erni\\IdeaProjects\\ZadanieGo\\src\\chat.txt");
    private static List<Integer> values = new ArrayList<>();
    private static List<StringBuilder> key = new ArrayList<>();


    public  List<Integer> get_number_of_words() throws FileNotFoundException{
        Scanner scanner = new Scanner(plik);
        int n;
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Scanner lineScanner = new Scanner(line);
            n = 0;
            StringBuilder word = new StringBuilder();
            while (lineScanner.hasNext()) {
                word.append(lineScanner.next());
                n++;
            }
            values.add(n-1);
        }
        return values;
    }
    public  List<StringBuilder> get_name() throws FileNotFoundException {
        Scanner scanner = new Scanner(plik);
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            StringBuilder name = new StringBuilder();
            for (int i = 0; i < line.length(); i++) {
                if ((int) line.charAt(i) == 58) {
                    for (int j = 0; j < i; j++) {
                        String letter = String.valueOf(line.charAt(j));
                        name.append(letter);
                    }
                }
            }
            key.add(name);
        }
        return key;
    }

    public void dispaly() throws FileNotFoundException {
        key = get_name();
        values = get_number_of_words();
        ArrayList<Pair> pairs = new ArrayList<>();
        for(int i = 0 ; i < key.size(); i++)
        {
            pairs.add(new Pair(key.get(i).toString(), values.get(i)));
        }
        Collections.sort(pairs);
        for (Pair p: pairs
             ) {
            System.out.println(p);

        }
    }
    private static class Pair implements Comparable<Pair>{

        String name;
        int number;

        public Pair(String name, int number)
        {
            this.name = name;
            this.number = number;
        }
        @Override
        public int compareTo(Pair p) {
            return Integer.compare(p.number , this.number);
        }
        public String toString(){
            return name+": "+ number;
        }
    }
}
