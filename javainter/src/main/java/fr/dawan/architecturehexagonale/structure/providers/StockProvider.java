package fr.dawan.architecturehexagonale.structure.providers;

import fr.dawan.architecturehexagonale.domain.StockSpi;

public class StockProvider implements StockSpi {
    @Override
    public int getProductAvailability(String productRef) {
        //logic
        return 0;
    }
}
