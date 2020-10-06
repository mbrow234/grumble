package com.grumble.service.impl;

import com.grumble.entities.Listing;
import com.grumble.mapper.ListingMapper;
import com.grumble.dto.ListingDto;
import com.grumble.repository.ListingRepository;
import com.grumble.service.ListingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ListingServiceImpl implements ListingService {

    private ListingRepository listingRepository;
    private ListingMapper listingMapper;

    @Autowired
    public ListingServiceImpl(ListingRepository listingRepository, ListingMapper listingMapper) {
        this.listingRepository = listingRepository;
        this.listingMapper = listingMapper;
    }

    public ListingDto getListingById(Long id) {
        Optional<Listing> listingEntity = listingRepository.findById(id);

        ListingDto listingDto;
        if (listingEntity.isPresent()) {
            listingDto = listingMapper.mapEntityToListing(listingEntity.get());
        } else {
            return null;
        }

        return listingDto;
    }

    public List<ListingDto> getAllListings() {
        List<ListingDto> listingDtos = new ArrayList<>();
        listingRepository.findAll().forEach(listing -> listingDtos.add(listingMapper.mapEntityToListing(listing)));
        return listingDtos;
    }

    public Long deleteListingById(Long id) {

        try {
            listingRepository.deleteById(id);
        } catch (Exception e) {
            return null;
        }

        return id;
    }

    public ListingDto createListing(ListingDto listingDto) {
        return listingMapper.mapEntityToListing(listingRepository.save(listingMapper.mapListingToEntity(listingDto)));
    }

}
