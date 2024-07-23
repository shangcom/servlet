package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberRepositoryTest {

  MemberRepository memberRepository = MemberRepository.getInstance();

  @AfterEach
  void afterEach() {
      memberRepository.clearStore();
  }

    @Test
    void save() {
        // Arrange
        // TODO: Initialize test data
        Member member = new Member("kim", 20);

        // Act
        // TODO: Call the method to be tested
        memberRepository.save(member);

        // Assert
        // TODO: Verify the results
        assertThat(member).isEqualTo(memberRepository.findById(member.getId()));
    }

    @Test
    void findAll() {
        // Arrange
        // TODO: Initialize test data
        Member member1 = new Member("park", 20);
        Member member2 = new Member("kim", 30);
        Member member3 = new Member("lee", 40);


        // Act
        // TODO: Call the method to be tested
        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);

        List<Member> list = new ArrayList<>();
        list.add(member1);
        list.add(member2);
        list.add(member3);


        // Assert
        // TODO: Verify the results

        assertThat(list).containsExactlyElementsOf(memberRepository.findAll());
    }
}
