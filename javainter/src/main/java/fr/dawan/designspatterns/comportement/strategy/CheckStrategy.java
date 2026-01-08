package fr.dawan.designspatterns.comportement.strategy;

public class CheckStrategy implements PaymentStrategy{

    private String number;

    public CheckStrategy(String number) {
        this.number = number;
    }

    @Override
    public void pay(double amount) {
        //logic
        System.out.println(amount+" paid with check...");
    }
}
