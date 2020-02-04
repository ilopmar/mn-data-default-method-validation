package mn.data.defmethod

import io.micronaut.test.annotation.MicronautTest
import spock.lang.Specification
import spock.lang.Unroll

import javax.inject.Inject
import javax.validation.ConstraintViolationException

@MicronautTest
class SensorRepositoryConstraintsSpec extends Specification {

    @Inject
    SensorRepository sensorRepository

    @Unroll
    void 'test "findSensorById(#id)" triggers ConstraintViolationException'() {
        when:
        sensorRepository.findSensorById(id)

        then:
        def e = thrown(ConstraintViolationException)
        e.constraintViolations.collect { it.propertyPath.toString() }.any { it.contains(field) }
        e.constraintViolations.collect { it.message }.any { it.contains(errorMessage) }

        where:
        id   | field               | errorMessage
        null | 'findSensorById.id' | 'must not be null'
    }
}
