package ga.veee.day16.Test;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;

public class QuestionsModel implements Serializable {
    ArrayList<Question> questions = new ArrayList<Question>();

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public LocalTime getTestDuration() {
        return testDuration;
    }

    LocalTime testDuration;

    public QuestionsModel(ArrayList<Question> questions, LocalTime testDuration) {
        this.questions = questions;
        this.testDuration = testDuration;
    }
}
