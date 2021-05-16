import java.util.HashMap;

public class Royhat {
    HashMap<String,String> logininfo = new HashMap<String,String>();

    public Royhat(){
        logininfo.put("Azamat","a");
    }

    public void put(String login,String password){
        logininfo.put(login,password);
    }
}
