package com.gjih.recentnewsbystock.service;

import com.gjih.recentnewsbystock.entity.Member;
import com.gjih.recentnewsbystock.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     * 회원 가입
     */
    @Transactional
    public Long join(Member member) {
        //validateDuplicateUsername(member.getUsername()); // 회원 아이디 중복 검증
        //validateDuplicateEmail(member.getEmail()); // 이메일 중복 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateUsername(String username) {
        List<Member> findMembers = memberRepository.findByUsername(username);
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 아이디입니다.");
        }
    }

    private void validateDuplicateEmail(String email) {
        List<Member> findMembers = memberRepository.findByEmail(email);
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 가입된 이메일입니다.");
        }
    }

}
