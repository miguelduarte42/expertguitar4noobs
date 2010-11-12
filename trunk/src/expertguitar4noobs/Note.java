/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package expertguitar4noobs;

/**
 *
 * @author MiKe
 */
public class Note {

    private int string;
    private int fret;

    public Note(int string, int fret) {
        this.string = string;
        this.fret = fret;
    }

    public int getString() {
        return string;
    }

    public int getFret() {
        return fret;
    }

    @Override
    public boolean equals(Object obj) {
        try{
            Note other_note = (Note)obj;

            if(other_note.string != this.string || other_note.fret != this.fret)
                return false;
            
        } catch (Exception e) {
            return false;
        }
        
        return true;
    }
}
