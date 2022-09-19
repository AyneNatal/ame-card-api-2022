package com.amefastforward.cardapi.service;

import com.amefastforward.cardapi.controller.request.CreateCardRequest;
import com.amefastforward.cardapi.model.Card;
import com.amefastforward.cardapi.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CardService {

    private final CardRepository cardRepository;

    @Autowired
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public Optional<Card> findById(int id) {
        return cardRepository.findById(id);
    }

    public Card createCard(CreateCardRequest cardRequest) {
        var card = new Card();
        card.setName(cardRequest.getName());
        card.setDescription(cardRequest.getDescription());
        card.setStrength(cardRequest.getStrength());
        card.setSpeed(cardRequest.getSpeed());
        card.setSkill(cardRequest.getSkill());
        card.setGear(cardRequest.getGear());
        card.setIntellect(cardRequest.getIntellect());
        card.setImageUrl(cardRequest.getImageUrl());
        card.setCreatedAt(LocalDateTime.now());
        card.setUpdatedAt(LocalDateTime.now());

        return cardRepository.save(card);
    }
}
