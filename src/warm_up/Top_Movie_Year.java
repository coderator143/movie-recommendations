package warm_up;

import data.Data_Collect;
import entities.Movies;
import entities.Ratings;

import java.util.*;

public class Top_Movie_Year {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an year");
        int y = sc.nextInt();

        Data_Collect ob = new Data_Collect();
        ArrayList<Ratings> ratingsArrayList= ob.getRatingsArrayList();
        ArrayList<Movies> moviesArrayList = ob.getMoviesArrayList();

        ArrayList<Integer> movieIDs = new ArrayList<>();

        for(Movies movie: moviesArrayList) if(y == movie.getRelease_date()) movieIDs.add(movie.getMovie_id());

        Map<Double, Integer> m = new TreeMap<>(Collections.reverseOrder());

        for(Integer id: movieIDs) {
            int count = 0, sum_ratings = 0;
            for(Ratings ratings: ratingsArrayList) {
                if(id == ratings.getItem_id()) {
                    sum_ratings += ratings.getRating();
                    count++;
                }
            }
            double avg_rating = sum_ratings/(double)count;
            m.put(avg_rating, id);
        }

        if(m.isEmpty()) {
            System.out.println("No such movie with release year "+y+" exists");
            return;
        }

        Map.Entry<Double, Integer> entry = m.entrySet().iterator().next();
        double best_rating = entry.getKey();
        int movie_id = entry.getValue();

        int scale = (int) Math.pow(10, 1);
        best_rating = (double) Math.round(best_rating * scale) / scale;

        String movie_name = "";
        for(Movies movie: moviesArrayList) {
            if(movie.getMovie_id() == movie_id) {
                movie_name = movie.getMovie_title();
                break;
            }
        }

        System.out.println("The top movie of year "+ y +" is "+ movie_name +"with an average rating of "
                + best_rating);
    }
}
