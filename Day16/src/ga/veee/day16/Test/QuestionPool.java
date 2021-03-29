package ga.veee.day16.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;

public class QuestionPool {
    private ArrayList<Question> questions = new ArrayList<Question>();
    public static int MAX;

    public void add(String question, String[] options, UUID id, int answer) {
        questions.add(new Question(question, options, id, answer));
        MAX = questions.size();
    }

    public ArrayList<Question> getRandomQuestion(int count) {
        Collections.shuffle(questions);
        return new ArrayList<Question>(questions.subList(0, count));
    }

    public int getTotalNoQuestions() {
        return questions.size();
    }
}