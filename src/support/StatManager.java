package support;

public class StatManager {

    public static int numResults = 0;
    public static int numThreads = 0;
    public static int numDirs = 0;
    public static int numFiles = 0;
    
    public static void reset(){
        numResults = 0;
        numThreads = 0;
        numDirs = 0;
        numFiles = 0;
    }
}
