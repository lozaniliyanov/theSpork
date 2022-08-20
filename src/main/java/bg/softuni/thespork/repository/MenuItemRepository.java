package bg.softuni.thespork.repository;

import bg.softuni.thespork.model.entities.MenuItemEntity;
import bg.softuni.thespork.model.entities.enums.MenuCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItemEntity, Long> {
    List<MenuItemEntity> findAllByMenuCategory(MenuCategory menuCategory);

}
