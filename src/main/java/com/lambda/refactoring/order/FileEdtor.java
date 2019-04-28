package com.lambda.refactoring.order;

public class FileEdtor implements IEditor {
    @Override
    public void save() {
        System.out.println(" do save");
    }

    @Override
    public void open() {
        System.out.println(" do open");
    }
}
