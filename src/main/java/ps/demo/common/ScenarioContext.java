package ps.demo.common;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.http.ResponseEntity;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@ScenarioState
@Setter
@Getter
public class ScenarioContext {

    private ResponseEntity<Object> responseEntity;

    private Map<String, Object> pars = new ConcurrentHashMap<>();

    public void clear() {
        this.responseEntity = null;
        pars.clear();
    }

}
