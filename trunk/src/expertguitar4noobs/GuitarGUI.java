/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package expertguitar4noobs;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.sound.midi.*;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 *
 * @author MiKe
 */
public class GuitarGUI extends JFrame {
    
    private Instrument[] guitars;
    private MidiPlayer player;

    public static void main(String[] args) {
        MidiPlayer mp = new MidiPlayer();

        new GuitarGUI(mp.getGuitars(), mp);
    }

    public GuitarGUI(Instrument[] guitars, MidiPlayer player) {
        super("expert guitar 4 n00bs");

        this.guitars = guitars;
        this.player = player;
        
        this.setLayout(new BorderLayout());

        JPanel right_panel = new JPanel(new BorderLayout());

        JPanel guitar_list_panel = createGuitarListPanel();

        right_panel.add(guitar_list_panel, BorderLayout.NORTH);

        GuitarCanvas canvas = new GuitarCanvas();

        this.add(right_panel,BorderLayout.EAST);
        this.add(canvas,BorderLayout.WEST);

        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public JPanel createGuitarListPanel(){

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder("Escolher Guitarra"));

        JComboBox guitar_list = new JComboBox(guitars);
        panel.add(guitar_list);

        return panel;
    }

}
