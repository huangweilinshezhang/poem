package model.student;

import java.util.List;

/**记录批量学生的成绩*/
public class ScoreListVo {
	List<Score> data;

	public List<Score> getData() {
		return data;
	}

	public void setData(List<Score> data) {
		this.data = data;
	}
}
