package com.bridgelabz.JavaPractice.enums;
import java.util.Comparator;
import com.bridgelabz.JavaPractice.*;

public enum SortOptions {
	
	 NAME(Comparator.comparing(Person::getFname)),
	    CITY(Comparator.comparing(Person::getCity)),
	    STATE(Comparator.comparing(Person::getState)),
	    ZIP(Comparator.comparing(Person::getZip));

	    public final Comparator<? super Person> comparator;

	    SortOptions(Comparator<? super Person> comparator) {
	        this.comparator = comparator;
	    }

}
