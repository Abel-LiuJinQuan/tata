package com.hita.tata.bbs.block.param.request;

public class GetArticleByBlock {
	private Integer pageNum;
	private Integer pageSize;
	private String blockName;

	public GetArticleByBlock() {
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

	public String getBlockName() {
		return blockName;
	}

	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}
}
