package warm_up;

import data.Data_Collect;
import entities.Movies;
import entities.Ratings;

import java.util.*;

public class Top_Movie_Genre {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a genre");
        String g = sc.nextLine();

        Data_Collect ob = new Data_Collect();
        ArrayList<Ratings> ratingsArrayList= ob.getRatingsArrayList();
        ArrayList<Movies> moviesArrayList = ob.getMoviesArrayList();

        ArrayList<Integer> movieIDs = new ArrayList<>();

        for(Movies movie: moviesArrayList) {
            if(movie.getIsAction() == 1 && g.equalsIgnoreCase("Action"))
                movieIDs.add(movie.getMovie_id());
            else if(movie.getIsUnknown() == 1 && g.equalsIgnoreCase("unknown"))
                movieIDs.add(movie.getMovie_id());
            else if(movie.getIsAdventure() == 1 && g.equalsIgnoreCase("Adventure"))
                movieIDs.add(movie.getMovie_id());
            else if(movie.getIsAnimation() == 1 && g.equalsIgnoreCase("Animation"))
                movieIDs.add(movie.getMovie_id());
            else if(movie.getIsChildren() == 1 && g.equalsIgnoreCase("Children"))
                movieIDs.add(movie.getMovie_id());
            else if(movie.getIsComedy() == 1 && g.equalsIgnoreCase("Comedy"))
                movieIDs.add(movie.getMovie_id());
            else if(movie.getIsCrime() == 1 && g.equalsIgnoreCase("Crime"))
                movieIDs.add(movie.getMovie_id());
            else if(movie.getIsDocumentary() == 1 && g.equalsIgnoreCase("Documentary"))
                movieIDs.add(movie.getMovie_id());
            else if(movie.getIsDrama() == 1 && g.equalsIgnoreCase("Drama"))
                movieIDs.add(movie.getMovie_id());
            else if(movie.getIsFantasy() == 1 && g.equalsIgnoreCase("Fantasy"))
                movieIDs.add(movie.getMovie_id());
            else if(movie.getIsFilmNoir() == 1 && g.equalsIgnoreCase("Film-Noir"))
                movieIDs.add(movie.getMovie_id());
            else if(movie.getIsHorror() == 1 && g.equalsIgnoreCase("Horror"))
                movieIDs.add(movie.getMovie_id());
            else if(movie.getIsMusical() == 1 && g.equalsIgnoreCase("Musical"))
                movieIDs.add(movie.getMovie_id());
            else if(movie.getIsMystery() == 1 && g.equalsIgnoreCase("Mystery"))
                movieIDs.add(movie.getMovie_id());
            else if(movie.getIsRomance() == 1 && g.equalsIgnoreCase("Romance"))
                movieIDs.add(movie.getMovie_id());
            else if(movie.getIsSci() == 1 && g.equalsIgnoreCase("Sci-Fi"))
                movieIDs.add(movie.getMovie_id());
            else if(movie.getIsThriller() == 1 && g.equalsIgnoreCase("Thriller"))
                movieIDs.add(movie.getMovie_id());
            else if(movie.getIsWar() == 1 && g.equalsIgnoreCase("War"))
                movieIDs.add(movie.getMovie_id());
            else if(movie.getIsWestern() == 1 && g.equalsIgnoreCase("Western"))
                movieIDs.add(movie.getMovie_id());
        }

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
            System.out.println("No such movie with genre "+g+" exists");
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

        System.out.println("The top movie of genre "+ g +" is "+ movie_name +"with an average rating of "
                + best_rating);
    }
}
