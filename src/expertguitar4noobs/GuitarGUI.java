/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package expertguitar4noobs;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sound.midi.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author MiKe
 */
public class GuitarGUI extends JFrame {
    
    private Instrument[] guitars;
    private MidiPlayer player;
    private Guitar guitar;
    private GuitarCanvas canvas;

    public static void main(String[] args) {
        new GuitarGUI().setVisible(true);
    }

    public GuitarGUI() {
        super("expert guitar 4 n00bs");
        try{
            this.player = MidiPlayer.getInstance();
            this.guitar = new Guitar();
            this.guitars = player.getGuitars();


            this.setLayout(new BorderLayout());

            JPanel right_panel = new JPanel(new BorderLayout());

            JPanel guitar_list_panel = createGuitarListPanel();
            JPanel tab_panel = createTabPanel();

            right_panel.add(guitar_list_panel, BorderLayout.NORTH);
            right_panel.add(tab_panel, BorderLayout.CENTER);

            canvas = new GuitarCanvas();

            this.add(right_panel,BorderLayout.EAST);
            this.add(canvas,BorderLayout.WEST);

            this.pack();
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        } catch (Exception e ){
            e.printStackTrace();
        }
    }

    public JPanel createGuitarListPanel(){

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder("Escolher Guitarra"));

        JComboBox guitar_list = new JComboBox(guitars);
        panel.add(guitar_list);

        return panel;
    }

    public JPanel createTabPanel(){

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder("Mapear Teclas"));

        JButton add_button = new JButton("Mapear");
        add_button.addActionListener(new AddButtonListener());
        
        panel.add(add_button);

        return panel;
    }

    private class AddButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            int[] notas = canvas.getActiveNotes();
            boolean[] buttons = canvas.getActiveButtons();

            Tab tab = new Tab(notas[0], notas[1], notas[2], notas[3], notas[4], notas[5], false);
            guitar.mapKeys(new Keys(buttons), tab);
        }
    }

}
