package com.lambda.refactoring.order;

public class MainOrderTest {

    public static void main(String[] args) {
        testCommon();
        testLambda();
        testFinal();
    }

    private static void testFinal() {
        //使用方法引用构建
        IEditor editor = new FileEdtor();
        Macro macro = new Macro();
        macro.record(editor::open);
        macro.record(editor::save);
        macro.run();
    }

    private static void testLambda() {
        //使用Lambda表达式构建
        IEditor editor = new FileEdtor();
        Macro macro = new Macro();
        macro.record(()->editor.open());
        macro.record(()->editor.save());
        macro.run();


    }

    private static void testCommon() {
        IEditor editor = new FileEdtor();
        Macro macro = new Macro();
        macro.record(new Open(editor));
        macro.record(new Save(editor));
        macro.run();
    }
}
