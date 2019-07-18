package com.hita.tata.bbs.block.param.response;

import java.util.List;

public class GetArticleByBlockResp {
	private Integer total;
	private List<ArticleListInform> articleList;
	private Integer pageNum;
	private Integer pageSize;


	public GetArticleByBlockResp() {
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<ArticleListInform> getArticleList() {
		return articleList;
	}

	public void setArticleList(List<ArticleListInform> articleList) {
		this.articleList = articleList;
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
}
