package fr.dawan.designspatterns.creation.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Reponse implements Cloneable{

    private String texte;
    private boolean correct;


    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
