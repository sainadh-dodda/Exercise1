package de.hybris.platform.customerreview;

import java.util.List;
import org.springframework.beans.factory.annotation.Value;

public class ProfanityHandler {
	
	private static List<String> PROFANITYLIST;
	
	@Value("#{'${profanityWords}'.split(',')}")
	public void setProfanityList(List<String> profanityList) {
		PROFANITYLIST = profanityList;
	}
	
	public static boolean isLanguageFoul(String chatText) {
        String[] chatTextAsArray = chatText.split(" ");
        for(String element : chatTextAsArray) {
            if(PROFANITYLIST.contains(element)) {
                return true;
            }
        }
        return false;
    }

}
