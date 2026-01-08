package fr.dawan.designspatterns.comportement.observer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Client implements Observer<Double>{

    private String name;

    @Override
    public void update(Double price) {
        System.out.println(name+" : Notification: new price = "+price);
        //logic
    }
}
