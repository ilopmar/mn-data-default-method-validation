package mn.data.defmethod;

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import io.micronaut.validation.Validated;

import javax.annotation.Nonnull;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Validated
@JdbcRepository(dialect = Dialect.MYSQL)
public interface SensorRepository extends CrudRepository<SensorEntity, Long> {

    default Optional<Sensor> findSensorById(@Nonnull @NotNull Long id) {
        return Optional.empty();
    }

}
