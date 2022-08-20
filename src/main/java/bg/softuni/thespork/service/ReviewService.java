package bg.softuni.thespork.service;

import bg.softuni.thespork.model.service.RestaurantServiceModel;
import bg.softuni.thespork.model.service.ReviewServiceModel;

import java.util.List;

public interface ReviewService {
    // TODO: 20/08/2022 add getAllReviewsMethod
    void seedReviews();

    ReviewServiceModel addReview(ReviewServiceModel reviewServiceModel, String user, RestaurantServiceModel restaurantServiceModel);

    ReviewServiceModel findById(Long id);

    List<ReviewServiceModel> findReviewsByRestaurantId(Long id);

    void deleteReview(Long id);
}
