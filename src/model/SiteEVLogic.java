package model;

public class SiteEVLogic {

	
	public SiteEVLogic() {

	}
	
	
	public void addLike(SiteEV ev) {
		int like = ev.getLike();
		ev.setLike(like + 1);
	}
	
	public void addDisLike(SiteEV ev) {
		int dislike = ev.getdisLike();
		ev.setDisLike(dislike + 1); 
	}
	
}
