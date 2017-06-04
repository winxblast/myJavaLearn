package com.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

	private List<Card> aPoker;//创建一副扑克牌
	private List<Player> players;//所有玩家
	
	public static void main(String[] args) {
		Game newGame = new Game();
		newGame.initialPoker();
		newGame.shuffle();
		newGame.initialPlayer();
		newGame.deal();
		newGame.compareCard();

	}
	
	/**
	 * 游戏类构造方法，功能未扩展，暂时只有两位玩家一副牌
	 */
	public Game() {
		this.aPoker = new ArrayList<Card>();
		this.players = new ArrayList<Player>();
	}
	
	public void initialPoker() {
		System.out.println("-------创建扑克牌-------");
		System.out.println("扑克牌为：");
		for (Card.SuitEnum se : Card.SuitEnum.values()) {
			//values（）方法网上有介绍，但是java API中找不到，比较诡异
			System.out.print("[");
			for (Card.NumberEnum ne : Card.NumberEnum.values()) {
				aPoker.add(new Card(se,ne));
				System.out.print(se.toString()+ne.toString()+"，");
			}
			System.out.println("]");
		}
		System.out.println("-------创建扑克牌成功！-------");
	}
	
	public void shuffle() {
		System.out.println("-------开始洗牌-------");
		List<Card> pokerTemp = new ArrayList<Card>(aPoker);//这里没法用aPoker.clone()方法
		Random random = new Random();
		for (int i=52; i>0; i--) {
			int r = random.nextInt(i);
			aPoker.set(52-i, pokerTemp.remove(r));
		}
		System.out.println("-------洗牌结束-------");
//		for (Card card : aPoker) {
//			System.out.print(card.getSuit()+card.getNumber()+" ");
//		}
	}
	
	public void initialPlayer() {
		System.out.println("-------创建玩家-------");
		for (int i=0; i<2; i++) {
			Player p;
			boolean b;
			System.out.println("请输入第"+(i+1)+"位玩家的信息：");
			do {
				p = new Player();
				if (players.contains(p)) {
					System.out.println("已存在该玩家或ID，请重新输入！");
					b = true;
				} else {
					b = false;
				}
			} while (b);
			players.add(p);
		}
		for (Player player : players) {
			System.out.println("----欢迎玩家："+player.getName());
		}
	}
	
	public void deal() {
		System.out.println("-------开始发牌-------");
		for (int i=0; i<2; i++) {//一人发两张牌
			for (Player player : players) {
				player.setHandCards(aPoker.remove(0));
				System.out.println("----玩家："+player.getName()+"-拿牌");
			}
		}
		System.out.println("-------发牌结束！-------");
	}

	public void compareCard() {
		System.out.println("-------开始游戏...-------");
		Player winPlayer = players.get(0);
		for (Player player : players) {
			System.out.println("玩家："+player.getName()+"最大的手牌为："+player.getMaxCard().toString());
			if (player.getMaxCard().compareTo(winPlayer.getMaxCard())>0) {
				winPlayer = player;
			}
		}
		System.out.println("-------玩家："+winPlayer.getName()+"获胜！-------");
		System.out.println("玩家各自的手牌为：");
		for (Player player : players) {
			player.getHandCards();
		}
	}
}
