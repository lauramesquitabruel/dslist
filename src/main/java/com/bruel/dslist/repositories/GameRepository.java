package com.bruel.dslist.repositories;

import com.bruel.dslist.entities.Game;
import com.bruel.dslist.projections.GameMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {

    @Query(nativeQuery = true, value = """
           SELECT t1.id, t1.title, t1.gm_year AS `year`, t1.img_url as `imgUrl`, t1.short_desc as `shortDesc`, t2.position
           FROM games AS t1\s
           INNER JOIN games_game_list as t2 on t1.id = t2.game_id
           WHERE t2.list_id = 1
           ORDER BY t2.position
           """)
    List<GameMinProjection> searchByList(long listId);
}
