<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.neoflex.model.Movie" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
  <title>NeoFlex Movie Recommendations</title>
  <style>
    body {
      margin: 0;
      font-family: 'Segoe UI', sans-serif;
      background-color: #141414;
      color: #fff;
    }

    header {
      background-color: #111;
      padding: 20px;
      text-align: center;
      font-size: 32px;
      color: #e50914;
      font-weight: bold;
      letter-spacing: 2px;
    }

    .container {
      text-align: center;
      padding: 40px 20px;
    }

    h2 {
      color: #fff;
      margin-bottom: 25px;
      font-size: 26px;
      font-weight: 600;
    }

    select, input[type=submit] {
      padding: 12px 18px;
      font-size: 16px;
      margin: 10px 8px;
      border-radius: 5px;
      border: none;
      background-color: #333;
      color: #fff;
    }

    select:focus {
      outline: none;
      border: 1px solid #e50914;
    }

    input[type=submit] {
      background-color: #e50914;
      font-weight: bold;
      transition: background-color 0.3s;
    }

    input[type=submit]:hover {
      background-color: #b00610;
      cursor: pointer;
    }

    .movie-container {
      display: flex;
      flex-wrap: wrap;
      justify-content: center;
      margin-top: 40px;
    }

    .movie-card {
      background-color: #222;
      border-radius: 12px;
      margin: 15px;
      width: 220px;
      overflow: hidden;
      box-shadow: 0 8px 16px rgba(0, 0, 0, 0.6);
      transition: transform 0.3s, box-shadow 0.3s;
    }

    .movie-card:hover {
      transform: scale(1.05);
      box-shadow: 0 12px 24px rgba(0, 0, 0, 0.8);
    }

    .movie-card img {
      width: 100%;
      height: 320px;
      object-fit: cover;
    }

    .movie-card h3 {
      font-size: 18px;
      margin: 10px 0 5px;
      color: #fff;
    }

    .movie-card p {
      font-size: 14px;
      margin: 0 0 10px;
      color: #ccc;
    }

    .no-results {
      margin-top: 40px;
      font-size: 18px;
      color: #bbb;
    }

    @media (max-width: 768px) {
      .movie-card {
        width: 90%;
      }
    }
  </style>
</head>
<body>
<header>NeoFlex</header>

<div class="container">
  <h2>🎬 Discover Movies by Genre</h2>

  <form action="recommend" method="post">
    <select name="genre" required>
      <option disabled selected>Select Genre</option>
      <option>Action</option>
      <option>Comedy</option>
      <option>Drama</option>
      <option>Sci-Fi</option>
      <option>Horror</option>
      <option>Romance</option>
      <option>Thriller</option>
      <option>Animation</option>
      <option>Fantasy</option>
      <option>Mystery</option>
      <option>Biography</option>
      <option>Adventure</option>
    </select>
    <input type="submit" value="Get Recommendations">
  </form>

  <div class="movie-container">
    <%
      List<Movie> movies = (List<Movie>) request.getAttribute("movies");
      if (movies != null && !movies.isEmpty()) {
        for (Movie movie : movies) {
    %>
    <div class="movie-card">
      <img src="<%= movie.getImageUrl() %>" alt="<%= movie.getTitle() %> Poster">
      <h3><%= movie.getTitle() %></h3>
      <p>Genre: <%= movie.getGenre() %></p>
      <p>Rating: ⭐ <%= movie.getRating() %></p>
    </div>
    <%
      }
    } else if (movies != null) {
    %>
    <div class="no-results">😕 No movies found for this genre. Try another one!</div>
    <%
      }
    %>
  </div>
</div>
</body>
</html>





