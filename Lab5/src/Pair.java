//amanda Yu 20093332
//Shangzhou Yin 20126159
public class Pair<T> {
	private  T name1;
	private  T name2;
	
	public Pair()
	{
		name1 = null;
		name2 = null;
	}
	public Pair(T first, T second)
	{
		name1 = first;
		name2 = second;
	}
	
	public boolean equals(Object otherObject)
	{
		if(otherObject == null)
			return false;
		else if (getClass() != otherObject.getClass())
			return false;
		else
		{
			Pair<T> otherPair = (Pair<T>)otherObject;
			return (name1.equals(otherPair.name1)
					&&name2.equals(otherPair.name2));
		}
	}
	public String toString()
	{
		return ("name1" + name1.toString() + "\n" + "name2" + name2.toString());
	}
}
