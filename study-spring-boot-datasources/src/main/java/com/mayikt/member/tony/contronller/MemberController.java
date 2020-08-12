package com.mayikt.member.tony.contronller;

import com.mayikt.member.tony.entity.Member;
import com.mayikt.member.tony.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;

    @RequestMapping("/addMember")
    public Map addMember(Member member) {
        return memberService.addMember(member);
    }
}
