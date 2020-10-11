package sampleCode.Chapter3.Parameters;

public class FirstNameLastName {
    public static void main(String[] args) {

        // declare variables
        String fname;
        String lname;

        // assign variables
        fname = "Darwin";
        lname = "Schweitzer";

        // call method
        getFirstLetter(fname);
        getFirstLetter(lname);

    }

        public static void getFirstLetter(String x) {
            char intials = x.charAt(0);
            System.out.println(intials);
        }
}
