

package com.easyship.repository;
import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easyship.entity.Parcel;

public interface ParcelRepository extends JpaRepository<Parcel,Integer>{

    Parcel findByTrackingId(String trackingId);

    long countByStatus(String status);

    List<Parcel> findTop10ByOrderByIdDesc();

}