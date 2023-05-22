package com.callor.blackjack.service;

import java.util.ArrayList;
import java.util.List;

import com.callor.blackjack.service.impl.DeckServiceImplV1;
import com.callor.blackjack.service.impl.PlayerServiceImplV1;

public class BlackJeckService {
	protected final List<PlayerService> playerList;
	protected final DeckService deckService;
	
	public BlackJeckService() {
		playerList =  new ArrayList<>();
		deckService = new DeckServiceImplV1();
	}
	
	public void gameStart() {
		playerList.add(new PlayerServiceImplV1());
		playerList.add(new PlayerServiceImplV1("타짜"));
		playerList.add(new PlayerServiceImplV1("영수"));
		
		for(int i = 0; i < 2; i++){
			for(PlayerService player :playerList) {
				player.hit(deckService.getDeck());
			}
		}
		
		if(playerList.get(0).getScore() < 17) {
			playerList.get(0).hit(deckService.getDeck());
		}
		
		for(PlayerService player : playerList) {
			player.showDeck();
		}
		
//		int score = 0;
//		String name = "";
//		for(PlayerService player : playerList) {
//			if(player.getScore() < 22) {
//				if(player.getScore() > score) {
//					score = player.getScore();
//					name  = player.getPlayerName(); 
//				} else if(player.getScore() == score) {
//					name = name + ", " + player.getPlayerName();
//				}
//			}
//		}
//		System.out.printf("%s 승리, 점수 : %d",name, score);

		for(int i = 1; i<playerList.size(); i++) {
			int score = playerList.get(0).getScore();
			String name  = playerList.get(i).getPlayerName();
			if(playerList.get(i).getScore() < 22) {
				if(playerList.get(i).getScore() > score) {
					score = playerList.get(i).getScore();
				}
			}
			System.out.printf("딜러 : %s = %s승리, 점수 : %d",name, name, score);
			System.out.println();
		}
	}
	
	
}
