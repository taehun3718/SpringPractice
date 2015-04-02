package com.ktds.pratice.biz;

import com.ktds.pratice.dao.DIPracticeDao;

public class DIPracticeBizImpl implements DIPracticeBiz {

	public DIPracticeDao diPraticeDao;
	
	@Override
	public String getSomeString() {
		return diPraticeDao.getSomeString();
	}

	@Override
	public void setDiPracticeDao(DIPracticeDao diPracticeDao) {
		this.diPraticeDao = diPracticeDao;
	}
}
