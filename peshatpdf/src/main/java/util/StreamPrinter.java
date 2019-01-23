package main.java.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Hilfsmethode einen PDF-Stream vom Tex-File-Printer in ein PDF-File zu speichern
 */

   public class StreamPrinter implements Runnable {

        private final InputStream inputStream;
        private final boolean print;

        public StreamPrinter(InputStream inputStream, boolean print) {
            this.inputStream = inputStream;
            this.print = print;
        }

        private BufferedReader getBufferedReader(InputStream is) {
            return new BufferedReader(new InputStreamReader(is));
        }

        @Override
        public void run() {

            String line = "";

            try (BufferedReader br = getBufferedReader(inputStream)){

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

