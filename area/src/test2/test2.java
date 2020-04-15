package test2;
import java.util.Scanner;

public class test2 {

	public static void main(String[] args) {
		Scanner s =new Scanner(System.in);
		double l;
		double w;
		String  shape;
		System.out.println("Enter the shape you want to calculate its area");
		shape=s.nextLine();
		if(shape.equals("rectangle"))
		{
		   System.out.println("enter the length");
		   l=s.nextDouble();
		   System.out.println("enter the width");
		   w=s.nextDouble();
		   double area=l*w;
		   System.out.println("the area of rectangle is "+area);
		}
		
		else if(shape.equals("square"))
		{
		   System.out.println("enter the length");
		   l=s.nextDouble();
		   double area=l*l;
		   System.out.println("the area of rectangle is "+area);
		}
		else if(shape.equals("triangle"))
		{
		   System.out.println("enter the height");
		   l=s.nextDouble();
		   System.out.println("enter the base");
		   w=s.nextDouble();
		   double area=(1/2)*w*l;
		   System.out.println("the area of rectangle is "+area);
		}
	}

}
