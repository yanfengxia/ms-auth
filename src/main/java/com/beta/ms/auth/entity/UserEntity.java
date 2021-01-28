package com.beta.ms.auth.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "USERS")
public class UserEntity extends BaseEntity implements Serializable {

    @JsonIgnore
    private String username;
    @JsonIgnore
    private String password;

    @ManyToMany (fetch = FetchType.LAZY)
    @JoinTable(name = "USER_ROLE_ASSIGNMENTS",
            joinColumns = {@JoinColumn(name = "USER_ID", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID", nullable = false, updatable = false)})
    private List<RoleEntity> roles;

}
