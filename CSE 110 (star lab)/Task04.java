import java.util.Scanner;
public class Task04
{
  public static void main(String[] args)
  {
    Scanner Sc = new Scanner(System.in);
    System.out.println("Please enter lines: ");
    int line = Sc.nextInt();
    System.out.println("Please enter Star: ");
    int star = Sc.nextInt();
    
    for(int term = 1;term<=line;term++)
    {
      for(int count =1;count<=star;count++)
    {
      System.out.print(count);
    }
    System.out.println();
    }
  }
}