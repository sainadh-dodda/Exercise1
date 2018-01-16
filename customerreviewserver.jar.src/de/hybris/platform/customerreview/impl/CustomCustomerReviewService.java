package de.hybris.platform.customerreview.impl;

import de.hybris.platform.customerreview.CustomerReviewModel;
import de.hybris.platform.customerreview.ICustomCustomerReviewService;
import de.hybris.platform.customerreview.Product;
import de.hybris.platform.customerreview.ProductModel;
import de.hybris.platform.customerreview.ProfanityHandler;
import de.hybris.platform.customerreview.UserModel;
import de.hybris.platform.customerreview.dao.CustomerReviewDao;
import de.hybris.platform.customerreview.dao.ICustomCustomerReviewDao;
import de.hybris.platform.customerreview.dao.impl.CustomCustomerReviewDao;
import de.hybris.platform.customerreview.jalo.JaloBusinessException;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;

public class CustomCustomerReviewService extends DefaultCustomerReviewService implements ICustomCustomerReviewService {

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

	@Override
	public String createCustomCustomerReview(Double rating, String headline, String comment, UserModel user,
			ProductModel product) {
		if (comment != null && comment == "") {
			if (ProfanityHandler.isLanguageFoul(comment)) {
				throw new JaloBusinessException("Comment is having curse/profanity words. Please retext it.", 0);
			}
		}

		if (rating < 0) {
			throw new JaloBusinessException("Rating is less than zero. Please provide a valid rating.", 0);
		}

		super.createCustomerReview(rating, headline, comment, user, product);
		return "Successfully created the customer review";
	}

	@Override
	public CustomerReviewModel createCustomerReview(Double paramDouble, String paramString1, String paramString2,
			UserModel paramUserModel, ProductModel paramProductModel) {
		// TODO Auto-generated method stub
		return null;
	}

}
