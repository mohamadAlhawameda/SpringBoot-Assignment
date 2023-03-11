package com.cpan252.assignment.repository;

import com.cpan252.assignment.model.item;
import org.springframework.data.repository.CrudRepository;
import com.cpan252.assignment.model.item.Anime;
import java.util.List;

public interface ItemRepository extends CrudRepository<item, Long> {
    List<item> findByBrand(Anime anime);
    List<item> findByBrandAndPrucdedDate(String brand, int prucdedDate);
}
