/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package expertguitar4noobs;

import java.util.ArrayList;
import javax.sound.midi.*;

/**
 *
 * @author MiKe
 */
public class MidiPlayer {

    private static int DEFAULT_NOTE_VELOCITY = 400;
    private MidiChannel channel;
    private Synthesizer synthesizer;
    private Instrument[] guitars;

    public static void main(String[] args) throws Exception {
        MidiPlayer midi = new MidiPlayer();

        //Play and stop a note
        midi.startNote(60);
        Thread.sleep(2000);
        midi.stopNote(60);

        //Change pitch and try again
        midi.changePitch(0);
        midi.startNote(60);
        Thread.sleep(2000);
        midi.stopNote(60);
    }

    public MidiPlayer() {

        try {
            synthesizer = MidiSystem.getSynthesizer();
            synthesizer.open();

            guitars = getGuitars(synthesizer);

            channel = synthesizer.getChannels()[5];
            
            //Distortion Guitar
            changeGuitar(guitars[11]);
        } catch (Exception e) {
            //Bad code is bad. Unhandled Exception never is thrown (I hope)
            e.printStackTrace();
        }
    }

    public void startNote(int note) {
        channel.noteOn(note, DEFAULT_NOTE_VELOCITY);
    }

    public void stopNote(int note) {
        channel.noteOff(note);
    }

    public void changePitch(int pitch) {
        channel.setPitchBend(pitch);
    }

    public void changeGuitar(Instrument guitar) {

        synthesizer.loadInstrument(guitar);
        channel.programChange(guitar.getPatch().getProgram());
    }

    public Instrument[] getGuitars() {
        return guitars;
    }

    private Instrument[] getGuitars(Synthesizer synthesizer) {

        ArrayList<Instrument> guitars_list = new ArrayList<Instrument>();

        for (Instrument inst : synthesizer.getAvailableInstruments()) {
            if (inst.getName().toLowerCase().contains("guitar")) {
                guitars_list.add(inst);
                System.out.println(inst.getName());
            }
        }

        Instrument[] guitars_array = new Instrument[guitars_list.size()];

        int i = 0;
        for (Instrument inst : guitars_list) {
            guitars_array[i] = inst;
            i++;
        }

        return guitars_array;
    }
}
