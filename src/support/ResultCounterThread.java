package support;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import static support.StatManager.numDirs;
import static support.StatManager.numFiles;
import static support.StatManager.numResults;
import static support.StatManager.numThreads;

public class ResultCounterThread extends Thread implements Runnable {
    
    private JLabel label;
    private boolean go;

    public ResultCounterThread(JLabel label) {
        this.label = label;
        go = false;
    }
    
    public void setGo(boolean go){
        this.go = go;
    }
    
    @Override
    public void run() {
        while(true) {
            if (go){
                label.setText(String.valueOf(numResults));
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ex) {}
            }
        }
    }
}
