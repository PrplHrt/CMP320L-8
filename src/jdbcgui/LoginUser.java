package jdbcgui;

public class LoginUser {
    private String username;
    private String name;
    private Integer type;
    
    public LoginUser(String user, String name, Integer type){
        this.username = user;
        this.name = name;
        this.type = type;
    }
    
    public Integer getType(){
        return this.type;
    }
    public String getName(){
        return this.name;
    }
    public String getUserName(){
        return this.username;
    }
}
