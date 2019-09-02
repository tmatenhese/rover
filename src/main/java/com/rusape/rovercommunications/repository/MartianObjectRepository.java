package com.rusape.rovercommunications.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rusape.rovercommunications.model.MartianObject;

public interface MartianObjectRepository extends JpaRepository<MartianObject, Long> {

}
