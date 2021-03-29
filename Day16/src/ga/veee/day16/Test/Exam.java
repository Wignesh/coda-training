package ga.veee.day16.Test;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalTime;
import java.util.ArrayList;

public interface Exam extends Remote {

    QuestionsModel startExam(int noOfQuestions, LocalTime testDuration) throws RemoteException;
}
