package com.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {

	private String id;
	private String name;
	private List<Card> handCards;
	
	public Player () {
		this.setId();
		this.setName();
		this.handCards  = new ArrayList<Card>();
	}
	
	public String getId() {
		return id;
	}
	public void setId() {
		System.out.println("请输入1~4位长度玩家ID");
		Scanner in = new Scanner(System.in);
		while (true) {
			try {
				this.id = String.valueOf(in.nextInt());
				if (this.id.length()<1 || this.id.length()>4) {
					throw new IllegalArgumentException();
				}
				break;
			} catch (Exception e) {
				System.out.println("格式错误，请重新输入1~4位长度玩家ID");
				this.id = in.next();
			}
		}
		
	}
	
	public String getName() {
		return name;
	}
	public void setName() {
		System.out.println("请输入1~10位长度玩家姓名");
		Scanner in = new Scanner(System.in);
		this.name = in.next();
		while (this.name.length()<1 || this.name.length()>10) {
			System.out.println("请重新输入1~10位长度玩家姓名");
			this.name = in.next();
		}
	}
	
	public void getHandCards() {
		System.out.print("玩家:"+id+","+name+"手中的全部牌为:[");
		for (Card card : handCards) {
			System.out.print(card.getSuit()+card.getNumber()+" ");
		}
		System.out.println("]");
	}
	public void setHandCards(Card card) {
		this.handCards.add(card);
	}
	
	public Card getMaxCard () {
		Card maxCard = handCards.get(0);
		for (Card card : handCards) {
			if (card.compareTo(maxCard)>0)
				maxCard = card;
		}
		return maxCard;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Player))
			return false;
		Player other = (Player) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (id.equals(other.id))
			return true;//被我修改过了，不是最初生成的equals，id和name有一个对到就算重复
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (name.equals(other.name))
			return true;
		return false;
	}
}
