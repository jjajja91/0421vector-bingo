package org.test;

public class Point {

	int x;
	int y;

	// 기본 생성자
	Point() {
		this(1, 1); // Point(1,1) 호출한 것
	}

	// 매개변수가 있는 생성자
	Point(int x, int y) {

		this.x = x;
		this.y = y;

	}

	// 두 사이의 점의 거리를 구해라 (리턴은 double)(매개변수 Point2개)
	static double getDistance(Point p1, Point p2) {

		int a = p1.x - p2.x;
		int b = p1.y - p2.y;

		return Math.sqrt(a * a + b * b);
	}

	// 코드의 중복을 제거하려면, 어느 한 쪽이 다른 쪽을 호출하면 됨
	// 두 사이의 점의 거리를 구해라 (리턴은 double)
	// (getDistance 메서드를 사용하는 인스턴스와 매개변수로 쓰는 인스턴스의 거리)
	double getDistance(Point p) {

		return getDistance(this, p);

	}

	@Override
	public String toString() {
		return "[x=" + x + ", y=" + y + "]";
	}

	// 일단 instanceof로 형변환 가능한지 체크
	// 되면 다운캐스팅
	// 안되면 false, 되면 x점, y점 비교해서 같으면 true
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Point))
			return false;
		Point point = (Point) obj;
		return this.x == point.x && this.y == point.y;
	}

}
