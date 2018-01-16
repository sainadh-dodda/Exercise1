package de.hybris.platform.customerreview;

import de.hybris.platform.customerreview.dao.impl.Product;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.customerreview.model.CustomerReviewModel;

public interface ICustomCustomerReviewService {
	
	public Integer getNumberOfReviews(Integer ratingStart, Integer ratingEnd, Product item);
	
	public String createCustomCustomerReview(Double rating, String headline, String comment, UserModel user, ProductModel product);

}
