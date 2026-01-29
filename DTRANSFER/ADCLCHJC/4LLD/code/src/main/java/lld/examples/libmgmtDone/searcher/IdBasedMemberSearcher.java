package code.src.main.java.lld.examples.libmgmtDone.searcher;

import user.Member;
import java.util.List;

public class IdBasedMemberSearcher implements MemberSearcher {

    private final int id;
    public IdBasedMemberSearcher(int id) {
        this.id = id;
    }


    @Override
    public List<Member> search(){
        return null;
    }


}