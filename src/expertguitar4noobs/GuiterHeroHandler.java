/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package expertguitar4noobs;

import de.hardcode.jxinput.event.JXInputButtonEvent;
import de.hardcode.jxinput.event.JXInputButtonEventListener;

/**
 *
 * @author LUISTEOFILO
 */
public class GuiterHeroHandler implements JXInputButtonEventListener {

    public void changed(JXInputButtonEvent jxibe) {
        System.out.println(jxibe.getButton().getName());
    }

}
