import java.util.Scanner;
public class Task02
{
  public static void main(String[] args)
  {
    Scanner Sc = new Scanner(System.in);
    System.out.println("Please enter a number: ");
    int star = Sc.nextInt();
      
      for(int count =1;count<=star;count++)
    {
      System.out.print("*");
    }
    System.out.println();
  }
}
