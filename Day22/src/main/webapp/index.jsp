<%--
  Created by IntelliJ IDEA.
  User: vignesh
  Date: 08/04/21
  Time: 2:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Home</title>
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
            background-image: url("https://login.oracle.com/mysso/sso_loginui/sso-f17v2-bgimg.jpg");
        }
        * {
            box-sizing: border-box;
        }
        hr {
            border: 1px double #f1f1f1;
            margin-bottom: 25px;
        }
        .login-button,
        .signup-button {
            background-color: #759c6c;
            color: white;
            font-size: 16px;
            padding: 14px 20px;
            margin: 40px 20px;
            border: none;
            cursor: pointer;
            opacity: 0.9;
        }
        .login-button:hover,
        .signup-button:hover {
            opacity: 1;
        }
        .signup-button {
            background-color: #000000;
        }
        .forms {
            display: flex;
            align-items: center;
            justify-content: space-around;
        }

        .container {
            border: 6px solid;
            border-color: #f1f1f1;
            background-color: #fff;
            border-radius: 2%;
            width: 30%;
            margin: auto;
            margin-top: 30px;
            padding: 24px;
        }
        .welcome {
            font-size: xx-large;
            margin: 0;
            width: 100%;
            text-align: center;
            text-decoration: underline wavy;
            text-underline-position: under;
        }
        .link {
            color: #ad562c;
            background: none;
            border: none;
            padding: 0;
            font: inherit;
            cursor: pointer;
            outline: inherit;
            text-decoration: underline;
        }

        .help {
            display: block;
            margin-left: auto;
            margin-right: auto;
            margin-top: 12px;
        }

        /* Smartphones (portrait and landscape) ----------- */
        @media only screen and (min-device-width: 320px) and (max-device-width: 480px) {
            /* Styles */
            .container {
                width: 98%;
            }
        }

        /* iPads (portrait and landscape) ----------- */
        @media only screen and (min-device-width: 768px) and (max-device-width: 1024px) {
            /* Styles */
            .container {
                width: 60%;
            }
        }

        /* iPads (landscape) ----------- */
        @media only screen and (min-device-width: 768px) and (max-device-width: 1024px) and (orientation: landscape) {
            /* Styles */
            .container {
                width: 60%;
            }
        }

        /* iPads (portrait) ----------- */
        @media only screen and (min-device-width: 768px) and (max-device-width: 1024px) and (orientation: portrait) {
            /* Styles */
            .container {
                width: 60%;
            }
        }

        /* Desktops and laptops ----------- */
        @media only screen and (min-width: 1224px) {
            /* Styles */
            .container {
                width: 30%;
            }
        }

        /* Large screens ----------- */
        @media only screen and (min-width: 1824px) {
            .container {
                width: 40%;
            }
        }
    </style>
</head>
<body>
<div class="container">
    <h3 class="welcome">Welcome!</h3>
    <div class="forms">
        <form action="auth.do" method="POST">
            <input type="hidden" name="formId" value="Home" />
            <input type="hidden" name="actionId" value="login" />
            <button type="submit" class="login-button">Sign In</button>
        </form>

        <form action="auth.do" method="POST">
            <input type="hidden" name="formId" value="Home" />
            <input type="hidden" name="actionId" value="register" />
            <button type="submit" class="signup-button">Sign Up</button>
        </form>
    </div>

    <button type="button" class="link help">Need Help?</button>
</div>
</body>
</html>

