package org.in.yuvaa.yuvaarestapi.repository.event;

import org.in.yuvaa.yuvaarestapi.entity.event.EventStateEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventStateRepository extends CrudRepository<EventStateEntity, Long> {
}
