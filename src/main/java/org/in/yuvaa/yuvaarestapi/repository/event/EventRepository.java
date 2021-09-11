package org.in.yuvaa.yuvaarestapi.repository.event;

import org.in.yuvaa.yuvaarestapi.entity.event.EventEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<EventEntity, Long> {

    EventEntity findByEventId(String eventId);

    @Query(value = "SELECT * FROM event e inner join event_state es on e.id = es.state_id where es.event_state='APPROVED'",
    nativeQuery = true)
    List<EventEntity> findAllApprovedEvents();

    @Query(value = "select id from event e where e.event_id = :eventId", nativeQuery = true)
    long findEventId(@Param("eventId") String eventId);
}
