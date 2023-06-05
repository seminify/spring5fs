package org.seminify.spring5fs.spring;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class MemberDao {
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Member> memRowMapper() {
        return (rs, rowNum) -> {
            Member member = new Member(rs.getString("EMAIL"), rs.getString("PASSWORD"), rs.getString("NAME"), rs.getTimestamp("REGDATE").toLocalDateTime());
            member.setId(rs.getLong("ID"));
            return member;
        };
    }

    public MemberDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Member selectByEmail(String email) {
        List<Member> results = jdbcTemplate.query(
                "SELECT * FROM MEMBER WHERE EMAIL = ?",
                memRowMapper(),
                email
        );
        return results.isEmpty() ? null : results.get(0);
    }

    public void insert(Member member) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                con -> {
                    PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO MEMBER (EMAIL, PASSWORD, NAME, REGDATE) VALUES (?, ?, ?, ?)", new String[]{"ID"});
                    preparedStatement.setString(1, member.getEmail());
                    preparedStatement.setString(2, member.getPassword());
                    preparedStatement.setString(3, member.getName());
                    preparedStatement.setTimestamp(4, Timestamp.valueOf(member.getRegisterDateTime()));
                    return preparedStatement;
                },
                keyHolder
        );
        Number keyValue = keyHolder.getKey();
        member.setId(keyValue.longValue());
    }

    public void update(Member member) {
        jdbcTemplate.update(
                "UPDATE MEMBER SET NAME = ?, PASSWORD = ? WHERE EMAIL = ?",
                member.getName(), member.getPassword(), member.getEmail()
        );
    }

    public List<Member> selectAll() {
        return jdbcTemplate.query(
                "SELECT * FROM MEMBER",
                memRowMapper()
        );
    }

    public int count() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM MEMBER", Integer.class);
    }

    public List<Member> selectByRegDate(LocalDateTime from, LocalDateTime to) {
        return jdbcTemplate.query(
                "SELECT * FROM MEMBER WHERE REGDATE BETWEEN ? AND ? ORDER BY REGDATE DESC",
                memRowMapper(),
                from, to
        );
    }

    public Member selectById(Long memId) {
        List<Member> results = jdbcTemplate.query(
                "SELECT * FROM MEMBER WHERE ID = ?",
                memRowMapper(),
                memId
        );
        return results.isEmpty() ? null : results.get(0);
    }
}
