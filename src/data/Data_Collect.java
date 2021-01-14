package data;

import entities.Movies;
import entities.Ratings;
import entities.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Data_Collect {

    private static ArrayList<Ratings> ratingsArrayList = new ArrayList<>();
    private static ArrayList<User> userArrayList = new ArrayList<>();
    private static ArrayList<Movies> moviesArrayList = new ArrayList<>();
    public ArrayList<Ratings> getRatingsArrayList() {
        try {
            File ratings_file = new File("C:\\Users\\Shantanu\\IdeaProjects\\Movie_Recommendation\\" +
                    "src\\" + "data_files\\ratings.data");
            Scanner myReader = new Scanner(ratings_file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                var ar = data.split("\\s+");
                Ratings ratings = new Ratings(Integer.parseInt(ar[0]), Integer.parseInt(ar[1]),
                        Integer.parseInt(ar[2]), Integer.parseInt(ar[3]));
                ratingsArrayList.add(ratings);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return ratingsArrayList;
    }

    public ArrayList<User> getUserArrayList() {
        try {
            File user_file = new File("C:\\Users\\Shantanu\\IdeaProjects\\Movie_Recommendation\\src\\" +
                    "data_files\\user.data");
            Scanner myReader = new Scanner(user_file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                String[] ar;
                ar = data.split("[|]");
                User user = new User(Integer.parseInt(ar[0]), Integer.parseInt(ar[1]), ar[2], ar[3], ar[4]);
                userArrayList.add(user);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return userArrayList;
    }

    public ArrayList<Movies> getMoviesArrayList() throws Exception {
        FileReader fr = new FileReader("C:\\Users\\Shantanu\\IdeaProjects\\Movie_Recommendation\\" +
                "src\\" + "data_files\\movie.data");
        BufferedReader br = new BufferedReader(fr);
        String data;
        while ((data=br.readLine()) != null) {
            StringBuilder data1 = new StringBuilder();
            for(int x=0;x<data.length();x++) {
                if(data.charAt(x) == '|' && data.charAt(x+1) == '|') continue;
                data1.append(data.charAt(x));
            }
            data = data1.toString();
            data1 = new StringBuilder();
            for(int x=0;x<data.length()-1;x++) {
                char ch = data.charAt(x), ch1 = data.charAt(x+1);
                if(ch == '(' && Character.isDigit(ch1)) data1.append("|");
                else if(ch == ')' && ch1 == '|') {
                }
                else data1.append(ch);
            }
            data1.append(data.charAt(data.length() - 1));
            data = data1.toString();
            String[] ar = data.split("[|]");
            //System.out.println(ar.length);
            try {
                Movies movie = new Movies(Integer.parseInt(ar[0]), ar[1], Integer.parseInt(ar[2]), ar[3],
                        ar[4], Integer.parseInt(ar[6]), Integer.parseInt(ar[7]), Integer.parseInt(ar[8]),
                        Integer.parseInt(ar[9]), Integer.parseInt(ar[10]), Integer.parseInt(ar[11]),
                        Integer.parseInt(ar[12]), Integer.parseInt(ar[13]), Integer.parseInt(ar[14]),
                        Integer.parseInt(ar[15]), Integer.parseInt(ar[16]), Integer.parseInt(ar[17]),
                        Integer.parseInt(ar[18]), Integer.parseInt(ar[19]), Integer.parseInt(ar[20]),
                        Integer.parseInt(ar[21]), Integer.parseInt(ar[22]), Integer.parseInt(ar[23]),
                        Integer.parseInt(ar[24]));
                moviesArrayList.add(movie);
            }
            catch (Exception e) { /*System.out.println("Trash row");*/ }
        }
        br.close();
        fr.close();
        return moviesArrayList;
    }
}
