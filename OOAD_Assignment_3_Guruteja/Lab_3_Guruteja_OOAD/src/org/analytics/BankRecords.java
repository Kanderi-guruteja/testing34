package org.analytics;
import java.io.BufferedReader;
import java.text.SimpleDateFormat;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
public class BankRecords extends Client {
	// Create an array of BankRecords objects and an ArrayList to store the data from the CSV file
public static BankRecords ref1[] = new BankRecords[600];
static ArrayList<List<String>> array = new ArrayList<>();
private String id;
private int age;
private String sex;
private String region;
private double income;
private String married;
private int children;
private String car;
private String save_act;
private String current_act;
private String mortgage;
private String pep;
public static void main(String[] args) throws IOException {
	System.out.println("Welcome to Bank of IIT");
	// Create an instance of the BankRecords class
	BankRecords myobj1 = new BankRecords();
	// Read the data from the CSV file
	myobj1.readData();
	// Print the current date and time and the name of the programmer
	String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
    System.out.println("Cur dt=" + timeStamp + "\nProgrammed by Guruteja\n\n");
	}

public void readData() {
	BufferedReader br = null;
	try {
		// Create a BufferedReader object to read the data from the CSV file
		br = new BufferedReader(new FileReader (new File("bank-Detail(2).csv")));
		String line;
		// Read each line of the CSV file and add it to the ArrayList
		while ((line = br.readLine()) != null) 
		{

			array.add(Arrays.asList(line.split(",")));
	}
} 
	catch (Exception e) {
		// If there's an error reading the CSV file, print an error message
	System.err.println("There was a problem loading the file");
	}
	processData(); // Call the processData method to convert the data in the ArrayList to BankRecords objects
	}
@Override
public void processData() {
	// Create an index variable for the ref1 array
int idx=0;
//Iterate through the ArrayList and create a BankRecords object for each row of data
for (List<String> rowData: array) {
	// Initialize the BankRecords object
	ref1[idx] = new BankRecords();
	// Set the values of the BankRecords object using the data from the ArrayList
	ref1[idx].setId(rowData.get(0)); //get 1st column
	ref1[idx].setAge(Integer.parseInt(rowData.get(1))); //get 2nd column
	ref1[idx].setSex(rowData.get(2));
	ref1[idx].setRegion(rowData.get(3));
	ref1[idx].setIncome(Double.parseDouble(rowData.get(4)));
	ref1[idx].setMarried(rowData.get(5));
	ref1[idx].setChildren(Integer.parseInt(rowData.get(6)));
	ref1[idx].setCar(rowData.get(7));
	ref1[idx].setSave_act(rowData.get(8));
	ref1[idx].setCurrent_act(rowData.get(9));
	ref1[idx].setMortgage(rowData.get(10));
	ref1[idx].setPep(rowData.get(11));
	idx++;// Increment the index variable
	}
}
@Override
	public void printData() {
	// Print the headings of the table
	System.out.println("No\tID\t\tAGE\t\tSEX\t\tREGION\t\tINCOME\t\tMORTGAGE");
	System.out.println("---\t-----\t\t---\t\t---\t\t------\t\t------\t\t------");
		for (int i=0;i<25;i++){
			String s=String.format("%s\t\t%d\t\t%s\t\t%s\t\t%.2f\t\t%s",
					ref1[i].getId(),ref1[i].getAge(),ref1[i].getSex(),ref1[i].getRegion(),ref1[i].getIncome(),ref1[i].getMortgage());
					System.out.println(s);
				}
	}
//getter and setter methods for the various attributes
public String getId() {
return id;
}
public void setId(String id) {
this.id = id;
}
public int getAge() {
return age;
}
public void setAge(int age) {
this.age = age;
}

public String getSex() {
return sex;
}
public void setSex(String sex) {
this.sex = sex;
}
public String getRegion() {
return region;
}
public void setRegion(String region) {
this.region = region;
}
public double getIncome() {
return income;
}
public void setIncome(double income) {
this.income = income;
}
public String getMarried() {
return married;
}
public void setMarried(String married) {
this.married = married;
}
public int getChildren() {
return children;
}
public void setChildren(int children) {
this.children = children;
}
public String getCar() {
return car;
}
public void setCar(String car) {
this.car = car;
}
public String getSave_act() {
return save_act;
}
public void setSave_act(String save_act) {
this.save_act = save_act;
}
public String getCurrent_act() {
return current_act;
}
public void setCurrent_act(String current_act) {
this.current_act = current_act;
}
public String getMortgage() {
return mortgage;
}
public void setMortgage(String mortgage) {
this.mortgage = mortgage;
}
 String getPep() {
	return pep;
		}
	public void setPep(String pep) {
	this.pep = pep;
	}
}
	/*
	The main method is the program's starting point.
	*/
	
