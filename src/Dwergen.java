import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Oefening1 {
    public static void main(String[] args){
        int minDiamant = Integer.MAX_VALUE;
        HashMap<Integer, List<Integer>> diamantWaardes = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int aantalTestgevallen = sc.nextInt();

        for (int i = 1; i <= aantalTestgevallen; i++) {
            int warardeRekening = sc.nextInt();
            int aantalDwergen = sc.nextInt();

            for (int j =0; j<aantalDwergen; j++){
                int aantalDiamanten = sc.nextInt();
                if (aantalDiamanten<minDiamant){
                    minDiamant = aantalDiamanten;
                }

                List<Integer> list = new ArrayList<>();
                for (int k=0; k<aantalDiamanten; k++){
                    int diamantWaarde = sc.nextInt();
                    list.add(diamantWaarde);

                }
                diamantWaardes.put(j,list);
            }

            boolean found = false;

            for (int aantaldiamenten = 1; aantaldiamenten <= minDiamant; aantaldiamenten++){
                if(found)
                    break;

                HashMap<Integer, Integer> dwergIOndex = new HashMap<>();

                for(int dwerg = 0; dwerg < aantalDwergen; dwerg++) {
                    dwergIOndex.put(dwerg, 0);
                }

                int som = 0;

                for(int dwerg = 0; dwerg < aantalDwergen; dwerg++) {
                    int dwergindex = dwergIOndex.get(dwerg);


                    for (int index = dwergindex; index < dwergindex + aantaldiamenten; index++) {
                        som += diamantWaardes.get(dwerg).get(index);
                    }

                    if(som == warardeRekening) {
                        System.out.println(i + " " + aantaldiamenten);
                        // next testcase
                        found = true;
                        break;
                    } else {
                        for(int changeIndexDwerg = 0; changeIndexDwerg < aantalDwergen; changeIndexDwerg++) {

                            int currentIndex = dwergIOndex.get(changeIndexDwerg);
                            int aantalDiamantenDwerg = diamantWaardes.get(changeIndexDwerg).size();

                            if(currentIndex + aantaldiamenten < aantalDiamantenDwerg) {
                                dwergIOndex.put(changeIndexDwerg, currentIndex++);
                                dwerg = 0;
                            }

                        }
                    }
                }
            }

            if(found)
                continue;

            System.out.println(i+ " ONMOGELIJK");
        }

    }
}
