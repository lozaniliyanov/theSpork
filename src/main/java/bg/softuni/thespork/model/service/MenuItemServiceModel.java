package bg.softuni.thespork.model.service;

import java.math.BigDecimal;

public class MenuItemServiceModel {
    private String menuCategory;
    private String menuItemName;
    private String description;
    private BigDecimal price;
    private MenuServiceModel menu;

    public MenuItemServiceModel() {

    }

    public String getMenuCategory() {
        return menuCategory;
    }

    public MenuItemServiceModel setMenuCategory(String menuCategory) {
        this.menuCategory = menuCategory;
        return this;
    }

    public String getMenuItemName() {
        return menuItemName;
    }

    public MenuItemServiceModel setMenuItemName(String menuItemName) {
        this.menuItemName = menuItemName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public MenuItemServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public MenuItemServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public MenuServiceModel getMenu() {
        return menu;
    }

    public MenuItemServiceModel setMenu(MenuServiceModel menu) {
        this.menu = menu;
        return this;
    }
}
