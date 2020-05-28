package support;

import java.util.ArrayList;
import java.util.Arrays;

public class Utils {
    
    public static ArrayList<String> getExtensions(String str) {
        str = str.replace(" ", "");
        String arrExtensions[] = str.split(",");
        
         return new ArrayList<>(Arrays.asList(arrExtensions));
    }
    
    public static boolean hasSameExtension(String fileName, String extToCheck) {
        boolean areTheSame = false;
        
        // Get the extension
        ArrayList<String> list = new ArrayList<>(Arrays.asList(fileName.split("\\.")));
        // Add an initial dot so we'll get the real extension, since the dot was removed when the string was splited
        String extension = "." + list.get(list.size() - 1);
        
        if (extension.equals(extToCheck)) {
            areTheSame = true;
        }
        
        return areTheSame;
    }
}
