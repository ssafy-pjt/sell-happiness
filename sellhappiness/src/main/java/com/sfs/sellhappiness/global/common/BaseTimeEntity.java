package com.sfs.sellhappiness.global.common;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {
    //등록일
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createDate;

    //등록자, 수정자 => 로그인한 계정정보 가져오기

    //수정일
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;
}
