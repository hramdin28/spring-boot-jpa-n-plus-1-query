package com.programmer.gate.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@NamedEntityGraph(
        name = "team-entity-graph",
        attributeNodes = {
                @NamedAttributeNode(value = "players", subgraph = "players-subgraph"),
        },
        subgraphs = {
                @NamedSubgraph(
                        name = "players-subgraph",
                        attributeNodes = {
                                @NamedAttributeNode("team")
                        }
                )
        }
)
@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_Sequence")
    @SequenceGenerator(name = "team_Sequence", sequenceName = "TEAM_SEQ")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.MERGE,
            fetch = FetchType.LAZY,
            mappedBy = "team")
    private List<Player> players;

    public Team() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Player> getPlayers() {
        return players;
    }

}
