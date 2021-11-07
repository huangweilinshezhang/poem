package model.student;

import java.util.List;

public class Poem {
	private Long id;//主键
	private String title;//诗词名称
	private String dynasty;//朝代
	private int poemId;//作者id
	private String content;//内容
	private String type;//诗词类型
	
	
	List<Poem> poemList;//一对多dto:poem-auther
	
	public List<Poem> getPoemList() {
		return poemList;
	}
	public void setPoemList(List<Poem> poemList) {
		this.poemList = poemList;
	}
	public int getPoemId() {
		return poemId;
	}
	public void setPoemId(int poemId) {
		this.poemId = poemId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDynasty() {
		return dynasty;
	}
	public void setDynasty(String dynasty) {
		this.dynasty = dynasty;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
