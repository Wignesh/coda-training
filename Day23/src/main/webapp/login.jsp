<%@ include file="Nav.jsp" %>
<!DOCTYPE html>
<%@page import="java.util.ResourceBundle" buffer="8kb" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Locale" %>
<html>

<head>
<%--    <meta charset="UTF-8">--%>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
<body>
<%
    ResourceBundle rb=(ResourceBundle)session.getAttribute("rb");
    if(rb == null){
        rb = ResourceBundle.getBundle("ga.veee.day23.control.Dictionary", new Locale("en"));
    }
%>
<div class="auth-page">
    <div class="auth-container-left">
        <div class="auth-container">
            <div class="login-container" id="login-container">
                <form id="loginForm" action="login.do" method="POST">
                    <input type="hidden" name="formId" value="Login" />
                    <h1 class="auth-title">Sign In</h1>
                    <p class="auth-message">Please fill in this form to login to your account.</p>
                    <hr class="line-break" />
                    <label for="username"><b><%=rb.getString("username") %></b><span class="required-field"> *</span></label>
                    <input type="text" class="auth-input" value="vignesh" placeholder="Enter Username"
                           name="username" minlength="6" maxlength="32" required />

                    <label for="password"><b><%=rb.getString("password") %><span class="required-field"> *</span></b></label>
                    <input type="password" class="auth-input" value="1234" placeholder="Enter Password"
                           name="password" id="password" minlength="6" maxlength="32" required />
                    <i class="fa fa-eye" aria-hidden="true" id="togglePassword"
                       onclick="handlePasswordVisiblity('password')"></i>

                    <label> <input type="checkbox" class="checkbox" checked="checked" name="rememberme" value="1"
                                   style="margin-bottom: 15px" /> Remember me <span></span></label>

                    <p>Don't have an account ? <a href="register.jsp" id="sign-up-switch" class="auth-link">Sign
                        up</a></p>
            </div>
            <button type="submit" id="button" class="auth-button"><i id="auth-icon"
                                                                     class="fa fa-unlock-alt auth-icon" aria-hidden="true"></i>Sign In</button>
            </form>
            <button type="button" class="auth-link help-link" onclick="showAuthHelp()">Need Help?</button>
            <a href="forget.jsp" id="forget-password-link" class="auth-link forget-link">Forget Password ?</a>
        </div>
    </div>
    <div class="auth-container-right">
        <div class="auth-page-hero-flex">
            <div class="auth-hero-container">
                <div class="auth-hero-bg-rounded"></div>
                <img class="auth-hero-image" src="https://i.imgur.com/wrqF9dW.png" alt="" />
            </div>
            <div class="auth-hero-body">
                <h1>Fresh <span>Grocery</span><br />Shopping</h1>
                <p>100 Healthy & Affortable</p>
                <button class="hero-button">Shop Now</button>
            </div>
        </div>

        <!-- <div class="hero-flex">
            <div class="hero-left-box">
              <h1>Fresh <span>Grocery</span><br />Shopping</h1>
              <p>100 Healthy & Affortable</p>
              <button class="hero-button">Shop Now</button>
            </div>
            <div class="hero-round-bg"></div>
            <div class="hero-right-box">
              <img class="hero-image" src="https://i.imgur.com/wrqF9dW.png" alt="" />
            </div> -->
        <!-- <img class="hero-leaf1" src="https://i.imgur.com/3uScmSk.png" alt="" />
            <img class="hero-leaf2" src="https://i.imgur.com/3uScmSk.png" alt="" />
            <img class="hero-leaf3" src="https://i.imgur.com/3uScmSk.png" alt="" /> -->
        <!-- </div> -->
        <!-- <div class="number-input">
<button type="button" onclick="this.parentNode.querySelector('input[type=number]').stepDown()">-</button>
<input class="quantity" maxlength="2" min="0" max="10" name="%s" value="0" type="number" form="main-form" />
<button type="button" onclick="this.parentNode.querySelector('input[type=number]').stepUp()" class="plus">+</button>
</div> -->
    </div>
</div>
</body>

</html>


<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>
<%--<head>--%>
<%--    <meta charset="UTF-8" />--%>
<%--    <meta http-equiv="X-UA-Compatible" content="IE=edge" />--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1.0" />--%>
<%--    <title>Login</title>--%>
<%--    <style>--%>
<%--        body {--%>
<%--            font-family: Arial, Helvetica, sans-serif;--%>
<%--            background-image: url("https://login.oracle.com/mysso/sso_loginui/sso-f17v2-bgimg.jpg");--%>
<%--        }--%>
<%--        * {--%>
<%--            box-sizing: border-box;--%>
<%--        }--%>
<%--        input[type="text"],--%>
<%--        input[type="password"] {--%>
<%--            width: 100%;--%>
<%--            padding: 15px;--%>
<%--            margin: 5px 0 22px 0;--%>
<%--            display: inline-block;--%>
<%--            border: none;--%>
<%--            background: #f1f1f1;--%>
<%--        }--%>

<%--        input[type="text"]:focus,--%>
<%--        input[type="password"]:focus {--%>
<%--            background-color: #ddd;--%>
<%--            border-bottom: 3px solid #5d9050;--%>
<%--            outline: none;--%>
<%--        }--%>
<%--        hr {--%>
<%--            border: 1px double #f1f1f1;--%>
<%--            margin-bottom: 25px;--%>
<%--        }--%>
<%--        .button {--%>
<%--            background-color: #759c6c;--%>
<%--            color: white;--%>
<%--            font-size: 16px;--%>
<%--            padding: 14px 20px;--%>
<%--            margin: 8px 0;--%>
<%--            border: none;--%>
<%--            cursor: pointer;--%>
<%--            width: 100%;--%>
<%--            opacity: 0.9;--%>
<%--        }--%>
<%--        .button:hover {--%>
<%--            opacity: 1;--%>
<%--        }--%>
<%--        .container {--%>
<%--            border: 6px solid #f1f1f1;--%>
<%--            background-color: #fff;--%>
<%--            border-radius: 2%;--%>
<%--            width: 30%;--%>
<%--            margin: 30px auto auto;--%>
<%--            padding: 24px;--%>
<%--        }--%>
<%--        .welcome {--%>
<%--            font-size: xx-large;--%>
<%--            margin: 0;--%>
<%--            width: 100%;--%>
<%--            text-align: center;--%>
<%--            text-decoration: underline wavy;--%>
<%--            text-underline-position: under;--%>
<%--        }--%>
<%--        .link {--%>
<%--            color: #ad562c;--%>
<%--            background: none;--%>
<%--            border: none;--%>
<%--            padding: 0;--%>
<%--            font: inherit;--%>
<%--            cursor: pointer;--%>
<%--            outline: inherit;--%>
<%--            text-decoration: underline;--%>
<%--        }--%>
<%--        .title {--%>
<%--            margin-bottom: 20px;--%>
<%--        }--%>
<%--        .signup-container {--%>
<%--            display: none;--%>
<%--        }--%>
<%--        .invalidIp {--%>
<%--            color: red;--%>
<%--            display: none;--%>
<%--        }--%>
<%--        .help {--%>
<%--            display: block;--%>
<%--            margin-left: auto;--%>
<%--            margin-right: auto;--%>
<%--            margin-top: 12px;--%>
<%--        }--%>
<%--        .input {--%>
<%--            color: #000;--%>
<%--            font-weight: bold;--%>
<%--            font-size: 16px;--%>
<%--        }--%>

<%--        /* Smartphones (portrait and landscape) ----------- */--%>
<%--        @media only screen and (min-device-width: 320px) and (max-device-width: 480px) {--%>
<%--            /* Styles */--%>
<%--            .container {--%>
<%--                width: 100%;--%>
<%--            }--%>
<%--        }--%>

<%--        /* iPads (portrait and landscape) ----------- */--%>
<%--        @media only screen and (min-device-width: 768px) and (max-device-width: 1024px) {--%>
<%--            /* Styles */--%>
<%--            .container {--%>
<%--                width: 60%;--%>
<%--            }--%>
<%--        }--%>

<%--        /* iPads (landscape) ----------- */--%>
<%--        @media only screen and (min-device-width: 768px) and (max-device-width: 1024px) and (orientation: landscape) {--%>
<%--            /* Styles */--%>
<%--            .container {--%>
<%--                width: 60%;--%>
<%--            }--%>
<%--        }--%>

<%--        /* iPads (portrait) ----------- */--%>
<%--        @media only screen and (min-device-width: 768px) and (max-device-width: 1024px) and (orientation: portrait) {--%>
<%--            /* Styles */--%>
<%--            .container {--%>
<%--                width: 60%;--%>
<%--            }--%>
<%--        }--%>

<%--        /* Desktops and laptops ----------- */--%>
<%--        @media only screen and (min-width: 1224px) {--%>
<%--            /* Styles */--%>
<%--            .container {--%>
<%--                width: 30%;--%>
<%--            }--%>
<%--        }--%>

<%--        /* Large screens ----------- */--%>
<%--        @media only screen and (min-width: 1824px) {--%>
<%--            .container {--%>
<%--                width: 40%;--%>
<%--            }--%>
<%--        }--%>

<%--    </style>--%>
<%--    <script>--%>
<%--        function toggle() {--%>
<%--            const loginContainer = document.getElementById("login-container");--%>
<%--            const signupContainer = document.getElementById("signup-container");--%>
<%--            const button = document.getElementById("button");--%>

<%--            if (loginContainer.style.display === "none") {--%>
<%--                loginContainer.style.display = "block";--%>
<%--                signupContainer.style.display = "none";--%>
<%--                button.innerText = "Sign In";--%>
<%--                button.style.backgroundColor = "#759C6C";--%>
<%--            } else {--%>
<%--                signupContainer.style.display = "block";--%>
<%--                loginContainer.style.display = "none";--%>
<%--                button.innerText = "Sign Up";--%>
<%--                button.style.backgroundColor = "#000000";--%>
<%--            }--%>
<%--        }--%>

<%--        function submitSignUp(e) {--%>
<%--            e.preventDefault();--%>
<%--            if (document.getElementById("s-pass-confirm").value === document.getElementById("s-pass").value) {--%>
<%--                document.getElementById("signupForm").submit();--%>
<%--            } else {--%>
<%--                document.getElementById("invalidIp").style.display = "block";--%>
<%--            }--%>
<%--        }--%>

<%--        function submitForm() {--%>
<%--            const loginContainer = document.getElementById("login-container");--%>

<%--            if (loginContainer.style.display === "none") {--%>
<%--                document.getElementById("signupSubmit").click();--%>
<%--            } else {--%>
<%--                document.getElementById("loginSubmit").click();--%>
<%--            }--%>
<%--        }--%>

<%--        function hide(id) {--%>
<%--            document.getElementById(id).style.display = "none";--%>
<%--        }--%>

<%--        function init() {--%>
<%--            const loginContainer = document.getElementById("login-container");--%>
<%--            const button = document.getElementById("button");--%>

<%--            if (loginContainer.style.display === "none") {--%>
<%--                button.innerText = "Sign Up";--%>
<%--                button.style.backgroundColor = "#000000";--%>
<%--            } else {--%>
<%--                button.innerText = "Sign In";--%>
<%--                button.style.backgroundColor = "#759C6C";--%>
<%--            }--%>
<%--        }--%>
<%--    </script>--%>
<%--</head>--%>
<%--<body onload="init()">--%>
<%--<div class="container">--%>
<%--    <h3 class="welcome">Welcome!</h3>--%>
<%--    <div class="login-container" id="login-container">--%>
<%--        <form id="loginForm" action="login.do" method="POST">--%>
<%--            <input type="hidden" name="formId" value="Login"/>--%>
<%--            <h1 class="title">Sign In</h1>--%>
<%--            <p>Please fill in this form to login to your account.</p>--%>
<%--            <hr />--%>
<%--            <label for="username"><b>Username</b></label>--%>
<%--            <input type="text" class="input" value="vignesh" placeholder="Enter Username" name="username" minlength="6" maxlength="32" required />--%>

<%--            <label for="password"><b>Password</b></label>--%>
<%--            <input type="password" class="input" value="1234" placeholder="Enter Password" name="password" minlength="6" maxlength="32" required />--%>

<%--            <label> <input type="checkbox" class="checkbox" checked="checked" name="rememberme" value="1" style="margin-bottom: 15px" /> Remember me <span></span></label>--%>

<%--            <p>Don't have an account ? <button onclick="toggle()" id="sign-up-switch" type="button" class="link">Sign up</button></p>--%>
<%--            <input type="submit" id="loginSubmit" style="display: none" />--%>
<%--        </form>--%>
<%--    </div>--%>

<%--    <div class="signup-container" id="signup-container">--%>
<%--        <form id="signupForm" action="register.do" method="POST" onsubmit="submitSignUp(event)">--%>
<%--            <input type="hidden" name="formId" value="Register"/>--%>
<%--            <h1 class="title">Sign Up</h1>--%>
<%--            <p>Please fill in this form to create an account.</p>--%>
<%--            <hr />--%>
<%--            <label for="username"><b>Username</b></label>--%>
<%--            <input type="text" class="input" placeholder="Enter Username" name="username" minlength="6" maxlength="32" required />--%>

<%--            <label for="password"><b>Password</b></label>--%>
<%--            <input type="password" class="input" placeholder="Enter Password" id="s-pass" name="password" minlength="6" maxlength="32" required onfocus="hide('invalidIp')" />--%>

<%--            <label for="confirm-password"><b>Confirm Password</b></label>--%>
<%--            <input type="password" class="input" placeholder="Confirm Password" id="s-pass-confirm" name="confirm-password" minlength="6" maxlength="32" required onfocus="hide('invalidIp')" />--%>
<%--            <span id="invalidIp" class="invalidIp">Password & Confirm-Passowrd should match</span>--%>
<%--            <p>Already have an account ? <button onclick="toggle()" id="sign-in-switch" type="button" class="link">Sign In</button></p>--%>
<%--            <input type="submit" id="signupSubmit" style="display: none" />--%>
<%--        </form>--%>
<%--    </div>--%>
<%--    <button type="button" id="button" class="button" onclick="submitForm()">Sign In</button>--%>

<%--    <button type="button" class="link help">Need Help?</button>--%>
<%--</div>--%>
<%--</body>--%>
<%--</html>--%>
