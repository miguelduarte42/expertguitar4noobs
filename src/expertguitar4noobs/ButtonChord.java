/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package expertguitar4noobs;

import java.util.ArrayList;

/**
 *
 * @author MiKe
 */
public class ButtonChord {

    private ArrayList<Note> notes = new ArrayList<Note>();

    public void addNote(Note note){
        notes.add(note);
    }

    public void removeNote(Note note){
        notes.remove(note);
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }

    @Override
    public boolean equals(Object obj) {
        try{
            ButtonChord other_bc = (ButtonChord)obj;

           for(Note note : this.notes)
               if(!other_bc.getNotes().contains(note))
                   return false;

        } catch (Exception e) {
            return false;
        }

        return true;
    }

}
