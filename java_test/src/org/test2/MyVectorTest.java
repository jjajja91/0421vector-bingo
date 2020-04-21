package org.test2;

import static org.junit.Assert.assertTrue;

import java.util.Vector;

import org.junit.Test;

public class MyVectorTest {

	 // 2차원 배열 arr의 빙고 갯수를 세어서 반환
	int bingoCheck1(int[][] arr) {
		int cnt = 0;
		boolean isBingo = false;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == 1)
					isBingo = true;
				else {
					isBingo = false;
					break;
				}
			}
			if (isBingo)
				cnt++;
		} 														// 가로 한 줄이 다 맞는지 확인, 다 맞으면 isBingo true, 하나라도 틀리면 false하고 break

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[j][i] == 1)
					isBingo = true;
				else {
					isBingo = false;
					break;
				}
			}
			if (isBingo)
				cnt++;
		} 														// 세로 한 줄이 다 맞는지 확인, 다 맞으면 isBingo true, 하나라도 틀리면 false하고 break

		for (int i = 0; i < arr.length; i++) {
			if (arr[i][i] == 1)
				isBingo = true;
			else {
				isBingo = false;
				break;
			}
		} 														// 우하향 대각 다 맞는지 확인, 다 맞으면 isBingo true, 하나라도 틀리면 false하고 break;
		if (isBingo)
			cnt++;

		for (int i = 0, j = 4; i < arr.length; i++, j--) {
			if (arr[i][j] == 1)
				isBingo = true;
			else {
				isBingo = false;
				break;
			}
		}														// 우상향 대각 다 맞는지 확인, 다 맞으면 isBingo true, 하나라도 틀리면 false하고 break;
		if (isBingo)
			cnt++;

		return cnt;
	}

	int bingoCheck(int[][] arr) {
		int cnt = 0;
		int checkDown = 0;
		int checkUp = 0;
		
		for(int i = 0; i<arr.length; i++){
			if(arr[i][i]==1)							// 우하향 대각선은 배열의 열과 행 번호가 같다는 점을 이용해서 i의 for문에서만 확인하고 checkDown 올려줌
				checkDown++;
			int checkRow = 0;
			int checkCol = 0;							// 가로와 세로는 j가 다 돌면 체크 횟수가 초기화 돼야하므로 i의 for문에서 0으로 선언해줌
			for(int j = 0; j<arr[i].length; j++){
				if(arr[i][j]==1)
					checkRow++;							// i가 고정된 상황에서 i를 열번호로 사용하고 행번호를 증가시키며 확인하여 checkRow 플러스 해줌
				if(arr[j][i]==1)
					checkCol++;							// i가 고정된 상황에서 i를 행번호로 사용하고 열번호를 증가시키며 확인하여 checkCol 플러스 해줌
				if(i+j==arr.length-1){
					if(arr[i][j]==1)
						checkUp++;						// i+j가 배열 사이즈의 -1인 경우가 우상향 대각선이므로 확인하여 checkUp 플러스 해줌
				}
			}
			if(checkRow==arr[i].length)					// checkRow가  arr[i]의 length만큼 증가되었으면 모두 1인 것이므로 cnt를 올려줌
				cnt++;
			if(checkCol==arr[i].length)					// checkCol이 arr[i]의 length만큼 증가되었으면 모두 1인 것이므로 cnt를 올려줌 (row, col 모두 j for문 빠져나갔을 때 확인
				cnt++;
		}
		if(checkDown==arr.length)						// checkDown이 arr의 length만큼 증가되었으면 모두 1인 것이므로 cnt를 올려줌
			cnt++;
		if(checkUp==arr.length)							// checkUp이 arr의 length만큼 증가되었으면 모두 1인 것이므로 cnt를 올려줌 (우하향 우상향 대각선 빙고는 빙고판 전체에 하나씩 존재하므로 i for문 밖에서 확인
			cnt++;

		return cnt;										// 올라간 cnt 리턴
	}
	
	@Test
	public void test5() {
		int[][] arr = { { 1, 1, 1, 1, 1, 1, 1 },
						{ 1, 1, 1, 1, 1, 1, 1 },
						{ 1, 1, 1, 1, 1, 1, 1 },
						{ 1, 1, 1, 1, 1, 1, 1 },
						{ 1, 1, 1, 1, 1, 1, 1 },
						{ 1, 1, 1, 1, 1, 1, 1 },
						{ 1, 1, 1, 1, 1, 1, 1 }};

		assertTrue(bingoCheck(arr) == 16);
	}
	
	@Test
	public void test4() {
		int[][] arr = { { 1, 1, 1, 1, 1 }, 
						{ 1, 1, 1, 1, 1 }, 
						{ 1, 1, 1, 1, 1 }, 
						{ 1, 1, 1, 1, 1 }, 
						{ 1, 1, 1, 1, 1 } };

		assertTrue(bingoCheck(arr) == 12);
	}
	
	@Test
	public void test3() {
		int[][] arr = { { 1, 1, 1, 1, 1 }, 
						{ 1, 1, 0, 0, 0 }, 
						{ 1, 0, 1, 0, 0 }, 
						{ 1, 0, 0, 1, 0 }, 
						{ 1, 0, 0, 0, 1 } };

		assertTrue(bingoCheck(arr) == 3);
	}

	@Test
	public void test2() {
		int[][] arr = { { 1, 1, 1, 1, 1 }, 
						{ 1, 0, 0, 0, 0 }, 
						{ 1, 0, 0, 0, 0 }, 
						{ 1, 0, 0, 0, 0 }, 
						{ 1, 0, 0, 0, 0 } };

		assertTrue(bingoCheck(arr) == 2);
	}

	@Test
	public void test1() {
		int[][] arr = { { 1, 1, 1, 1, 1 }, 
						{ 0, 0, 0, 0, 0 }, 
						{ 0, 0, 0, 0, 0 }, 
						{ 0, 0, 0, 0, 0 }, 
						{ 0, 0, 0, 0, 0 } };

		assertTrue(bingoCheck(arr) == 1);
	}

	
	@Test
	public void vTest3() {

		Vector v = new Vector();
		MyVector v2 = new MyVector(10);
		
		v.add("자바");
		v2.add("자바");
		v.add(null);
		v2.add(null);
		v.add(3);
		v2.add(3);
		v.add(true);
		v2.add(true);
		v.add('c');
		v2.add('c');
			
		assertTrue(v.toString().equals(v2.toString()));
		for(int i = 0; i<v.size(); i++){
			assertTrue(v.get(i)==v2.get(i));
			assertTrue(v.indexOf(v.get(i))==v2.indexOf(v2.get(i)));
		}
		
		
			
		v.remove(3);
		v2.remove(3);
		
		v.remove("자바");
		v2.remove("자바");
		
		v.remove(null);
		v2.remove(null);
		
		assertTrue(v.size()==v2.size());
		assertTrue(v.toString().equals(v2.toString()));
		
		
	}
	
	
	@Test
	public void vTest2() {

		Vector v = new Vector();
		MyVector v2 = new MyVector(10);
		
		assertTrue(v.isEmpty() == v2.isEmpty());
		
		v.add("1");
		v2.add("1");
		
		assertTrue(v.isEmpty() == v2.isEmpty());
		
	}
	
	
	@Test
	public void vTest1() {

		Vector v = new Vector();
		MyVector v2 = new MyVector(10);
		for (int i = 0; i < 1000; i++) {
			v.add("" + i);
			v2.add("" + i);
		}

		assertTrue(v.size() == v2.size());
		assertTrue(v.capacity() == v2.capacity());		

	}

}
