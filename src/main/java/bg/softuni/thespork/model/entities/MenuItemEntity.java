package bg.softuni.thespork.model.entities;

import bg.softuni.thespork.model.entities.enums.MenuCategory;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "menu_items")
public class MenuItemEntity extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private MenuCategory menuCategory;
    @Column(name = "menu_item_name", nullable = false)
    private String menuItemName;
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    @Column(name = "price", nullable = false)
    private BigDecimal price;
    @ManyToOne
    private MenuEntity menu;

    public MenuItemEntity() {

    }

    public MenuCategory getMenuCategory() {
        return menuCategory;
    }

    public MenuItemEntity setMenuCategory(MenuCategory menuCategory) {
        this.menuCategory = menuCategory;
        return this;
    }

    public String getMenuItemName() {
        return menuItemName;
    }

    public MenuItemEntity setMenuItemName(String menuItemName) {
        this.menuItemName = menuItemName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public MenuItemEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public MenuItemEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public MenuEntity getMenu() {
        return menu;
    }

    public MenuItemEntity setMenu(MenuEntity menu) {
        this.menu = menu;
        return this;
    }
}
