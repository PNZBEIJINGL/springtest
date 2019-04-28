package com.lambda.refactoring.order;

public class Save implements IAction {

    private final IEditor editor;

    public Save(IEditor editor) {
        this.editor = editor;
    }

    @Override
    public void perform() {
        editor.save();
    }
}
