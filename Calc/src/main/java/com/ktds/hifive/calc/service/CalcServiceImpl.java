package com.ktds.hifive.calc.service;

import com.ktds.hifive.calc.Calc;
import com.ktds.hifive.calc.Div;
import com.ktds.hifive.calc.Min;
import com.ktds.hifive.calc.Mul;
import com.ktds.hifive.calc.Sum;

public class CalcServiceImpl implements CalcService {

	private Calc calc;
	
	public void setCalc(Calc calc) {
		this.calc = calc;
	}

	//���� �������� � Ŭ������ �ε�Ǿ����� Ȯ���ϱ� ����
	//instanceof �����ڸ� ����ؼ� Ȯ���Ѵ�.
	@Override
	public int calc(int num1, int num2) {
		if(calc instanceof Sum){
			System.out.println("���ϱ� �Դϴ�.");
		}
		else if(calc instanceof Min){
			System.out.println("���� �Դϴ�.");
		}
		else if(calc instanceof Mul){
			System.out.println("���ϱ� �Դϴ�.");
		}
		else if(calc instanceof Div){
			System.out.println("������ �Դϴ�.");
		}
		return calc.calc(num1, num2);
	}
}
