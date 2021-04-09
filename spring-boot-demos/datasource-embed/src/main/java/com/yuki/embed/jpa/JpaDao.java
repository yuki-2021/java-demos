package com.yuki.embed.jpa;

import com.yuki.embed.entity.Area;
import org.springframework.data.repository.CrudRepository;

public interface JpaDao extends CrudRepository<Area,Long> {

}
