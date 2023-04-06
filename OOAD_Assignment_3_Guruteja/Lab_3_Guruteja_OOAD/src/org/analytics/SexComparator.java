package org.analytics;
import java.util.Comparator;
//Defining a class named SexComparator that implements the Comparator interface for type BankRecords
public class SexComparator implements Comparator<BankRecords> {
 @Override
//Overriding the compare() method of the Comparator interface
 public int compare(BankRecords o1, BankRecords o2) {
	 // Using the compareTo() method of the String class to compare the sex of two BankRecords objects
 int result = o1.getSex().compareTo(o2.getSex());
 return result;
 }
}
