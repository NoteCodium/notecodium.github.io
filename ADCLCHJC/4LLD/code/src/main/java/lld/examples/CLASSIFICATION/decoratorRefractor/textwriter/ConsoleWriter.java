package code.src.main.java.lld.examples.CLASSIFICATION.decoratorRefractor.textwriter;

public class ConsoleWriter implements Writer {
    @Override
    public void write(String text) {
        System.out.println(text);
    }
}


