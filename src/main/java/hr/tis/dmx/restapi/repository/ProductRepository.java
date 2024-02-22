package hr.tis.dmx.restapi.repository;

import hr.tis.dmx.restapi.dto.PopularProductDto;
import hr.tis.dmx.restapi.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	boolean existsByCode(String code);

	@Query("select p from Product p where (:code is null or upper(p.code) like upper(concat('%', :code, '%') )) and (:name is null or upper(p.name) like upper(concat('%', :name, '%')))")
	List<Product> findAllByCodeAndName(@Param("code") String code, @Param("name") String name);

	@Query("select new hr.tis.dmx.restapi.dto.PopularProductDto(p.name, avg(r.rating)) from Product p join p.reviews r group by p.name order by avg(r.rating) desc")
	List<PopularProductDto> findTop3PopularProducts(Pageable pageable);
}
