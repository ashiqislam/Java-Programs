public class Person 
{
    private String name; 
    private String address; 
    private String phoneNumber; 

    public Person()
    {
    }

    public Person(String name, String address, String phoneNumber) 
    {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName()
    {
        return name;
    }

    public String getAddress()
    {
        return address;
    }

    public String getNumber()
    {
        return phoneNumber;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
}

