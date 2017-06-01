package task4;

import java.io.Serializable;
import java.net.URISyntaxException;
import java.util.*;
import java.io.*;

public class Task4 {

    public static void main(String[] args) throws URISyntaxException{

        String file = "task4Collection.ser";

        CollectionOfMovies collectionOfMovies = (CollectionOfMovies)deserialize(file);
        choice(file, collectionOfMovies);

    }
    static void choice(String file, CollectionOfMovies collectionOfMovies){
        boolean exit = false;
        while (!exit) {

            Scanner in = new Scanner(System.in);
            System.out.println("Your choice? : 1.) View collection 2.) Add 3.) Remove 4.) Save 5.) Exit ===>");
            String inChoice = in.next();
            switch (inChoice) {
                case "1": {
                    collectionOfMovies.view();
                    break;
                }
                case "2": {
                    System.out.println("Enter the movie===>");
                    String movieName = in.next();
                    System.out.println("Enter number of actors ===>");
                    int n = in.nextInt();
                    System.out.println("Enter actors ===>");
                    String[] actors = new String[n];
                    for (int i = 0; i < n; i++) {
                        actors[i] = in.next();
                    }
                    Movie movie = new Movie(movieName, actors);
                    collectionOfMovies.add(movie);
                    System.out.println("==========Movie was added successfully=========");
                    collectionOfMovies.view();
                    break;
                }
                case "3": {
                    System.out.println("Enter the movie===>");
                    String movieName = in.next();
                    collectionOfMovies.remove(movieName);
                    System.out.println("==========Movie was removed successfully=========");
                    collectionOfMovies.view();
                    break;
                }
                case "4": {
                    serialize(file, collectionOfMovies);
                    System.out.println("==========Collection was saved successfully=========");
                    break;
                }
                case "5": {
                    exit = true;
                    System.out.println("=============By-by==============");
                    ;
                    break;
                }
                default: {
                    System.out.println("=======No such operation=========");
                }
            }
        }
    }
    static void serialize(String file, Object object){
        try (FileOutputStream   fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(object);
        } catch (IOException e) {

        }
    }
    static Object deserialize(String file){
        Object object = null;
        try (FileInputStream   fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)){

          object = ois.readObject();

        } catch (IOException  e) {

        }
        catch (ClassNotFoundException e2) {

        }
        return object;
    }
}
class Movie implements Serializable{
  //  private static final long serialVersionUID = 1L;
    String movie;
    String[] actorsOfMovie;
    public Movie(String movie, String[] actorsOfMovie) {
        this.movie = movie;
        this.actorsOfMovie = actorsOfMovie;
    }
}
class CollectionOfMovies implements Serializable {

  //  private static final long serialVersionUID = 1L;

    Map<String, String[]> map;

    public CollectionOfMovies(int numOfMovies, Movie...m) {
        this.map = new HashMap<>();
        for (int i = 0; i < numOfMovies; i++) {
            map.put(m[i].movie,m[i].actorsOfMovie);
        }
    }
    void view() {

        for (Map.Entry<String,String[]> entry:map.entrySet()) {
            System.out.println(entry.getKey()+"   "+Arrays.toString(entry.getValue()));
        }
        System.out.println("=================================");
    }
    void add(Movie newMovie){
        map.put(newMovie.movie,newMovie.actorsOfMovie);
    }
    void remove(String movie){
        map.remove(movie);
    }

}
