package com.jyhun.shop.service;

import com.jyhun.shop.dto.MemberResponseDTO;
import com.jyhun.shop.entity.Member;
import com.jyhun.shop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public MemberResponseDTO findMemberById(Long id){
        Member member = memberRepository.findById(id).orElse(null);
        return MemberResponseDTO.toDTO(member);
    }

    @Transactional(readOnly = true)
    public MemberResponseDTO findMemberByEmail(String email){
        Member member = memberRepository.findByEmail(email).orElse(null);
        return MemberResponseDTO.toDTO(member);
    }

}
