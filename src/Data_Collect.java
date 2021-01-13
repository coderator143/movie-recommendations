import entities.Movies;
import entities.Ratings;
import entities.User;
import utilities.Constants;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Data_Collect {
    public static void main(String args[]) {
        try {
            File genre_file = new File("C:\\Users\\Shantanu\\IdeaProjects\\Movie_Recommendation\\src\\" +
                    "data_files\\genre.data");
            File movie_file = new File("C:\\Users\\Shantanu\\IdeaProjects\\Movie_Recommendation\\src\\" +
                    "data_files\\movie.data");
            File user_file = new File("C:\\Users\\Shantanu\\IdeaProjects\\Movie_Recommendation\\src\\" +
                    "data_files\\user.data");
            File ratings_file = new File("C:\\Users\\Shantanu\\IdeaProjects\\Movie_Recommendation\\src\\" +
                    "data_files\\ratings.data");

            // storing contents into ratings array list from ratings file
            Scanner myReader = new Scanner(ratings_file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String ar[] = data.split("\\s+");
                Ratings ratings = new Ratings(Integer.parseInt(ar[0]), Integer.parseInt(ar[1]),
                        Integer.parseInt(ar[2]), Integer.parseInt(ar[3]));
                Constants.ratingsArrayList.add(ratings);
            }

            // storing contents into user array list from user file
            myReader = new Scanner(user_file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                String ar[] = data.split("[|]");
                User user = new User(Integer.parseInt(ar[0]), Integer.parseInt(ar[1]), ar[2], ar[3], ar[4]);
                Constants.userArrayList.add(user);
            }

            // storing contents into user array list from user file
            myReader = new Scanner(movie_file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                String ar[] = data.split("[|]");
                Movies movie = new Movies(Integer.parseInt(ar[0]), ar[1], ar[2], ar[3], ar[4],
                        Integer.parseInt(ar[5]), Integer.parseInt(ar[6]), Integer.parseInt(ar[7]),
                        Integer.parseInt(ar[8]), Integer.parseInt(ar[9]), Integer.parseInt(ar[10]),
                        Integer.parseInt(ar[11]), Integer.parseInt(ar[12]), Integer.parseInt(ar[13]),
                        Integer.parseInt(ar[14]), Integer.parseInt(ar[15]), Integer.parseInt(ar[16]),
                        Integer.parseInt(ar[17]), Integer.parseInt(ar[18]), Integer.parseInt(ar[19]),
                        Integer.parseInt(ar[20]), Integer.parseInt(ar[21]), Integer.parseInt(ar[22]),
                        Integer.parseInt(ar[23]));
                Constants.moviesArrayList.add(movie);
            }

//            for(User user: Constants.userArrayList) {
//                System.out.println(user.getUser_ID()+"|"+user.getAge()+"|"+user.getGender()+"|"+
//                        user.getOccupation()+"|"+user.getZip_code());
//            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
