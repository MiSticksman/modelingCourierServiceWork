package vsu.shaforostov.modelingcourierservicework.repository;

import org.springframework.data.repository.CrudRepository;
import vsu.shaforostov.modelingcourierservicework.entity.Courier;

public interface CourierRepository extends CrudRepository<Courier, Integer> {
}
