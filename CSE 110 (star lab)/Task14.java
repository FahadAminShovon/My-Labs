import java.util.Scanner;
public class Task14
{
  public static void main(String[] args)
  {
    Scanner Sc = new Scanner(System.in);
    System.out.println("Please enter length: ");
    int length = Sc.nextInt();
    System.out.println("Please enter width: ");
    int width = Sc.nextInt();
    
    for(int count=1;count<=length;count++)
    {
      for(int star=1;star<=width;star++)
      {
        if((star==1)||(star==width)||(count==1)||(count==length))
        {
          System.out.print("*");
        }
        else{
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }
}