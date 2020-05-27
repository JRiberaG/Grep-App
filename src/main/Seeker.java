package main;

import com.sun.istack.internal.Nullable;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import static main.JFrameMain.CONTAINS;
import static main.JFrameMain.ENDS_WITH;
import static main.JFrameMain.STARTS_WITH;
import support.StatManager;
import static support.StatManager.numDirs;
import static support.StatManager.numFiles;
import static support.StatManager.numResults;
import static support.StatManager.numThreads;
import static support.Utils.hasSameExtension;

public class Seeker extends Thread implements Runnable {
    
    private File file;
    private String pattern;
    private static int patternSelection;
    
    private int numLine;
    private String line;
    private ArrayList<File> files;
    
    private static DefaultTableModel model;
    private ArrayList<String> listExtensions;

    // Constructor made to seek
    public Seeker(File file, String pattern, int selection, @Nullable ArrayList<String> listExtensions) {
        this.file = file;
        this.pattern = pattern;
        this.patternSelection = selection;
        this.model = JFrameMain.model;
        this.listExtensions = listExtensions;
    }    
    
    // Constructor made to return results
    public Seeker(File file, int numLine, String line) {
        this.file = file;
        this.numLine = numLine;
        this.line = line;
    }
    
    @Override
    public void run() {
        // Searches in all non binary files
        if (listExtensions == null) {
            if (file.isDirectory()) {
                
//                numDirs++;
                
                files = new ArrayList<>(Arrays.asList(file.listFiles()));
                for(File f : files) {
                    Seeker seeker = new Seeker(f, pattern, patternSelection, null);
                    
//                    numThreads++;
                    
                    seeker.start();
                }
            } else {
                try {
                    synchronized(StatManager.class) {
                        numFiles++;
                    }       
                    readFile(file, pattern, patternSelection);
//                    for (Seeker s : results) {
//                        System.out.println(s.toString());
//                    }
                } catch (IOException ex) {
                    Logger.getLogger(Seeker.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        // Searches in determinate extensions
        else {
            if (file.isDirectory()) {
//                numDirs++;
                files = new ArrayList<>(Arrays.asList(file.listFiles()));
                for(File f : files) {
                    Seeker seeker = new Seeker(f, pattern, patternSelection, listExtensions);
//                    numThreads++;
                    seeker.start();
                }
            } else {
                // Check whether the file extension matches any of the extensions user inputed
                for (String ext : listExtensions) {
                    if (hasSameExtension(file.getName(), ext)) {
                        try {
                            synchronized(StatManager.class) {
                                numFiles++;
                            }
                            Seeker.readFile(file, pattern, patternSelection);
                        } catch (IOException ex) {
                            Logger.getLogger(JFrameMain.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        // Didn't match, goes for the next one
                    }
                }
            }
        }
    }
    
    public static void readFile(File file, String pattern, int selection) throws IOException {
        try {
            model = JFrameMain.model;
            BufferedReader br = new BufferedReader(new FileReader(file));
            
            int numLine = 0;
            String line;
            
            // Starts with ...
            if (selection == STARTS_WITH) {
                boolean exit = false;
                while(!exit) {
                    line = br.readLine();
                    if (line.contains(pattern)) {
                        addNewMatch(line, numLine, file);
                    }
                    exit = true;
                }
            } 
            // Contains && ends with ...
            else {
                while((line = br.readLine()) != null){
                    numLine++;
                    if (selection == CONTAINS) {
                        if (line.contains(pattern)) {
                            addNewMatch(line, numLine, file);
                        }
                    }
                }
                
                if (selection == ENDS_WITH) {
                    if (line.contains(pattern)) {
                        addNewMatch(line, numLine, file);
                    }
                }
            }
            
            br.close();
        } catch (FileNotFoundException ex) {}
        
        synchronized(StatManager.class) {
            --numFiles;
        }
    }
    
    private static void addNewMatch(String line, int numLine, File file) {
        line = line.trim();
        numResults++;

        String resultPrinted[] = {file.getAbsolutePath(), String.valueOf(numLine), line};
        synchronized(model){
            model.addRow(resultPrinted);
        }
    }

    @Override
    public String toString() {
        return String.format("%" + -120 + "s", file) + String.format("%" + -60 + "s", numLine) + line;
    }   
    
}
