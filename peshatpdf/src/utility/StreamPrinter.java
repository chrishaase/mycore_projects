package utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamPrinter implements Runnable {

    private final InputStream inputStream;

    private boolean print;

    public StreamPrinter(InputStream inputStream, boolean print) {
        this.inputStream = inputStream;
        this.print = print;
    }

    private BufferedReader getBufferedReader(InputStream is) {
        return new BufferedReader(new InputStreamReader(is));
    }

    @Override
    public void run() {
        BufferedReader br = getBufferedReader(inputStream);
        String line = "";
        try {
            while ((line = br.readLine()) != null) {
                if (print) {
                    System.out.println(line);
                }
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
