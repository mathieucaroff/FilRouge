package filRouge.FilRouge;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public interface Transition {
    boolean pullable();
    void pull();
}
