package de.hybris.platform.customerreview.dao;

import de.hybris.platform.customerreview.jalo.Product;

public interface ICustomCustomerReviewDao {

	public Integer getNumberOfReviews(Integer ratingStart, Integer ratingEnd, Product item);

}
