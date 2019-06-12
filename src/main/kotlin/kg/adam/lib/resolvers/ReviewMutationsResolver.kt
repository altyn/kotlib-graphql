package kg.adam.lib.resolvers

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import kg.adam.lib.entity.Review
import kg.adam.lib.repository.ReviewRepository
import org.springframework.stereotype.Component

@Component
class ReviewMutationsResolver (private val reviewRepository: ReviewRepository) : GraphQLMutationResolver {
    fun newReview(snackId: String, rating: Int, text: String): Review {
        val review = Review(snackId, rating, text)
        reviewRepository.save(review)
        return review
    }
}