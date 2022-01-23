package Visitors;

import Elements.PlayfieldElement;

public interface Visitor {
    public void visit(PlayfieldElement element);
}
