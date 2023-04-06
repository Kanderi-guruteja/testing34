package org.analytics;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

public class Records extends BankRecords {
    // create formatted object to write output directly to console & file
    static FileWriter fw = null;

    public Records() {
        try {
        	// initialize FileWriter object
            fw = new FileWriter("Bankrecords.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // creating records object
        Records br = new Records();
        br.readData();
        System.out.println("\nData Analytic Results are:");
        try {
            // call functions to perform analytics
            fw.write("\nData Analytic Results:\n\n");
            averageComp(); // This method analyses the average income
            FemComp(); // female count with mortgage/savings accounts
            malesComp(); // male counts per location with car and 1 child
            Date date = new Date();
            fw.write("\nGuruteja\n");
            fw.write(date.toString());
            // *** close out file object ***//
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void averageComp() {
        Arrays.sort(ref1, new SexComparator());
        // set up needed variables to gather counts & income by sex
        // to determine average income by sex
        int maleCt = 0, femCt = 0;
        double maleInc = 0, femInc = 0;
        for (int i = 0; i < ref1.length; i++) {
            if (ref1[i].getSex().equals("FEMALE")) {
                femCt++;
                femInc += ref1[i].getIncome();
            } else {
                maleCt++;
                maleInc += ref1[i].getIncome();
            }
        }
        // display resulting averages to console and to file
        System.out.printf("\nAverage income of females: $%.2f\n", femInc / femCt);
        System.out.printf("Average income of males: $%.2f\n", maleInc / maleCt);
        try {
            fw.write(String.format("Average income of females: $%.2f\n", femInc / femCt));
            fw.write(String.format("Average income of males: $%.2f\n\n", maleInc / maleCt));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * Method name: FemComp
     * Calculate the number of females with a mortgage and savings account
     */
    private static void FemComp() {
        Arrays.sort(ref1, new SexComparator());
        // set up needed variables to gather counts & income by sex
        // to determine average income by sex
        int femCt = 0;
        for (int i = 0; i < ref1.length; i++) {
            if (ref1[i].getSex().equals("FEMALE") && ref1[i].getMortgage().equals("YES") &&
                    ref1[i].getSave_act().equals("YES")) {
                femCt++;
            }
        }
        // display resulting averages to console and to file
        System.out.println("Number of females with a mortgage and savings account: " + femCt);
        try {
            fw.write("Number of females with a mortgage and savings account: " + femCt + "\n\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * Method name: malesComp
     * Calculate the number of males with both a car and 1 child per location
     */
    private static void malesComp() {
        Arrays.sort(ref1, new SexComparator());
        // set up needed variables to gather counts by region for males with car and 1 child
        int innerCityMales = 0, ruralMales = 0, townMales = 0, suburbanMales = 0;
        for (int i = 0; i < ref1.length; i++) {
            if (ref1[i].getSex().equals("MALE") && ref1[i].getCar().equals("YES") && ref1[i].getChildren() == 1) {
                if (ref1[i].getRegion().equalsIgnoreCase("INNER_CITY")) {
                    innerCityMales++;
                } else if (ref1[i].getRegion().equalsIgnoreCase("RURAL")) {
                    ruralMales++;
                } else if (ref1[i].getRegion().equalsIgnoreCase("TOWN")) {
                    townMales++;
                } else {
                    suburbanMales++;
                }
            }
        }
        // display resulting counts to console and to file
        System.out.println("Intercity males with car & 1 child: " + innerCityMales);
        System.out.println("Rural region males with &  1 child: " + ruralMales);
        System.out.println("Suburban males with car & 1 child: " + suburbanMales);
        System.out.println("Town region males with car & 1 child: " + townMales);
        try {
            fw.write("Intercity males with car & 1 child: " + innerCityMales + "\n");
            fw.write("Rural region males with &  1 child: " + ruralMales + "\n");
            fw.write("Suburban males with car & 1 child: " + suburbanMales + "\n\n");
            fw.write("Town region males with car & 1 child: " + townMales + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


