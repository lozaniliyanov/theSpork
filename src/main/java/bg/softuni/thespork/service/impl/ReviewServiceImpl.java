package bg.softuni.thespork.service.impl;

import bg.softuni.thespork.model.entities.RestaurantEntity;
import bg.softuni.thespork.model.entities.ReviewEntity;
import bg.softuni.thespork.model.entities.UserEntity;
import bg.softuni.thespork.model.service.RestaurantServiceModel;
import bg.softuni.thespork.model.service.ReviewServiceModel;
import bg.softuni.thespork.repository.ReviewRepository;
import bg.softuni.thespork.service.ReviewService;
import bg.softuni.thespork.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserService userService;
    private final ModelMapper modelMapper;

    public ReviewServiceImpl(ReviewRepository reviewRepository,
                             UserService userService,
                             ModelMapper modelMapper) {
        this.reviewRepository = reviewRepository;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @Override
    public ReviewServiceModel addReview(ReviewServiceModel reviewServiceModel, String user, RestaurantServiceModel restaurantServiceModel) {
        ReviewEntity reviewEntity = modelMapper.map(reviewServiceModel, ReviewEntity.class);
        reviewEntity.setAuthor(modelMapper.map(userService.findUserByUsername(user), UserEntity.class));
        reviewEntity.setRestaurant(modelMapper.map(restaurantServiceModel, RestaurantEntity.class));
        return modelMapper.map(reviewRepository.save(reviewEntity), ReviewServiceModel.class);
    }

    @Override
    public ReviewServiceModel findById(Long id) {
        return null;
    }

    @Override
    public List<ReviewServiceModel> findReviewsByRestaurantName(String restaurantName) {
        return this.reviewRepository.findAllByRestaurant_RestaurantName(restaurantName).stream().map(
                reviewEntity -> this.modelMapper.map(reviewEntity, ReviewServiceModel.class)
        ).collect(Collectors.toList());
    }

    @Override
    public void deleteReview(Long id) {

    }
}
