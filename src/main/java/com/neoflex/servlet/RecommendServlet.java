package com.neoflex.servlet;

import com.neoflex.model.Movie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

@WebServlet("/recommend")
public class RecommendServlet extends HttpServlet {

    private static final Map<String, List<Movie>> movieRecommendations = new HashMap<>();

    @Override
    public void init() throws ServletException {
        movieRecommendations.put("Action", Arrays.asList(
                new Movie("Mad Max: Fury Road", "Action", 8.1, "https://m.media-amazon.com/images/I/81h+zUUGd0L._AC_SY679_.jpg"),
                new Movie("John Wick", "Action", 7.4, "https://m.media-amazon.com/images/I/71oyWdX7fOL._AC_SY679_.jpg"),
                new Movie("Gladiator", "Action", 8.5, "https://m.media-amazon.com/images/I/71DwGCa3olL._AC_SY679_.jpg"),
                new Movie("The Dark Knight", "Action", 9.0, "https://m.media-amazon.com/images/I/51EbJjlTdzL.jpg"),
                new Movie("Avengers: Endgame", "Action", 8.4, "https://m.media-amazon.com/images/I/71niXI3lxlL._AC_SY679_.jpg"),
                new Movie("Inception", "Action", 8.8, "https://m.media-amazon.com/images/I/51oD-1XQBLL.jpg")
        ));

        movieRecommendations.put("Comedy", Arrays.asList(
                new Movie("The Grand Budapest Hotel", "Comedy", 8.1, "https://m.media-amazon.com/images/I/71CwQ-WXsnL._AC_SY679_.jpg"),
                new Movie("Superbad", "Comedy", 7.6, "https://m.media-amazon.com/images/I/91qxFYYxWkL._AC_SY679_.jpg"),
                new Movie("The Hangover", "Comedy", 7.7, "https://m.media-amazon.com/images/I/81R1iUNYZ5L._AC_SY679_.jpg"),
                new Movie("Step Brothers", "Comedy", 6.9, "https://m.media-amazon.com/images/I/81dvoD4N9dL._AC_SY679_.jpg"),
                new Movie("Zombieland", "Comedy", 7.6, "https://m.media-amazon.com/images/I/81YQ0trssUL._AC_SY679_.jpg"),
                new Movie("21 Jump Street", "Comedy", 7.2, "https://m.media-amazon.com/images/I/71Oc-+BZpzL._AC_SY679_.jpg")
        ));

        movieRecommendations.put("Drama", Arrays.asList(
                new Movie("The Shawshank Redemption", "Drama", 9.3, "https://m.media-amazon.com/images/I/51NiGlapXlL.jpg"),
                new Movie("Forrest Gump", "Drama", 8.8, "https://m.media-amazon.com/images/I/61xMy2zjLFL.jpg"),
                new Movie("Fight Club", "Drama", 8.8, "https://m.media-amazon.com/images/I/51v5ZpFyaFL.jpg"),
                new Movie("The Pursuit of Happyness", "Drama", 8.0, "https://m.media-amazon.com/images/I/61rK7VcdCzL.jpg"),
                new Movie("Joker", "Drama", 8.4, "https://m.media-amazon.com/images/I/71wBVC6rYbL._AC_SY679_.jpg"),
                new Movie("A Beautiful Mind", "Drama", 8.2, "https://m.media-amazon.com/images/I/91EMuA4+5xL._AC_SY679_.jpg")
        ));

        movieRecommendations.put("Sci-Fi", Arrays.asList(
                new Movie("Interstellar", "Sci-Fi", 8.6, "https://m.media-amazon.com/images/I/71y9s+3bYaL._AC_SY679_.jpg"),
                new Movie("The Matrix", "Sci-Fi", 8.7, "https://m.media-amazon.com/images/I/51vpnbwFHrL.jpg"),
                new Movie("Inception", "Sci-Fi", 8.8, "https://m.media-amazon.com/images/I/51oD-1XQBLL.jpg"),
                new Movie("Blade Runner 2049", "Sci-Fi", 8.0, "https://m.media-amazon.com/images/I/81uAI28PIPL._AC_SY679_.jpg"),
                new Movie("Dune", "Sci-Fi", 8.0, "https://m.media-amazon.com/images/I/61x5zK7Fa7L._AC_SY679_.jpg"),
                new Movie("Ex Machina", "Sci-Fi", 7.7, "https://m.media-amazon.com/images/I/61-f4mTEpoL._AC_SY679_.jpg")
        ));

        movieRecommendations.put("Horror", Arrays.asList(
                new Movie("The Conjuring", "Horror", 7.5, "https://m.media-amazon.com/images/I/71WITt6UokL._AC_SY679_.jpg"),
                new Movie("A Quiet Place", "Horror", 7.5, "https://m.media-amazon.com/images/I/71PHbZqUXAL._AC_SY679_.jpg"),
                new Movie("Get Out", "Horror", 7.7, "https://m.media-amazon.com/images/I/71TTBgsYaJL._AC_SY679_.jpg"),
                new Movie("It", "Horror", 7.3, "https://m.media-amazon.com/images/I/81aG1NSFfdL._AC_SY679_.jpg"),
                new Movie("Hereditary", "Horror", 7.3, "https://m.media-amazon.com/images/I/71yEfwNRu8L._AC_SY679_.jpg"),
                new Movie("Insidious", "Horror", 6.8, "https://m.media-amazon.com/images/I/81miQzE1xgL._AC_SY679_.jpg")
        ));

        movieRecommendations.put("Romance", Arrays.asList(
                new Movie("The Notebook", "Romance", 7.8, "https://m.media-amazon.com/images/I/81tb2V7pF5L._AC_SY679_.jpg"),
                new Movie("Pride & Prejudice", "Romance", 7.8, "https://m.media-amazon.com/images/I/71InftFWSXL._AC_SY679_.jpg"),
                new Movie("La La Land", "Romance", 8.0, "https://m.media-amazon.com/images/I/91pR9wKJ3zL._AC_SY679_.jpg"),
                new Movie("Titanic", "Romance", 7.9, "https://m.media-amazon.com/images/I/71aqkOIEb7L._AC_SY679_.jpg"),
                new Movie("Me Before You", "Romance", 7.4, "https://m.media-amazon.com/images/I/81nnd1g9ZzL._AC_SY679_.jpg"),
                new Movie("A Walk to Remember", "Romance", 7.3, "https://m.media-amazon.com/images/I/81nzjdFMe3L._AC_SY679_.jpg")
        ));

        movieRecommendations.put("Thriller", Arrays.asList(
                new Movie("Se7en", "Thriller", 8.6, "https://m.media-amazon.com/images/I/51K8ouYrHeL.jpg"),
                new Movie("Gone Girl", "Thriller", 8.1, "https://m.media-amazon.com/images/I/71-Q8kTwBHL._AC_SY679_.jpg"),
                new Movie("Shutter Island", "Thriller", 8.2, "https://m.media-amazon.com/images/I/71T4Wl1KfxL._AC_SY679_.jpg"),
                new Movie("Prisoners", "Thriller", 8.1, "https://m.media-amazon.com/images/I/81BQJ8Ge7TL._AC_SY679_.jpg"),
                new Movie("The Girl with the Dragon Tattoo", "Thriller", 7.8, "https://m.media-amazon.com/images/I/91GE6eSxb-L._AC_SY679_.jpg"),
                new Movie("Split", "Thriller", 7.3, "https://m.media-amazon.com/images/I/81NSMOZyGbL._AC_SY679_.jpg")
        ));

        movieRecommendations.put("Animation", Arrays.asList(
                new Movie("Toy Story", "Animation", 8.3, "https://m.media-amazon.com/images/I/81vRKP2zCbL._AC_SY679_.jpg"),
                new Movie("Inside Out", "Animation", 8.1, "https://m.media-amazon.com/images/I/81Y0q7F+2JL._AC_SY679_.jpg"),
                new Movie("Coco", "Animation", 8.4, "https://m.media-amazon.com/images/I/91tFbdAOU8L._AC_SY679_.jpg"),
                new Movie("Finding Nemo", "Animation", 8.2, "https://m.media-amazon.com/images/I/81ylX9OmoDL._AC_SY679_.jpg"),
                new Movie("Zootopia", "Animation", 8.0, "https://m.media-amazon.com/images/I/71Elk5x0JFL._AC_SY679_.jpg"),
                new Movie("Frozen", "Animation", 7.4, "https://m.media-amazon.com/images/I/91Qp1sVRm9L._AC_SY679_.jpg")
        ));

        movieRecommendations.put("Fantasy", Arrays.asList(
                new Movie("Harry Potter and the Sorcerer's Stone", "Fantasy", 7.6, "https://m.media-amazon.com/images/I/81xkKceU+oL._AC_SY679_.jpg"),
                new Movie("The Lord of the Rings: Fellowship of the Ring", "Fantasy", 8.8, "https://m.media-amazon.com/images/I/51Qvs9i5a%2BL.jpg"),
                new Movie("Pan's Labyrinth", "Fantasy", 8.2, "https://m.media-amazon.com/images/I/81X1WzKuznL._AC_SY679_.jpg"),
                new Movie("The Chronicles of Narnia", "Fantasy", 6.9, "https://m.media-amazon.com/images/I/71vHs+3XcBL._AC_SY679_.jpg"),
                new Movie("Fantastic Beasts", "Fantasy", 7.2, "https://m.media-amazon.com/images/I/91PYQbCVYDL._AC_SY679_.jpg"),
                new Movie("Stardust", "Fantasy", 7.6, "https://m.media-amazon.com/images/I/61gNDMG1P5L._AC_SY679_.jpg")
        ));

        movieRecommendations.put("Mystery", Arrays.asList(
                new Movie("Knives Out", "Mystery", 7.9, "https://m.media-amazon.com/images/I/81bg+uVGW4L._AC_SY679_.jpg"),
                new Movie("Sherlock Holmes", "Mystery", 7.6, "https://m.media-amazon.com/images/I/91N0wZfJX+L._AC_SY679_.jpg"),
                new Movie("The Sixth Sense", "Mystery", 8.1, "https://m.media-amazon.com/images/I/91OPVbh2-lL._AC_SY679_.jpg"),
                new Movie("Zodiac", "Mystery", 7.7, "https://m.media-amazon.com/images/I/91ZqSzkFs7L._AC_SY679_.jpg"),
                new Movie("Gone Girl", "Mystery", 8.1, "https://m.media-amazon.com/images/I/71-Q8kTwBHL._AC_SY679_.jpg"),
                new Movie("The Prestige", "Mystery", 8.5, "https://m.media-amazon.com/images/I/51Hv0ry2G8L.jpg")
        ));

        movieRecommendations.put("Biography", Arrays.asList(
                new Movie("The Social Network", "Biography", 7.7, "https://m.media-amazon.com/images/I/71Ed8HNBJdL._AC_SY679_.jpg"),
                new Movie("Bohemian Rhapsody", "Biography", 7.9, "https://m.media-amazon.com/images/I/81sXcvTx8nL._AC_SY679_.jpg"),
                new Movie("The Theory of Everything", "Biography", 7.7, "https://m.media-amazon.com/images/I/91rk4xpVVmL._AC_SY679_.jpg"),
                new Movie("The Imitation Game", "Biography", 8.0, "https://m.media-amazon.com/images/I/81nWdVc0ytL._AC_SY679_.jpg"),
                new Movie("12 Years a Slave", "Biography", 8.1, "https://m.media-amazon.com/images/I/81NvH4bJxtL._AC_SY679_.jpg"),
                new Movie("Steve Jobs", "Biography", 7.2, "https://m.media-amazon.com/images/I/81KOehgDwGL._AC_SY679_.jpg")
        ));

        movieRecommendations.put("Adventure", Arrays.asList(
                new Movie("Indiana Jones: Raiders of the Lost Ark", "Adventure", 8.4, "https://m.media-amazon.com/images/I/81eDB2Wcw-L._AC_SY679_.jpg"),
                new Movie("The Lord of the Rings: The Two Towers", "Adventure", 8.8, "https://m.media-amazon.com/images/I/71kt3Bt3hBL._AC_SY679_.jpg"),
                new Movie("Jurassic Park", "Adventure", 8.2, "https://m.media-amazon.com/images/I/81GvV3R6VZL._AC_SY679_.jpg"),
                new Movie("Pirates of the Caribbean: The Curse of the Black Pearl", "Adventure", 8.0, "https://m.media-amazon.com/images/I/91LShNnt+wL._AC_SY679_.jpg"),
                new Movie("Avatar", "Adventure", 7.9, "https://m.media-amazon.com/images/I/71wL3ErE44L._AC_SY679_.jpg"),
                new Movie("Life of Pi", "Adventure", 7.9, "https://m.media-amazon.com/images/I/81cvDO2R4aL._AC_SY679_.jpg")
        ));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String genre = request.getParameter("genre");
        if (genre == null || genre.trim().isEmpty()) {
            request.setAttribute("error", "Please select a genre.");
            request.getRequestDispatcher("recommend.jsp").forward(request, response);
            return;
        }

        List<Movie> recommended = movieRecommendations.getOrDefault(genre, new ArrayList<>());
        request.setAttribute("movies", recommended);
        request.getRequestDispatcher("recommend.jsp").forward(request, response);
    }
}




