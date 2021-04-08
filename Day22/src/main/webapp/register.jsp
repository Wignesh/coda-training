<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register</title>
</head>
<body>
<h1>Register</h1>
<form action="register.do" method="post">
    <input type="hidden" name="formid" value="Register"/>
    <label for="uname">Username : </label>
    <input type="text" name="uname" id="uname"/>
    <label for="upass">Password : </label>
    <input type="password" name="upass" id="upass"/>
    <input type="submit" value="Register">
</form>
</body>
</html>