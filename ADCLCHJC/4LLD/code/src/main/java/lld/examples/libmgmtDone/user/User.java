package code.src.main.java.lld.examples.libmgmtDone.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

//revise abstract class
@Getter
@RequiredArgsConstructor
public abstract class User {
    private final int id;
    private final String name;
   
}
