package net.conferencescheduling.spring.repository;

import net.conferencescheduling.spring.model.entity.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeywordRepository extends JpaRepository<Keyword,Long> {
    Keyword findKeywordByKeyword(String name);
}
