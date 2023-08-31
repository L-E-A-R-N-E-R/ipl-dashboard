package com.ipl.ipldashboard.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.CrudRepository;

import com.ipl.ipldashboard.model.Match;


public interface MatchRepository extends CrudRepository<Match, Long>{
    
    public List<Match> getByTeam1OrTeam2OrderByDateDesc(String teamName1, String teamName2, PageRequest pageRequest);

    default List<Match> findLatestMatchesbyTeam(String teamName, int count){
        return getByTeam1OrTeam2OrderByDateDesc(teamName, teamName, PageRequest.of(0,count));
    }
}
