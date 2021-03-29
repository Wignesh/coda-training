package ga.veee.day16.Test;

import java.io.Serializable;
import java.util.UUID;

public class Question implements Serializable {
    private final String question;
    private final int answer;

    public void setUserAnswer(int userAnswer) {
        this.userAnswer = userAnswer;
    }

    private int userAnswer = 0;
    private final UUID id;
    private final String[] options;

    public String[] getOptions() {
        return options;
    }

    public Question(String question, String[] options, UUID id, int answer) {
        this.question = question;
        this.options = options;
        this.id = id;
        this.answer = answer;
    }

    public String getAnswer() {
        return this.options[this.answer - 1];
    }

    public UUID getId() {
        return this.id;
    }

    public String getQuestion() {
        return question;
    }

    public String getUserAnswer() {
        return userAnswer > 0 ? this.options[this.userAnswer - 1] : "Not Attended";
    }

    public boolean isCorrect() {
        return this.answer == this.userAnswer;
    }
}