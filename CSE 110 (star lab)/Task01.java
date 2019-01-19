import java.util.Scanner;
public class Task01
{
  public static void main(String[] args)
  {
    Scanner Sc = new Scanner(System.in);
    System.out.println("Please enter a number: ");
    int num = Sc.nextInt();
      
      for(int count =1;count<=num;count++)
    {
      System.out.print(count+",");
    }
    System.out.println();
  }
}
