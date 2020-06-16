package po;

import java.util.List;

public class Page<T> {

	public Page() {
		// TODO Auto-generated constructor stub
	}
	private int PageNo;
	public static final int show_items = 4;
	private int CountNo;
	private int TotalNo;//一共有多少页码
	private List<T> list;

	public int getPageNo() {
		if(PageNo < 1) {
			return 1;
		}
		if(PageNo>getTotalNo()) {
			if(getTotalNo()==0) {
				return 1;
			}
			else return getTotalNo();
		}
		return PageNo;
		
	}

	public void setPageNo(int pageNo) {
		this.PageNo = pageNo;
	}

	public int getCountNo() {
		return CountNo;
	}

	public void setCountNo(int countNo) {
		CountNo = countNo;
	}


	public int getTotalNo() {
		if(getCountNo() % show_items == 0) {
			return getCountNo() / show_items;
			
		}
		return getCountNo() / show_items + 1;
		
	}
	 
	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Page [PageNo=" + PageNo + ", CountNo=" + CountNo + ", TotalNo=" + TotalNo + "]";
	}


}
