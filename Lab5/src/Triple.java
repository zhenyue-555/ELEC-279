//amanda Yu 20093332
//Shangzhou Yin 20126159
public class Triple<T1, T2> {
	private T1 Dcity;
	private double distance;
	private T1 Acity;
	
	public Triple()
	{
		Dcity = null;
		Acity = null;
		distance = 0.0;
	}
	public Triple(T1 DcityName, double theDistance, T1 AcityName)
	{
		Dcity = DcityName;
		distance = theDistance;
		Acity = AcityName;
		
	}
	public boolean equals(Object otherObject)
	{
		if(otherObject == null)
			return false;
		else if (getClass() != otherObject.getClass())
			return false;
		else
		{
			Triple otherTriple = (Triple)otherObject;
			return (Dcity.equals(otherTriple.Dcity)
					&&Acity.equals(otherTriple.Acity)&&(distance==otherTriple.distance));
		}
	}
	public String toString()
	{
		return ("Departure city is: " + Dcity.toString() + "\n" + "the distance is: " + distance + "the arrival city is: " + Acity.toString());
	}
	
}
