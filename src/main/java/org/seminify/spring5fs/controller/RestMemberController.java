package org.seminify.spring5fs.controller;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.seminify.spring5fs.spring.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RestMemberController {
    @Autowired
    private MemberDao memberDao;
    @Autowired
    private MemberRegisterService memberRegisterService;

    @GetMapping("/api/members")
    public List<Member> members() {
        return memberDao.selectAll();
    }

    @GetMapping("/api/members/{id}")
    public ResponseEntity<Object> member(@PathVariable Long id, HttpServletResponse httpServletResponse) throws IOException {
        Member member = memberDao.selectById(id);
        if (member == null) {
            throw new MemberNotFoundException();
        }
        return ResponseEntity.status(HttpStatus.OK).body(member);
    }

    @PostMapping("/api/members")
    public ResponseEntity<Object> newMember(@RequestBody @Valid RegisterRequest registerRequest, Errors errors) {
        if (errors.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("errorCodes = " + errors.getAllErrors().stream().map(objectError -> objectError.getCodes()[0]).collect(Collectors.joining(","))));
        try {
            return ResponseEntity.created(URI.create("/api/members/" + memberRegisterService.regist(registerRequest))).build();
        } catch (DuplicateMemberException dupEx) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
