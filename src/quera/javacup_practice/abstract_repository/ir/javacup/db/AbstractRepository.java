package quera.javacup_practice.abstract_repository.ir.javacup.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class AbstractRepository<U, T extends IEntity<U>> implements IRepository<U,T>{
    private final Map<U, T> data = new HashMap<>();
    private final IdGenerator<U> idGenerator;

    public AbstractRepository(IdGenerator<U> idGenerator){
        this.idGenerator = idGenerator;
    }

    @Override
    public void save(T entity) {
        checkNotNull(entity);
        U id = idGenerator.generate();
        entity.setId(id);
        data.put(id, entity);
    }

    @Override
    public void update(T entity) {
        checkNotNull(entity);
        checkIfIdExists(entity.getId());
        data.put(entity.getId(), entity);
    }

    @Override
    public T load(U id) {
        return data.get(id);
    }

    @Override
    public List<T> loadAll() {
        return new ArrayList<>(data.values());
    }

    @Override
    public void delete(U id) {
        checkIfIdExists(id);
        data.remove(id);
    }

    @Override
    public void deleteAll() {
        data.clear();
    }

    private void checkNotNull(T entity){
        if(entity==null) throw new IllegalArgumentException("entity is null");
    }

    private void checkIfIdExists(U id){
        if(id==null) throw new IllegalArgumentException("entity id is null");
        if(!data.containsKey(id)) throw new RuntimeException("no entity with this id exists");
    }
}
