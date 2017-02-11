/**
 * @Author John Green & Stacy Austin
 * @sources www.mkyong.com, www.sitepoint.com, www.stackoverflow.com, Java Software Structures 4th Edition, Data Structures and Algorithms in Java 2nd Edition
 */
public class Driver {
    /**
     * 
     * @param args 
     */
 public static void main(String args[]) {
  NewTable cars = new NewTable("cars.txt");

  NewTable toyotas = Algebra.Restrict(cars, "MAKE='Ford'");

  NewTable answer = Algebra.Project(fords, "Make,Model,Price");

  Algebra.Display(answer);

  NewTable equals = Algebra.Restrict(cars, "PRICE=21000");
  Algebra.Display(equals);

  NewTable greaterThan = Algebra.Restrict(cars, "PRICE>=21000");
  Algebra.Display(greaterThan);

  NewTable lessThan = Algebra.Restrict(cars, "PRICE<=21000");
  Algebra.Display(lessThan);
 }
}