package expertguitar4noobs;

import java.util.Arrays;

public class Keys {
    protected boolean[] checked;

    public Keys(boolean[] checked) {
        this.checked = checked;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Keys other = (Keys) obj;
        if (!Arrays.equals(this.checked, other.checked)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Arrays.hashCode(this.checked);
        return hash;
    }
}
