package com.ktds.pratice.biz.factory;

import com.ktds.pratice.biz.DIPracticeBiz;
import com.ktds.pratice.biz.DIPracticeBizImpl;
import com.ktds.pratice.dao.DIPracticeDaoImpl;

public class DIPracticeBizFactory {

	public static DIPracticeBiz getDIPracticeBizFactory() {
		DIPracticeBiz diPractiveBiz = new DIPracticeBizImpl();
		diPractiveBiz.setDiPracticeDao(new DIPracticeDaoImpl());
		return diPractiveBiz;
	}
}
