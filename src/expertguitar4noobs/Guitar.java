package expertguitar4noobs;

import de.hardcode.jxinput.Axis;
import de.hardcode.jxinput.JXInputDevice;
import de.hardcode.jxinput.JXInputManager;
import de.hardcode.jxinput.event.JXInputEventManager;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Guitar {

    private static String[] compatibleDevices = new String[]{
        "Guitar Hero3 for PlayStation (R) 3"
    };
    private JXInputDevice device;// = getGuitarHeroController();
    private Keys pressedKeys;
    private Hashtable<Keys, Tab> mappings;
    private GuitarNoteHandler noteHandler;
    private GuitarHatHandler hatHandler;
    private GuitarDistorsionHandler distorsionHandler;
    private Tab lastTab = null;
    //private boolean isPlaying = false;

    @SuppressWarnings("UseOfObsoleteCollectionType")
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

        this.pressedKeys = new Keys(new boolean[]{false, false, false, false, false});
        this.noteHandler = new GuitarNoteHandler(this);
        this.hatHandler = new GuitarHatHandler(this);
        this.distorsionHandler = new GuitarDistorsionHandler(this);
        this.mappings = new Hashtable<Keys, Tab>();

        System.out.println("Device Buttons");
        for (int i = 0; i != device.getNumberOfButtons(); ++i) {
            System.out.println(device.getButton(i).getName());
            JXInputEventManager.addListener(noteHandler, device.getButton(i));
        }

        for (int i = 0; i != device.getNumberOfDirectionals(); ++i) {
            System.out.println(device.getDirectional(i).getName());
            JXInputEventManager.addListener(hatHandler, device.getDirectional(i));
        }

        for (int i = 0; i != device.getMaxNumberOfAxes(); ++i) {
            Axis a = device.getAxis(i);
            if (a != null) {
                System.out.println(a.getName());
                JXInputEventManager.addListener(distorsionHandler, a);
            }
        }

        JXInputEventManager.setTriggerIntervall(1);
    }

    public Keys getPressedKeys() {
        return pressedKeys;
    }

    public void changeKeyState(int pos) {
        pressedKeys.checked[pos] = !pressedKeys.checked[pos];
    }

    void setKeyState(int i, boolean state) {
        pressedKeys.checked[i] = state;
    }

    void shut() {
        if (lastTab != null) {
            lastTab.shut(false);
            //try { Thread.sleep(300); } catch(Exception ex) {}
//            isPlaying = false;
        }
    }

    void playTab() {
        Tab newTab = mappings.get(pressedKeys);
        if (newTab == null) {
            return;
        }
        if (lastTab != null) {
            if (lastTab != newTab) {
                lastTab.shut(true);
                //try { Thread.sleep(1000); } catch (Exception ex) {}
            }
        }
        newTab.play();
        lastTab = newTab;
    }

    public void mapKeys(Keys keys, Tab tab) {
        if (keys.hasChecked()) {
            mappings.put(keys, tab);
        }
    }

    public void unmapKeys(Keys keys) {
        mappings.remove(keys);
    }

    void setDistorsion(double val) {
        lastTab.setDistorsion(val);
    }
}
