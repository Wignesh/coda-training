package ga.veee.day7;

public class ObjectCreationDemo {
    public static void main(String[] args) throws Exception {
        MyBusinessLogic myb = MyBusinessLogic.createObject();
        myb.str = "first object...";
        MyBusinessLogic myb2 = MyBusinessLogic.createObject();
        myb2.str = "second object...";

        myb.setDataLogic(DataLogic.createObject());
        System.out.println(myb.getDataLogic());
        myb.setDataLogic(DataLogic.createObject());
        System.out.println(myb.getDataLogic());

        myb.setDataLogic(DataLogic.createObject());
        myb.setDataLogic(DataLogic.createObject());

        System.out.println(myb.str);
    }
}

class MyBusinessLogic implements Cloneable {    
    String str;
    DataLogic dataLogic;

    public final DataLogic getDataLogic() {
        return dataLogic;
    }

    public final void setDataLogic(DataLogic dataLogic) {
        this.dataLogic = dataLogic;
    }

    private MyBusinessLogic() {
        System.out.println("cons called...");
    }

    private static MyBusinessLogic myb;

    synchronized public static MyBusinessLogic createObject() throws Exception {
        if (myb == null) {
            myb = new MyBusinessLogic();
        }
        return myb.createClone();
    }

    public MyBusinessLogic createClone() throws Exception {
        return (MyBusinessLogic) super.clone();
    }
}

class DataLogic implements Cloneable {
    private DataLogic() {
        System.out.println("DataLogic cons called...");
    }

    private static DataLogic myb;

    synchronized public static DataLogic createObject() throws Exception {
        if (myb == null) {
            myb = new DataLogic();
        }
        return myb.createClone();
    }

    public DataLogic createClone() throws Exception {
        return (DataLogic) super.clone();
    }
}
//My Resources are shared but still properties are unique...