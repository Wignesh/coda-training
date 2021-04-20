function checkPassword() {
    var passwordStrength = document.getElementById("password-strength");
    if (document.getElementById("s-pass-confirm").value != document.getElementById("s-pass").value) {
        document.getElementById("s-pass-confirm").style.borderBottom = "thick solid red";
        document.getElementById("confirm-password-msg").innerText = "Password & Confirm-Passowrd should match";
    } else {
        const msg = passwordStrength.textContent;
        document.getElementById("confirm-password-msg").innerText = "";
        if (msg.includes("Worst")) {
            document.getElementById("s-pass-confirm").style.borderBottom = "0px solid red";
        } else if (msg.includes("Bad")) {
            document.getElementById("s-pass-confirm").style.borderBottom = "4px solid red";
        } else if (msg.includes("Weak")) {
            document.getElementById("s-pass-confirm").style.borderBottom = "4px solid gold";
        } else if (msg.includes("Good")) {
            document.getElementById("s-pass-confirm").style.borderBottom = "4px solid orange";
        } else if (msg.includes("Strong")) {
            document.getElementById("s-pass-confirm").style.borderBottom = "4px solid green";
        }
    }
}

function submitSignUpForm(e) {
    e.preventDefault();
    if (document.getElementById("s-pass-confirm").value === document.getElementById("s-pass").value) {
        document.getElementById("s-pass-confirm").style.borderBottom = "0px solid red";

        document.getElementById("signupForm").submit();
    } else {
        document.getElementById("s-pass-confirm").style.borderBottom = "thick solid red";
        document.getElementById("confirm-password-msg").innerText = "Password & Confirm-Passowrd should match";
    }
}

function hideElem(id) {
    document.getElementById(id).style.display = "none";
}

function passwordHealth() {
    var strength = {
        0: "Worst - Really, you call that! a password?",
        1: "Bad - Don't come crying to me when your'e hacked!",
        2: "Weak - Perhaps this was good, 10 years ago!",
        3: "Good - I almost like where you're going with this!",
        4: "Strong - Yeah, like your'e going to remember this!",
    };

    var password = document.getElementById("s-pass");
    var meter = document.getElementById("password-strength-meter");
    var text = document.getElementById("password-strength-text");
    var passwordStrength = document.getElementById("password-strength");

    var val = password.value;
    var result = zxcvbn(val);
    meter.value = result.score;
    if (val !== "") {
        passwordStrength.innerText = strength[result.score];
        let suggestions = `<ul style="list-style-type:square">`;
        if (result.feedback.warning) suggestions += `<li>${result.feedback.warning}</li>`;
        result.feedback.suggestions.forEach((e) => {
            suggestions += `<li>${e}</li>`;
        });
        suggestions += `</ul>`;
        text.innerHTML = suggestions;
    } else {
        text.innerHTML = "";
    }
    if (document.getElementById("s-pass-confirm").value != "") {
        checkPassword();
    }
}

function handlePasswordVisiblity(id) {
    const password = document.getElementById(id);
    const type = password.getAttribute("type") === "password" ? "text" : "password";
    password.setAttribute("type", type);
    document.getElementById(window.event.target.id).classList.toggle("fa-eye-slash");
}

function showAuthHelp() {
    const help = document.getElementById("forget-password-link");
    if (help.style.display == "") help.style.display = "block";
    else help.style.display = help.style.display == "none" ? "block" : "none";
}
