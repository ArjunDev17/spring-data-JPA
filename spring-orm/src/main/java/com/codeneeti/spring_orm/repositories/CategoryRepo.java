package com.codeneeti.spring_orm.repositories;

import com.codeneeti.spring_orm.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,String> {
}
