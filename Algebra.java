import java.io.*;
import java.util.*;
/**
 * @Author John Green & Stacy Austin
 * @sources www.mkyong.com, www.sitepoint.com, www.stackoverflow.com ,Java Software Structures 4th Edition, Data Structures and Algorithms in Java 2nd Edition
 * writes new NewTable using tilde delimited text file
 * @Algebra  comparators for NewTables
 */
public class Algebra {
    /**
     * 
     * @param tbl
     * @param clms
     * @return 
     */
 public static NewTable Project(NewTable tbl, String clms) {
  int num1 = num1(clms);
  int num2 = tbl.number();
  int num3 = 0;
  String[] array = buildTable(num1, clms);
  String[][] retreive = new String[num2][num1];
  int x = 0;
  while (x < array.length) {
   for (int z = 0; z < tbl.tbl[0].length; z++) {
    if (array[x].equalsIgnoreCase(tbl.tbl[0][z])) {

     for (int y = 0; y < tbl.tbl.length; y++) {

      retreive[y][num3] = tbl.tbl[y][z];
     }
     num3 += 1;
    }
   }
   x++;
  }
  return new NewTable(retreive);
 }
/**
 * 
 * @param tbl
 * @param string
 * @return 
 */
 public static NewTable Restrict(NewTable tbl, String string) {
  String c1 = c1(string);
  String restr = restrict(string);
  String oper = oper(string);

   if(oper.equals(">=")){
       return new NewTable(gtlteq(tbl, c1, restr, oper));
   }
   if(oper.equals(">")){
       return new NewTable(gtlteq(tbl, c1, restr, oper));
   }
   if(oper.equals("<=")){
       return new NewTable(gtlteq(tbl, c1, restr, oper));
   }
   if(oper.equals("<")){
       return new NewTable(gtlteq(tbl, c1, restr, oper));
   }
   if(oper.equals("=")){
       return new NewTable(eq(tbl, c1, restr));
   }
   if(oper.equals("!=")){
       return new NewTable(eqTbl(tbl, c1, restr));
   }
   else{
       System.out.println("ERROR CANNOT PERFORM THIS COMPARISON");
   }
  return tbl;
 }
/**
 * 
 * @param tbl 
 * StackOverflow
 */
 public static void Display(NewTable tbl) {
  String[][] a = tbl.tbl;
  String columns = "";
  for (String item: a[0]) {
   columns = item;
   PrintStream printf;
   printf = System.out.printf("%-16s", columns);
  }
  System.out.println();
  for (String item: a[0]) {
   System.out.print("-----");
  }
  for (int x = 1; x < a.length; x++) {
   System.out.println("");
   for (int y = 0; y < a[0].length; y++) {
    System.out.printf("%-16s", a[x][y]);
   }
  }
  System.out.println("\n");
 }
/**
 * 
 * @param tbl
 * @param clm
 * @param restr
 * @return 
 */
 private static String[][] eqTbl(NewTable tbl, String clm, String restr) {
  int clm2 = tbl.c1(clm);
  int row2 = 1;
  String[][] array = new String[rrow(tbl, clm, restr)][tbl.rcol()];
  //StackOverflow
  System.arraycopy(tbl.tbl[0], 0, array[0], 0, tbl.tbl[0].length);
  for (int y = 1; y < tbl.tbl.length; y++) {
   if (!tbl.tbl[y][clm2].equalsIgnoreCase(restr)) {
       //StackOverflow
    System.arraycopy(tbl.tbl[y], 0, array[row2], 0, tbl.tbl[0].length);
    row2 += 1;
   }
  }
  return array;
 }
/**
 * 
 * @param tbl
 * @param clm
 * @param restr
 * @param exe
 * @return 
 */
 private static String[][] gtlteq(NewTable tbl, String clm, String restr, String exe) {
  int clm2 = tbl.c1(clm);
  int row2 = 1;
  String[][] array = new String[rrow(tbl, clm, restr, exe)][tbl.rcol()];
  // StackOverflow
  System.arraycopy(tbl.tbl[0], 0, array[0], 0, tbl.tbl[0].length);
  if (exe.equals(">")) {
   for (int y = 1; y < tbl.tbl.length; y++) {
    if (Integer.parseInt(tbl.tbl[y][clm2]) > Integer.parseInt(restr)) {
     //StackOverflow
     System.arraycopy(tbl.tbl[y], 0, array[row2], 0, tbl.tbl[0].length);
     row2 += 1;
    }
   }
  }
  if (exe.equals("<")) {
   for (int y = 1; y < tbl.tbl.length; y++) {
    if (Integer.parseInt(tbl.tbl[y][clm2]) < Integer.parseInt(restr)) {
     //StackOverflow
     System.arraycopy(tbl.tbl[y], 0, array[row2], 0, tbl.tbl[0].length);
     row2 += 1;
    }
   }
  }
  if (exe.equals("<=")) {
   for (int y = 1; y < tbl.tbl.length; y++) {
    if (Integer.parseInt(tbl.tbl[y][clm2]) <= Integer.parseInt(restr)) {
     //StackOverflow
     System.arraycopy(tbl.tbl[y], 0, array[row2], 0, tbl.tbl[0].length);
     row2 += 1;
    }
   }
  }
  if (exe.equals(">=")) {
   for (int y = 1; y < tbl.tbl.length; y++) {
    if (Integer.parseInt(tbl.tbl[y][clm2]) >= Integer.parseInt(restr)) {
     //StackOverflow
     System.arraycopy(tbl.tbl[y], 0, array[row2], 0, tbl.tbl[0].length);
     row2 += 1;
    }
   }
  }
  return array;
 }
/**
 * 
 * @param tbl
 * @param clm
 * @param restr
 * @return 
 */
 private static int rrow(NewTable tbl, String clm, String restr) {
  int clm2 = tbl.c1(clm);
  int roID = 0;
  if (clm2 < 0) {
   System.out.println("ERROR COLUMN DOES NOT EXIST");
   return -1;
  }
  for (int x = 1; x < tbl.tbl.length; x++) {
   if (tbl.tbl[x][clm2].equalsIgnoreCase(restr))
    roID += 1;
  }
  return roID + 1;
 }

/**
 * 
 * @param tbl
 * @param clm
 * @param restr
 * @param exe
 * @return 
 */
 private static int rrow(NewTable tbl, String clm, String restr, String exe) {
  int clm2;
  clm2 = tbl.c1(clm);
  int roID = 0;
  if (clm2 < 0) {
   System.out.println("ERROR COLUMN DOES NOT EXIST");
   return -1;
  }
   /*  if (exe.equals("=")) {
   for (int x = 1; x < tbl.tbl.length; x++) {
    if (Integer.parseInt(tbl.tbl[x][clm2]) <= Integer.parseInt(restr))
     roID += 1;
   }
  }
   if (exe.equals("!=")) {
   for (int x = 1; x < tbl.tbl.length; x++) {
    if (Integer.parseInt(tbl.tbl[x][clm2]) <= Integer.parseInt(restr))
     roID += 1;
   }
  }
  */  
 if (exe.equals(">=")) {
   for (int x = 1; x < tbl.tbl.length; x++) {
    if (Integer.parseInt(tbl.tbl[x][clm2]) >= Integer.parseInt(restr))
     roID += 1;
   }
  }
  if (exe.equals(">")) {
   for (int x = 1; x < tbl.tbl.length; x++) {
    if (Integer.parseInt(tbl.tbl[x][clm2]) > Integer.parseInt(restr))
     roID += 1;
   }
  }
   if (exe.equals("<=")) {
   for (int x = 1; x < tbl.tbl.length; x++) {
    if (Integer.parseInt(tbl.tbl[x][clm2]) <= Integer.parseInt(restr))
     roID += 1;
   }
  }
  if (exe.equals("<")) {
   for (int x = 1; x < tbl.tbl.length; x++) {
    if (Integer.parseInt(tbl.tbl[x][clm2]) < Integer.parseInt(restr))
     roID += 1;
   }
  }
  return roID + 1; // Have to include the r1 for the columns with + 1
 }

/**
 * 
 * @param tbl
 * @param clm
 * @param restr
 * @return 
 */
 private static String[][] eq(NewTable tbl, String clm, String restr) {
  int clm2 = tbl.c1(clm);
  int row2 = 1;
  String[][] array = new String[rrow(tbl, clm, restr)][tbl.rcol()];
  System.arraycopy(tbl.tbl[0], 0, array[0], 0, tbl.tbl[0].length);
  for (int y = 1; y < tbl.tbl.length; y++) {
   if (tbl.tbl[y][clm2].equalsIgnoreCase(restr)) {
    System.arraycopy(tbl.tbl[y], 0, array[row2], 0, tbl.tbl[0].length);
    row2 += 1;
   }
  }
  return array;
 }
 /**
  * 
  * @param restrict
  * @return 
  */
 private static String restrict(String restrict) {
  String str = "";
  Scanner scan2 = new Scanner(restrict);
  scan2.useDelimiter(">=|>|<=|<|!=|=|'");
  scan2.next();
  while (scan2.hasNext()) {
   String a = scan2.next();
   if (!a.contains(" ")) {
    str = a;
   }
  }
  return str;
 }
/**
 * 
 * @param restrict
 * @return 
 * REGEx From RegEx Handout
 */
 private static String oper(String restrict) {
  return restrict.replaceAll("[^=<>!]", "");
 }
/**
 * 
 * @param restrict
 * @return 
 */
 private static String c1(String restrict) {
  Scanner scan2 = new Scanner(restrict);
  scan2.useDelimiter("=|>|<|>=|<=|!=|'");
  return scan2.next();
 }
/**
 * 
 * @param a
 * @param b
 * @return 
 */
 private static int num1(String[] a, String[] b) {
  int num3 = 0;
  for (String a2: a) {
   for (String a3: b) {
    if (a2.equalsIgnoreCase(a3)) {
     num3 += 1;
    }
   }
  }
  return a.length + b.length - num3;
 }
/**
 * 
 * @param clms
 * @return 
 */
 private static int num1(String clms) {
  int num3 = 0;
  Scanner scan = new Scanner(clms);
  scan.useDelimiter(", *");
  while (scan.hasNext()) {
   scan.next();
   num3 += 1;
  }
  return num3;
 }
 /**
  * 
  * @param cols
  * @param clms
  * @return 
  */
 private static String[] buildTable(int cols, String clms) {
  String[] a = new String[cols];
  int num3 = 0;
  Scanner scan = new Scanner(clms);
  scan.useDelimiter(", *");
  while (scan.hasNext()) {
   a[num3] = scan.next();
   num3 += 1;
  }
  return a;
 }
}