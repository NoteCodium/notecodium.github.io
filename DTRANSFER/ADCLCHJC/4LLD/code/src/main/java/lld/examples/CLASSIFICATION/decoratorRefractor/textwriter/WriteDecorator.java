package code.src.main.java.lld.examples.CLASSIFICATION.decoratorRefractor.textwriter;

// Suggested code may be subject to a license. Learn more: ~LicenseLog:1042472924.
@RequiredArgsConstructor
public class WriteDecorator implements Writer{
    private final Writer writer;
    @Override
    public void write(String text) {
        writer.write(text);
    }
    
}
