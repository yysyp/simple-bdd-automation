package ps.demo.action;


import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class DbAction {

    @Autowired
    private DataSource dataSource;

    @SneakyThrows
    public List<Entity> findBySql(String sql, Object ... parameters) {
        return Db.use(dataSource).query(sql, parameters);
    }

    @SneakyThrows
    public Entity findOneBySql(String sql, Object ... parameters) {
        return Db.use(dataSource).queryOne(sql, parameters);
    }

    @SneakyThrows
    public int execute(String sql, Object...parameters) {
        return Db.use(dataSource).execute(sql, parameters);
    }

    @SneakyThrows
    public int insert(Entity entity) {
        return Db.use(dataSource).insert(entity);
    }
}
