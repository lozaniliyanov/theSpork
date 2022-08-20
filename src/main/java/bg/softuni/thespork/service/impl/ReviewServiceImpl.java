package bg.softuni.thespork.service.impl;

import bg.softuni.thespork.model.entities.ReviewEntity;
import bg.softuni.thespork.model.service.RestaurantServiceModel;
import bg.softuni.thespork.model.service.ReviewServiceModel;
import bg.softuni.thespork.repository.ReviewRepository;
import bg.softuni.thespork.service.RestaurantService;
import bg.softuni.thespork.service.ReviewService;
import bg.softuni.thespork.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final RestaurantService restaurantService;
    private final UserService userService;
    private final ModelMapper modelMapper;

    public ReviewServiceImpl(ReviewRepository reviewRepository,
                             RestaurantService restaurantService,
                             UserService userService,
                             ModelMapper modelMapper) {
        this.reviewRepository = reviewRepository;
        this.restaurantService = restaurantService;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedReviews() {
        ReviewEntity reviewForPikosNo1 = new ReviewEntity().
                setComment("Excellent").
                setRating(5.0).
                setCreatedDate(LocalDateTime.now()).
                setAuthor(userService.findByName("mamosOwner")).
                setRestaurant(restaurantService.findByName("Pikos"));
        ReviewEntity reviewForMamosNo1 = new ReviewEntity().
                setComment("Excellent").
                setRating(5.0).
                setCreatedDate(LocalDateTime.now()).
                setAuthor(userService.findByName("pikosOwner")).
                setRestaurant(restaurantService.findByName("Mamos"));
        ReviewEntity reviewForPikosNo2 = new ReviewEntity().
                setComment("Good").
                setRating(4.0).
                setCreatedDate(LocalDateTime.now()).
                setAuthor(userService.findByName("mamosOwner")).
                setRestaurant(restaurantService.findByName("Pikos"));
        ReviewEntity reviewForMamosNo2 = new ReviewEntity().
                setComment("Good").
                setRating(4.0).
                setCreatedDate(LocalDateTime.now()).
                setAuthor(userService.findByName("pikosOwner")).
                setRestaurant(restaurantService.findByName("Mamos"));
        ReviewEntity reviewForPikosNo3 = new ReviewEntity().
                setComment("Okay").
                setRating(3.0).
                setCreatedDate(LocalDateTime.now()).
                setAuthor(userService.findByName("mamosOwner")).
                setRestaurant(restaurantService.findByName("Pikos"));
        ReviewEntity reviewForMamosNo3 = new ReviewEntity().
                setComment("Okay").
                setRating(3.0).
                setCreatedDate(LocalDateTime.now()).
                setAuthor(userService.findByName("pikosOwner")).
                setRestaurant(restaurantService.findByName("Mamos"));
        reviewRepository.save(reviewForPikosNo1);
        reviewRepository.save(reviewForMamosNo1);
        reviewRepository.save(reviewForPikosNo2);
        reviewRepository.save(reviewForMamosNo2);
        reviewRepository.save(reviewForPikosNo3);
        reviewRepository.save(reviewForMamosNo3);
    }

    @Override
    public ReviewServiceModel addReview(ReviewServiceModel reviewServiceModel, String user, RestaurantServiceModel restaurantServiceModel) {
        return null;
    }

    @Override
    public ReviewServiceModel findById(Long id) {
        return null;
    }

    @Override
    public List<ReviewServiceModel> findReviewsByRestaurantId(Long id) {
        return null;
    }

    @Override
    public void deleteReview(Long id) {

    }
}
