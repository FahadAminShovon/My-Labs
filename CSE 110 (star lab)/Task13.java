import java.util.Scanner;
public class Task13
{
  public static void main(String[] args)
  {
    Scanner Sc = new Scanner(System.in);
    System.out.println("Please enter number: ");
    int num = Sc.nextInt();
    int space,star;
    for(int count=1;count<=(num*2-1);count++)
    {
      for(space=0;space<Math.abs(num-count);space++)
      {
        System.out.print(" ");
      }
      for(star=1;star<=Math.abs((num-space)*2-1);star++)
      {
        System.out.print(star);
      }
      System.out.println();
    }
  }
}