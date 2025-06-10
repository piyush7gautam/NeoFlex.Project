<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Welcome to NeoFlex</title>
    <style>
        * {
            box-sizing: border-box;
        }

        body {
            margin: 0;
            font-family: 'Segoe UI', sans-serif;
            background: url('https://wallpapercave.com/wp/wp4069393.jpg') no-repeat center center/cover;
            background-attachment: fixed;
            height: 100vh;
            color: white;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            text-align: center;
            position: relative;
        }

        .overlay {
            position: absolute;
            width: 100%;
            height: 100%;
            background: rgba(0, 0, 0, 0.7);
            top: 0;
            left: 0;
            z-index: 0;
        }

        .content {
            position: relative;
            z-index: 1;
            max-width: 600px;
            padding: 0 20px;
        }

        h1 {
            font-size: 48px;
            color: #e50914;
            margin-bottom: 20px;
        }

        p {
            font-size: 18px;
            margin-bottom: 30px;
            color: #ccc;
        }

        .buttons {
            display: flex;
            gap: 20px;
            justify-content: center;
            flex-wrap: wrap;
        }

        .buttons a {
            background-color: #e50914;
            color: white;
            padding: 12px 24px;
            border-radius: 5px;
            text-decoration: none;
            font-weight: bold;
            transition: background-color 0.3s;
        }

        .buttons a:hover {
            background-color: #b00610;
        }

        @media (max-width: 600px) {
            h1 {
                font-size: 32px;
            }

            .buttons a {
                width: 100%;
                text-align: center;
            }
        }
    </style>
</head>
<body>
<div class="overlay"></div>
<div class="content">
    <h1>Welcome to NeoFlex</h1>
    <p>Your personalized movie streaming experience. Log in or create an account to start watching now!</p>
    <div class="buttons">
        <a href="login.jsp" aria-label="Login to NeoFlex">Login</a>
        <a href="register.jsp" aria-label="Register for NeoFlex">Register</a>
    </div>
</div>
</body>
</html>



