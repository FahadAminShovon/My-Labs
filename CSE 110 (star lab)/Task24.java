import java.util.Scanner;
public class Task24
{
  public static void main(String[] args)
  {
    Scanner Sc = new Scanner(System.in);
    System.out.println("Please enter a number: ");
    int num = Sc.nextInt();
    
    for(int count =1;count<=(num*2-1);count++)
    {
      System.out.print(Math.abs((Math.abs(num-count))-num));
  }
    System.out.println();
  }
}