import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Opmaak {
    public static int breedte;
    public static int hoogte;
    public static List<Integer> hoogsteCijfers = new ArrayList<>();
    public static List<List<Integer>> l1 = new ArrayList<>();
    public static List<Integer> l2 = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);
    public static int TestGeval;

    public static void main(String[] args) {

        int testGevallen = sc.nextInt();

        for (int l = 1; l <= testGevallen; l++) {
            TestGeval = l;
            breedte = sc.nextInt();
            hoogte = sc.nextInt();

            //fill
            fill();

            //hoogstecijfer
            System.out.print(l+" ");
            hoogsteCijfer();

            //printCijfers
            System.out.print(l+" ");
            printCijfers();

            //print tussenlijn
            System.out.print(l+" ");
            printTussenlijn();

            //print som
            System.out.print("\n"+l+" ");
            printSom();
        }
    }

    private static void fill() {
        for (int i = 0; i< hoogte; i++){
            for (int j = 0; j<breedte; j++){
                l2.add(sc.nextInt());
            }
            l1.add(l2);
            l2 = new ArrayList<>();
        }
    }

    private static void hoogsteCijfer() {
        for (int i = 0; i<breedte;i++){
            int hoogsteCijfer = l1.get(1).get(i);
            for (int j = 0; j< hoogte; j++){
                if (l1.get(j).get(i)>hoogsteCijfer){
                    hoogsteCijfer = l1.get(j).get(i);
                }
            }
            hoogsteCijfers.add(hoogsteCijfer);
        }
    }

    public static void printCijfers(){
        for (int i = 0; i<hoogte; i++){
            System.out.print(TestGeval+" ");
            for (int j = 0; j<l1.get(i).size(); j++){
                int verschil = hoogsteCijfers.get(j).toString().length() - l1.get(i).get(j).toString().length();
                for (int k = 0; k<verschil; k++){
                    System.out.print(" ");
                }
                System.out.print(l1.get(i).get(j));
                if(j != breedte-1){
                    System.out.print(" | ");
                }
            }
            System.out.println();
        }
    }

    public static void printTussenlijn(){
        for (int i = 0; i<breedte; i++){
            int kak = hoogsteCijfers.get(i).toString().length()+1;
            if (i != 0)
                kak = hoogsteCijfers.get(i).toString().length()+2;
            for (int j = 0; j<kak; j++){
                System.out.print("-");
            }
            if (i != breedte-1)
                System.out.print("+");
        }
    }

    public static void printSom(){
        for (int i = 0; i<breedte; i++){
            int som = 0;
            for (int j = 0; j<hoogte; j++){
                som += l1.get(j).get(i);
            }
            System.out.print(som);
            if (i!=breedte-1){
                System.out.print(" | ");
            }
        }
    }
}
