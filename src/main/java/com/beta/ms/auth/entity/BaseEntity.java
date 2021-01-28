package com.beta.ms.auth.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
   @Temporal(TemporalType.TIMESTAMP)
   private Date createdAt;

   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
   @Temporal(TemporalType.TIMESTAMP)
   private Date updatedAt;

   @PrePersist
   protected void onCreate() {
      createdAt = updatedAt = new Date();
   }

   @PreUpdate
   protected void onUpdate() {
      updatedAt = new Date();
   }

}
