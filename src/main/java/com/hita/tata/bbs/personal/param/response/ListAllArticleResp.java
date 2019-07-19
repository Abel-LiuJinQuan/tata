package com.hita.tata.bbs.personal.param.response;

import com.hita.tata.bbs.personal.entity.ListAllArticleData;

import java.util.List;

public class ListAllArticleResp {
	private Integer total;
	private Integer pageNum;
	private Integer pageSize;
	private List<ListAllArticleData> listAllArticleData;

	public ListAllArticleResp() {
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
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

	public List<ListAllArticleData> getListAllArticleData() {
		return listAllArticleData;
	}

	public void setListAllArticleData(List<ListAllArticleData> listAllArticleData) {
		this.listAllArticleData = listAllArticleData;
	}
}
