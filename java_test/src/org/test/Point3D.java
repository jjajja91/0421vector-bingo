package org.test;

public class Point3D extends Point {

	// 상속 받고 변수 하나 추가
	int z;

	// 기본 생성자
	public Point3D() {
		this(1, 1, 1);
	}

	// 매개변수 가진 생성자
	public Point3D(int x, int y, int z) {
		super(x, y);						// 조상 멤버는 조상 생성자로 초기화 하는 것이 맞음
		this.z = z;
	}

	@Override
	public String toString() {
		return super.toString()+", z=" + z + "]";
	}

}
