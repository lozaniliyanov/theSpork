package bg.softuni.thespork.model.entities;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "menus")
public class MenuEntity extends BaseEntity {
    @OneToOne
    private RestaurantEntity restaurant;
    @OneToMany(mappedBy = "menu")
    private List<MenuItemEntity> menuItemEntities;

    public MenuEntity() {

    }

    public RestaurantEntity getRestaurant() {
        return restaurant;
    }

    public MenuEntity setRestaurant(RestaurantEntity restaurant) {
        this.restaurant = restaurant;
        return this;
    }

    public List<MenuItemEntity> getMenuItems() {
        return menuItemEntities;
    }

    public MenuEntity setMenuItems(List<MenuItemEntity> menuItemEntities) {
        this.menuItemEntities = menuItemEntities;
        return this;
    }
}
