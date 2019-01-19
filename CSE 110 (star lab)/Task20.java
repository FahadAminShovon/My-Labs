import java.util.Scanner;
public class Task20
{
  public static void main(String[] args)
  {
    Scanner Sc = new Scanner(System.in);
    System.out.println("Please enter hight: ");
    int hight = Sc.nextInt();
    
    for(int count=1;count<=hight;count++)
    {
      for(int space=count;space<hight;space++)
      {
        System.out.print(" ");
      }
      for(int star=1;star<=(count*2-1);star++)
      {
        if((star==1)||(star==(count*2-1))||(count==hight))
        {
          System.out.print("*");
        }
        else
        {
           System.out.print(" ");
           }
      }
      System.out.println();
    }
  }
}