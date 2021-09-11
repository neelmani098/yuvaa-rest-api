package org.in.yuvaa.yuvaarestapi.repository.joinus;

import org.in.yuvaa.yuvaarestapi.entity.joinus.JoinUsEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JoinUsRepository extends CrudRepository<JoinUsEntity, Long> {

    JoinUsEntity findByJoinId(String joinId);

    @Query(value = "select * from joinus ju where ju.selected = true", nativeQuery = true)
    List<JoinUsEntity> getSelectedMembers();

    @Query(value = "select * from joinus ju where ju.selected = false", nativeQuery = true)
    List<JoinUsEntity> getRejectedMembers();
}
