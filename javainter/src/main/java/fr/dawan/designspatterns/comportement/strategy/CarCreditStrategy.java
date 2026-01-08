package fr.dawan.designspatterns.comportement.strategy;

public class CarCreditStrategy implements PaymentStrategy{

    private String name;
    private String cardNumber;
    private String cvv;
    private String dateExperacy;

    public CarCreditStrategy(String name, String cardNumber, String cvv, String dateExperacy) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.dateExperacy = dateExperacy;
    }

    @Override
    public void pay(double amount) {
        //logic
        System.out.println(amount+" paid with credit/card");
    }
}
