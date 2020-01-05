import java.util.*;
import java.io.*;
import java.time.*;
//
class fibonacci
{
	
  void displayPair(List<Integer> a)
	{
		ListIterator<Integer> lr = a.listIterator();
		while(lr.hasNext())
		{
			int i = lr.next();
			if( i == -1)
				System.out.print(" : ");
			else
				System.out.print(i);
		}
		System.out.println();
	}
	
//
  List<Integer> addByDigit(List<Integer> l)
	{
		List<Integer> stored = new ArrayList<Integer>();//Final values
		List<Integer> inter = new ArrayList<Integer>();//For intermediate storage
	  int val;
		ListIterator li1 = l.listIterator();
		while(li1.hasNext()) // For traversing to second part
		{
			val = (int)li1.next();
			if(val == -1) // The delimitter is -1
				break;
			
		}
		val = (int)li1.next();
		stored.add(val);
		while(li1.hasNext())
		{
			val = (int)li1.next();
			stored.add(val);
		}
		stored.add(-1);
		 ListIterator li2 = l.listIterator();
		 while(li2.hasNext())
		 {
		 	val = (int)li2.next();
		 	if(val == -1)
		 		break;
		 }
		 li2.previous(); // this returns -1
		 int carry = 0, sum = 0;
		 while(li2.hasPrevious())
		 {
		 	sum = carry + (int)li1.previous() + (int)li2.previous();
		 	if(sum >= 10)
		 		{
		 			inter.add(sum-10);
		 			carry = 1;
		 		}
		 	else
		 		{
		 			inter.add(sum);
		 			carry = 0;
		 		}
		 }
		 val = (int)li1.previous();
		 if(val != -1) // if val is -1 then the two terms have same no digits
		 {
		 	li1.next();
		 	sum = carry + (int)li1.previous();
		 	if(sum >= 10)
		 		{
		 			inter.add(sum-10);
		 			carry = 1;
		 		}
		 	else
		 		{
		 			inter.add(sum);
		 			carry = 0;
		 		}

		 }
		 if(carry == 1)
		 inter.add(carry);
		 ListIterator li3 = inter.listIterator();
		 while(li3.hasNext())
		 	li3.next();
	
     while(li3.hasPrevious())
		 {
		 	val = (int)li3.previous();
		 	stored.add(val);
		 }

		 displayPair(stored);
		 System.out.println();


	return stored;
	}
}
//
class fibBigNum
{
	public static void main(String[] a)
	{
		long sT = Instant.now().toEpochMilli();

		List<Integer> b = new ArrayList<Integer>();
		b.add(0);
		b.add(-1);
		b.add(1);

		fibonacci f = new fibonacci();
		for(int i= 1; i<=500; i++)
			b = f.addByDigit(b);

    long fT = Instant.now().toEpochMilli();
    float tE = fT - sT;
		tE /=1000;
		System.out.println("Time taken :- " + tE +"s");
	}
}
