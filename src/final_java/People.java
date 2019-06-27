package final_java;

public class People {
    private String username;
    private String password;
    private String name;
    private int age;
    private String gender;
    private double height;
    private String image;
    private String WhatsApp;
    private String Line;
    private String Instagram;
    private String Twitter;
    private String Facebook;
    private String Snapchat;
    private String trait1;
    private String trait2;
    private String trait3;
    
    People(String Pusername, String Ppassword, String Pname, int Page, String Pgender, double Pheight, String Pimage, String PWhatsApp, String PLine, String PInstagram, String PTwitter, String PFacebook, String PSnapchat, String Ptrait1, String Ptrait2, String Ptrait3){
        this.username = Pusername;
        this.password = Ppassword;
        this.name = Pname;
        this.age = Page;
        this.gender = Pgender;
        this.height = Pheight;
        this.image = Pimage;
        this.WhatsApp = PWhatsApp;
        this.Line = PLine;
        this.Instagram = PInstagram;
        this.Twitter = PTwitter;
        this.Facebook = PFacebook;
        this.Snapchat = PSnapchat;
        this.trait1 = Ptrait1;
        this.trait2 = Ptrait2;
        this.trait3 = Ptrait3;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public double getHeight() {
        return height;
    }

    public String getImage() {
        return image;
    }

    public String getWhatsApp() {
        return WhatsApp;
    }

    public String getLine() {
        return Line;
    }

    public String getInstagram() {
        return Instagram;
    }

    public String getTwitter() {
        return Twitter;
    }

    public String getFacebook() {
        return Facebook;
    }

    public String getSnapchat() {
        return Snapchat;
    }

    public String getTrait1() {
        return trait1;
    }

    public String getTrait2() {
        return trait2;
    }

    public String getTrait3() {
        return trait3;
    }
}
