package com.Bankrecords.org;
//Importing the necessary libraries
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
//Creating a Class BankRecords and inheriting the client class
public class BankRecords extends Client {
	//declaring the varibales as required
    int age;
    float income;
    int children;
    String id;
    String sex;
    String car;
    String pep;
    String region;
    String married;
    String mortgage;
    String save_act;
    String current_act;
    ArrayList<String> arrayList;
    
//Implementing getters and setter methods fro accessing and modifying the instance variables
    
    public int getterAge() {
        return age;
    }
    public void setterAge(int age) {
        this.age = age;
    }
    
    public float getterIncome() {
        return income;
    }

    public void setterIncome(Float income) {
        this.income = income;
    }
    public int getterChildren() {
        return children;
    }

    public void setterChildren(int children) {
        this.children = children;
    }
    
    public String getterID() {
        return id;
    }

    public void setterID(String id) {
        this.id = id;
    }

    public String getterSex() {
        return sex;
    }

    public void setterSex(String sex) {
        this.sex = sex;
    }
    public String getterCar() {
        return car;
    }

    public void setterCar(String car) {
        this.car = car;
    }
    public String getterPep() {
        return pep;
    }

    public void setterPep(String pep) {
        this.pep = pep;
    }
    public String getterRegion() {
        return region;
    }

    public void setterRegion(String region) {
        this.region = region;
    }

    public String getterMarried() {
        return married;
    }

    public void setterMarried(String married) {
        this.married = married;
    }
    public String getterMortgage() {
        return mortgage;
    }

    public void setterMortgage(String mortgage) {
        this.mortgage = mortgage;
    }
    
    public String getterSave_act() {
        return save_act;
    }

    public void setterSave_act(String save_act) {
        this.save_act = save_act;
    }
    
    public String getterCurrent_act() {
        return current_act;
    }

    public void setterCurrent_act(String current_act) {
        this.current_act = current_act;
    }
    //Implementing the try & catch methods and read the input data from csv file
    public void readData() {
        try {
        	
            FileReader Readfile = new FileReader("bank-Detail(2).csv");// Create a new FileReader object to read the CSV file
            try (BufferedReader Readbuffer = new BufferedReader(Readfile)) {
                String rec;
             
                arrayList = new ArrayList<String>();// Initialize an ArrayList to store the data
                
                while ((rec = Readbuffer.readLine()) != null) // Loop through each line of the file and add it to the ArrayList
                	{
                	StringBuffer sbr = new StringBuffer();
                    sbr.append(rec);// Append the line to the StringBuffer object
                    arrayList.add(sbr.toString());
                }
            } // Catch a FileNotFoundException if the file is not found
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found :)"+ e.getMessage());
        } // Catch an IOException if there is an error reading the file
          catch (IOException e) { 
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public void processData() { //for loop for processing the data from csv
        for (int j = 0; j < 25 && j < arrayList.size(); j++) {
            try {
                String myobj = arrayList.get(j);
                String column[] = myobj.toString().split(",");
                this.setterID(column[0]);
                this.setterAge(Integer.parseInt(column[1]));
                this.setterSex(column[2]);
                this.setterRegion(column[3]);
                this.setterIncome(Float.parseFloat(column[4]));
                this.setterMortgage(column[10]);
                this.printData();
            } catch (Exception e) {
                // handle the exception if something went wrong while processing
                System.out.println("Error processing data at index " + j + ": " + e.getMessage());
            }
        }
    }

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public float getIncome() {
		return income;
	}
	public void setIncome(float income) {
		this.income = income;
	}
	public int getChildren() {
		return children;
	}
	public void setChildren(int children) {
		this.children = children;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCar() {
		return car;
	}
	public void setCar(String car) {
		this.car = car;
	}
	public String getPep() {
		return pep;
	}
	public void setPep(String pep) {
		this.pep = pep;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getMarried() {
		return married;
	}
	public void setMarried(String married) {
		this.married = married;
	}
	public String getMortgage() {
		return mortgage;
	}
	public void setMortgage(String mortgage) {
		this.mortgage = mortgage;
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
	public ArrayList<String> getarrayList() {
		return arrayList;
	}
	public void setaList(ArrayList<String> aList) {
		this.arrayList = aList;
	}

		//Method printData()
	    @Override
	    public void printData()//this method calls within processdata() to print out data for each record
	    {
	    	String a = String.format("%-10s", this.getterID());
	    	String b = String.format("%-7s", this.getterAge());
	    	String c = String.format("%-9s", this.getterSex());
	    	String d = String.format("%-16s", this.getterRegion());
	    	String e = String.format("%-15s", this.getterIncome());
	    	String f = String.format("%-5s", this.getterMortgage());
	    	
	    	System.out.println(a+b+c+d+e+f);//prints the data to console
	    }
	   
	    //Creating the Main function
	    public static void main(String[] args)
	    {
	        //Creating new instance
	    	BankRecords br = new BankRecords();
	       
	        br.readData();
	       
	        System.out.println("ID"+"\t "+" AGE"+"\t"+" SEX"+"\t"+"  REGION"+"\t "+" INCOME"+" \t"+" MORTGAGE");//printing the parameters of the csv file to console
	       
	        //Function call
	        br.processData();
	    }
		public void printData(ArrayList<BankRecords> records) {//Prints the data from arraylist of bankrecords
			}
	}
	
