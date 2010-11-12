package expertguitar4noobs;

public class Tab {

    final int FRET_NOT_USED = -1;

    int[] frets;

    public static int getNote(int string, int fret) {
        int[] initial_notes = {40,45,50,55,59,64};
        return initial_notes[string]+fret;
    }

    public Tab(int E_stringFret, int A_stringFret, int D_stringFret, int G_stringFret, int B_stringFret, int e_stringFret) {
        frets = new int[] {
            E_stringFret,
            A_stringFret,
            D_stringFret,
            G_stringFret,
            B_stringFret,
            e_stringFret
        };
    }

    public void play() {
        MidiPlayer mp = MidiPlayer.getInstance();

        for(int i = 0; i != frets.length; ++i) {
            if(frets[i] != FRET_NOT_USED) {
                mp.startNote(getNote(i,frets[i]));
            }
        }
    }

    public void shut() {
        MidiPlayer mp = MidiPlayer.getInstance();

        for(int i = 0; i != frets.length; ++i) {
            if(frets[i] != FRET_NOT_USED) {
                mp.stopNote(getNote(i,frets[i]));
            }
        }
    }

    public void strum() {
        MidiPlayer mp = MidiPlayer.getInstance();

        for(int i = 0; i != frets.length; ++i) {
            if(frets[i] != FRET_NOT_USED) {
                mp.startNote(getNote(i,frets[i]));
                try { Thread.sleep(50); } catch(Exception e) {}
            }
        }
    }
}
