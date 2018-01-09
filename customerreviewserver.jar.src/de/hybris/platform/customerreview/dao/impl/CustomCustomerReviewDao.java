package de.hybris.platform.customerreview.dao.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.hybris.platform.customerreview.dao.ICustomCustomerReviewDao;
import de.hybris.platform.customerreview.jalo.Product;
import de.hybris.platform.jalo.flexiblesearch.FlexibleSearch;
import de.hybris.platform.customerreview.constants.GeneratedCustomerReviewConstants;

public class CustomCustomerReviewDao implements ICustomCustomerReviewDao {

	@Override
	public Integer getNumberOfReviews(Integer ratingStart, Integer ratingEnd, Product item) {
		String query = "SELECT count(*) FROM {" + GeneratedCustomerReviewConstants.TC.CUSTOMERREVIEW + "} WHERE {"
				+ "product" + "} = ?product AND {" + "rating" + "} >= ratingStart AND {" + "rating" + "} <= ratingEnd";
		Map<String, Object> values = new HashMap<String, Object>();
		values.put("product", item);
		values.put("ratingStart", ratingStart);
		values.put("ratingEnd", ratingEnd);
		List<Integer> result = FlexibleSearch.getInstance()
				.search(query, values, Collections.singletonList(Integer.class), true, true, 0, -1).getResult();
		return (Integer) result.iterator().next();
	}

}
