package jombie.Model;

import java.util.ArrayList;

import jombie.Control.Game;

public class Location {
	protected static final int directionY[] = { -1, -1, -1, 0, 0, 0, 1, 1, 1 };
	protected static final int directionX[] = { -1, 0, 1, -1, 0, 1, -1, 0, 1 };

	private int location_y;
	private int location_x;

	public Location(int y, int x) {
		this.location_y = y;
		this.location_x = x;
	}
	/**
	 * UserList �޾ƿͼ� �ߺ� üũ�ؾ��ϴµ� ȣ�� �ϴ� ���� User Ŭ�������� �ٽ� �ǵ������ �ʿ伺����
	 * gameŬ�������� setLocation������ �ɷ� ����.
	 */
	public boolean setLocation(int y, int x) {
		if (canGo(y, x)) {
			// if (isDuplicated(userList, y, x)) return false;
			this.location_y = y;
			this.location_x = x;
			 return true;
		} else {
			return false;
		}

	}

	public boolean moveDirect_8D(User user, ArrayList<User> userList, int move) {
		int next_y = location_y + directionY[move];
		int next_x = location_x + directionX[move];
		
		if (canGo(next_y, next_x) && !isDuplicated(user, userList, next_y, next_x)) {
			location_y = next_y;
			location_x = next_x;
			return true;
		}
		return false;
	}
	
	/** �̵� ������ �������� üũ. */
	public boolean canGo(int y, int x) {
		return y >= 0 && y <= Game.mapSize_y - 1 && x >= 0 && x <= Game.mapSize_x - 1;
	}
	/** �ٸ� ������ �ߺ��� ��ġ�� ������ �ʾҴ��� üũ. */
	public boolean isDuplicated(User me, ArrayList<User> userList, int y, int x) {
		for (User user : userList) {
			if(user == me) {
				continue;
			}
			if (user.getUserLocation().location_y == y && user.getUserLocation().location_x == x) {
				return true;
			}
		}
		return false;
	}

	public int getLocationY() {
		return this.location_y;
	}

	public int getLocationX() {
		return this.location_x;
	}
}
