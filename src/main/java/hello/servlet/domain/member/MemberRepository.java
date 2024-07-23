package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {

    private Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0;

    private static final MemberRepository instance = new MemberRepository();


    /*
     * 싱글톤 객체 반환하는 메서드임. static 메서드로 작성해야함.
     * 그런데 롬복 '@Getter' 사용하면 static이 아닌 일반 메서드로 만들어줌.
     * 따라서 여기서는 직접 작성한 아래 메서드를 사용해야함.
     * 롬복 게터 사용하라는 메시지 그냥 씹어라!
     */
    public static MemberRepository getInstance() {
    return instance;
}

/*일반 생성자*/
    private MemberRepository() {
    }

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(long id) {
        return store.get(id);
    }

    /**
     * MemberRepository는 싱글톤 패턴으로 구현되어 하나의 인스턴스만 있음.
     * 애플리케이션 전역에서 동일한 데이터 저장소(store)를 공유.
     * 따라서 store을 보호해야하는데, 만약 여기서 store 자체를 반환하면 외부에서 수정할 가능성이 생긴다.
     * 따라서 store의 value를 담은 ArrayList 객체를 새로 만들어서 반환해준다.
     * 이러면 외부에서 arrayList를 변경해도 store에는 아무런 영향이 없다.
     */
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }


}
