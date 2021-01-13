package entities;

public class Ratings {
    private int user_id, item_id, rating, timestamp;

    public Ratings(int user_id, int item_id, int rating, int timestamp) {
        this.user_id = user_id;
        this.item_id = item_id;
        this.rating = rating;
        this.timestamp = timestamp;
    }

    // user ID
    public int getUser_id() { return user_id; }
    public void setUser_id(int user_id) { this.user_id = user_id; }

    // item ID
    public int getItem_id() { return item_id; }
    public void setItem_id(int item_id) { this.item_id = item_id; }

    // rating
    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    // timestamp
    public int getTimestamp() { return timestamp; }
    public void setTimestamp(int timestamp) { this.timestamp = timestamp; }
}
