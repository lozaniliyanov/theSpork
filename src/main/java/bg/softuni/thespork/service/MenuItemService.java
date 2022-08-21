package bg.softuni.thespork.service;

import bg.softuni.thespork.model.entities.enums.MenuCategory;
import bg.softuni.thespork.model.service.MenuItemServiceModel;
import bg.softuni.thespork.model.service.MenuServiceModel;

import java.util.List;

public interface MenuItemService {
//    void seedMenuItems();

    MenuItemServiceModel addMenuItem(MenuItemServiceModel menuItemServiceModel, MenuServiceModel menuServiceModel);

    MenuItemServiceModel editMenuItem(MenuItemServiceModel menuItemServiceModel, Long id);

    void deleteMenuItem(Long id);

    List<MenuItemServiceModel> findAllMenuItemsUnderCategory(MenuCategory menuCategory);
}
