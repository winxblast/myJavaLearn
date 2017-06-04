package com.game;

public class EnumTest {//enum类型学习测试
	
	private enum NumberEnum {
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
	
	public static void main (String[] args) {
		NumberEnum ne1 = NumberEnum.EIGHT;
		NumberEnum ne2 = NumberEnum.valueOf("TEN");
		if (ne1.equals(ne2)) {
			System.out.println("true"+ne1.compareTo(ne2));
		} else
			System.out.println("false"+ne1.compareTo(ne2));
		
		for (NumberEnum ne3 : NumberEnum.values()) {
			System.out.println(ne3.toString());
		}
	}
}
