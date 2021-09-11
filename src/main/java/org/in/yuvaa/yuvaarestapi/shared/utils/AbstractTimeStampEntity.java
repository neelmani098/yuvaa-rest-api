package org.in.yuvaa.yuvaarestapi.shared.utils;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class AbstractTimeStampEntity {

    @Temporal(TemporalType.TIMESTAMP)
    private Date registeredTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date approvedTime;

    @PrePersist
    protected void onCreate(){
        registeredTime = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        approvedTime = new Date();
    }

}
