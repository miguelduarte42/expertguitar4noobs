/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package expertguitar4noobs;

import de.hardcode.jxinput.Button;
import de.hardcode.jxinput.JXInputDevice;
import de.hardcode.jxinput.JXInputManager;
import de.hardcode.jxinput.event.JXInputButtonEvent;
import de.hardcode.jxinput.event.JXInputButtonEventListener;
import de.hardcode.jxinput.event.JXInputEventManager;
import de.hardcode.jxinput.test.ButtonListener;

/**
 *
 * @author LUISTEOFILO
 */
public class Main {

    public static JXInputDevice getGuitarHeroController() {
        System.out.println(JXInputManager.getNumberOfDevices());
        for (int i = 0; i != JXInputManager.getNumberOfDevices(); ++i) {
            JXInputDevice device = JXInputManager.getJXInputDevice(i);
            if (device.getName().equals("Guitar Hero3 for PlayStation (R) 3")) {
                return device;
            }
        }

        return null;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        JXInputDevice gh3c = getGuitarHeroController();

        GuiterHeroHandler event = new GuiterHeroHandler();

        Button greenButton = null;

        for (int i = 0; i != gh3c.getNumberOfButtons(); ++i) {
            JXInputEventManager.addListener(event, gh3c.getButton(i));
        }

        JXInputEventManager.setTriggerIntervall(10);
        

        Thread.sleep(100000000);
        

        /*JXInputEventManager.

        while
         (true) {
        }*/

        /*
        Button b = gh3c.getButton(1);

        System.out.println(b.getType()==Button.PUSHBUTTON);


        while(true) {
        if(b.getState()) {
        System.out.println("CARREGOU!");
        }
        }*/
    }
}
