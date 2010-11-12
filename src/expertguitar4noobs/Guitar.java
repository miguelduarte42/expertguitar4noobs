package expertguitar4noobs;

import de.hardcode.jxinput.JXInputDevice;
import de.hardcode.jxinput.JXInputManager;
import de.hardcode.jxinput.event.JXInputEventManager;
import java.util.HashSet;
import java.util.Hashtable;

public class Guitar {

    private static String[] compatibleDevices = new String[] {
        "Guitar Hero3 for PlayStation (R) 3"
    };

    private JXInputDevice device;// = getGuitarHeroController();
    private boolean[] pressedKeys;
    private Hashtable<Boolean[], Tab> mappings;
    private GuitarNoteHandler eventHandler;

    public Guitar() throws Exception {
        System.out.println("Device List");

        for (int i = 0; i != JXInputManager.getNumberOfDevices(); ++i) {
            JXInputDevice d = JXInputManager.getJXInputDevice(i);

            System.out.println(" - " + d.getName());

            boolean deviceFound = false;

            for (int j = 0; j != compatibleDevices.length; ++j) {
                if (d.getName().equals(compatibleDevices[j])) {
                    deviceFound = true;
                    this.device = d;
                    break;
                }
            }

            if (device != null) {
                break;
            }
        }

        if (device == null) {
            throw new Exception("Guitar device not found!");
        }

        this.pressedKeys = new boolean[5];
        this.eventHandler = new GuitarNoteHandler(this);

        System.out.println("Device Buttons");
        for (int i = 0; i != device.getNumberOfButtons(); ++i) {
            System.out.println(device.getButton(i).getName());
            JXInputEventManager.addListener(eventHandler, device.getButton(i));
        }

        /*for(int i = 0; i != device.getNumberOfAxes(); ++i) {
            System.out.println(device.getAxis(i).getName());

            //JXInputEventManager.addListener(eventHandler, device.getDirectional(i)));
        }*/

        JXInputEventManager.setTriggerIntervall(10);
    }

    public boolean[] getPressedKeys() {
        return pressedKeys;
    }

    public void changeKeyState(int pos) {
        pressedKeys[pos] = !pressedKeys[pos];
    }

    void setKeyState(int i, boolean state) {
        pressedKeys[i] = state;
    }
}
