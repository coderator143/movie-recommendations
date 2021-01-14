package warm_up;

import data.Data_Collect;
import entities.Movies;
import entities.Ratings;

import java.util.*;

public class Most_Watched_Genre {
    public static void main(String[] args) throws Exception {
        Data_Collect ob = new Data_Collect();
        ArrayList<Ratings> ratingsArrayList= ob.getRatingsArrayList();
        ArrayList<Movies> moviesArrayList = ob.getMoviesArrayList();

        Map<Integer, Integer> m = new TreeMap<>(Collections.reverseOrder());
        Map<Integer, String> genre = new HashMap<>();

        genre.put(1, "unknown"); genre.put(2, "action"); genre.put(3, "adventure"); genre.put(4, "animation");
        genre.put(5, "children's"); genre.put(6, "comedy"); genre.put(7, "crime"); genre.put(8, "documentary");
        genre.put(9, "drama"); genre.put(10, "fantasy"); genre.put(11, "film-noir"); genre.put(12, "horror");
        genre.put(13, "musical"); genre.put(14, "mystery"); genre.put(15, "romance"); genre.put(16, "sci-fi");
        genre.put(17, "thriller"); genre.put(18, "war"); genre.put(19, "western");

        for(int x=1;x<=19;x++) {
            ArrayList<Integer> movieIDs = new ArrayList<>();
            int count = 0;
            for(Movies movie: moviesArrayList) {
                String g = genre.get(x);
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
            for(Integer id: movieIDs)
                for(Ratings ratings: ratingsArrayList) if(id == ratings.getItem_id()) count++;
            m.put(count, x);
        }

        Map.Entry<Integer, Integer> entry = m.entrySet().iterator().next();
        int most_count = entry.getKey();
        int genre_id = entry.getValue();

        String most_watched_genre = genre.get(genre_id);

        System.out.println("Most watched genre is "+ most_watched_genre +" and it has been rated "
                + most_count +" times");
    }
}
