package expertguitar4noobs;

public class Tab {

    final int FRET_NOT_USED = -1;
    protected boolean strum;
    protected int[] frets;

    public static int getNote(int string, int fret) {
        int[] initial_notes = {40,45,50,55,59,64};
        return initial_notes[string]+fret;
    }

    public Tab(int E_stringFret, int A_stringFret, int D_stringFret, int G_stringFret, int B_stringFret, int e_stringFret, boolean strum) {
        frets = new int[] {
            E_stringFret,
            A_stringFret,
            D_stringFret,
            G_stringFret,
            B_stringFret,
            e_stringFret
        };
        this.strum = strum;
    }

    public void play() {
        new StartNoteThread(this).start();
    }

    public void shut() {
        new EndNoteThread(this).start();
    }
}
