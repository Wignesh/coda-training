package ga.veee.day16.Test;

import java.rmi.Naming;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExamClient {
    public static void main(String[] args) throws Exception {
        Exam exam = (Exam) Naming.lookup("rmi://localhost:1099/exam/startExam");
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter no of questions (1-%d) : ", exam.getTotalNoQuestions());
        int noOfQuestions = scanner.nextInt();

        QuestionsModel questionsModel = exam.startExam(noOfQuestions, LocalTime.of(0, 0, 5, 0));
        ArrayList<Question> questions = questionsModel.getQuestions();
        LocalTime testDuration = questionsModel.getTestDuration();

        ExecutorService es = Executors.newCachedThreadPool();

        es.execute(() -> {
            for (Question question : questions) {
                ExamUtils.promptQuestion(question);
            }
            endExam(questions, false);
        });
        es.execute(() -> {
            while (true) {
                if (LocalTime.now().isAfter(testDuration)) {
                    endExam(questions, true);
                    break;
                }
            }
        });
        es.shutdown();

    }

    static void endExam(ArrayList<Question> answers, boolean isTimeUp) {
        System.out.println();
        ExamUtils.breakLine();
        System.out.println(isTimeUp ? "\nTimes up, Test has been ended" : "\nTest has been ended");
        int score = 0, maxScore = 1;
        for (Question answer : answers) {
            score += answer.isCorrect() ? maxScore : 0;
            System.out.println(answer.getQuestion());
            System.out.printf("Correct Answer : %s\t Yours : %s\t Score : %d\n", answer.getAnswer(), answer.getUserAnswer(), answer.isCorrect() ? maxScore : 0);
            ExamUtils.breakLine();
        }
        System.out.printf("Total Score %d / %d", score, maxScore * answers.size());
        System.exit(0);
    }

}

class ExamUtils {
    public static void promptQuestion(Question question) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(question.getQuestion());
        String[] options = question.getOptions();
        for (int i = 0; i < options.length; i++) {
            System.out.println(String.format("%d) ", i + 1) + options[i]);
        }

        System.out.printf("Enter Answer (%d-%d) : ", 1, options.length);
        while (true) {
            int answer = scanner.nextInt();
            if (answer > 0 && answer <= options.length) {
                question.setUserAnswer(answer);
                break;
            } else
                System.out.printf("Invalid option enter between (%d-%d) : ", 1, options.length);
        }
        breakLine();
    }

    public static void breakLine() {
        System.out.println("_".repeat(80));
    }
}
