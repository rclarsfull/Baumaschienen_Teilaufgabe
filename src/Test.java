import java.time.LocalDate;

public class Test {
    public static void main(String[]args){
        Baumaschiene bm1=new Baumaschiene("Machiene","Bagger",100,null);
        Auftrag a=new Auftrag(LocalDate.now());
        bm1.buche(a,LocalDate.of(2021,1,1),LocalDate.of(2021,1,5));
        System.out.println(bm1);

        bm1.buche(a,LocalDate.of(2022,1,1),LocalDate.of(2022,2,1));
        System.out.println(bm1);
        bm1.buche(a,LocalDate.of(2021,1,20),LocalDate.of(2021,2,1));// belegt test
        System.out.println(bm1);
        bm1.buche(a,LocalDate.of(2028,1,1),LocalDate.of(2028,2,1)); // am ende
        System.out.println(bm1);
        bm1.buche(a,LocalDate.of(2012,1,1),LocalDate.of(2012,2,1));// am anfang
        System.out.println(bm1);
    }


}
