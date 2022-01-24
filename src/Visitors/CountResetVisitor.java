package Visitors;

import Elements.PlayfieldElement;

public class CountResetVisitor implements Visitor {
    @Override
    public void visit(PlayfieldElement element) {
        element.resetCount();
    }
}
