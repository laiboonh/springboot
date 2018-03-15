package hello;

import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.resource.list.ResourceList;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class GreetingRepositoryImpl extends ResourceRepositoryBase<Greeting, Long> {

    private Map<Long, Greeting> greetings = new HashMap<>();

    public GreetingRepositoryImpl() {
        super(Greeting.class);

        greetings.put(1L, new Greeting(1L, "Hello Alice!"));
        greetings.put(2L, new Greeting(2L, "Hello Bob!"));
        greetings.put(3L, new Greeting(3L, "Hello Mary!"));
    }

    @Override
    public synchronized ResourceList<Greeting> findAll(QuerySpec querySpec) {
        //return querySpec.apply(greetings.values());
        throw new BadRequestException("shit happens!");
    }
}
