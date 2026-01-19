package code.src.main.java.lld.examples.CLASSIFICATION.decoratorRefractor.textwriter;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWriter implements Writer{
    private final String filePath;
    public FileWriter(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void write(String text) {
        try{
            Files.write(Paths.get(filePath), text.getBytes());
        }
        catch(Exception e){
            System.out.println("Exception in Filewriter");
        }
    }
    
}
