public class Customer extends Person
{
    private int CustomerNumber; 
    private boolean mailList; 
    public Customer()
    {
    }

    public Customer(String name, String address, String phoneNumber,
    int CustomerNumber, boolean mailList)
    {
        super(name, address, phoneNumber);
        this.CustomerNumber = CustomerNumber;
        this.mailList = mailList;
    }

    public int getcustNumber()
    {
        return CustomerNumber;
    }

    public boolean getMailList()
    {
        return mailList;
    }

    public void setcustNumber(int CustomerNumber)
    {
        this.CustomerNumber = CustomerNumber;
    }

    public void setMailList(boolean mailList)
    {
        this.mailList = mailList;
    }

    public String toString()
    {
        return "Name: "+getName()+
        "\nAddress: " +getAddress()+
        "\nTelephone: "+getNumber()+
        "\nCustomer Number: "+CustomerNumber+
        "\nMailing List: "+mailList;
    }
}