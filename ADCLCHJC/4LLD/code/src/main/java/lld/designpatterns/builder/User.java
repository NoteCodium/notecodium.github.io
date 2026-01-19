package code.src.main.java.lld.designpatterns.builder;

public class User {
// Suggested code may be subject to a license. Learn more: ~LicenseLog:1374396551.
    private final String name;
    private final String phone; //optional

    private User(Builder builder){
        //you can do validation here
        this.name=builder.name;
        this.phone=builder.phone;
    }

    public static class Builder{
        private final String name;
        private String phone; //optional
    
        public Builder(String name){
            this.name=name;
            this.phone="";
        }

        // public Builder setPhone(String phone){
        //     this.phone=phone;
        //     return this;
        // }

        public Builder phone(String phone){
        //or here also
            
            this.phone=phone;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }


}


