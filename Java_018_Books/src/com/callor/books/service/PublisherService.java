package com.callor.books.service;

import java.util.List;

import com.callor.books.models.PublisherDto;

public interface PublisherService {
	
	public void loadPubliser();
	public void printPubliser();
	
	public PublisherDto getPubliser(String name);
	public List<PublisherDto> getPubliserList();
	public List<PublisherDto> getPubliserListByName(String name);
}
