public class Profile {
    private String user;
    private String pass;
    private String place;
    public Profile(String[] profileArray) {
        setUser(profileArray[0]);
        setPass(profileArray[1]);
        setPlace(profileArray[2]);
    }

    public String getPass() {
        return pass;
    }
    public void setPass(String pass){
        this.pass = pass;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user){
        this.user = user;
    }
    public String getPlace() {
        return place;
    }
    public void setPlace(String place){
        this.place = place;
    }
    public boolean isPassEmpty() {
        if(this.pass == "") {
            return true;
        }else {
            return false;
        }
    }
}
