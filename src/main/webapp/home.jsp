<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    if (session.getAttribute("username") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>NeoFlex Home</title>
    <style>
        body {
            margin: 0;
            font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;
            background-color: #141414;
            color: white;
        }

        .header {
            background-color: #111;
            padding: 20px 40px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            box-shadow: 0 2px 8px rgba(0, 0, 0, 0.6);
        }

        .header h1 {
            color: #e50914;
            margin: 0;
            font-size: 30px;
            letter-spacing: 2px;
        }

        .header nav a {
            color: white;
            text-decoration: none;
            margin-left: 24px;
            font-size: 16px;
            font-weight: bold;
            transition: color 0.3s;
        }

        .header nav a:hover {
            color: #e50914;
        }

        .banner {
            padding: 100px 40px 60px;
            background: linear-gradient(to top, rgba(20,20,20,0.9), rgba(20,20,20,0.4)),
            url('https://wallpapercave.com/wp/wp4056410.jpg') no-repeat center center/cover;
            color: white;
            text-shadow: 1px 1px 4px black;
        }

        .banner h2 {
            font-size: 48px;
            margin-bottom: 15px;
        }

        .banner p {
            font-size: 20px;
            max-width: 600px;
        }

        .movie-section {
            padding: 30px 40px;
        }

        .movie-section h3 {
            font-size: 24px;
            margin-bottom: 18px;
            border-left: 5px solid #e50914;
            padding-left: 12px;
        }

        .movie-grid {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(160px, 1fr));
            gap: 18px;
        }

        .movie-card {
            background-color: #222;
            border-radius: 8px;
            overflow: hidden;
            transition: transform 0.3s ease-in-out;
            cursor: pointer;
            box-shadow: 0 6px 12px rgba(0,0,0,0.5);
        }

        .movie-card:hover {
            transform: scale(1.08);
            box-shadow: 0 12px 24px rgba(0,0,0,0.8);
        }

        .movie-card img {
            width: 100%;
            height: 240px;
            object-fit: cover;
            display: block;
        }

        .movie-card p {
            padding: 10px;
            margin: 0;
            font-size: 15px;
            text-align: center;
            font-weight: bold;
            color: #fff;
        }

        @media (max-width: 768px) {
            .banner h2 {
                font-size: 32px;
            }

            .banner p {
                font-size: 16px;
            }

            .movie-card img {
                height: 200px;
            }
        }
    </style>
</head>
<body>

<div class="header">
    <h1>NeoFlex</h1>
    <nav>
        <a href="home.jsp">Home</a>
        <a href="recommend.jsp">Recommendations</a>
    </nav>
</div>

<div class="banner">
    <h2>Welcome to NeoFlex</h2>
    <p>Stream blockbuster movies by genre. Get curated picks based on your mood and taste!</p>
</div>

<div class="movie-section">
    <h3>🔥 Action</h3>
    <div class="movie-grid">
        <div class="movie-card">
            <img src="https://m.media-amazon.com/images/I/71oyWdX7fOL._AC_SY679_.jpg" alt="John Wick">
            <p>John Wick</p>
        </div>
        <div class="movie-card">
            <img src="https://m.media-amazon.com/images/I/81h+zUUGd0L._AC_SY679_.jpg" alt="Mad Max: Fury Road">
            <p>Mad Max: Fury Road</p>
        </div>
    </div>
</div>

<div class="movie-section">
    <h3>😂 Comedy</h3>
    <div class="movie-grid">
        <div class="movie-card">
            <img src="https://m.media-amazon.com/images/I/81C3bSu5jnL._AC_SY679_.jpg" alt="The Mask">
            <p>The Mask</p>
        </div>
        <div class="movie-card">
            <img src="https://m.media-amazon.com/images/I/51v5ZpFyaFL._AC_.jpg" alt="Superbad">
            <p>Superbad</p>
        </div>
    </div>
</div>

</body>
</html>

