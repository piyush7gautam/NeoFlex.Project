<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Login to NeoFlex</title>
  <style>
    body {
      margin: 0;
      padding: 0;
      font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;
      background-color: #141414;
      color: #ffffff;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
      background-image: url('https://assets.nflxext.com/ffe/siteui/vlv3/8fa5b97d-0779-4e9e-a2bb-49704d841c39/3ac09f78-7554-4a9f-b2b7-6a82c8c82733/IN-en-20240513-popsignuptwoweeks-perspective_alpha_website_small.jpg');
      background-size: cover;
      background-position: center;
    }

    .overlay {
      position: absolute;
      top: 0;
      left: 0;
      height: 100vh;
      width: 100vw;
      background: rgba(0, 0, 0, 0.6);
      z-index: 0;
    }

    .login-container {
      position: relative;
      z-index: 1;
      background-color: rgba(0, 0, 0, 0.75);
      padding: 50px 40px;
      border-radius: 8px;
      max-width: 400px;
      width: 100%;
      box-shadow: 0 0 60px rgba(0, 0, 0, 0.9);
    }

    h2 {
      margin-bottom: 25px;
      font-size: 28px;
      font-weight: 700;
      text-align: center;
    }

    input[type="text"], input[type="password"] {
      width: 100%;
      padding: 15px;
      margin: 10px 0;
      background-color: #333;
      border: none;
      border-radius: 4px;
      color: white;
      font-size: 14px;
    }

    input[type="submit"] {
      width: 100%;
      padding: 15px;
      background-color: #e50914;
      color: white;
      border: none;
      border-radius: 4px;
      font-weight: bold;
      font-size: 16px;
      margin-top: 15px;
      cursor: pointer;
      transition: background-color 0.3s;
    }

    input[type="submit"]:hover {
      background-color: #f6121d;
    }

    .register-link {
      margin-top: 20px;
      text-align: center;
      font-size: 14px;
    }

    .register-link a {
      color: #fff;
      text-decoration: none;
      font-weight: bold;
    }

    .register-link a:hover {
      text-decoration: underline;
    }

    .error-message {
      color: #ff4c4c;
      background-color: rgba(255, 0, 0, 0.1);
      border-left: 4px solid #ff4c4c;
      padding: 10px;
      margin-bottom: 15px;
      border-radius: 4px;
      font-size: 14px;
    }
  </style>
</head>
<body>
<div class="overlay"></div>
<div class="login-container">
  <h2>Login to NeoFlex</h2>

  <% String error = (String) request.getAttribute("error"); %>
  <% if (error != null) { %>
  <div class="error-message"><%= error %></div>
  <% } %>

  <form action="login" method="post">
    <input type="text" name="username" placeholder="Enter your Username" required>
    <input type="password" name="password" placeholder="Enter your Password" required>
    <input type="submit" value="Login">
  </form>
  <div class="register-link">
    New to NeoFlex? <a href="register.jsp">Sign up now</a>
  </div>
</div>
</body>
</html>
