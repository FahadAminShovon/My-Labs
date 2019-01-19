import java.util.Scanner;
public class Task11
{
  public static void main(String[] args)
  {
    Scanner Sc = new Scanner(System.in);
    System.out.println("Please enter hight: ");
    int hight=Sc.nextInt();
    
    for(int term = hight;term>=1;term--)
    {
      int termOne=0;
      for(termOne=1;termOne<term;termOne++)
      {
        System.out.print(" ");
      }
      for(int termTwo=term;termTwo<=hight;termTwo++)
      {
        System.out.print(termTwo);
      }
      System.out.println();
    }
  }
}