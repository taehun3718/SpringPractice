package com.ktds.christof_kim.calc.impl;

import java.util.Scanner;

import com.ktds.christof_kim.calc.Calc;

public class SubImpl implements Calc {

	@Override
	public void calc() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("���ڸ� �Է� �ϼ��� :");
		int num1 = scanner.nextInt();
		
		System.out.println("���ڸ� �Է� �ϼ��� :");
		int num2 = scanner.nextInt();
		
		System.out.println("���ڸ� �Է� �ϼ��� :");
		int num3 = scanner.nextInt();
		
		System.out.println("�� ����� ����:" + (num1 - num2 - num3) );
		
		
	}
}
