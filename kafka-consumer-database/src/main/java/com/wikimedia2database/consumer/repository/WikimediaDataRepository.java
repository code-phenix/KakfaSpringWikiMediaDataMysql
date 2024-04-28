package com.wikimedia2database.consumer.repository;

import com.wikimedia2database.consumer.entity.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaDataRepository  extends JpaRepository<WikimediaData,Long> {


}
