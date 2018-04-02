package jombie.View;

import java.io.PrintWriter;
import java.util.ArrayList;

import jombie.Model.User;

public class Map {
	protected int mapSize_y;
	protected int mapSize_x;

	public Map(int y, int x) {
		mapSize_y = y;
		mapSize_x = x;
	}

	public void drawMap(ArrayList<User> userList) {
		// sparseMatrix ���ø��� �� �� ����.
		int last_y = -1;
		int last_x = -1;
		// �� ��� ������ : ���� ��ǥ�� �ߺ� �� ��� �ߺ��ؼ� ��� �����.
		String dot;
		for (User user : userList) {
			int currentUserPosition_y = user.getUserLocation().getLocationY();
			int currentUserPosition_x = user.getUserLocation().getLocationX();
			// �ߺ��Ǵ� ��� ������� �������� ����
			// ����� ó���ߴ����� �� �𸣰ڴµ�, �ϴ� ȭ�鿡 �ߺ������� �ʴ´�.
			// ������ �����Ŷ�� �����ߴµ�, �ƴϳ�..
			if (last_y == currentUserPosition_y && last_x == currentUserPosition_x) {
				continue;
			} else {
				last_x++;
			}
			if (last_y == -1) {
				last_y = 0;
			}

			for (; last_y < currentUserPosition_y; last_y++, last_x = 0) {
				dot = "";
				for (; last_x < mapSize_x; last_x++) {
					dot += ". ";
				}
				System.out.println(dot);
			}
			dot = "";
			for (; last_x < currentUserPosition_x; last_x++) {
				dot += ". ";
			}
			System.out.print(dot);
//			System.out.print(user.isDead()? ". " : "* ");
			
			// �������� �̸��� ù ���ڸ� ǥ��
			System.out.print(user.isDead()? ". " : user.getUserName().charAt(0) + " ");
		}
		++last_x;
		for (; last_y < mapSize_y; last_y++, last_x = 0) {
			dot = "";
			for (; last_x < mapSize_x; last_x++) {
				dot += ". ";
			}
			System.out.println(dot);
		}
		System.out.println();
	}

	/**
	 * User�� �°� ���� ������
	 * ����� ���� �� �� �ְ�, ����� ����� �� �� ����.
	 */
	public void drawMap(ArrayList<User> userList, boolean isJombie, ArrayList<User> nearEnemy) {
		int last_y = -1;
		int last_x = -1;
		String dot;
		
		for (User user : userList) {
			int currentUserPosition_y = user.getUserLocation().getLocationY();
			int currentUserPosition_x = user.getUserLocation().getLocationX();
			// �ߺ��Ǵ� ��� ������� �������� ����
			// ����� ó���ߴ����� �� �𸣰ڴµ�, �ϴ� ȭ�鿡 �ߺ������� �ʴ´�.
			// ������ �����Ŷ�� �����ߴµ�, �ƴϳ�..
			if (last_y == currentUserPosition_y && last_x == currentUserPosition_x) {
				continue;
			} else {
				last_x++;
			}
			if (last_y == -1) {
				last_y = 0;
			}

			for (; last_y < currentUserPosition_y; last_y++, last_x = 0) {
				dot = "";
				for (; last_x < mapSize_x; last_x++) {
					dot += ". ";
				}
				System.out.println(dot);
			}
			dot = "";
			for (; last_x < currentUserPosition_x; last_x++) {
				dot += ". ";
			}
			System.out.print(dot);
//			System.out.print(user.isDead()? ". " : "* ");
			
			// �������� �̸��� ù ���ڸ� ǥ��
			// ����� ������ ��ġ��, ����� ����� ��ġ�� �� �� ����.
			// ���� ���� �ʿ��� ����� ����.
			// LoginUser�� ������ ��, ���� ���� ��ġ�� �ִ� ����� �ʿ� ���� ����.
			// ġƮ���� �����ϰ�����
			if(!user.isDead() && (!user.isJombie()^isJombie || nearEnemy.contains(user))){
				System.out.print(user.getUserName().charAt(0) + " ");
			}else{
				System.out.print(". ");
			}
			
//			System.out.print(user.isDead()? ". " : !(user.isJombie()^isJombie)? (user.getUserName().charAt(0) + " ") : ". ");
		}
		++last_x;
		for (; last_y < mapSize_y; last_y++, last_x = 0) {
			dot = "";
			for (; last_x < mapSize_x; last_x++) {
				dot += ". ";
			}
			System.out.println(dot);
		}
		System.out.println();
	}
	
	public void drawMapToWriter(PrintWriter writer, ArrayList<User> userList, boolean isJombie, ArrayList<User> nearEnemy){
		int last_y = -1;
		int last_x = -1;
		String dot;
		
		for (User user : userList) {
			int currentUserPosition_y = user.getUserLocation().getLocationY();
			int currentUserPosition_x = user.getUserLocation().getLocationX();
			// �ߺ��Ǵ� ��� ������� �������� ����
			// ����� ó���ߴ����� �� �𸣰ڴµ�, �ϴ� ȭ�鿡 �ߺ������� �ʴ´�.
			// ������ �����Ŷ�� �����ߴµ�, �ƴϳ�..
			if (last_y == currentUserPosition_y && last_x == currentUserPosition_x) {
				continue;
			} else {
				last_x++;
			}
			if (last_y == -1) {
				last_y = 0;
			}

			for (; last_y < currentUserPosition_y; last_y++, last_x = 0) {
				dot = "";
				for (; last_x < mapSize_x; last_x++) {
					dot += ". ";
				}
				writer.println(dot);
			}
			dot = "";
			for (; last_x < currentUserPosition_x; last_x++) {
				dot += ". ";
			}
			writer.print(dot);
//			writer.print(user.isDead()? ". " : "* ");
			
			// �������� �̸��� ù ���ڸ� ǥ��
			// ����� ������ ��ġ��, ����� ����� ��ġ�� �� �� ����.
			// ���� ���� �ʿ��� ����� ����.
			// LoginUser�� ������ ��, ���� ���� ��ġ�� �ִ� ����� �ʿ� ���� ����.
			// ġƮ���� �����ϰ�����
			if(!user.isDead() && (!user.isJombie()^isJombie || nearEnemy.contains(user))){
				writer.print(user.getUserName().charAt(0) + " ");
			}else{
				writer.print(". ");
			}
			
//			writer.print(user.isDead()? ". " : !(user.isJombie()^isJombie)? (user.getUserName().charAt(0) + " ") : ". ");
		}
		++last_x;
		for (; last_y < mapSize_y; last_y++, last_x = 0) {
			dot = "";
			for (; last_x < mapSize_x; last_x++) {
				dot += ". ";
			}
			writer.println(dot);
		}
		writer.println();
		writer.flush();
	}
	
}
