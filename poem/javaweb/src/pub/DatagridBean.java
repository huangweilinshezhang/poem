package pub;

import java.util.List;

/**封装给数据表格easyui-datagrid使用的数据*/
//{"total":1,"rows":[{"id":12,"name":"abc"}] }
public class DatagridBean {
	protected int total;//数据库里面一共有多少条数据
	protected List rows;
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
	
}
