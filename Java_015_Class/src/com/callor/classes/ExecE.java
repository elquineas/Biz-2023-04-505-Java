package com.callor.classes;

import java.util.ArrayList;
import java.util.List;

import com.callor.models.AnimalDto;

public class ExecE {
	public static void main(String[] args) {
		List<AnimalDto> anList = new ArrayList<>();
		AnimalDto anDto1 = new AnimalDto("럭키","허스키","5세");
		AnimalDto anDto2 = new AnimalDto("나비","버밀라","3세");
		AnimalDto anDto3 = new AnimalDto("몽","스피츠","7세");
		
		anList.add(anDto1);
		anList.add(anDto2);
		anList.add(anDto3);
		
		System.out.println(anList.toString());
	}
}
