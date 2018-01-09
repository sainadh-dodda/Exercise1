package de.hybris.platform.customerreview.impl;

import de.hybris.platform.customerreview.ICustomCustomerReviewService;
import de.hybris.platform.customerreview.Product;
import de.hybris.platform.customerreview.dao.CustomerReviewDao;
import de.hybris.platform.customerreview.dao.ICustomCustomerReviewDao;
import de.hybris.platform.customerreview.dao.impl.CustomCustomerReviewDao;
import org.springframework.beans.factory.annotation.Required;

public class CustomCustomerReviewService implements ICustomCustomerReviewService {

	private CustomCustomerReviewDao customCustomerReviewDao;

	public CustomCustomerReviewDao getCustomerReviewDao() {
		return this.customCustomerReviewDao;
	}

	@Required
	public void setCustomerReviewDao(CustomCustomerReviewDao customCustomerReviewDao) {
		this.customCustomerReviewDao = customCustomerReviewDao;
	}

	@Override
	public Integer getNumberOfReviews(Integer ratingStart, Integer ratingEnd, Product item) {
		return getCustomerReviewDao().getNumberOfReviews(ratingStart, ratingEnd, item);
	}

}
