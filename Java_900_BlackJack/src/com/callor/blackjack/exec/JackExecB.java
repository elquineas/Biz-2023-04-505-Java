package com.callor.blackjack.exec;

import java.util.List;

import com.callor.blackjack.models.CardDto;
import com.callor.blackjack.service.BlackJeckService;
import com.callor.blackjack.service.DeckService;
import com.callor.blackjack.service.PlayerService;
import com.callor.blackjack.service.impl.DeckServiceImplV1;
import com.callor.blackjack.service.impl.PlayerServiceImplV1;

public class JackExecB {
	public static void main(String[] args) {
		BlackJeckService blackJack = new BlackJeckService();
		blackJack.gameStart();
	}
}
