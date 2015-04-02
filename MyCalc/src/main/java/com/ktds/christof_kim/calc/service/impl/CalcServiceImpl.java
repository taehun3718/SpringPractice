 package com.ktds.christof_kim.calc.service.impl;

import com.ktds.christof_kim.calc.Calc;
import com.ktds.christof_kim.calc.service.CalcService;

public class CalcServiceImpl implements CalcService {

	private Calc calc;
	
	public void setCalc(Calc calc) {
		this.calc = calc;
	}

	@Override
	public void calc() {
		calc.calc();
	}
}