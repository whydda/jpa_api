package com.example.jpa_api.jpa.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class Users {

    /**
     * FetchType.EAGER, FetchType.LAZY로 전략을 변경 할 수 있습니다.
     * 두 전략의 차이점은 EAGER인 경우 관계된 Entity의 정보를 미리 읽어오는 것이고 LAZY는 실제로 요청하는 순간 가져오는겁니다.
     */
    @Id
    @NotNull
    private String id;

    @NotNull
    @Column(name = "pass")
    private String pass;

    private String name;

//    @OneToMany
//    private

}
