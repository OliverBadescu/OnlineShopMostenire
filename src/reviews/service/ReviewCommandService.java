package reviews.service;

import reviews.model.Review;

public interface ReviewCommandService {

    void saveData();

    void adaugareReview(Review review);

    void stergeReview(Review review);
}
