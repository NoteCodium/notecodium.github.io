package code.src.main.java.lld.designpatterns.builder;

public class Main {
    public static void main(String[] args) {
        //this is important, although User is not static, Builder, its inner class
        //is static

        // User.Builder builder=
        //     new User.Builder("Tarun");

        // builder.setPhone("9450");
        // User user=
        //     new User(builder);

        // User user=
        //     new User
        //         .Builder("Tarun")
        //         .setPhone("9450")
        //         .build();


        User user=
                new User
                    .Builder("Tarun")
                    .phone("9450")
                    .build();

    }
}


