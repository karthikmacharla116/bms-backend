package com.bms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bms.entity.BusRoute;

@Repository
public interface BusRepository extends JpaRepository<BusRoute, Integer> {

//	@Modifying
//	@Query("update BusRoute b SET b.busNo= :busNo, b.routeNo=:routeNo, b.driverName=:driverName, b.phoneNum=:phoneNum, "
//			+ "b.source=:source, b.destination=:destination, b.feesAmount=:feesAmount, "
//			+ "b.stop1=:stop1, b.stop2=:stop2, b.stop3=:stop3, b.stop4=:stop4 WHERE b.busId = :busId")
//	public void updateBusRouteByBusId(@Param("busNo") String busNo, @Param("routeNo") String routeNo,
//			@Param("driverName") String driverName, @Param("phoneNum") String phoneNum, @Param("source") String source,
//			@Param("destination") String destination, @Param("feesAmount") String feesAmount,
//			@Param("stop1") String stop1, @Param("stop2") String stop2, @Param("stop3") String stop3,
//			@Param("stop4") String stop4, @Param("busId") int busId);

}
