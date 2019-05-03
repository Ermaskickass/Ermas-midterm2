package org.hys;

public class Vote {
	String pollId;
	String userId;
	String name;
	String choice;
	
	
	public String getPollId() {
		return pollId;
	}


	public void setPollId(String pollId) {
		this.pollId = pollId;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String uesrId) {
		this.userId = uesrId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getChoice() {
		return choice;
	}


	public void setChoice(String choice) {
		this.choice = choice;
	}


	@Override
	public String toString() {
		return "Vote [pollId=" + pollId + ", uesrId=" + userId + ", name=" + name + ", choice=" + choice + "]\n";
	}
	
	

}
