package model;

import java.io.Serializable;

public class SiteEV implements Serializable {

	private int like;
	private int dislike;
	
	public SiteEV() {
		like = 0;
		dislike = 0;
	}
	
	public int getLike() {
		return like;
	}
	
	public int getdisLike() {
		return dislike;
	}
	
	public void setLike(int num) {
		this.like = num;
	}
	
	public void setDisLike(int num) {
		this.dislike = num;
	}
	
}
