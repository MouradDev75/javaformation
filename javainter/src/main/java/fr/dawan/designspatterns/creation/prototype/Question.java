package fr.dawan.designspatterns.creation.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Question implements Cloneable{

    private String texte;
    private List<Reponse> reponses = new ArrayList<>();

    /*
    la méthode clone; ne clone que lestypes primitifs: int, string, double........
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        Question qst = (Question) super.clone(); //cloner les types primitifs

        //attributs reponses n'est pas de type primitifs
        qst.reponses = new ArrayList<>();
        for(Reponse rep : reponses){
            qst.getReponses().add((Reponse) rep.clone());
        }

        return qst;
    }
}
