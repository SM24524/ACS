
import java.util.Scanner;
import java.io.IOException;
import java.io.FileReader;

public class TextFileAccessor {
    private String fileName;
    private Scanner scan;

    public String getFileName(){
        return fileName;
    }

    public Scanner getScan(){
        return scan;
    }

    // throws a FileNotFoundException if can't open file
    public void openFile(String fn)throws IOException{
        fileName = fn;
        scan = new Scanner(new FileReader(fileName));
    }

    public void processFile(){
        while (scan.hasNext()) {
            processLine(scan.nextLine());
        }
        scan.close();
    }

    protected void processLine(String line){

    }

    public String getReportStr(){
        return "";
    }
}
