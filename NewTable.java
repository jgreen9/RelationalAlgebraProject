import java.io.*;
import java.util.*;
/**
 * @Author John Green & Stacy Austin
 * @sources www.mkyong.com, www.sitepoint.com, www.stackoverflow.com, Java Software Structures 4th Edition, Data Structures and Algorithms in Java 2nd Edition
 * writes NewTable using tilde table input from text file
 */
public final class NewTable {
    
 private File newFile;
 public final String[][] tbl;
 public Scanner scan;
/**
 * 
 * @param writeFile 
 */
 public NewTable(String writeFile) {
  this.newFile = new File("src/" + writeFile);
  tbl = new String[roID()][clm2()];
  makeTable();
 }
 /**
  * 
  * @param tbl2 
  */
 public NewTable(String[][] tbl2) {
  this.tbl = tbl2;
 }
 /**
  * 
  */
 private void makeTable() {
  try {
   int r1 = 0;
   try (Scanner scan2 = new Scanner(newFile)) {
    while (scan2.hasNextLine()) {
     int c1 = 0;
     String next = scan2.nextLine();
     scan = new Scanner(next);
     //stackoverflow
     scan.useDelimiter("~ *");
     while (scan.hasNext()) {
      tbl[r1][c1] = scan.next();
      c1 += 1;
     }
     r1 += 1;
    }
   }
  } catch (FileNotFoundException e) {
      e.printStackTrace();
  }
 }
/**
 * 
 * @return 
 */
 public String[] Carray() {
    String[] array = new String[tbl[0].length];
    System.arraycopy(tbl[0], 0, array, 0, tbl[0].length);
    return array;
 }
/**
 * 
 * @return 
 */
 public int rcol() { 
    return this.tbl[0].length;
 }
/**
 * 
 * @param column
 * @return 
 */
 public int c1(String column) {
  for (int numcol = 0; numcol < tbl[0].length; numcol++) {
   if (tbl[0][numcol].equalsIgnoreCase(column)) {
    return numcol;
   }
  }
  return -1;
 }
/**
 * 
 * @return 
 */
 public int clm2() {
  int num3 = 0;
  try {
   try (Scanner scan2 = new Scanner(newFile)) {
    String next = scan2.nextLine();
    scan = new Scanner(next);
    scan.useDelimiter("~");
    while (scan.hasNext()) {
     scan.next();
     num3 += 1;
    }
   }
  } catch (FileNotFoundException e) {
      e.printStackTrace();
  }
  return num3;
 }
/**
 * 
 * @return 
 */
 public int roID() {
  int num3 = 0;
  try {
   try (Scanner scan2 = new Scanner(newFile)) {
    while (scan2.hasNextLine()) {
     String next = scan2.nextLine();
     if (next.length() > 0) {
      num3 += 1;
     }
    }
   }
  } 
  catch (FileNotFoundException e) {
	  e.printStackTrace();
  }
  return num3;
 }
/**
 * 
 * @return 
 */
 public int number() {
    return tbl.length;
 }
}