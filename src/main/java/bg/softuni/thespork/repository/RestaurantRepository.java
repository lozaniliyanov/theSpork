package bg.softuni.thespork.repository;

import bg.softuni.thespork.model.entities.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Long> {
    List<RestaurantEntity> findAllByOwnerId(Long id);

    List<RestaurantEntity> findAllByOwner_Username(String username);

    Optional<RestaurantEntity> findByRestaurantName(String restaurantName);

    @Query("SELECT COUNT(r) FROM RestaurantEntity r")
    int countRestaurantEntities();

    boolean existsByRestaurantName(String restaurantName);
}
