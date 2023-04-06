package com.Bankrecords.org;//Created a package com.Bankrecords.org

//Import Array list from library
	import java.util.ArrayList;
//Create abstarct class name client,readdata,processdata and printdata
	public abstract class Client {
	    public abstract void readData();
	    public abstract void processData();
	    public abstract void printData(ArrayList<BankRecords> records);
		public void printData() {
		}
	}


