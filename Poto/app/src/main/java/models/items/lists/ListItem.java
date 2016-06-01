package models.items.lists;

/**
 * Created by andrew on 5/30/16.
 */
public class ListItem {

    private String name;
    private String content;
    private int rating;
    private int numRatings;
    private int userRating;
    private int icon;
    // TODO list of reviews

    // The name
    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }

    // The content - usually a description
    public String getContent() { return this.content; }
    public void setContent(String content) { this.content = content; }

    // The rating - average rating from all users
    public int getRating() { return this.rating; }
    public void setRating(int rating) { this.rating = rating; }

    // The number of ratings
    public int getNumRatings() { return this.numRatings; }
    public void setNumRatings(int numRatings) { this.numRatings = numRatings; }

    // The user rating - the rating that the current user gave the item
    public int getUserRating() { return this.userRating; }
    public void setUserRating(int userRating) { this.userRating = userRating; }

    // TODO - ensure this is the correct type for icons
    public int getIcon() { return this.icon; }
    public void setIcon(int icon) { this.icon = icon; }
}
