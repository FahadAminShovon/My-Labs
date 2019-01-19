import java.util.Scanner;
public class Task09
{
  public static void main(String[] args)
  {
    Scanner Sc = new Scanner(System.in);
    System.out.println("Please enter hight: ");
    int hight=Sc.nextInt();
    
    for(int term = 1;term<=hight;term++)
    {
      for(int termOne=term;termOne<hight;termOne++)
      {
        System.out.print(" ");
      }
      for(int termTwo=1;termTwo<=(term*2-1);termTwo++)
      {
        System.out.print("*");
      }
      System.out.println();
    }
  }
}