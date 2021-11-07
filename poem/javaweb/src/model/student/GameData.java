package model.student;

public class GameData {
	private String title;
	private String auther;
	private String dynater;
	private boolean flag;
	
	private String suggestiveVerse;
	private String trueAnswer;
	private String[] choose;
	
	
	
	public String getSuggestiveVerse() {
		return suggestiveVerse;
	}
	public void setSuggestiveVerse(String suggestiveVerse) {
		this.suggestiveVerse = suggestiveVerse;
	}
	
	public String getTrueAnswer() {
		return trueAnswer;
	}
	public void setTrueAnswer(String trueAnswer) {
		this.trueAnswer = trueAnswer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuther() {
		return auther;
	}
	public void setAuther(String auther) {
		this.auther = auther;
	}
	public String getDynater() {
		return dynater;
	}
	public void setDynater(String dynater) {
		this.dynater = dynater;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public String[] getChoose() {
		return choose;
	}
	public void setChoose(String[] choose) {
		this.choose = choose;
	}
	
	
}
