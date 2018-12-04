package com.fenbeitong.openapitest.dao;

import com.fenbeitong.openapitest.models.common.QueryCityInfoResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * CityInfoDao
 * <p> TODO
 *
 * @author ivan
 * @version 1.0
 * Created by ivan on 18-12-4 - 上午11:23.
 **/
@Repository
public interface CityInfoDao extends JpaRepository<QueryCityInfoResponse,String> {
}
