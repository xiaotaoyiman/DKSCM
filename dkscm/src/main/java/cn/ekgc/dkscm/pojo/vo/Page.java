package cn.ekgc.dkscm.pojo.vo;

import java.io.Serializable;
import java.util.List;

import cn.ekgc.dkscm.util.ConstantUtil;

/**
 * <b>系统分页视图对象</b>
 * @param <E>
 * @author Arthur
 * @version 1.0.0
 * @since 2019-11-07
 */
public class Page<E> implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer pageNum;			// 当前页码
	private Integer pageSize;			// 每页显示数量
	private Integer begin;				// 开始下标
	private Integer size;				// 连续查询数量
	private List<E> list;				// 分页查询列表
	private Long totalSize;				// 总条数
	private Long totalPage;				// 总页数
	private Integer draw;
	
	public Page() {}
	public Page(Integer pageNum, Integer pageSize, Integer draw) {
		if (pageNum != null && pageNum > 0) {
			this.pageNum = pageNum;
		} else {
			this.pageNum = ConstantUtil.PAGE_NUM;
		}
		
		if (pageSize != null && pageSize > 0) {
			this.pageSize = pageSize;
		} else {
			this.pageSize = ConstantUtil.PAGE_SIZE;
		}
		this.draw = draw;
		
		// 根据当前分页情况获取对应的MySQL查询信息
		this.begin = (this.pageNum - 1) * this.pageSize;
		this.size = this.pageSize;
	}
	
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getBegin() {
		return begin;
	}
	public void setBegin(Integer begin) {
		this.begin = begin;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public List<E> getList() {
		return list;
	}
	public void setList(List<E> list) {
		this.list = list;
	}
	public Long getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(Long totalSize) {
		this.totalSize = totalSize;
	}
	public Long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}
	
	public Integer getDraw() {
		return draw;
	}
	public void setDraw(Integer draw) {
		this.draw = draw;
	}
	
	public void setTotalPage() {
		this.totalPage = (this.totalSize % this.pageSize == 0) ? (this.totalSize / this.pageSize) 
				: (this.totalSize / this.pageSize) + 1;
	}
}
