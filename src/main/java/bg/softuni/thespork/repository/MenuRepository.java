package bg.softuni.thespork.repository;

import bg.softuni.thespork.model.entities.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<MenuEntity, Long> {

}
