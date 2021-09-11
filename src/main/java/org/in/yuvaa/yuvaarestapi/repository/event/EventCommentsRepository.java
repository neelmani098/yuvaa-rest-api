package org.in.yuvaa.yuvaarestapi.repository.event;

import org.in.yuvaa.yuvaarestapi.entity.event.EventCommentsEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventCommentsRepository extends CrudRepository<EventCommentsEntity, Long> {

    @Query(value = "select * from event_comments ec where ec.comments_id = :eventId",
    nativeQuery = true)
    List<EventCommentsEntity> getAllComments(@Param("eventId") long eventId);
}
