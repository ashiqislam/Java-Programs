public class PreferredCustomer extends Customer
{

    private double purchase;
    private double discount;
    private double discountPrice;

    public PreferredCustomer(String name,String address,
    String phoneNumber,int custNumber,
    boolean mailList,double purchase)
    {
        super(name,address,phoneNumber,
            custNumber,mailList);
        this.purchase=purchase;
    }

    private void calcDiscount()
    {
        if(getPurchase()>=2000) {
            setDiscount(10);
        }
        else if(getPurchase()>=1500) {
            setDiscount(7);
        }
        else if(getPurchase()>=1000) {
            setDiscount(6);
        }
        else if(getPurchase()>=500) {
            setDiscount(5);
        }
    }

    public void setPurchase(double purchase)
    {
        this.purchase=purchase;
    }

    private void setDiscount(double discount)
    {
        this.discount=discount;
    }

    public double getPurchase()
    {
        return purchase;
    }

    public double getDiscount()
    {
        calcDiscount();
        return discount;
    }

    private void calcDiscountPrice()
    {
        discountPrice=getPurchase()-(getPurchase()*(getDiscount()/100));
    }

    public void setDiscountPrice(double discountPrice)
    {
        this.discountPrice=discountPrice;
    }

    public double getDiscountPrice()
    {
        calcDiscountPrice();
        return discountPrice;
    }

    public String toString()
    {
        String preferredCustomer=super.toString()+
            "\nPurchases: $"+getPurchase()+
            "\nDiscount Level: "+getDiscount()+ " percent"+
            "\nDiscounted Price: $"+getDiscountPrice();
        return preferredCustomer;
    }
}