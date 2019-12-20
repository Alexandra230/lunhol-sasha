package ua.khpi.oop.Lunhol04;
/*
 * class in which CMD commands are processed
 * */
public class ArgsCMD {
	/**
	  * @author ALEXANDRA
	  * @version 4.1
	  * Here start point of the program
	  * */
	static boolean DBG = false;
    private String[] args;
    ArgsCMD(String[] args) {
        this.args = args;
    }
    boolean isEmpty(){
        return args.length == 0;
    }
    /*
     * Function for comparing received commands
     * */
    void arguments(){
        for (String i: args){
        if (i.equals("-d") || i.equals("-debug"))
            ArgsCMD.debug();
        else if(i.equals("-h") || i.equals("-help"))
            ArgsCMD.help();
        else
            System.out.println("Error. Use only this arguments: \"-d\", \"-debug\", \"-h\", \"-help\"");
        }
    }
/*
 * Function that displays information about yourself and about task when user calling the help
 * */
    private static void help() {
        System.out.println("Author: Lunhol Alexandra Sergeevna");
        System.out.println("Individual tasks:");
        System.out.println("Using the program of solving the problem of laboratory work #3, "
        		+ "\naccording to the application task provide the processing of user commands in the form of a text menu:\n" +
                "data entry;\n" +
                "view data;\n" +
                "view data;\n" +
                "displaying the result;\n" +
                "program completion, etc.");
    }
/*
 * Function that displays additional information when you called debug
 * */
    
    private static void debug() {
        DBG = true;
        System.out.println("Debug");
    }
}
