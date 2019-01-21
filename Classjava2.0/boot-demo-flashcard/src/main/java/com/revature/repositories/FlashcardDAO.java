package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Category;
import com.revature.beans.Flashcard;

@Repository  // JpaRepository <[class],[primary key data type]>
public interface FlashcardDAO extends JpaRepository<Flashcard, Integer>{
	
	// other choices for the repository
	// CrudRepository : Supertype
	// PagingAndSortingRepository : 

	public List<Flashcard> getByCategory(Category c);
}
