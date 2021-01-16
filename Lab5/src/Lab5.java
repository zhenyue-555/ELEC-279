//amanda Yu 20093332
//Shangzhou Yin 20126159
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.HashSet;
import java.util.Iterator;

public class Lab5 {	

	public static void main(String[] args)
    {
		ArrayList<Integer> intArray  = new ArrayList<Integer>(5);
		Random randomGenerator  = new Random();
		
		for (int i = 0; i<10; i++)
		{
		   int rand = randomGenerator.nextInt(100);
		   intArray.add(rand);
		}
		System.out.println(intArray);
		ArrayList<Integer> revIntArray  = new ArrayList<Integer>(10);
		
		for(int num : intArray)
		{
			revIntArray.add(0,num);
			
		}
		System.out.println(revIntArray);
		ArrayList<HourlyEmployee> HE  = new ArrayList<HourlyEmployee>(100);
		HourlyEmployee a = new HourlyEmployee("aaa",new Date(2000,01,01),10,10);
		HourlyEmployee b = new HourlyEmployee("bbb",new Date(2000,02,02),20,20);
		HourlyEmployee c = new HourlyEmployee("ccc",new Date(2000,03,03),30,30);
		HourlyEmployee d = new HourlyEmployee("ddd",new Date(2000,04,04),40,40);
		HE.add(a);
		HE.add(b);
		HE.add(c);
		HE.add(d);
		System.out.println(HE);
		System.out.println(HE.size());
		HourlyEmployee e = new HourlyEmployee("eee",new Date(),50,50);
		HE.set(0, e);
		System.out.println(HE);
		HE.remove(2);
		HE.trimToSize();
		System.out.println(HE);
		System.out.println(HE.size());
		Pair<String> obj1 = new Pair<String>("H","Day");
		Pair<String> obj2 = new Pair<String>("H","Day");
		Pair<String> obj3 = new Pair<String>("He","Deay");
		System.out.println(obj1.equals(obj2));
		System.out.println(obj1.equals(obj3));
		Triple <String,Double>trip1 = new Triple<>("Toronto", 547.0,"Montreal");
		Triple <String,Double>trip2 = new Triple<>("Toronto", 264.5,"Kingston");
		Triple <String,Double>trip3 = new Triple<>("Toronto", 264.5,"Kingston");
		System.out.println(trip1.equals(trip2));
		System.out.println(trip2.equals(trip3));
		
    }
}
