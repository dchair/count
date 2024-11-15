package chair.count.dao.impl;

import chair.count.dao.PlayerDao;
import chair.count.dto.PlayerRequest;
import chair.count.model.Player;
import chair.count.rowMapper.PlayerRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PlayerDaoImpl implements PlayerDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Integer addPlayer(PlayerRequest playerRequest) {
        String sql ="INSERT INTO player(player_name,chips,created_date,last_modified_date)"+
                "VALUES(:playerName,:chips,:createdDate,:lastModifiedDate)";

        Map<String, Object> map = new HashMap<>();
        map.put("playerName", playerRequest.getPlayerName());
        map.put("chips" , playerRequest.getChips());

        Date now = new Date();
        map.put("createdDate", now);
        map.put("lastModifiedDate",now);

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql,new MapSqlParameterSource(map),keyHolder);

        int playerId = keyHolder.getKey().intValue();

        return playerId;
    }

    @Override
    public Player getPlayerById(Integer playerId) {
        String sql ="SELECT player_id,player_name,chips,created_date,last_modified_date " +
                "FROM player where player_id = :playerId";
        Map<String, Object> map = new HashMap<>();
        map.put("playerId",playerId);
        List<Player> playerList = namedParameterJdbcTemplate.query(sql, map ,new PlayerRowMapper());

        if(playerList.size()>0){
            return playerList.get(0);
        }else{
            return null;
        }
    }

    @Override
    public Player getPlayerByName(String playerName) {
        String sql = "SELECT player_id,player_name,chips,created_date,last_modified_date " +
                "FROM player WHERE player_name = :playerName";
        Map<String ,Object> map = new HashMap<>();
        map.put("playerName",playerName);

        List<Player> playerList = namedParameterJdbcTemplate.query(sql, map ,new PlayerRowMapper());

        if(playerList.size()>0){
            return playerList.get(0);
        }else{
            return null;
        }
    }

    @Override
    public List<Player> getPlayers() {
        String sql="SELECT player_id,player_name,chips,created_date,last_modified_date " +
                "FROM player";
        return namedParameterJdbcTemplate.query(sql, new PlayerRowMapper());
    }
}
