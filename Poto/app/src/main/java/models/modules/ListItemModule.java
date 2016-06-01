package models.modules;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import models.items.lists.ListItem;

/**
 * Created by andrew on 5/30/16.
 */
public class ListItemModule {

    /**
     * Functions to sort lists by various properties
     * @param list
     * @param ascending
     */
    public static void sortByName(ArrayList<ListItem> list, boolean ascending) {
        if (ascending) Collections.sort(list, NameComparatorAscending);
        else Collections.sort(list, NameComparatorDescending);
    }

    public static void sortByRating(ArrayList<ListItem> list, boolean ascending) {
        if (ascending) Collections.sort(list, RatingComparatorAscending);
        else Collections.sort(list, RatingComparatorDescending);
    }

    public static void sortByUserRating(ArrayList<ListItem> list, boolean ascending) {
        if (ascending) Collections.sort(list, UserRatingComparatorAscending);
        else Collections.sort(list, UserRatingComparatorDescending);
    }

    /** Comparators
     *      for sorting the items by various properties
     */
    private static Comparator<ListItem> NameComparatorAscending = new Comparator<ListItem>() {
        @Override
        public int compare(ListItem lhs, ListItem rhs) {
            String leftName = lhs.getName();
            String rightName = rhs.getName();
            return leftName.compareTo(rightName);
        }
    };

    private static Comparator<ListItem> NameComparatorDescending = new Comparator<ListItem>() {
        @Override
        public int compare(ListItem lhs, ListItem rhs) {
            String leftName = lhs.getName();
            String rightName = rhs.getName();
            return rightName.compareTo(leftName);
        }
    };

    private static Comparator<ListItem> RatingComparatorAscending = new Comparator<ListItem>() {
        @Override
        public int compare(ListItem lhs, ListItem rhs) {
            int leftRating = lhs.getRating();
            int rightRating = rhs.getRating();
            return leftRating - rightRating;
        }
    };

    private static Comparator<ListItem> RatingComparatorDescending = new Comparator<ListItem>() {
        @Override
        public int compare(ListItem lhs, ListItem rhs) {
            int leftRating = lhs.getRating();
            int rightRating = rhs.getRating();
            return rightRating - leftRating;
        }
    };

    private static Comparator<ListItem> UserRatingComparatorAscending = new Comparator<ListItem>() {
        @Override
        public int compare(ListItem lhs, ListItem rhs) {
            int leftUserRating = lhs.getUserRating();
            int rightUserRating = rhs.getUserRating();
            return leftUserRating - rightUserRating;
        }
    };

    private static Comparator<ListItem> UserRatingComparatorDescending = new Comparator<ListItem>() {
        @Override
        public int compare(ListItem lhs, ListItem rhs) {
            int leftUserRating = lhs.getRating();
            int rightUserRating = rhs.getRating();
            return rightUserRating - leftUserRating;
        }
    };
}
