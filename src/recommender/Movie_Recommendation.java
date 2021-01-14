package recommender;

import data.Data_Collect;
import entities.Movies;
import entities.Ratings;
import java.util.*;

public class Movie_Recommendation {
    public static String most_watched_genre(HashMap<String, Integer> genre) {
        String g= "";
        int most = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> entry : genre.entrySet()) {
            if (entry.getValue() > most) {
                most = entry.getValue();
                g = entry.getKey();
            }
        }
        return g;
    }

    public static ArrayList<Integer> createUnseenArrayList(ArrayList<Movies> moviesArrayList,
                                                    HashSet<Integer> moviesSeen, String g) {
        ArrayList<Integer> movieIDs = new ArrayList<>();
        for(Movies movie: moviesArrayList) {
            if(!moviesSeen.contains(movie.getMovie_id())) {
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
        }
        return movieIDs;
    }

    public static Map<Double, Integer> get_average_rating(ArrayList<Integer> movieIDs,
                                                          ArrayList<Ratings> ratingsArrayList) {
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
            int scale = (int) Math.pow(10, 1);
            avg_rating = (double) Math.round(avg_rating * scale) / scale;
            m.put(avg_rating, id);
        }
        return m;
    }

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a user ID");
        int user_id = sc.nextInt();

        Data_Collect ob = new Data_Collect();
        ArrayList<Ratings> ratingsArrayList= ob.getRatingsArrayList();
        ArrayList<Movies> moviesArrayList = ob.getMoviesArrayList();

        // Step 1
        HashSet<Integer> moviesSeen = new HashSet<>();
        for(Ratings ratings: ratingsArrayList)
            if (user_id == ratings.getUser_id()) moviesSeen.add(ratings.getItem_id());

//        Map<Double, Integer> m2 = new TreeMap<>(Collections.reverseOrder());
//        for(Integer id: moviesSeen) {
//            int count = 0, sum_ratings = 0;
//            for(Ratings ratings: ratingsArrayList) {
//                if(id == ratings.getItem_id()) {
//                    sum_ratings += ratings.getRating();
//                    count++;
//                }
//            }
//            double avg_rating = sum_ratings/(double)count;
//            int scale = (int) Math.pow(10, 1);
//            avg_rating = (double) Math.round(avg_rating * scale) / scale;
//            m2.put(avg_rating, id);
//        }
//
//        System.out.println("Top 5 movies watched:");
//        Iterator<Map.Entry<Double, Integer>> itr = m2.entrySet().iterator();
//        int y = 0;
//        while(itr.hasNext() && y < 5) {
//            Map.Entry<Double, Integer> entry = itr.next();
//            int movieID = entry.getValue();
//            String s = "";
//            for(Movies movies: moviesArrayList) {
//                if(movies.getMovie_id() == movieID) {
//                    s += movies.getMovie_title();
//                    break;
//                }
//            }
//            s += "("+entry.getKey()+")";
//            System.out.println(s);
//            y++;
//        }
//        System.out.println();

        // Step 2
        HashMap<String, Integer> genre = new HashMap<>();

        genre.put("unknown", 0); genre.put("action", 0); genre.put("adventure", 0); genre.put("animation", 0);
        genre.put("children", 0); genre.put("comedy", 0); genre.put("crime", 0); genre.put("documentary", 0);
        genre.put("drama", 0); genre.put("fantasy", 0); genre.put("film-noir", 0); genre.put("horror", 0);
        genre.put("musical", 0); genre.put("mystery", 0); genre.put("romance", 0); genre.put("sci-fi", 0);
        genre.put("thriller", 0); genre.put("war", 0); genre.put("western", 0);

        for(Integer movieIDs: moviesSeen) {
            for(Movies movie: moviesArrayList) {
                if(movie.getMovie_id() == movieIDs) {
                    if(movie.getIsAction() == 1) genre.put("action", genre.get("action") + 1);
                    if(movie.getIsUnknown() == 1) genre.put("unknown", genre.get("unknown") + 1);
                    if(movie.getIsAdventure() == 1) genre.put("adventure", genre.get("adventure") + 1);
                    if(movie.getIsAnimation() == 1) genre.put("animation", genre.get("animation") + 1);
                    if(movie.getIsChildren() == 1) genre.put("children", genre.get("children") + 1);
                    if(movie.getIsComedy() == 1) genre.put("comedy", genre.get("comedy") + 1);
                    if(movie.getIsCrime() == 1) genre.put("crime", genre.get("crime") + 1);
                    if(movie.getIsDocumentary() == 1) genre.put("documentary", genre.get("documentary") + 1);
                    if(movie.getIsDrama() == 1) genre.put("drama", genre.get("drama") + 1);
                    if(movie.getIsFantasy() == 1) genre.put("fantasy", genre.get("fantasy") + 1);
                    if(movie.getIsFilmNoir() == 1) genre.put("film-noir", genre.get("film-noir") + 1);
                    if(movie.getIsHorror() == 1) genre.put("horror", genre.get("horror") + 1);
                    if(movie.getIsMusical() == 1) genre.put("musical", genre.get("musical") + 1);
                    if(movie.getIsMystery() == 1) genre.put("mystery", genre.get("mystery") + 1);
                    if(movie.getIsRomance() == 1) genre.put("romance", genre.get("romance") + 1);
                    if(movie.getIsSci() == 1) genre.put("sci-fi", genre.get("action") + 1);
                    if(movie.getIsThriller() == 1) genre.put("thriller", genre.get("thriller") + 1);
                    if(movie.getIsWar() == 1) genre.put("war", genre.get("war") + 1);
                    if(movie.getIsWestern() == 1) genre.put("western", genre.get("western") + 1);
                }
            }
        }

        String genre_one = most_watched_genre(genre);
        genre.put(genre_one, 0);
        String genre_two = most_watched_genre(genre);

        // Step 3
        ArrayList<Integer> movie_id_genre1 = createUnseenArrayList(moviesArrayList, moviesSeen, genre_one);
        ArrayList<Integer> movie_id_genre2 = createUnseenArrayList(moviesArrayList, moviesSeen, genre_two);

        // Step 4
        Map<Double, Integer> m = get_average_rating(movie_id_genre1, ratingsArrayList);

        ArrayList<String> recommendations = new ArrayList<>();

        Iterator<Map.Entry<Double, Integer>> i = m.entrySet().iterator();
        int x = 0;
        while(i.hasNext() && x < 3) {
            Map.Entry<Double, Integer> entry = i.next();
            int movieID = entry.getValue();
            String s = "";
            for(Movies movies: moviesArrayList) {
                if(movies.getMovie_id() == movieID) {
                    s += movies.getMovie_title();
                    break;
                }
            }
            s += "("+entry.getKey()+")";
            recommendations.add(s);
            x++;
        }

        Map<Double, Integer> m1 = get_average_rating(movie_id_genre2, ratingsArrayList);
        i = m1.entrySet().iterator();
        x = 0;
        while(i.hasNext() && x < 2) {
            Map.Entry<Double, Integer> entry = i.next();
            int movieID = entry.getValue();
            String s = "";
            for(Movies movies: moviesArrayList) {
                if(movies.getMovie_id() == movieID) {
                    s += movies.getMovie_title();
                    break;
                }
            }
            s += "("+entry.getKey()+")";
            recommendations.add(s);
            x++;
        }

        System.out.println("Movie recommendations for user are :");
        for(String s: recommendations) System.out.println(s);
    }
}