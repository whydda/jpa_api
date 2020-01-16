package com.example.jpa_api.jpa.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comment")
public class Comment {

    @Column(name="comment_seq")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer seq;

    @Column(name="timeline_seq")
    private Integer timelineSeq;

    private String comment;
    private int selCnt;
    private int likeCnt;
    private String regId;
    @Temporal(TemporalType.TIMESTAMP)
    private Date regDate;
    private String modId;
    @Temporal(TemporalType.TIMESTAMP)
    private Date modDate;
    private String delId;
    @Temporal(TemporalType.TIMESTAMP)
    private Date delDate;

}
