package org.hys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository
public class VoteDao {
	
	static final String ADD_VOTE = "INSERT vote(pollId,userId,name,choice) VALUES(?,?,?,?)";
	
	static final String LIST_VOTE = "SELECT pollId,userId,name,choice From vote Where pollId = ?";
	
	static final String GET_AVERAGE = "SELECT avg(choice) FROM vote WHERE pollId=?";
	
	RowMapper<Vote> voteRowMapper = new BeanPropertyRowMapper<>(Vote.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public int addVote(Vote vote) {
		return jdbcTemplate.update(ADD_VOTE, vote.getPollId(), vote.getUserId(),
				vote.getName(), vote.getChoice());
	}

	public List<Vote> listVotes(String pollId) {
		return jdbcTemplate.query(LIST_VOTE, voteRowMapper, pollId);
	}

	public double getAverage(String pollId) {
		return jdbcTemplate.queryForObject(GET_AVERAGE, Double.class, pollId);
	}
}
