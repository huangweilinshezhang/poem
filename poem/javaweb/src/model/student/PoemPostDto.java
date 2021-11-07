package model.student;

import java.util.List;

public class PoemPostDto {
	private Long id;//主键
	private String title;//诗词名称
	private String dynasty;//朝代
	private String poet;
	private String content;//内容
	private String msg;
	private int PoemId;
	private String auther;
	private String type;
	private int total;//总共数据有
	private String page;//总共页数
	private String count;//总共多少条
	private String begin;
	private String end;
	
	
	public String getBegin() {
		return begin;
	}
	public void setBegin(String begin) {
		this.begin = begin;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAuther() {
		return auther;
	}
	public void setAuther(String auther) {
		this.auther = auther;
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
	public String getPoet() {
		return poet;
	}
	public void setPoet(String poet) {
		this.poet = poet;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getPoemId() {
		return PoemId;
	}
	public void setPoemId(int poemId) {
		PoemId = poemId;
	}
	
	
}
