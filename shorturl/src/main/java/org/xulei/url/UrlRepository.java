package org.xulei.url;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UrlRepository {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

	@Transactional(readOnly = true)
    public long generalUrlId() {
        return jdbcTemplate.queryForObject("SELECT SEQ_URL_ID.NEXTVAL FROM DUAL", Long.class);
    }

    @Transactional(readOnly = true)
    public Url findUrlByCode(final String  code) {
        return jdbcTemplate.queryForObject("SELECT * FROM URL WHERE CODE=?", new Object[]{code}, new UrlRowMapper());
    }

    public Url create(final Url url) {
        final String sql = "INSERT INTO URL(URL_ID,CODE,LONG_URL,CREATE_TIME,SYS_ID,CUST_ID,TRACE_CODE) VALUES(?,?,?,?,?,?,?)";
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection)
                    throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setLong(1, url.getUrlId());
                ps.setString(2, url.getCode());
                ps.setString(3, url.getLongUrl());
                //
                java.util.Date date = new java.util.Date();
                java.sql.Timestamp time = new java.sql.Timestamp(date.getTime());
                ps.setTimestamp(4, time);
                //
                ps.setInt(5, url.getSysId());
                ps.setString(6, url.getCustId());
                ps.setString(7, url.getTraceCode());
                return ps;
            }
        });
        return url;
    }
    
    public UrlVisitlog createUrlVisitlog(final UrlVisitlog log) {
        final String sql = "INSERT INTO URL_VISIT_LOG(CODE,SYS_ID,CUST_ID,TRACE_CODE,VISIT_TIME,IP,User_Agent,Cookie) VALUES(?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection)
                    throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, log.getCode());
                ps.setInt(2, log.getSysId());
                ps.setString(3, log.getCustId());
                ps.setString(4, log.getTraceCode());
                //
                java.util.Date date = new java.util.Date();
                java.sql.Timestamp time = new java.sql.Timestamp(date.getTime());
                ps.setTimestamp(5, time);
                //
                ps.setString(6,log.getIp());
                ps.setString(7, log.getUserAgent());
                ps.setString(8, log.getCookie());
                return ps;
            }
        });
        return log;
    }

    class UrlRowMapper implements RowMapper<Url> {

        @Override
        public Url mapRow(ResultSet rs, int rowNum) throws SQLException {
            Url Url = new Url();
            Url.setUrlId(rs.getLong("URL_ID"));
            Url.setCode(rs.getString("CODE"));
            Url.setLongUrl(rs.getString("LONG_URL"));
            Url.setCreateTime(rs.getDate("CREATE_TIME"));
            Url.setSysId(rs.getInt("SYS_ID"));
            Url.setCustId(rs.getString("CUST_ID"));
            Url.setTraceCode(rs.getString("TRACE_CODE"));
            return Url;
        }
    }
}
