package fr.dawan.designspatterns.creation.builder;

import lombok.*;

/*@Getter
@Setter
@ToString
@EqualsAndHashCode*/
@Data // contient: @Getter, @Setter, @ToString, @RequiredArgConstructor
@Builder
public class ProductLombok {
    private int id;
    private String name;
    private double price;
}
