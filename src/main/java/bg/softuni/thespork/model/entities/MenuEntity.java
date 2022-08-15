package bg.softuni.thespork.model.entities;

import bg.softuni.thespork.model.entities.enums.Cuisine;

import javax.persistence.*;

@Entity
@Table(name = "menus")
public class MenuEntity extends BaseEntity {
    @ManyToOne
    private RestaurantEntity restaurant;
    @Enumerated(EnumType.STRING)
    private Cuisine cuisine;

}
