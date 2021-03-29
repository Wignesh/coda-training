package ga.veee.day16.Test;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class ExamService extends UnicastRemoteObject implements Exam {


    protected ExamService() throws RemoteException {
    }

    static QuestionPool questionPool;

    public static void main(String[] args) throws RemoteException, AlreadyBoundException, MalformedURLException {
        questionPool = createQuestionsPool();

        ExamService examService = new ExamService();

        LocateRegistry.createRegistry(1099);

        System.out.println("Server Ready....");

        Naming.bind("rmi://localhost:1099/exam/startExam", examService);
    }

    static QuestionPool createQuestionsPool() {
        QuestionPool questionPool = new QuestionPool();
        questionPool.add("Java was designed by " + "_".repeat(5), new String[]{"Microsoft", "Mozilla Corporation", "Sun Microsystems", "Amazon Inc.", "Google"}, UUID.randomUUID(), 3);
        questionPool.add("Earlier name of Java Programming language was " + "_".repeat(5), new String[]{"Eclipse", "OAK", "Netbeans", "D", "C"}, UUID.randomUUID(), 2);
        questionPool.add("Which of the following personality is called as father of Java Programming language " + "_".repeat(5), new String[]{"James Gosling", "Larry Page", "Bjarne Stroustrup", "Chan", "None of these"}, UUID.randomUUID(), 2);
        questionPool.add("Why OAK was renamed to Java ?", new String[]{"because the language was unsuccessful , so they created another version and changed its name to java.", "because the name was not relevant to the language they created", "because there was another language called Oak", "Doesn't mean anything", "None of these"}, UUID.randomUUID(), 3);
        questionPool.add("Java was publicly released in " + "_".repeat(5), new String[]{"25-05-1995", "27-05-1995", "29-05-1995", "28-05-1995", "05-05-1995"}, UUID.randomUUID(), 2);
        questionPool.add("Which kind of language java is ?", new String[]{"Object Oriented", "Procedural", "Event Driven", "Functional", "None of these"}, UUID.randomUUID(), 1);
        questionPool.add("In the beginning, Java was created in order to " + "_".repeat(5), new String[]{"Perform Operations on the Internet", "Connect many household machines", "Create Strong Programming alternative to C++", "Just for fun", "ALL of the above"}, UUID.randomUUID(), 2);
        questionPool.add("Java is a _____ programming language ? ", new String[]{"high-level", "Middle-level", "Low-level", "Level", "None of the above"}, UUID.randomUUID(), 1);
        questionPool.add("Which of the following are correct advantage of java? ", new String[]{"Java is OOP", "Java is Simple", "Java is Secure", "Java is Portable", "All of the above"}, UUID.randomUUID(), 5);
        questionPool.add("In which year, Sun Microsystems released much of its Java virtual machine?", new String[]{"2005", "2006", "2007", "2008", "2009"}, UUID.randomUUID(), 2);
        questionPool.add("After first public release java was targeted at " + "_".repeat(5), new String[]{"Internet development", "Search Engine Development", "Desktop Development", "Operating System Development", "Playing games"}, UUID.randomUUID(), 1);
        questionPool.add("First public implementation of java was " + "_".repeat(5), new String[]{"Java 1.2", "Java 1.0", "Java 1.1", "Java Premium 1.0", "Java Premium 1.1"}, UUID.randomUUID(), 2);
        questionPool.add("Basic aim of java was to solve the problem of connecting many household machines together.", new String[]{"Java data kit", "Java defination kit", "Java design kit", "Java development kit", "Java D kit"}, UUID.randomUUID(), 4);
        questionPool.add("Sun Microsystems released the first public implementation as Java 1.0 in?", new String[]{"1994", "1995", "1996", "1997", "1998"}, UUID.randomUUID(), 3);
        questionPool.add("Java SE 15 version released on?", new String[]{"March 19, 2019", "March 17, 2020", "September 17, 2019", "September 15, 2020", "September 15, 2019"}, UUID.randomUUID(), 4);
        return questionPool;
    }

    @Override
    public QuestionsModel startExam(int noOfQuestions, LocalTime testDuration) throws RemoteException {
        testDuration = LocalTime.now().plus(testDuration.toNanoOfDay(), ChronoUnit.NANOS);
        return new QuestionsModel(questionPool.getRandomQuestion(noOfQuestions), testDuration);
    }

    @Override
    public int getTotalNoQuestions() throws RemoteException {
        return questionPool.getTotalNoQuestions();
    }
}
