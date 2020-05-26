package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Seeker extends Thread implements Runnable{
    
    private File file;
    private String pattern;
    private int patternSelection;
    
    private int numLine;
    private String line;
    private ArrayList<File> files;

    // Constructor made to seek
    public Seeker(File file, String pattern, int selection) {
        this.file = file;
        this.pattern = pattern;
        this.patternSelection = selection;
    }    
    
    // Constructor made to return results
    public Seeker(File file, int numLine, String line) {
        this.file = file;
        this.numLine = numLine;
        this.line = line;
    }

    
    @Override
    public void run() {
        if (file.isDirectory()) {
            files = new ArrayList<>(Arrays.asList(file.listFiles()));
            for(File f : files) {
                Seeker s = new Seeker(f, pattern, patternSelection);
                s.start();
            }
        } else {
            try {
                ArrayList<Seeker> results = readFile(file, pattern, patternSelection);
//                for (Coincidencia c : coincidencias) {
//                    System.out.println(c);
//                }
            } catch (IOException ex) {
                Logger.getLogger(Seeker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static ArrayList<Seeker> readFile(File file, String pattern, int selection) throws IOException {
        ArrayList<Seeker> results = new ArrayList<>();
        
        try {
            
            BufferedReader br = new BufferedReader(new FileReader(file));
            
            int numLine = 0;
            
            String line;
            while((line = br.readLine()) != null){
                numLine++;
                if (line.contains(pattern)) {
                    Seeker s = new Seeker(file, numLine, line);
                    results.add(s);
                }
            }
            
            br.close();
        } catch (FileNotFoundException ex) {}
        
        return results;
    }
}
