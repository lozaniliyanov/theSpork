package bg.softuni.thespork.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "restaurants")
public class RestaurantEntity extends BaseEntity {
//    @Column(name = "owner")
//    @OneToOne
//    private UserEntity owner;

}
