package bg.softuni.thespork.service.impl;

import bg.softuni.thespork.model.entities.MenuItemEntity;
import bg.softuni.thespork.model.entities.enums.MenuCategory;
import bg.softuni.thespork.model.service.MenuItemServiceModel;
import bg.softuni.thespork.model.service.MenuServiceModel;
import bg.softuni.thespork.repository.MenuItemRepository;
import bg.softuni.thespork.repository.MenuRepository;
import bg.softuni.thespork.service.MenuItemService;
import bg.softuni.thespork.service.MenuService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class MenuItemServiceImpl implements MenuItemService {

    private final MenuService menuService;
    private final MenuItemRepository menuItemRepository;
    private final ModelMapper modelMapper;
    private final MenuRepository menuRepository;

    public MenuItemServiceImpl(MenuService menuService, MenuItemRepository menuItemRepository, ModelMapper modelMapper, MenuRepository menuRepository) {
        this.menuService = menuService;
        this.menuItemRepository = menuItemRepository;
        this.modelMapper = modelMapper;
        this.menuRepository = menuRepository;
    }

    @Override
    public void seedMenuItems() {
        MenuItemEntity menuItemStarter1ForPikos = new MenuItemEntity().
                setMenuItemName("menuItemStarter1ForPikos").
                setMenuCategory(MenuCategory.STARTER).
                setDescription("Description for menuItemStarter1ForPikos").
                setPrice(BigDecimal.valueOf(1)).
                setMenu(menuRepository.findById(1L).orElseThrow());
        menuItemRepository.save(menuItemStarter1ForPikos);
    }

    @Override
    public MenuItemServiceModel addMenuItem(MenuItemServiceModel menuItemServiceModel, MenuServiceModel menuServiceModel) {
        return null;
    }

    @Override
    public MenuItemServiceModel editMenuItem(MenuItemServiceModel menuItemServiceModel, Long id) {
        return null;
    }

    @Override
    public void deleteMenuItem(Long id) {

    }

    @Override
    public List<MenuItemServiceModel> findAllMenuItemsUnderCategory(MenuCategory menuCategory) {
        return null;
    }
}
