package fr.dawan.designspatterns.comportement.strategy;

/**
 * Interface qui décrit le rôle du pattern strategy
 */
public interface PaymentStrategy {
    void pay(double amount);
}
