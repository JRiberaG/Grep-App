package support;

public class StringHelper {
    // <editor-fold defaultstate="collapsed" desc="LABEL ERRORS">
    public static String errorPath404 = "This path / file does not exists";
    public static String errorFieldEmpty = "This field can't be empty";
    // </editor-fold>
    
    public static String status = "Status";
    public static String finished = "Finished";
    public static String searching1 = "Searching.";
    public static String searching2 = "Searching..";
    public static String searching3 = "Searching...";
    public static String waiting = "Waiting";
    public static String file = "File";
    public static String numOfLine = "# of line";
    public static String line = "Line";
    public static String numOfResults = "# of results: ";
    
    public static String pathOrFile = "Path or file:";
    public static String pattern = "Pattern:";
    
    public static String searchConfiguration = "Search configuration";
    public static String searchOption = "Search option";
    public static String extensionOption = "Extension option";
    public static String results = "Results";
    
    public static String search = "Search:";
    public static String reset = "Reset:";
    public static String clear = "Clear:";
    
    public static String contains = "Contains ...";
    public static String endsWith = "Ends with...";
    public static String startsWith = "Starts with...";
    public static String allNonBinary = "All non binary files";
    public static String specificExtensions = "Specific extensions";
    
    public static String howToUse = "How to use";
    public static String language = "Language";
    public static String spanish = "Spanish";
    public static String english = "English";
    public static String about = "About";   
    
    public static String titleAbout = "About - GrepApp";
    public static String titleHowTo = "How to use the app - GrepApp";
    public static String howToSteps = "<html>" +
                                        "<h3>How to use the app</h3>\n" +
                                        "<p> The objective of this app is to locate within the path or the file the pattern given by the user, quite useful when you know you wrote something like <code>Hello World!</code> but you can't remember where...<br/>\n" +
                                        "<h4>Steps to follow:</h4>\n" +
                                        "1) Type (copy/paste if you like) the path or the file in the corresponding field.<br/>\n" +
                                        "2) Type the pattern to search, for example, <code>Hello World!</code><br/>\n" +
                                        "3) Select where do you want or do you except to find the pattern, either within the whole file, just at the beginning or at the very end. <br/>\n" +
                                        "4) Select the kind of files you want to search on, either all the binary files or just those who have a concrete extension, for example: <code>.json, .cpp, .java, .html,</code> ... <br/>\n" +
                                        "5) Press <b>Search</b> and wait until the status stays as <i>Finished</i>. <br/><br/>\n" +
                                        "\n" +
                                        "In case you want to reset the fields to their default value, press <b>Reset</b>.<br/>\n" +
                                        "In case you want to clear the data from the results, press <b>Clear</b>.<br/><br/>\n" +
                                        "\n" +
                                        "Any suggestion, doubt  or constructive criticism is very welcomed!<br/>\n" +
                                        "(Link to my GitHub in the <b>About</b> menu)<br/>\n" +
                                        "</html>";
}
