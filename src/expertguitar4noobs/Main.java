package expertguitar4noobs;

public class Main {

    static Tab AM = new Tab(-1, 0, 2, 2, 2, 0, true);
    static Tab BM = new Tab(-1, 2, 4, 4, 4, 2, true);
    static Tab CM = new Tab(3, 3, 0, 2, 1, 0, true);
    static Tab DM = new Tab(-1, -1, 0, 2, 3, 2, true);
    static Tab EM = new Tab(0, 2, 2, 1, 0, 0, true);
    static Tab FM = new Tab(1, 3, 3, 2, 1, 1, true);
    static Tab GM = new Tab(3, 2, 0, 0, 3, 3, true);

    static Tab Am = new Tab(-1, -1, 2, 2, 1, 0, true);
    static Tab Bm = new Tab(-1, 2, 4, 4, 3, 2, true);
    //static Tab Cm_chord = new Tab(3, 3, 0, 2, 1, 0, true);
    static Tab Dm = new Tab(-1, -1, 0, 2, 3, 1, true);
    static Tab Em = new Tab(0, 2, 2, 0, 0, 0, true);
    static Tab Fm = new Tab(1, 3, 3, 1, 1, 1, true);
    static Tab Gm = new Tab(3, 5, 5, 3, 3, 3, true);

    static Tab Power1 = new Tab(3, 5, -1, -1, -1, -1, true);
    static Tab Power2 = new Tab(6, 8, -1, -1, -1, -1, true);
    static Tab Power3 = new Tab(8, 10, -1, -1, -1, -1, true);
    static Tab Power4 = new Tab(9, 11, -1, -1, -1, -1, true);


    /*public static void main(String[] args) throws InterruptedException, Exception {
       
        Guitar guitar = new Guitar();

        guitar.mapKeys(new Keys(new boolean[] {true, false, false, false, false}), Power1);
        guitar.mapKeys(new Keys(new boolean[] {false, true, false, false, false}), Power2);
        guitar.mapKeys(new Keys(new boolean[] {false, false, true, false, false}), Power3);
        guitar.mapKeys(new Keys(new boolean[] {false, false, false, true, false}), Power4);

        //guitar.mapKeys(new Keys(new boolean[] {false, true, false, false, false}), Bchord);
        //guitar.mapKeys(new Keys(new boolean[] {false, false, true, false, false}), Cchord);

        /*Tab tab = new Tab(3, 2, 0, 0, 3, 3, true);//.strum();



        tab.play();
        Thread.sleep(2000);
        tab.shut();
        
        Thread.sleep(100000000);
    }*/
}
