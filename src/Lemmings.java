import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Oefening2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        class Lemming {
            int position;
            boolean direction;
        }

        List<Lemming> lemmings = new ArrayList<>();
        int kamerBreedte;
        int aantalLemmings;
        int counterTijd=0;
        int gevalNummer=0;
        int aantalGevallen = sc.nextInt();
        for (int j = 1; j <= aantalGevallen; j++) {
            kamerBreedte = sc.nextInt();
            aantalLemmings = sc.nextInt();

            for (int i = 0; i < aantalLemmings; i++) {
                String input = sc.next(); // Line
                if (!input.equals("")){
                    int pos = Integer.parseInt(input.substring(0,(input.length()-1)));
                    boolean dir = false;
                    if (input.substring(input.length()-1).equals("R")) { dir = true;}
                    Lemming lemming = new Lemming();
                    lemming.direction = dir;
                    lemming.position = pos;
                    lemmings.add(lemming);
                }

            }

            int hoogste = lemmings.stream().max((l, k) -> l.position - k.position).get().position;
            System.out.println("hoog: " + hoogste);
            gevalNummer++;
            while (hoogste > 0) {
                List<Integer> positions = new ArrayList<>();
                for (Lemming lemming: lemmings ) {
                    positions.add(lemming.position);
                }
                for (Lemming lemming: lemmings ) {
                    if (positions.contains(lemming.position) || lemming.position == kamerBreedte) {
                        if (lemming.direction == true){lemming.direction = false;}
                        else {lemming.direction = true;}
                    }
                }
                for (Lemming lemming: lemmings) {
                    if (lemming.direction == true) {
                        lemming.position += 1; //0.5 proberen indien niet werkt
                    } else {
                        lemming.position -= 1;
                    }
                }
                hoogste = lemmings.stream().max((l, k) -> l.position - k.position).get().position;
                counterTijd++;
            }

            System.out.println(gevalNummer + " " + counterTijd);
        }


    }
}
