package de.hybris.platform.customerreview;

import de.hybris.platform.customerreview.dao.impl.Product;

public interface ICustomCustomerReviewService {
	
	public Integer getNumberOfReviews(Integer ratingStart, Integer ratingEnd, Product item);

}
