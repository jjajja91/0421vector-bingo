package org.test;

public class PointTest {

	public static void main(String[] args) {

		Point point = new Point();						// 기본 생성자
		Point point2 = new Point(5, 5);					// 매개변수 두개 가진 생성자
		Point point3 = new Point(2, 7);					// equals 비교를 위한 point2와 같은 매개변수를 넣은 point3
		System.out.println(point.toString());			// 기본 생성자로 생성한 인스턴스의 toString 확인
		System.out.println(point2.toString());			// 매개변수 가진 것으로 생성한 인스턴스의 toString 확인
		System.out.println(Point.getDistance(point2, point3));	// static 메서드 getDistance 확인(point와 point2 비교)
		System.out.println(point.getDistance(point2));			// 매개변수 하나 가진 메서드 getDistance 확인(메서드를 호출한 point와 매개변수 point2 비교)
		System.out.println(point.equals(point2));		// equals 확인 (다른 경우)
		System.out.println(point.equals(2));			// 타입 다른 경우 equals 확인
		System.out.println(point2.equals(point3));		// equals 확인 (같은 경우)

		Point3D point3D = new Point3D(3, 4, 5);			// point3D 매개변수 3개
		Point3D point3D2 = new Point3D();				// point3D 기본 생성자
		System.out.println(point3D.toString());			// toString으로 확인
		System.out.println(point3D2.toString());		// toString으로 확인
		
	}

}
