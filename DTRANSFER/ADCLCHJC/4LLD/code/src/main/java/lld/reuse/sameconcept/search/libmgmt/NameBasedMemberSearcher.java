package code.src.main.java.lld.reuse.sameconcept.search.libmgmt;

import user.Member;
import java.util.List;

public class NameBasedMemberSearcher implements MemberSearcher {
    private final String memberName;

    public NameBasedMemberSearcher(String memberName) {
        this.memberName = memberName;
    }

    @Override
    public List<Member> search() {
        // TODO Auto-generated method stub
        return null;
    }




}