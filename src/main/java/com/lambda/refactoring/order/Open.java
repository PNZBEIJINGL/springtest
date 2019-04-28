package com.lambda.refactoring.order;

public class Open implements IAction {
    private final IEditor editor;

    public Open(IEditor editor) {
        this.editor = editor;
    }


    @Override
    public void perform() {
        editor.open();
    }
}
