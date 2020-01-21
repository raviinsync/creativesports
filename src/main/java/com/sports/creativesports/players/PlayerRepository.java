package com.sports.creativesports.players;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Players,Integer> {

  /*@Query("select c from Players c where c.first_name=ravi"")
  List<Players> findByFirstName();
  */

}
