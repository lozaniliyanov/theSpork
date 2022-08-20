package bg.softuni.thespork.service;

import bg.softuni.thespork.model.entities.MenuEntity;

public interface MenuService {
    void seedMenus();

    MenuEntity findById(Long id);
}
