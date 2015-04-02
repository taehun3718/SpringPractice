package com.ktds.christof_kim.calc.impl;

import java.util.Scanner;

import com.ktds.christof_kim.calc.Calc;

public class MulImpl implements Calc {

	@Override
	public void calc() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("숫자를 입력 하세요 :");
		int num1 = scanner.nextInt();
		
		System.out.println("숫자를 입력 하세요 :");
		int num2 = scanner.nextInt();
		
		System.out.println("숫자를 입력 하세요 :");
		int num3 = scanner.nextInt();
		
		System.out.println("숫자를 입력 하세요 :");
		int num4 = scanner.nextInt();
		
		System.out.println("네 결과의 곱하기:" + (num1 * num2 * num3 * num4));
	}
}
