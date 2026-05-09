package com.luminar.birthday_reminder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luminar.birthday_reminder.entity.BirthdayReminder;

@Repository
public interface BirthdayRepository extends JpaRepository<BirthdayReminder,Long>{

}
