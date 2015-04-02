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

	//실제 로직에서 어떤 클래스가 로드되었는지 확인하기 위해
	//instanceof 연산자를 사용해서 확인한다.
	@Override
	public int calc(int num1, int num2) {
		if(calc instanceof Sum){
			System.out.println("더하기 입니다.");
		}
		else if(calc instanceof Min){
			System.out.println("빼기 입니다.");
		}
		else if(calc instanceof Mul){
			System.out.println("곱하기 입니다.");
		}
		else if(calc instanceof Div){
			System.out.println("나누기 입니다.");
		}
		return calc.calc(num1, num2);
	}
}
