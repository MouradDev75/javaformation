package fr.dawan.designspatterns.comportement.strategy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Item {

    private String qrCode;
    private double price;
}
