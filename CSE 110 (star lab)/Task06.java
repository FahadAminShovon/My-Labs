import java.util.Scanner;
public class Task06
{
  public static void main(String[] args)
  {
    Scanner Sc = new Scanner(System.in);
    System.out.println("Please enter hight: ");
    int hight = Sc.nextInt();
    
    for(int term = 1;term<=hight;term++)
    {
      for(int count =1;count<=term;count++)
    {
      System.out.print(count);
    }
    System.out.println();
    }
  }
}