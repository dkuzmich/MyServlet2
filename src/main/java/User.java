import java.io.Serializable;

/**
 * Created by dkuzmich on 6/21/2017.
 */
public class User implements Serializable {

    private String name;
    private String email;
    private int id;
    private String country;
    private String pass;

    public User(String nm, String em, String country, String pass){
        this.name=nm;
        this.email=em;
        this.country=country;
        this.pass=pass;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return  "name=" + this.name + ", email=" + this.email +", country=" + country ;
    }
}
