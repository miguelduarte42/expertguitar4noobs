package expertguitar4noobs;

public class Main {

    public static void main(String[] args) throws InterruptedException, Exception {
       
        Guitar guitar = new Guitar();

        Tab tab = new Tab(3, 2, 0, 0, 3, 3);//.strum();

        tab.strum();
        Thread.sleep(2000);
        tab.shut();
        
        Thread.sleep(100000000);
    }
}
