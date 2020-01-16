package com.example.jpa_api.jpa.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "timeline")
public class Timeline {
    @Id
    @Column(name="timeline_seq")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer timelineSeq;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="timeline_seq")
    private Collection<Comment> comment;

    private String id;

    private String content;
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
