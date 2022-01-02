package com.portfolio.kiraPortfolio.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {
  //@Query(value = "select p from Project p where p.featured=?1",nativeQuery = true)
  List<Project> findByFeatured(Boolean featured);
}
