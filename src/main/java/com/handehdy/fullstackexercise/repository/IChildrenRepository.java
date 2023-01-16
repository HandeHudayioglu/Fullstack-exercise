package com.handehdy.fullstackexercise.repository;

import com.handehdy.fullstackexercise.repository.entity.Children;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
@Repository
public interface IChildrenRepository extends JpaRepository<Children,Long> {
    List<Children> findByCitizenId(Long id);
}
