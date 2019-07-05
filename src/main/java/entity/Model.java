package entity;

public class Model {

    // static variable single_instance of type Model
    private static Model single_instance = null;

    // static method to create instance of Singleton class
    public static Model getInstance()
    {
        if (single_instance == null)
            single_instance = new Model();

        return single_instance;
    }

}
