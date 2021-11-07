package model.student;
/**
 * 记录学生成绩
 * */
public class Score {
	Long studentId;
	Integer chinese,maths,english;
	
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public Integer getChinese() {
		return chinese;
	}
	public void setChinese(Integer chinese) {
		this.chinese = chinese;
	}
	public Integer getMaths() {
		return maths;
	}
	public void setMaths(Integer maths) {
		this.maths = maths;
	}
	public Integer getEnglish() {
		return english;
	}
	public void setEnglish(Integer english) {
		this.english = english;
	}
	
}
