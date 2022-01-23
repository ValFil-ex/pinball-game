package Visitors;

import Elements.PlayfieldElement;

public class ResetVisitor implements Visitor{
    @Override
    public void visit(PlayfieldElement element) {
        element.resetElement();
    }
}
