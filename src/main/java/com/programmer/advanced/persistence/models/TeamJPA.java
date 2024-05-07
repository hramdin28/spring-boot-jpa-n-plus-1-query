package com.programmer.advanced.persistence.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TEAM")
public class TeamJPA {

    @Id
    @UuidGenerator
    @Column(unique = true, length = 36)
    private String id;


    private String name;

    @OneToMany(
          fetch = FetchType.LAZY,
          mappedBy = "teamJPA")
    private List<PlayerJPA> playerJPAS;
}
