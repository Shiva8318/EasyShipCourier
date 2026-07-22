package com.easyship.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easyship.entity.Parcel;
import com.easyship.repository.ParcelRepository;
import com.easyship.repository.UserRepository;

@Service
public class DashboardService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ParcelRepository parcelRepository;

    public long getTotalUsers() {
        return userRepository.count();
    }

    public long getTotalParcels() {
        return parcelRepository.count();
    }

    public long getDeliveredParcels() {
        return parcelRepository.countByStatus("Delivered");
    }

    public long getPendingParcels() {
        return parcelRepository.count() -
               parcelRepository.countByStatus("Delivered");
    }

    public List<Parcel> getRecentParcels() {
        return parcelRepository.findTop10ByOrderByIdDesc();
    }
}