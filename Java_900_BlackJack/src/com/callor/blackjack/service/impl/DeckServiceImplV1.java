package com.callor.blackjack.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.callor.blackjack.models.CardDto;
import com.callor.blackjack.service.DeckService;

/*
 * 게임을 위한 카드 생성
 * hit를 했을때 사용할 카드 제출 
 */

public class DeckServiceImplV1 implements DeckService {
	
	protected final List<CardDto> cardDeck;
	
	public DeckServiceImplV1() {
		cardDeck = new ArrayList<>();
	}
	
	public List<CardDto> newCardDeck() {
		if(cardDeck.isEmpty()) {
			makeDeckList();	
		}
		for(int i = 0; i < 100; i++) {
			Collections.shuffle(cardDeck);		
		}
		return cardDeck;
	}
	
	public CardDto getDeck() {
		if(cardDeck.isEmpty()) {
			newCardDeck();	
		}
		try {
			return cardDeck.remove(0);
		} catch (Exception e) {
			return null;
		}
	}
	
	public void makeDeckList() {
		String strSuit = "◆♥♠♣";
		String strDenomination = "A234567890JQK";
		
		String[] suits  = strSuit.split(""); 
		String[] denoms = strDenomination.split("");
		
		for(String suit : suits) {
			for(String denom : denoms) {
				CardDto cardDto = new CardDto();
				cardDto.suit = suit;
				try {
					int value = Integer.valueOf(denom);
					if(value == 0) value = 10;
					cardDto.denomination = value+"";
					cardDto.value = value;
				} catch (Exception e) {
					cardDto.denomination = denom;
					if(denom.equals("A")) cardDto.value = 1;
					else cardDto.value = 10;
				}
				cardDeck.add(cardDto);
			}
		}
		
		
		
		
	}
	
}
