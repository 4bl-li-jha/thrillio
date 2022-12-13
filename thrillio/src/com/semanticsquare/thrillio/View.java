package com.semanticsquare.thrillio;

import com.semanticsquare.thrillio.constants.KidFriendlyStatus;
import com.semanticsquare.thrillio.constants.UserType;
import com.semanticsquare.thrillio.entities.Bookmark;
import com.semanticsquare.thrillio.entities.User;
import com.sematicsquare.thrillio.controllers.BookmarkController;

public class View {
	public static void browse(User user, Bookmark[][] bookmarks) {
		System.out.println("\n"+user.getEmail()+" is browsing items...");
		int bookmarkCount=0;
		
		for(Bookmark[] bookmarkList: bookmarks) {
			for(Bookmark bookmark: bookmarkList) {
				// Bookmarking!!
				if(bookmarkCount< DataStore.USER_BOOKMARK_LIMIT) {
					boolean isBookmarked= getBookmarkDecision(bookmark);
					if(isBookmarked) {
						bookmarkCount++;
						BookmarkController.getInstance().saveUserBookmark(user, bookmark);
						System.out.println("New Item Bookmarked -- "+bookmark);
					}
				}
				// Mark as kid-friendly
				if(user.getUserType().equals(UserType.EDITOR)||user.getUserType().equals(UserType.CHIEF_EDITOR)) {
					if(bookmark.isKidFriendlyEligible()&& bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.UNKNOWN)) {
						String kidFriendlyStatus= getKidFriendlyStatusDescision(bookmark);
						if(!kidFriendlyStatus.equals(KidFriendlyStatus.UNKNOWN)) {
							bookmark.setKidFriendlyStatus(kidFriendlyStatus);
							System.out.println("Kid-friendly status "+ kidFriendlyStatus+ ", "+bookmark);
						}
					}
						
				}
			}
		}
		
	}
	private static String getKidFriendlyStatusDescision(Bookmark bookmark) {
		
		return Math.random()<0.4?KidFriendlyStatus.APPROVED:(Math.random()>=0.4&&Math.random()<0.8)?KidFriendlyStatus.REJECTED:KidFriendlyStatus.UNKNOWN;
		
	}
	/*public static void bookmark(User user, Bookmark[][] bookmarks) {
		System.out.println("\n"+user.getEmail()+" is bookmarking");
		for(int i=0; i<DataStore.USER_BOOKMARK_LIMIT; i++) {
		int typeOffSet=(int)(Math.random()*DataStore.BOOKMARK_TYPES_COUNT);
		int bookmarkOffSet=(int)(Math.random()*DataStore.BOOKMARK_COUNT_PER_TYPE);
		
		Bookmark bookmark=bookmarks[typeOffSet][bookmarkOffSet];
		BookmarkController.getInstance().saveUserBookmark(user, bookmark);
		
		System.out.println(bookmark);
		}
	}*/

	private static boolean getBookmarkDecision(Bookmark bookmark) {
		return Math.random()< 0.5? true: false;
		
	}
}
