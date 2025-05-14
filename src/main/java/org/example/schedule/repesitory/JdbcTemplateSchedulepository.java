package org.example.schedule.repesitory;

import org.example.schedule.dto.ScheduleResponseDto;
import org.example.schedule.entity.Schedule;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import javax.sql.DataSource;
import java.awt.image.Kernel;
import java.security.Key;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class JdbcTemplateSchedulepository implements ScheduleRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateSchedulepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public ScheduleResponseDto saveschedule(Schedule schedule) {
        SimpleJdbcInsert jdbcInsert =  new SimpleJdbcInsert (jdbcTemplate);

        jdbcInsert.withCatalogName("schedule").withTableName("schedule").usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name",schedule.getName());
        parameters.put("password",schedule.getPassword());
        parameters.put("verifyPassword",schedule.getVerifyPassword());
        parameters.put("title",schedule.getTitle());
        parameters.put("contents",schedule.getContents());
        parameters.put("email",schedule.getEmail());
        parameters.put("date",schedule.getDate());
        parameters.put("time",schedule.getTime());

        Number number = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));


        return new ScheduleResponseDto(number.longValue(),schedule.getName(),schedule.getPassword(),
                schedule.getVerifyPassword(),schedule.getTitle(),schedule.getContents(),
                schedule.getDate(),schedule.getTime());
    }

    @Override
    public List<ScheduleResponseDto> findSchedules() {
        return jdbcTemplate.query("select*from schedule",scheduleRowMapper());
    }

    @Override
    public Optional<Schedule> findMemoById(Long id) {
        List<Schedule> result = jdbcTemplate.query("select*from Schedule where id = ?", scheduleRowMapper2(), id);

        return result.stream().findAny();
    }

    @Override
    public Schedule saveScheduleEmail(Schedule schedule) {
        return null;
    }

    @Override
    public int updateScheduleEmail(Long id,String email) {
        return jdbcTemplate.update("update Schedule set email = ? where id = ?",email,id);
    }

    @Override
    public int deleteSchedule(Long id) {
        return jdbcTemplate.update("delete from Schedule  where id = ?", id);
    }

    @Override
    public int updateSchedule(Long id, String name,String contents) {
        return jdbcTemplate.update("update Schedule set name = ?,contents =? where id =?",name,contents,id);
    }//입력받은 값을 가지고 업데이트 시킨다.

    @Override
    public Schedule findMemoByIdOrElseThrow(Long id) {
        List<Schedule> result = jdbcTemplate.query("select*from Schedule where id = ?", scheduleRowMapper2(), id);
        return result.stream().findAny().orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"없는값입니다."));
    }

    private RowMapper<ScheduleResponseDto> scheduleRowMapper(){
        return new RowMapper<ScheduleResponseDto>() {
            @Override
            public ScheduleResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new ScheduleResponseDto(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getLong("password"),
                        rs.getLong("verifyPassword"),
                        rs.getString("title"),
                        rs.getString("contents"),
                        rs.getString("email"),
                        rs.getDate("date").toLocalDate(),
                        rs.getTime("time").toLocalTime());
            }
        };
    }

    private RowMapper<Schedule> scheduleRowMapper2(){
        return new RowMapper<Schedule>() {
            @Override
            public Schedule mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Schedule(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getLong("password"),
                        rs.getLong("verifyPassword"),
                        rs.getString("title"),
                        rs.getString("contents"),
                        rs.getString("email"),
                        rs.getDate("date").toLocalDate(),
                        rs.getTime("time").toLocalTime());
            }
        };
    }
}
