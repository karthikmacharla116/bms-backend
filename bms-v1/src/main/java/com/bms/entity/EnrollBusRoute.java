package com.bms.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author { "name": "Winston", "role": "faculty", "feesPaid": "true",
 *         "busRoute": { "busId": "2", "busNo": "TS07Z1146", "routeNo": "07",
 *         "driverName": "Mallesh", "phoneNum": "823478322", "source" : "BHEL",
 *         "destination": "Gandipet", "feesAmount": "12000", "stop1":
 *         "Lingampalli", "stop2": "Gachibowli", "stop3": "Narsingi", "stop4":
 *         "kokapet" } }
 *
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnrollBusRoute {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int enrollId;
	private String name;
	private String role;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "payment_id", referencedColumnName = "paymentId")
	private Payment payment;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "bus_route_id", referencedColumnName = "busId")
	private BusRoute busRoute;

}
