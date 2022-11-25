package jpabook.jpashop;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public Long save(Member member) {
        em.persist(member);
        return member.getId();
        // getId만 반환하는 이유는 커맨드와 쿼리를 분리하기 위함(사이드 이펙트를 일으키는 커맨드성 작업은 피할 것)
    }

    public Member find(Long id) {
        return em.find(Member.class, id);
    }

}
