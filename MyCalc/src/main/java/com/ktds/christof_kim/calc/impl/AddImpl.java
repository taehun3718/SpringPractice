package com.ktds.christof_kim.calc.impl;

import java.util.Scanner;

import com.ktds.christof_kim.calc.Calc;

public class AddImpl implements Calc {

	@Override
	public void calc() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("숫자를 입력 하세요 :");
		int num1 = scanner.nextInt();
		
		System.out.println("숫자를 입력 하세요 :");
		int num2 = scanner.nextInt();
		
		System.out.println("두 결과의 합:" + (num1 + num2) );
		
		
	}
}
