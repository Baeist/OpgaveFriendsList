public class Friend {
    private String name;
    private String phone;
    private String email;

    public Friend(){}

    public Friend(String name, String phone, String email){
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getPhone(){
        return phone;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }
}
