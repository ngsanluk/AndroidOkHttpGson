package hk.com.sunnyng.androidokhttpgson;

/**
 * Created by sunnyng on 9/5/2017.
 */

public class Contact {
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private String country;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String toString() {
        return this.firstName + " " + this.mobile + " " + this.email;
    }

}
