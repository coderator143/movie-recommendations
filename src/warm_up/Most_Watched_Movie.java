package warm_up;

import data.Data_Collect;
import entities.Movies;
import entities.Ratings;

import java.util.*;

public class Most_Watched_Movie {
    public static void main(String[] args) throws Exception {
        Data_Collect ob = new Data_Collect();
        ArrayList<Ratings> ratingsArrayList= ob.getRatingsArrayList();
        ArrayList<Movies> moviesArrayList = ob.getMoviesArrayList();

        ArrayList<Integer> movieIDs = new ArrayList<>();

        for(Movies movie: moviesArrayList) movieIDs.add(movie.getMovie_id());

        Map<Integer, Integer> m = new TreeMap<>(Collections.reverseOrder());

        for(Integer id: movieIDs) {
            int count = 0;
            for(Ratings ratings: ratingsArrayList) {
                if(id == ratings.getItem_id()) count++;
            }
            m.put(count, id);
        }

        Map.Entry<Integer, Integer> entry = m.entrySet().iterator().next();
        int most_count = entry.getKey();
        int movie_id = entry.getValue();

        String movie_name = "";
        for(Movies movie: moviesArrayList) {
            if(movie.getMovie_id() == movie_id) {
                movie_name = movie.getMovie_title();
                break;
            }
        }

        System.out.println("Most watched movie is "+ movie_name +"and it has been rated "+ most_count +" times");
    }
}
