import java.util.Scanner;
public class Task17
{
  public static void main(String[] args)
  {
    Scanner Sc = new Scanner(System.in);
    System.out.println("Please enter hight: ");
    int hight = Sc.nextInt();
    
    for(int count=1;count<=hight;count++)
    {
      for(int star=1;star<=count;star++)
      {
        if((star==1)||(star==count)||(count==1)||(count==hight))
        {
          System.out.print(star);
        }
        else{
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }
}