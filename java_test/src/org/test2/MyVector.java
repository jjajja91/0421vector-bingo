package org.test2;

public class MyVector {

	// Object 배열 objArr을 인스턴스 변수로 갖는 MyVector 클래스

	int capacity;
	Object[] objArr;
	int size; // obArr에 저장된 객체의 개수를 저장하기 위한 인스턴스 변수

	// capacity를 16으로 갖는 기본 생성자
	public MyVector() {
		this(16);
	}

	// capacity를 매개변수로 갖는 생성자
	public MyVector(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		this.objArr = new Object[capacity];
	}

	// objArr에 저장된 객체의 개수인 인스턴스 변수 size를 반환하는 메서드
	public int size() {
		return this.size;
	}

	// 배열 objArr의 길이인 인스턴스 변수 capacity를 반환하는 메서드
	public int capacity() {
		return this.capacity;
	}

	// 객체배열이 비었는지 확인하는 메서드
	public boolean isEmpty() {
		if (this.size == 0) {
			return true;
		} else {
			return false;
		}
	}

	// objArr에 객체를 추가하는 메서드
	// 저장할 수 없으면 사이즈 만큼 capacity 늘린 새로운 배열만들기
	// 기존꺼 복사한걸 새로운 배열에 넣어주고 마지막에 추가할 오브젝트 넣기
	public void add(Object obj) {
		if (size < capacity) {
			objArr[size++] = obj;
		} else {
			Object[] objtmp = objArr;
			capacity = size * 2;
			objArr = new Object[capacity];
			for (int i = 0; i < objtmp.length; i++) {
				objArr[i] = objtmp[i];
			}
			objArr[size - 1] = obj;
			size++;
		}
	}

	// objArr에 저장된 객체를 반환하는 메서드
	public Object get(int index) {
		return objArr[index];
	}

	// objArr에 저장된 모든 객체를 문자열로 이어서 반환하도록 toString 오버라이딩
	// size 만큼만 출력 (마지막 꺼는 콤마를 붙여주지 않음) (반대로 처음꺼 콤마 안붙이고 각 문자열 앞에 콤마를 붙여도 됨)
	@Override
	public String toString() {
		String str = "";
		for (int i = 0; i < size; i++) {
			if (objArr[i] != null) {
				str += objArr[i].toString();
			} else {
				str += "null";
			}
			str += (i == size - 1 ? "" : ", ");
		}
		return "[" + str + "]";
	}

	// objArr에서 지정된 객체가 저장되어 있는 위치인 index를 반환하는 메서드
	// objArr의 i번지가 null인 경우에 continue
	// objArr의 i번지가 null이고 obj도 null인 경우에 i번지 리턴
	// 없으면 -1 리턴
	public int indexOf(Object obj) {
		for (int i = 0; i < size; i++) {
			if (objArr[i] == null && obj == null) {
				return i;
			}
			if (objArr[i] == null) {
				continue;
			}
			if (objArr[i].equals(obj)) {
				return i;
			}
		}
		return -1;
	}

	// indexOf를 활용하여 objArr에서 지정된 객체를 삭제하는 메서드
	// 하나씩 당겨주고 마지막 null 넣어준 후 size 줄여주기 true 리턴
	// indexof 사용하기 때문에 index가 -1이면 false 리턴
	// 아래의 index 번호로 삭제하는 메서드를 활용
	public boolean remove(Object obj) {
		int index = indexOf(obj);
		return remove(index);
	}

	// index 번호로 삭제하고 싶은 경우 만들어줌
	public boolean remove(int index) {
		if (index > size || index < 0)
			return false;
		for (int i = index; i < size - 1; i++) {
			objArr[i] = objArr[i + 1];
		}
		objArr[size - 1] = null;
		size--;
		return true;
	}

}
