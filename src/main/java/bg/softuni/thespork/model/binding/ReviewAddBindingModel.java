package bg.softuni.thespork.model.binding;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public class ReviewAddBindingModel {

    private String comment;
    @NotBlank(message = "This field is required")
    private double rating;
    @NotBlank(message = "This field is required")
    private String priceRange;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDateTime createdDate;

    public ReviewAddBindingModel() {

    }

    public String getComment() {
        return comment;
    }

    public ReviewAddBindingModel setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public double getRating() {
        return rating;
    }

    public ReviewAddBindingModel setRating(double rating) {
        this.rating = rating;
        return this;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public ReviewAddBindingModel setPriceRange(String priceRange) {
        this.priceRange = priceRange;
        return this;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public ReviewAddBindingModel setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
        return this;
    }
}
