package com.easyship.service;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easyship.entity.Parcel;
import com.easyship.repository.ParcelRepository;

@Service
public class ParcelService {

    @Autowired
    private ParcelRepository repository;

    public Parcel saveParcel(Parcel parcel) {
    	

        parcel.setStatus("Booked");

        String trackingId = "ES" +
                UUID.randomUUID().toString()
                .replace("-", "")
                .substring(0,8)
                .toUpperCase();

        parcel.setTrackingId(trackingId);

        return repository.save(parcel);
    }
    public List<Parcel> getAllParcels(){

        return repository.findAll();

    }
    public List<Parcel> getParcelsByUserEmail(String email){

        return repository.findByUserEmail(email);

    }
    public Parcel getParcelById(Integer id){

        return repository.findById(id).orElse(null);

    }
    public Parcel getParcelByTrackingId(String trackingId) {
        return repository.findByTrackingId(trackingId);
    }
    public void updateStatus(Integer id, String status) {

        Parcel parcel = repository.findById(id).orElse(null);

        if (parcel != null) {

            parcel.setStatus(status);

            repository.save(parcel);

        }

    }
}
