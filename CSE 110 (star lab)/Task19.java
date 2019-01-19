import java.util.Scanner;
public class Task19
{
  public static void main(String[] args)
  {
    Scanner Sc = new Scanner(System.in);
    System.out.println("Please enter hight: ");
    int hight = Sc.nextInt();
    int space;
    for(int count=hight;count>=1;count--)
    {
      for(space=1;space<count;space++)
      {
        System.out.print(" ");
      }
      for(int num=space;num<=hight;num++)
      {
        if((num==space)||(num==hight)||(count==1))
        {
          System.out.print(num);
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