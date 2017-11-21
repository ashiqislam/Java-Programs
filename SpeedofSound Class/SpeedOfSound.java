public class SpeedOfSound
{
  private double distance;      //the distance the sound traveled
  
  public SpeedOfSound (double d)
  {
    distance = d;
  }
  
  public void setDistance(double d) 
  {
    distance = d;
  }
  
  public double getDistance()   
  {
    return distance;  
  }
  
  public double getTimeInAir()
  {
    return distance/1100; 
  }
  
  public double getTimeInWater()
  {
    return distance/4900;  
  }
  
  public double getTimeInSteel()
  {
    return distance/16400; 
  }
}