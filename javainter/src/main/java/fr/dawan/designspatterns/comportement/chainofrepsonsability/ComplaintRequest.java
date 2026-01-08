package fr.dawan.designspatterns.comportement.chainofrepsonsability;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Data
public class ComplaintRequest {

    private int studentNumero;
    private int complaintType; // 1: Teacher - 2: Respons. pedagogique - 3: directeur
    private ComplaintState state;
    private String message;

}
