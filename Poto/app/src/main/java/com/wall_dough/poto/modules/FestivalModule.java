package com.wall_dough.poto.modules;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.wall_dough.poto.models.items.lists.Festival;

/**
 * Created by andrew on 5/31/16.
 */
public class FestivalModule extends ListItemModule {

    public static void sortByDate(ArrayList<Festival> list, boolean ascending) {
        if (ascending) Collections.sort(list, DateComparatorAscending);
        else Collections.sort(list, DateComparatorDescending);
    }

    private static Comparator<Festival> DateComparatorAscending = new Comparator<Festival>() {
        @Override
        public int compare(Festival lhs, Festival rhs) {
            Long leftDate = lhs.getDate();
            Long rightDate = rhs.getDate();
            return leftDate.compareTo(rightDate);
        }
    };

    private static Comparator<Festival> DateComparatorDescending = new Comparator<Festival>() {
        @Override
        public int compare(Festival lhs, Festival rhs) {
            Long leftDate = lhs.getDate();
            Long rightDate = rhs.getDate();
            return rightDate.compareTo(leftDate);
        }
    };
}
