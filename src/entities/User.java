package entities;

public class User {
    private int user_ID, age, zip_code;
    private String gender, occupation;

    public User(int user_ID, int age, int zip_code, String gender, String occupation) {
        this.user_ID = user_ID;
        this.age = age;
        this.zip_code = zip_code;
        this.gender = gender;
        this.occupation = occupation;
    }

    public int getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(int user_ID) {
        this.user_ID = user_ID;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getZip_code() {
        return zip_code;
    }

    public void setZip_code(int zip_code) {
        this.zip_code = zip_code;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}
