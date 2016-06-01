package models.items.lists;

/**
 * Created by andrew on 5/31/16.
 */
public class Festival extends ListItem {
    private long date;
    private String url;

    public long getDate() { return this.date; }
    public void setDate(long date) { this.date = date; }

    public String getUrl() { return this.url; }
    public void setUrl(String url) { this.url = url; }
}
