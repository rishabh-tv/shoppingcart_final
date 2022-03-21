import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;


public class ShoppingCartTest {
    eWallet wallet;

    @BeforeTest
    public void intialize()
    {
        wallet=new eWallet(500);
    }

    @Test
    public void addProductTotheCart() {
        Customer customer1 = new Customer(wallet);
        ShoppingCart cart1 = new ShoppingCart();
        Apple a1 = new Apple(1, 10.00, "Apple");
        NewsPaper n1 = new NewsPaper(2, 4.00, "Newspaper");
        Milk m1 = new Milk(2,10, "Milk");
        cart1.addProduct(a1);
        cart1.addProduct(n1);
        cart1.addProduct(m1);

        Assert.assertEquals(3,cart1.getShopppingList().size());

    }

    @Test
    public void getsubTotalForProducts() {

        ShoppingCart cart1 = new ShoppingCart();
        Apple a1 = new Apple(8, 10.00,  "Apple");
        cart1.addProduct(a1);
        Assert.assertEquals(80.00, cart1.subTotal(a1));

        NewsPaper n1 = new NewsPaper(2, 4.00, "Newspaper");
        cart1.addProduct(n1);
        Assert.assertEquals(8.00, cart1.subTotal(n1));

        Milk m1 = new Milk(2, 45.00, "Milk");
        cart1.addProduct(m1);
        Assert.assertEquals(90.00, cart1.subTotal(m1));


    }

    @Test
    public void getTotalBill() {

        ShoppingCart cart1 = new ShoppingCart();
        Apple a1 = new Apple(10, 10.00, "Apple");
        NewsPaper n1 = new NewsPaper(5, 4.00, "Newspaper");
        Milk m1 = new Milk(4, 45.00, "Milk");
        cart1.addProduct(a1);

        cart1.addProduct(n1);

        cart1.addProduct(m1);


        System.out.println("Total bill amount is " + cart1.total());
        Assert.assertEquals(300.00, cart1.total());
    }

    @Test
    public void toPayViaWallet() {
        Customer customer1 = new Customer(wallet);
        ShoppingCart cart1 = new ShoppingCart();
        Apple a1 = new Apple(8, 10.00, "Apple");
        NewsPaper n1 = new NewsPaper(2, 4.00, "Newspaper");
        Milk m1 = new Milk(2, 45.00, "Milk");
        cart1.addProduct(a1);
        customer1.addToCart(a1);
        cart1.addProduct(n1);
        customer1.addToCart(n1);
        cart1.addProduct(m1);
        customer1.addToCart(m1);

        System.out.println("Total bill amount is " + cart1.total());
        double totalAfterDed = 0.00;


        if (cart1.total() >= 100)
            totalAfterDed = cart1.total() - (cart1.total() * 0.5);
        wallet.deductBalance(totalAfterDed);
        System.out.println("Wallet balance is " + wallet.getBalance());
        Assert.assertEquals(411, wallet.getBalance());

    }
}