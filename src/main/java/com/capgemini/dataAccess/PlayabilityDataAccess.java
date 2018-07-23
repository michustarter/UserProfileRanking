package com.capgemini.dataAccess;

public class PlayabilityDataAccess {

	private int fromHour;
	private int upToHour;
	private String comment;

	public int getFromHour() {
		return fromHour;
	}

	public void setFromHour(int fromHour) {
		this.fromHour = fromHour;
	}

	public int getUpToHour() {
		return upToHour;
	}

	public void setUpToHour(int upToHour) {
		this.upToHour = upToHour;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public PlayabilityDataAccess(int fromHour, int upToHour, String comment) {
		this.fromHour = fromHour;
		this.upToHour = upToHour;
		this.comment = comment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + fromHour;
		result = prime * result + upToHour;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlayabilityDataAccess other = (PlayabilityDataAccess) obj;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (fromHour != other.fromHour)
			return false;
		if (upToHour != other.upToHour)
			return false;
		return true;
	}
	

}