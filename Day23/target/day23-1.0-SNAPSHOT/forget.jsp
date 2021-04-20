<%@ include file="Nav.jsp" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reset Password</title>

<body>
<div class="auth-page auth-page-color-1">

    <div class="auth-container-left">
        <div class="auth-container">
            <div class="login-container" id="login-container">
                <form id="loginForm" action="forget.do" method="POST">
                    <input type="hidden" name="formId" value="Login" />
                    <h1 class="auth-title">Forget</h1>
                    <p class="auth-message">Please fill in this form to receive password reset link.</p>
                    <hr class="line-break" />
                    <label for="username"><b>Username / E-Mail</b><span class="required-field"> *</span></label>
                    <input type="text" class="auth-input" value="vignesh" placeholder="Enter Username"
                           name="username" minlength="6" maxlength="32" required />
                    <p>Don't have an account ? <a href="register.jsp" id="sign-up-switch" class="auth-link">Sign
                        up</a></p>
            </div>
            <button type="submit" id="button" class="auth-button"><i id="auth-icon" class="fa fa-play auth-icon"
                                                                     aria-hidden="true"></i>Start Process</button>
            </form>
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
    </div>

</div>
</body>

</html>