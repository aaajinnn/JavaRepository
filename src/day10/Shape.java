package day10;
// Ex07

import java.nio.file.spi.FileSystemProvider;

/*추상클래스란?
 * - 추상메서드를 1개 이상 가진 클래스
 * - 사용하는 이유는> 상속받게할 목적으로 사용=>자식 클래스에서 추상메서드를 강제로 오버라이딩 시키기 위함
 *추상메서드란?
 * - 메서드 몸체 없이 헤더만 선언한 것 
 * 	  void area();
 * */
// 도형클래스
public abstract class Shape { // 도형 ==> 추상클래스

	// 멤버 변수
	private String info = "나는 도형 클래스";

	// 멤버 메서드 => concrete method(구체적으로 구현)
	public String getInfo() {
		return info;
	}

	// public 생략
	// 추상 메서드 => abstract메서드를 가진 클래스 역시 abstract를 붙여야 한다
	abstract void area(int x, int y); // 이런식으로 추상적이여서 몸체를 반환할 수 없는 경우를 말한다.

}//////////////////////

// Shape를 상속받아서 구현해보자
// 상속받은 추상메소드(int, int)를 오버라이드 하여 구현해야만 한다.
class Rectangle extends Shape {
	@Override
	void area(int w, int h) {
		int res = w * h;
		System.out.println("사각형 면적 : " + res);
	}
}/////////////////////

class Triangle extends Shape {
	@Override
	protected void area(int a, int b) {
		int res = (a * b) / 2;
		System.out.println("직삼각형의 면적 : " + res);

	}
}/////////////////////

// 만약 상속을 받았지만 오버라이드를 하지 않을거라면?
// abstract를 붙여 "추상클래스"로 만들어버린다.

abstract class Circle extends Shape {
	final double pi = 3.14; // final => 상수를 만들 때 붙이는 modifier(제한자) / JS의 const와 동일한 기능

}/////////////////////

// 추상클래스로 만든 Circle을 상속받아보자
class SubCircle extends Circle {
	@Override
	public void area(int r, int r2) { // Circle로 부터 물려받은 메서드
	}

	// Override
	public void area(int r) { // Circle로부터 물려받은 SubCircle이 자체적으로 만든 메서드(자식)
		double res = pi * r * r;
		System.out.println("원의 면적 : " + res);
	}
}/////////////////////
