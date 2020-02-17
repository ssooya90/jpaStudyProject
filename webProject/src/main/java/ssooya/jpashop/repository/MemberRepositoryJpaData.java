package ssooya.jpashop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import ssooya.jpashop.domain.Member;

import java.util.List;

/**
 * Created by ssooya90@naver.com on 2020-02-18
 * Github : http://github.com/ssooya90
 */
public interface MemberRepositoryJpaData extends JpaRepository<Member, Long> {

	List<Member> findByUsername(@Param("username") String username);
}
