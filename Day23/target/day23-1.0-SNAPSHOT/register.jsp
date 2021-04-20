<%@ include file="Nav.jsp" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Signup</title>

<body>
<div class="auth-page">
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
    </div>
    <div class="auth-container-left ">
        <div class="auth-container">
            <div class="signup-container" id="signup-container">
                <form id="signupForm" action="register.do" method="POST" onsubmit="submitSignUpForm(event)">
                    <input type="hidden" name="formId" value="Register" />
                    <h1 class="auth-title">Sign Up</h1>
                    <p class="auth-message">Please fill in this form to create an account.</p>
                    <hr class="line-break" />
                    <label for="username"><b>Username</b><span class="required-field"> *</span></label>
                    <input type="text" class="auth-input" placeholder="Enter Username" name="username" minlength="6"
                           maxlength="32" required />

                    <div class="password-container">
                        <label for="password"><b>Password</b><span class="required-field"> *</span></label>
                        <input type="password" class="auth-input" placeholder="Enter Password" id="s-pass"
                               name="password" oninput="passwordHealth()" minlength="6" maxlength="32" required />
                        <i class="fa fa-eye" aria-hidden="true" id="togglePassword"
                           onclick="handlePasswordVisiblity('s-pass')"></i>
                        <div class="pasword-meter">
                            <meter max="4" id="password-strength-meter">
                            </meter>
                        </div>
                        <p id="password-strength" class="password-strength"></p>
                        <p id="password-strength-text" class="password-strength-text"></p>
                        <label for="confirm-password"><b>Confirm Password</b><span class="required-field">
                                    *</span></label>
                        <input type="password" class="auth-input" placeholder="Confirm Password" id="s-pass-confirm"
                               name="confirm-password" minlength="6" maxlength="32" required
                               oninput="checkPassword()" />
                        <i class="fa fa-eye" aria-hidden="true" id="togglePasswordConfirm"
                           onclick="handlePasswordVisiblity('s-pass-confirm')"></i>
                        <p id="confirm-password-msg" class="password-strength"></p>
                    </div>
                    <p>Already have an account ? <a href="login.jsp" id="sign-in-switch" class="auth-link">Sign
                        In</a></p>
            </div>
            <button type="submit" id="button" class="auth-button"><i id="auth-icon" class="fa fa-user auth-icon"
                                                                     aria-hidden="true"></i>Sign Up</button>
            </form>
            <button type="button" class="auth-link help-link" onclick="showAuthHelp()">Need Help?</button>
            <a href="forget.jsp" id="forget-password-link" class="auth-link forget-link">Forget Password ?</a>
        </div>
    </div>


</div>
</body>

</html>

<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>
<%--<head>--%>
<%--    <meta charset="UTF-8"/>--%>
<%--    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>--%>
<%--    <title>Register</title>--%>
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
<%--            background-color: #000000;--%>
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

<%--        .login-container {--%>
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
<%--                width: 98%;--%>
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
<%--            if (signupContainer.style.display === "none") {--%>
<%--                loginContainer.style.display = "none";--%>
<%--                signupContainer.style.display = "block";--%>
<%--                button.innerText = "Sign In";--%>
<%--                button.style.backgroundColor = "#000000";--%>
<%--            } else {--%>
<%--                signupContainer.style.display = "none";--%>
<%--                loginContainer.style.display = "block";--%>
<%--                button.innerText = "Sign Up";--%>
<%--                button.style.backgroundColor = "#759C6C";--%>
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

<%--    </script>--%>
<%--</head>--%>
<%--<body>--%>
<%--<div class="container">--%>
<%--    <h3 class="welcome">Welcome!</h3>--%>
<%--    <div class="signup-container" id="signup-container">--%>
<%--        <form id="signupForm" action="register.do" method="POST" onsubmit="submitSignUp(event)">--%>
<%--            <input type="hidden" name="formId" value="Register"/>--%>
<%--            <h1 class="title">Sign Up</h1>--%>
<%--            <p>Please fill in this form to create an account.</p>--%>
<%--            <hr/>--%>
<%--            <label for="username"><b>Username</b></label>--%>
<%--            <input type="text" class="input" placeholder="Enter Username" name="username" minlength="6" maxlength="32"--%>
<%--                   required/>--%>

<%--            <label for="password"><b>Password</b></label>--%>
<%--            <input type="password" class="input" placeholder="Enter Password" id="s-pass" name="password" minlength="6"--%>
<%--                   maxlength="32" required onfocus="hide('invalidIp')"/>--%>

<%--            <label for="confirm-password"><b>Confirm Password</b></label>--%>
<%--            <input type="password" class="input" placeholder="Confirm Password" id="s-pass-confirm"--%>
<%--                   name="confirm-password" minlength="6" maxlength="32" required onfocus="hide('invalidIp')"/>--%>
<%--            <span id="invalidIp" class="invalidIp">Password & Confirm-Passowrd should match</span>--%>
<%--            <p>Already have an account ?--%>
<%--                <button onclick="toggle()" id="sign-in-switch" type="button" class="link">Sign In</button>--%>
<%--            </p>--%>
<%--            <input type="submit" id="signupSubmit" style="display: none"/>--%>
<%--        </form>--%>
<%--    </div>--%>

<%--    <div class="login-container" id="login-container">--%>
<%--        <form id="loginForm" action="login.do" method="POST">--%>
<%--            <input type="hidden" name="formId" value="Login"/>--%>
<%--            <h1 class="title">Sign In</h1>--%>
<%--            <p>Please fill in this form to login to your account.</p>--%>
<%--            <hr/>--%>
<%--            <label for="username"><b>Username</b></label>--%>
<%--            <input type="text" class="input" placeholder="Enter Username" name="username" minlength="6" maxlength="32"--%>
<%--                   required/>--%>

<%--            <label for="password"><b>Password</b></label>--%>
<%--            <input type="password" class="input" placeholder="Enter Password" name="password" minlength="6"--%>
<%--                   maxlength="32" required/>--%>

<%--            <label> <input type="checkbox" class="checkbox" checked="checked" name="rememberme" value="1"--%>
<%--                           style="margin-bottom: 15px"/> Remember me <span></span></label>--%>

<%--            <p>Don't have an account ?--%>
<%--                <button onclick="toggle()" id="sign-up-switch" type="button" class="link">Sign up</button>--%>
<%--            </p>--%>
<%--            <input type="submit" id="loginSubmit" style="display: none"/>--%>
<%--        </form>--%>
<%--    </div>--%>


<%--    <button type="button" id="button" class="button" onclick="submitForm()">Sign Up</button>--%>

<%--    <button type="button" class="link help">Need Help?</button>--%>
<%--</div>--%>
<%--</body>--%>
<%--</html>--%>
