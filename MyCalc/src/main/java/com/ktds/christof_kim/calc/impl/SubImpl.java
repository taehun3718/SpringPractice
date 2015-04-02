package com.ktds.christof_kim.calc.impl;

import java.util.Scanner;

import com.ktds.christof_kim.calc.Calc;

public class SubImpl implements Calc {

	@Override
	public void calc() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("숫자를 입력 하세요 :");
		int num1 = scanner.nextInt();
		
		System.out.println("숫자를 입력 하세요 :");
		int num2 = scanner.nextInt();
		
		System.out.println("숫자를 입력 하세요 :");
		int num3 = scanner.nextInt();
		
		System.out.println("세 결과의 빼기:" + (num1 - num2 - num3) );
		
		
	}
}
