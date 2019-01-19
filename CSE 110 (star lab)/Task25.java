import java.util.Scanner;
public class Task25
{
  public static void main(String[] args)
  {
    Scanner Sc = new Scanner(System.in);
    System.out.println("Please enter a number: ");
    int num = Sc.nextInt();
    
    for(int term=1;term<=num;term++)
    {
      for(int space=term;space<num;space++)
      {
        System.out.print(" ");
      }
      for(int count =1;count<=(term*2-1);count++)
      {
        System.out.print(Math.abs((Math.abs(term-count))-term));
      }
      System.out.println();
    }
  }
}