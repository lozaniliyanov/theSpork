package bg.softuni.thespork.model.view;

import bg.softuni.thespork.model.entities.enums.MenuCategory;

import java.math.BigDecimal;

public class MenuItemViewModel {
    private MenuCategory menuCategory;
    private String menuItemName;
    private String description;
    private BigDecimal price;
    private MenuViewModel menu;

    public MenuItemViewModel() {

    }

    public MenuCategory getMenuCategory() {
        return menuCategory;
    }

    public MenuItemViewModel setMenuCategory(MenuCategory menuCategory) {
        this.menuCategory = menuCategory;
        return this;
    }

    public String getMenuItemName() {
        return menuItemName;
    }

    public MenuItemViewModel setMenuItemName(String menuItemName) {
        this.menuItemName = menuItemName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public MenuItemViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public MenuItemViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public MenuViewModel getMenu() {
        return menu;
    }

    public MenuItemViewModel setMenu(MenuViewModel menu) {
        this.menu = menu;
        return this;
    }
}
