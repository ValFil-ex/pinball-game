package Visitors;

import Elements.PlayfieldElement;

public class ElementResetVisitor implements Visitor{
    @Override
    public void visit(PlayfieldElement element) {
        element.resetElement();
    }
}
