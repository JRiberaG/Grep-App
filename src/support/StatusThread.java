package support;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import static support.StatManager.numFiles;
import static support.StatManager.numThreads;

public class StatusThread extends Thread implements Runnable {
    
    private JLabel label;
    private boolean go;

    public StatusThread(JLabel label) {
        this.label = label;
        go = false;
    }

    public void setGo(boolean go) {
        this.go = go;
    }
    
    @Override
    public void run() {
        int i = 0;
        while(true) {
            if (go) {
//                if (numFiles > -2 && numFiles < 2) {
                if (numFiles == 0) {
                    label.setText(StringHelper.finished);
                } else {
                    if (i == 0) {
                        label.setText(StringHelper.searching1);
                        i++;
                    } else if (i == 1) {
                        label.setText(StringHelper.searching2);
                        i++;
                    } else {
                        label.setText(StringHelper.searching3);
                        i = 0;
                    }
                    
                    try {
                        Thread.sleep(900);
                    } catch (InterruptedException ex) {}
                }
            }
            else {
                try {
                    label.setText(StringHelper.waiting);
                    Thread.sleep(850);
                } catch (InterruptedException ex) {
                    System.out.println("error");
                }
            }
        }
    }
}
