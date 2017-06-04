package com.game;

public class Card implements Comparable<Card> {
	
	private SuitEnum suit;//花色
	private NumberEnum number;//点数

	/**
	 * 构造方法
	 */
	public Card (SuitEnum suit, NumberEnum number) {
//		this.suit = suit;
		//这样在setter中可以对输入进行判断
		this.setSuit(suit);
//		this.number = NumberEnum.valueOf(number);
		this.setNumber(number);
	}
	
	public String getSuit() {
		return suit.toString();
	}

	public void setSuit(SuitEnum suit) {
		try {
			this.suit = suit;
		} catch (Exception e) {
			System.out.println("发牌错误");//不过由于是程序发牌，这句就简单处理了，不会有错的
			//String类输入改为enum类，这样不会有错了
		}
	}



	public String getNumber() {
		return number.toString();
	}

	public void setNumber(NumberEnum number) {
		try {
			this.number = number;
		} catch (Exception e) {
			System.out.println("发牌错误");//不过由于是程序发牌，这句就简单处理了，不会有错的
		}
		
	}



	@Override //比较牌的大小
	public int compareTo(Card o) {
		// TODO Auto-generated method stub
		if (this.number.equals(o.number)) {
			return this.suit.compareTo(o.suit);
		} else {
			return this.number.compareTo(o.number);
		}
	}
	
	
	@Override//输出牌的名称
	public String toString () {
		return suit.toString()+number.toString();
	}
	
	
	public enum SuitEnum {
		DIAMONDS("方块"),CLUBS("梅花"),HEARTS("红桃"),SPADES("黑桃");
		
		private String suitName;
		
		//构造方法
		private SuitEnum (String suitName) {
			this.suitName = suitName;
		}
		
		@Override
		public String toString () {
			return this.suitName;
		}
	}
	
	public enum NumberEnum {
		//点数，从大到小3-10,J,Q,K,A,2
		THREE("3"),FOUR("4"),FIVE("5"),SIX("6"),SEVEN("7"),EIGHT("8"),NINE("9"),TEN("10"),
		JACK("J"),QUEEN("Q"),KING("K"),ACE("A"),TWO("2");
		
		private String numberName;
		
		private NumberEnum (String numberName) {
			this.numberName = numberName;
		}
		
		@Override
		public String toString () {
			return this.numberName;
		}
	}
}
