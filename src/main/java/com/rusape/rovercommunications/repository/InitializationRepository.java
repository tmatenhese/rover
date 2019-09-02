package com.rusape.rovercommunications.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rusape.rovercommunications.model.InitializationMessage;


public interface InitializationRepository extends JpaRepository<InitializationMessage, Long> {

}
